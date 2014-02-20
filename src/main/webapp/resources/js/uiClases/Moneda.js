var Moneda = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="moneda";
        this.breadcrumb='Moneda';
        this.descripcion="Desde aqui gestiones las Monedas";
    },

    afterDataTable:function(){

    },
    createValidation:function(){
        this.setDefaultValidationStyle();
    	
        $("form").validate({
    		rules: {
    			nombre: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa tu nombre"

    		}
    	});
    	
    	
    }


});

monedaRender=new Moneda();