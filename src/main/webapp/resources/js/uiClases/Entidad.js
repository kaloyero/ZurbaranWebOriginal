var Entidad = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="entidad";
        this.breadcrumb='Entidad';
        this.descripcion="Desde aqui gestiones las Entidades";
    },
    getTitleExport:function(){
		
		return "Entidad"
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
    	
    	
    },
    getDeleteMessage : function(data) {
  		if (data.valido==true){
  			return "Entidad eliminada con exito.";
  		}else{
  			return "Entidad en uso en el sistema.Se ha desactivado.";

  		}
	},


});

entidadRender=new Entidad()