var ResumenCuenta = new Class({
	Extends : Render,
	initialize : function(name) {
		this.name = name;
		this.type = "resumenCuenta";
		this.breadcrumb = 'Cuenta';
		this.descripcion = "Desde aqui gestiones las Cuentas";
	},

	bindAddEvents : function() {

		var self = this;
		this.parent();
		this.createCombosEspeciales();
		$('.datepicker').datepicker({
			showOtherMonths : true,
			dateFormat : 'dd-mm-yy'
		});

		$(".contAdministracionCombo").change(function() {
			translator.getListByAdmin("cuenta", $(this).val(), function(data) {
				self.cleanCombos();
				self.fillCombo(data, $("#contCuentaCombo"));
			})
		});
		$("#contCuentaCombo").change(
				function() {
					translator.getDataToFillConceptoFormByCuentaId("cuenta", $(
							this).val(), function(data) {
						self.fillSearchForm(data, "contFormNew");
					})
				});
		$(".contBuscar").click(function() {
    		self.createJsonSearch();
    	});

	},

	cleanCombos : function() {
		$("#entidadCombo").find('option').remove();
		$("#monedaCombo").find('option').remove();
		$("#contCuentaCombo").find('option').remove();
	},
	 bindListEvents:function() {
	     	var self=this;
	     	$(self.getViewButtons()).unbind( "click" );

	    	self.getViewButtons().click(function() {
	    		var elementId=self.getIdFromGrid(this);
		  		translator.getFormById("documento",elementId);
	    	});

	    	
	     },
	createJsonSearch : function() {
		var searchObject = new Object();
		searchObject.administracionId = $(".contAdministracionCombo").select2('data').id;
		searchObject.cuentaId = $("#contCuentaCombo").select2('data').id;
		searchObject.entidadId = $("#entidadCombo").select2('data').id;
		searchObject.monedaId = $(".monedaCombo").select2('data').id;
		searchObject.fechaDesde = $(".contVencimientoDesde").val();
		searchObject.fechaHasta = $(".contVencimientoHasta").val();
		searchObject.tipoEntidadId = $("#contTipoEntidadId").val();

		// Donde va mostrar en y Al?

		$(".contAdministracionCombo").removeClass("errorInput")
    	//Donde va mostrar en y Al?
          if (searchObject.administracionId==""){
        	  $(".contAdministracionCombo" ).addClass('errorInput');
          }else{
        	  this.crearBusqueda(searchObject);
          }
	},
	crearBusqueda : function(searchObject) {
		var self = this;
		$.ajax({
			type : 'POST',
			url : 'cuenta/getBySearchResumenCuenta/',
			contentType : "application/json",
			data : JSON.stringify(searchObject),
			success : function(data) {
				self.creaDatatable(data)
			}
		});

	},
	creaDatatable:function(data){
		appStatus.actualTable.fnClearTable()
		appStatus.actualTable.fnAddData(data.aaData)
		//$('#configurationTable').dataTable({aaData:data.aaData,"destroy": true});
	},
	fillSearchForm : function(result) {
		// Agrego el valor del tipo de entidad
		$("#entidadCombo").find('option').remove();
		$('#contTipoEntidadInput').val("")
		$("#entidadCombo").append(new Option("",""))
		$("#entidadCombo").append(new Option("TODOS","-1"))
		// $("."+formToFind).find('#entidadCombo').append(new Option("",""))
		// $("."+formToFind).find('.contTipoEntidadInput').val("")

		// Cargo el Combo de Entidades
		if (result.aaData[0]) {
			if (result.aaData[0][1]) {
				for ( var i = 0; i < result.aaData[0][1].length; i++) {
					var id = result.aaData[0][1][i]["id"];
					var text = result.aaData[0][1][i]["nombre"];
					$("#entidadCombo").append(new Option(text, id));
				}
			}

			$('#contTipoEntidadInput').val(
						result.aaData[0][0]["tipoEntidad"]["nombre"])
						$('#contTipoEntidadId').val(result.aaData[0][0]["tipoEntidad"]["id"])
		}
		$("#entidadCombo").select2("val", "");

		// Cargo el Combo de Monedas
	},
	createCombosEspeciales : function() {

		$("select").select2({
			placeholder : "Choose an option..."
		});
	},
	createValidation : function() {

	},

});

resumenCuentaRender = new ResumenCuenta()