var Banco = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="banco";
        this.breadcrumb='Banco';
        this.descripcion="Desde aqui gestiones los Bancos";
    },

    createValidation:function(){
        //this.setDefaultValidationStyle();
    	
        $(".contFormNew").validate({
    		rules: {
    			nombre: "required"
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre"
    		}
    	});
    	
    	
    },
    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
        $(".contFormEdit").validate({
    		rules: {
    			nombre: "required"
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre"
    		}
    	});
    	
    	
    }


});

bancoRender=new Banco();