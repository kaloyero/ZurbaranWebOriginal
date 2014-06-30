var Usuario = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="administracion";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administracion";
    },
    getTitleExport:function(){
		return "Usuario"
	},
    createValidation:function(){
        //this.setDefaultValidationStyle();
        $(".contFormNew").validate({
    		rules: {
    			nombre: "required",
    			email: "required",
    			password: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			email: "Por favor ingresa un email",
    			password: "Por favor ingresa un password"
    		}
    	});
    	
    	
    },
   

    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
        $(".contFormEdit").validate({
    		rules: {
    			nombre: "required",
    			email: "required",
    			password: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			email: "Por favor ingresa un email",
    			password: "Por favor ingresa un password"
    		}
    	});
    	
    	
    }


});

usuarioRender=new Usuario();