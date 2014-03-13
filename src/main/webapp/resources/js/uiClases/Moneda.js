var Moneda = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="moneda";
        this.breadcrumb='Moneda';
        this.descripcion="Desde aqui gestiones las Monedas";
    },

    createValidation:function(){
       // this.setDefaultValidationStyle();
    	
        $(".contFormNew").validate({
    		rules: {
    			nombre: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre"

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
    			nombre: "Por favor ingresa un nombre"

    		}
    	});
    	
    	
    }


});

monedaRender=new Moneda();