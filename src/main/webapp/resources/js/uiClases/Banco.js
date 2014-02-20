var Banco = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="banco";
        this.breadcrumb='Banco';
        this.descripcion="Desde aqui gestiones los Bancos";
    },

    afterDataTable:function(){

    },
    createValidation:function(){
        this.setDefaultValidationStyle();
    	
        $("form").validate({
    		rules: {
    			nombre: "required",
    			codigo: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			codigo: "Por favor ingresa un codigo"	
    		}
    	});
    	
    	
    }


});

bancoRender=new Banco()