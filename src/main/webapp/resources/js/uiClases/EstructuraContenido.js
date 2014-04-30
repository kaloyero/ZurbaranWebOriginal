var EstructuraContenido = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="estructuraContenido";
        this.breadcrumb='Moneda';
        this.descripcion="Desde aqui gestiones las Monedas";
    },

    createValidation:function(){
    	$(".contFormNew").validate({
    		rules: {
    			codigo: "required",
    		},
    		messages: {
    			codigo: "Por favor ingresa un codigo"

    		}
    	});
    	
    },
    createUpdateValidation:function(){
    	$(".contFormEdit").validate({
    		rules: {
    			codigo: "required",
    		},
    		messages: {
    			codigo: "Por favor ingresa un codigo"

    		}
    	});
    	
    }


});

estructuraContenidoRender=new EstructuraContenido();