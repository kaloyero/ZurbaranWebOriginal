var Entidad = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="entidad";
        this.breadcrumb='Entidad';
        this.descripcion="Desde aqui gestiones las Entidades";
    },


    createValidation:function(){
    	
        $(".contFormNew").validate({
    		rules: {
    			nombre: "required",
    			"tipo.id":"required"

    			},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			"tipo.id": "Por favor ingresa un Tipo de Entidad"

    		}
    	});
    	
    	
    },
    createUpdateValidation:function(){
    	
        $(".contFormEdit").validate({
    		rules: {
    			nombre: "required",
    			"tipo.id":"required"
    			},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			nombre: "Por favor ingresa un Tipo de Entidad"

    		}
    	});
    	
    	
    }


});

entidadRender=new Entidad()