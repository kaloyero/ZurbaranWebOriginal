var Moneda = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="moneda";
        this.breadcrumb='Moneda';
        this.descripcion="Desde aqui gestiones las Monedas";
    },
    getTitleExport:function(){
		
		return "Moneda"
	},

    createValidation:function(){
       // this.setDefaultValidationStyle();
    	
        $(".contFormNew").validate({
    		rules: {
    			nombre: "required",
    			codigo: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			codigo: "Por favor ingresa un codigo"

    		}
    	});
    	
    	
    },
    createUpdateValidation:function(){
        //this.setDefaultValidationStyle();
    	
        $(".contFormEdit").validate({
    		rules: {
    			nombre: "required",
    			codigo: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			codigo: "Por favor ingresa un codigo"

    		}
    	});
    	
    	
    }


});

monedaRender=new Moneda();