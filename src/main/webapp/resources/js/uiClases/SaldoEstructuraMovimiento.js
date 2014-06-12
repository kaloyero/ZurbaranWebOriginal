var SaldoEstructuraMovimiento = new Class({
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
		searchObject.fechaDesde=$(".contFechaDesde" ).val();
		searchObject.fechaHasta=$(".contFechaHasta" ).val();
		

		$(".contAdministracionCombo").removeClass("errorInput")
		$(".contEstructuraCombo").removeClass("errorInput")
		$(".contFechaHasta").removeClass("errorInput")
		$(".contFechaDesde").removeClass("errorInput")

		if (searchObject.administracionId==""){
        	  $(".contAdministracionCombo" ).addClass('errorInput');
        	  buscar=false;
          }
		if (searchObject.estructuraId==""){
      	  $(".contEstructuraCombo" ).addClass('errorInput');
      	  buscar=false;
        }
		if (searchObject.fechaDesde==""){
	      	  $(".contFechaDesde" ).addClass('errorInput');
	      	  buscar=false;
	        }
		if (searchObject.fechaHasta==""){
	      	  $(".contFechaHasta" ).addClass('errorInput');
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
			url : 'estructura/getSaldoEstructuraMovimiento/',
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

saldoEstructuraMovimientoRender = new SaldoEstructuraMovimiento()