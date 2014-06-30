var TipoEntidad = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="tipoEntidad";
        this.breadcrumb='Tipo Entidad';
        this.descripcion="Desde aqui gestiones los Tipo de Entidades";
    },
    
    getTitleExport:function(){
		
		return "TipoEntidad"
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

tipoEntidadRender=new TipoEntidad();