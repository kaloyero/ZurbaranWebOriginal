var Cotizacion = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="cotizacion";
        this.breadcrumb='Cotizacion';
        this.descripcion="Desde aqui gestiones las Cotizaciones";
    },
    getTitleExport:function(){
		
		return "Cotizacion"
	},
    
    bindAddEvents:function() {
    	this.parent();
     	 $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });
     	 $(".datepicker").datepicker("setDate",new Date());
    },
    
    bindUpdateEvents:function() {
    	var d1 = [[0, 3], [1, 3], [2, 5], [3, 7], [4, 8], [5, 10], [6, 11], [7, 9], [8, 5], [9, 13]];
    	this.parent();
    	$.plot($("#chart_ordered_bars"), [
    	                           {
    	                               data: d1,
    	                               bars: {
    	                                   show: true
    	                               }
    	                           }
    	                       ]);
    	 $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });
    	 
    	 $.ajax({type: 'GET',
     		url: 'cotizacion/getHistorico/8',
     		contentType: "application/json",
     		success: function(data) {
     			console.log("DDDDa",data)
     			
     			
 			}});
     	
    },
    
    createValidation:function(){
    	
        $(".contFormNew").validate({
    		rules: {
    			cotizacion: {
    			      required: true,
    			      number: true
    			    },
    			  fecha:{
    				  required:true
    			  },
    		messages: {
    			cotizacion: "Requerido",
    		    fecha:  "Requerido"

    		}
    		}
    	});
    	

    },
    createUpdateValidation:function(){
        //this.setDefaultValidationStyle();
    	
        $(".contFormEdit").validate({
        	rules: {
    			cotizacion: {
    			      required: true,
    			      number: true
    			    },
    				  fecha:{
        				  required:true
        			  },
        		messages: {
        			cotizacion: "Requerido",
        		    fecha:  "Requerido"

        		}
        	}
    	});
    	
    	
    }



});

cotizacionRender=new Cotizacion();