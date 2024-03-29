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
		
		$(".contFechaDesde").datepicker("setDate",new Date());
		
		$("#monedaComboEn").change(function() {
			var selectedId=$(this).select2('data').id;

				translator.getCotizacionyByMonedaId(selectedId,function(data){
				if (data==0){
					$("#headerCotizacion").val(1);

				}else{
					$("#headerCotizacion").val(data);

				}
				})  
			
			
		});		
		$(".contBuscar").click(function() {
    		self.createJsonSearch("buscar");
    	});
		$(".contExcel").click(function() {
    		self.createJsonSearch("excel");
    	});
	},

	cleanCombos : function() {
	
	},

	createJsonSearch : function(callback) {
		var searchObject = new Object();
		var buscar=true;
		searchObject.administracionId = $(".contAdministracionCombo").select2('data').id;
		searchObject.estructuraId = $(".contEstructuraCombo").select2('data').id;
		searchObject.fecha=$(".contFechaDesde" ).val();
		searchObject.monedaMostrarId=$("#monedaComboEn" ).select2('data').id;

		$(".contAdministracionCombo").removeClass("errorInput")
		$(".contEstructuraCombo").removeClass("errorInput")
		$(".contFechaDesde").removeClass("errorInput")

		if (searchObject.administracionId==""){
        	  $(".contAdministracionCombo" ).addClass('errorInput');
        	  buscar=false;
          }
		if (searchObject.estructuraId==""){
      	  $(".contEstructuraCombo" ).addClass('errorInput');
      	  buscar=false;
        }
		if (searchObject.fecha==""){
	      	  $(".contFechaDesde" ).addClass('errorInput');
	      	  buscar=false;
	        }

		if (buscar){
			 if (callback=="buscar"){
				 this.crearBusqueda(searchObject);

			 }else{
				 this.exportarExcel(searchObject)
		 }
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
	exportarExcel : function(searchObject) {
		$.ajax({
			type : 'POST',
			url : 'estructura/exporExSaldoEstructura/',
			contentType : "application/json",
			data : JSON.stringify(searchObject),
			success : function(data) {
				$.jGrowl("Informacion Exportada", {
     	   			theme : 'success'
     	   		});
			}
		});
	

},
	
makeDatatable : function() {
	var self = this;
	appStatus.actualTable = $('#configurationTable')
			.dataTable(
					{
						"bProcessing" : true,
						// "bServerSide": true,
						// "iDisplayStart": 0,
						// "DisplayLength":10,
						"aLengthMenu" : [ 10, 25, 50, 100, 150, 200 ],
						 "iDisplayLength":[50],
						// "bPaginate": true,
						// "bFiltered": true,
						"sAjaxSource" : appStatus.currentType
								+ "/lista",
						/*
						 * "oLanguage": { "sUrl":
						 * "dataTables.german.txt" },
						 * 
						 */sDom : 'T<"clear">lfrtip',
						 "bSort": false,
					   aoColumnDefs : {
					            'bSortable' : false,
					            'aTargets' : [ -1 ]
					        } ,				 
						oTableTools : {
							"sSwfPath" : "resources/media/swf/copy_csv_xls_pdf.swf",
							"aButtons" : [ "copy", {
								"sExtends" : "csv",
								"sTitle" : "Exportacion csv",
								"sFileName" : "saldoEstructura.csv"
							}, {
								"sExtends" : "xls",
								"sTitle" : "titleExportxls",
								"sFileName" : "saldoEstructura.xls"
							}, {
								"sExtends" : "pdf",
								"sTitle" : "titleExportpdf",
								"sFileName" : "saldoEstructura.pdf"
							}, "print" ]
						},
						"oLanguage" : {
							"sProcessing" : "Procesando...",
							"sSearch" : "B�squeda:",
							"sLengthMenu" : "Mostrar _MENU_ registros",
							"sZeroRecords" : "No se encontraron resultados",
							"sEmptyTable" : "Ning�n dato disponible en esta tabla",
							"sInfo" : "Mostrando _START_ hasta _END_ de un total de  _TOTAL_ registros",
							"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
							"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
							"sLoadingRecords" : "Cargando...",
							"oPaginate" : {
								"sNext" : "Pr�xima",
								"sFirst" : "Primera",
								"sLast" : "Ultima",
								"sPrevious" : "Previo"

							}
						},
						// Este CallBack se ejecuta cuando esta
						// lista la tabla
						"fnDrawCallback" : function(nRow, aData,
								iDisplayIndex, iDisplayIndexFull) {
							self.afterDataTable();

						}
					});
},

	creaDatatable:function(data){
		appStatus.actualTable.fnClearTable()
		appStatus.actualTable.fnAddData(data.aaData)
	},

	createCombosEspeciales : function() {

		$("select").select2({
			placeholder : "Elegir una opcion..."
		});
	},
	createValidation : function() {

	},

});

saldoEstructuraRender = new SaldoEstructura()