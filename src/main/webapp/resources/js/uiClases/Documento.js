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
    				self.toogleTabs(data);
    			})
    	});
    },
    cleanCombos:function(){
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();

    	
    },
    fillDocumentHeader:function(data){
    	console.log("DATA",data)
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
    toogleTabs:function(data){
    	var primero=null;
    	if (data.tipoDocumento.permiteImputaciones =='N'){
    		$(".contImputaciones").hide();
    	}else{
    		$(".contImputaciones").show();
    		primero=$(".contImputaciones");
    	}
    	if (data.tipoDocumento.permiteAplicaciones =='N'){
    		$(".contCancelaciones").hide();
    	}else{
    		
    		$(".contCancelaciones").show();
    		if (!primero)
    			primero=$(".contCancelaciones");
    	}
    	if (data.tipoDocumento.permiteEgrValTer =='N'){
    		$(".contEgreso").hide();
    	}else{

    		$(".contEgreso").show();
    		if (!primero)
    			primero=$(".contEgreso");
    	}
    	if (data.tipoDocumento.permiteIngValTer =='N'){
    		$(".contIngreso").hide();
    	}else{

    		$(".contIngreso").show();
    		if (!primero)
    			primero=$(".contIngreso");

    	}
    	if (data.tipoDocumento.permiteValProp =='N'){
    		$(".contValores").hide();
    	}else{

    		$(".contValores").show();
    		if (!primero)
    			primero=$(".contValores");
    	}
    	$(primero).find("a").trigger('click');

    }


});

documentoRender=new Documento();