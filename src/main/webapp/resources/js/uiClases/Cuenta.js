var Cuenta = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="cuenta";
        this.breadcrumb='Cuenta';
        this.descripcion="Desde aqui gestiones las Cuentas";
    },


    createValidation:function(){
       // this.setDefaultValidationStyle();
    	
        $(".contFormNew").validate({
    		rules: {
    			nombre: "required",
    			idsMonedas:"required"
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			idsMonedas: "Por favor elija una moneda"
    		}
    	});
    	
    	
    },
    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
        $(".contFormEdit").validate({
    		rules: {
    			nombre: "required",
    			idsMonedas:"required"
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			idsMonedas: "Por favor elija una moneda"
    		}
    	});
    	
    	
    }


});

cuentaRender=new Cuenta()