var Estructura = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="estructura";
        this.breadcrumb='Moneda';
        this.descripcion="Desde aqui gestiones las Monedas";
    },
    getTitleExport:function(){
		
		return "Estructura"
	},
    createValidation:function(){
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

estructuraRender=new Estructura();