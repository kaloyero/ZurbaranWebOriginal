var Entidad = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="entidad";
        this.breadcrumb='Entidad';
        this.descripcion="Desde aqui gestiones las Entidades";
    },

    afterDataTable:function(){

    },
    createValidation:function(){
        this.setDefaultValidationStyle();
    	
        $("form").validate({
    		rules: {
    			nombre: "required",
    			referencia:"required"
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			referencia: "Por favor ingresa una referencia"	
    		}
    	});
    	
    	
    }


});

entidadRender=new Entidad()