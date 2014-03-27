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
    	$(".contFormNew").find("#tipoDocumentoCombo").change(function() {
    		translator.getDocumentoHeader($(this).val(),function(data){
    				self.cleanCombos();

    				self.fillDocumentHeader(data);
    			})
    	});
    },
    cleanCombos:function(){
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();

    	
    },
    fillDocumentHeader:function(data){
    	//cargo las entidades
    	for (var i = 0; i < data.entidades.length; i++) { 
    		var id=data.entidades[i]["id"];
    		var text=data.entidades[i]["nombre"];
    		$("#entidadCombo").append(new Option(text,id));
    		
    	}
    	for (var i = 0; i < data.monedas.length; i++) { 
    		var id=data.monedas[i]["id"];
    		var text=data.monedas[i]["nombre"];
    		$("#monedaCombo").append(new Option(text,id));
    		
    	}
    	
    },


});

documentoRender=new Documento();