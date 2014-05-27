var SaldoEstructura = new Class({
	Extends : Render,
	initialize : function(name) {
		this.name = name;
		this.type = "saldoEstructura";
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
		
		$(".contBuscar").click(function() {
    		self.createJsonSearch();
    	});
	},

	cleanCombos : function() {
	
	},

	createJsonSearch : function() {
		var searchObject = new Object();
		var buscar=true;
		searchObject.administracionId = $(".contAdministracionCombo").select2('data').id;
		searchObject.estructuraId = $(".contEstructuraCombo").select2('data').id;
		searchObject.fecha=$(".contFechaDesde" ).val();
		
		// Donde va mostrar en y Al?

		$(".contAdministracionCombo").removeClass("errorInput")
    	//Donde va mostrar en y Al?
          if (searchObject.administracionId==""){
        	  $(".contAdministracionCombo" ).addClass('errorInput');
        	  buscar=false;
          }

		 if (buscar){
			 this.crearBusqueda(searchObject);
		 }
	},
	crearBusqueda : function(searchObject) {
		var self = this;
		$.ajax({
			type : 'POST',
			url : 'estructura/getSaldoEstructuraCuenta/',
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
	},

	createCombosEspeciales : function() {

		$("select").select2({
			placeholder : "Choose an option..."
		});
	},
	createValidation : function() {

	},

});

saldoEstructuraRender = new SaldoEstructura()