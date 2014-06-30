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
    	this.parent();
    	 $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });

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