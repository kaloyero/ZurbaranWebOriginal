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
    },
    
    bindUpdateEvents:function() {
    	this.parent();
    	 $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });

    },
    
    createValidation:function(){
    	
        $(".contFormNew").validate({
    		rules: {
    			nombre: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa tu nombre"

    		}
    	});
    	

    },
    createUpdateValidation:function(){
        //this.setDefaultValidationStyle();
    	
        $(".contFormEdit").validate({
        	rules: {
    			nombre: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa tu nombre"

    		}
    	});
    	
    	
    }



});

cotizacionRender=new Cotizacion();