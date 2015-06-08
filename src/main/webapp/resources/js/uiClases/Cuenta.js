var Cuenta = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="cuenta";
        this.breadcrumb='Cuenta';
        this.descripcion="Desde aqui gestiones las Cuentas";
    },

    getTitleExport:function(){
		
		return "Cuenta"
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
    	
    	
    },
    getDeleteMessage : function(data) {
  		if (data.valido==true){
  			return "Cuenta eliminado con exito.";
  		}else{
  			return "Cuenta en uso en el sistema.Se ha desactivado.";

  		}
	},


});

cuentaRender=new Cuenta()