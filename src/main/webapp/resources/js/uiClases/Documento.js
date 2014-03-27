var Documento = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="tipoDocumento";
        this.breadcrumb='Tipo Documento';
        this.descripcion="Desde aqui gestiones los Tipo de Documentos";
    },

    createValidation:function(){
     
    	
    },
    bindAddEvents:function() {
    	var self=this;
    	this.parent();
    	$(".contFormNew").find(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("tipoDocumento",$(this).val(),function(data){
    			//self.cleanCombos("contFormNew");
    			self.fillCombo(data,$(".contFormNew").find("#tipoDocumentoCombo"));
    			})
    	});
    }


});

documentoRender=new Documento();