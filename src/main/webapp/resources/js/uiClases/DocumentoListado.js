var DocumentoListado = new Class({
	Extends : Render,
	initialize : function(name) {
		this.name = name;
		this.type = "documento";
		this.breadcrumb = 'Documentos';
		this.descripcion = "Desde aqui gestiones los Documentos";
	},
	bindExtraFields : function() {
		
		var self=this;
		this.createCombosEspeciales();
		this.createDate();
		$(".contAdministracionCombo").change(
				function() {
					translator.getListByAdmin("tipoDocumento", $(this).val(),
							function(data) {
								self.cleanSearchForm();
								self.fillCombo(data, $("#tipoDocumentoCombo"));
								$("#tipoDocumentoCombo").select2("val", "");

							})
				});

		$("#tipoDocumentoCombo").change(function() {
			var selectedId = $(this).select2('data').id;

			translator.getDocumentoHeader(selectedId, function(data) {
				self.cleanSearchForm();
				self.fillDocumentSearch(data);
			})
		});
		
		$(".contBuscar").click(function() {
			self.createJson();
		});
		
	},
	cleanSearchForm:function(){
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();
    },

	fillDocumentSearch : function(data) {
		// cargo las entidades
		$('#entidadCombo').append("<option></option>")
		$('#monedaCombo').append("<option></option>")

		for ( var i = 0; i < data.entidades.length; i++) {
			var id = data.entidades[i]["id"];
			var text = data.entidades[i]["nombre"];
			$("#entidadCombo").append(new Option(text, id));

		}
		$("#entidadCombo").select2("val", "");

		for ( var i = 0; i < data.monedas.length; i++) {
			var id = data.monedas[i]["id"];
			var text = data.monedas[i]["nombre"];
			$("#monedaCombo").append(new Option(text, id));

		}
		$("#monedaCombo").select2("val", "");

		$(".contCuentaNombre").val(data.cuenta.nombre)
		$(".contTipoEntidad").val(data.cuenta.tipoEntidad.nombre)

	},
	 createCombosEspeciales:function(r){
	    
	    		$("select").select2({placeholder: "Choose an option..."});
	    	
	    },
	 createDate:function(){
	    $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });
	       	
	 },
	createValidation : function() {

	},
	createJson : function() {
		var searchObject=new Object();
    	searchObject.administracionId=$(".contAdministracionCombo" ).select2('data').id;
    	searchObject.entidadId=$("#entidadCombo" ).select2('data').id;
    	searchObject.tipoDocumentoId=$("#tipoDocumentoCombo" ).select2('data').id;
    	//searchObject.monedaId=$("#monedaCombo" ).select2('data').id;
    	
    	this.crearBusqueda(searchObject);
	},
	crearBusqueda:function(searchObject){
		$.ajax({type: 'POST',
    		url: 'documento/getBySearch/',
    		contentType: "application/json",
    		data : JSON.stringify(searchObject),
    		success: function(data) {
    			
			}});
    	
  
	}

});

documentoListadoRender = new DocumentoListado()