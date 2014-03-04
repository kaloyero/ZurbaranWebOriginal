var Administracion = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="administracion";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administracion";
    },

    afterDataTable:function(){

    },
    bindAddEvents:function() {
    	
    	

    },
    createValidation:function(){
        this.setDefaultValidationStyle();
    	
        $("form").validate({
    		rules: {
    			nombre: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre"

    		}
    	});
    	
    	
    }


});

administracionRender=new Administracion();