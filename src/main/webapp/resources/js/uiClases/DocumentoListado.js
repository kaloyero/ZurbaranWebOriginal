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
								self.fillCombo(data, $("#tipoDocumentoCombo"));
								$("#tipoDocumentoCombo").select2("val", "");

							})
				});


		$(".contCuentaCombo").change(function() {
			self.cleanSearchForm();
			var selectedId = $(this).select2('data').id;
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",selectedId,function(data){self.fillDocumentSearch(data);})
    	});
		
		$(".contBuscar").click(function() {
			self.createJson();
		});
		
	},
	cleanSearchForm:function(){
    	$('#entidadCombo').find('option').remove();
    },

	fillDocumentSearch : function(data) {
		// cargo las entidades
		$('#entidadCombo').append("<option></option>")

		for ( var i = 0; i < data.aaData[0][1].length; i++) {
			var id=data.aaData[0][1][i]["id"];
			var text=data.aaData[0][1][i]["nombre"];
			$("#entidadCombo").append(new Option(text, id));

		}
		$("#entidadCombo").select2("val", "");



		//$(".contTipoEntidad").val(data.cuenta.tipoEntidad.nombre)

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
    	if (("#ingreso").is(':checked')){
    		searchObject.tipoFecha=true;
    	}else{
    		searchObject.tipoFecha=false
    	}
    		
    	
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