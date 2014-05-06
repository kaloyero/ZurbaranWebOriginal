var Cotizacion = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="cotizacion";
        this.breadcrumb='Cotizacion';
        this.descripcion="Desde aqui gestiones las Cotizaciones";
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
    		messages: {
    			nombre: "Por favor ingresa tu nombre"

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
    		messages: {
    			nombre: "Por favor ingresa tu nombre"

    		}
        	}
    	});
    	
    	
    }



});

cotizacionRender=new Cotizacion();