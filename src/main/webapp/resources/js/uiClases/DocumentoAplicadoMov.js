var DocumentoAplicadoMov = new Class({
	Extends : Render,
	initialize : function(name) {
		this.name = name;
		this.type = "documentoAplicado";
		this.breadcrumb = 'Documentos';
		this.descripcion = "Desde aqui busque los movimientos de los docuentos Aplicados";
	},
	getTitleExport:function(){
		
		return "DocumentoAplicadoMovs";
	},

	bindAddEvents : function() {

		var self = this;
		this.parent();
		this.createCombosEspeciales();
		$('.datepicker').datepicker({
			showOtherMonths : true,
			dateFormat : 'dd-mm-yy'
		});
		$('.contVencimientoHasta').datepicker("setDate",new Date());
		

		$(".contAdministracionCombo").change(function() {
			translator.getListByAdmin("cuenta", $(this).val(), function(data) {
				self.cleanCombos();
				self.fillCombo(data, $("#contCuentaCombo"));
			});
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
		$("#monedaComboMostrar").find('option').remove();
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
		//this.resetResult();
		var searchObject = new Object();
		var buscar=true;
		
		searchObject.administracionId = $(".contAdministracionCombo").select2('data').id;
		searchObject.movCuentaId=$("#contCuentaCombo").select2('data').id;
		searchObject.movTipoEntidadId = $("#contTipoEntidadId").val();
		searchObject.movEntidadId = $("#entidadCombo").select2('data').id;
		searchObject.docAplicaNumeroFormateado = $("#contDocumento").val();
		searchObject.docAplicadoFechaDesde = $(".contVencimientoDesde").val();
		searchObject.docAplicadoFechaHasta  = $(".contVencimientoHasta").val();
		searchObject.movReferencia = $("#contReferencia").val();
		searchObject.movMonedaId = $(".monedaCombo").select2('data').id;
		searchObject.monedaMuestraId = $(".monedaComboMostrar").select2('data').id;		
		
		// Donde va mostrar en y Al?

		$(".contAdministracionCombo").removeClass("errorInput")
		$(".contVencimientoDesde").removeClass("errorInput")
		$(".contVencimientoHasta").removeClass("errorInput")
    	//Donde va mostrar en y Al?
          if (searchObject.administracionId==""){
        	  $(".contAdministracionCombo" ).addClass('errorInput');
        	  buscar=false;
          }
		 if (searchObject.fechaDesde!=""){
			 console.log("VALDE",$(".contVencimientoDesde").datepicker("getDate"))
			 var fechaDesde=$(".contVencimientoDesde").datepicker("getDate")
			 var fechaHasta =$(".contVencimientoHasta").datepicker("getDate")
			 if (fechaDesde > fechaHasta){
				 $(".contVencimientoDesde" ).addClass('errorInput');
				 $(".contVencimientoHasta" ).addClass('errorInput');
				 buscar=false;
			 }
		 }
		 if (buscar){
			 this.crearBusqueda(searchObject);
		 }
	},
	crearBusqueda : function(searchObject) {
		var self = this;
		$.ajax({
			type : 'POST',
			url : 'documentoAplicado/getBySearch/',
			contentType : "application/json",
			data : JSON.stringify(searchObject),
			success : function(data) {
				self.creaDatatable(data)
			}
		});

	},

	getFechaFromString:function(fecha){
	    var sptdate = String(fecha).split("-");
	    var myMonth = sptdate[0];
	    var myDay = sptdate[1];
	    var myYear = sptdate[2];
	    var combineDatestr = myYear + "/" + myDay + "/" + myMonth;

	    var dt = new Date(combineDatestr);
	    return dt
	},
	
	makeDatatable:function(){
		var self=this;
		jQuery.fn.dataTableExt.oSort['date-dd-mmm-yyyy-desc'] = function (a, b) {
		   var ordA = self.getFechaFromString(a),
		        ordB = self.getFechaFromString(b);
		    
		    return (ordA.getTime() > ordB.getTime()) ? 1 : ((ordA.getTime() < ordB.getTime()) ? -1 : 0);
		};
		jQuery.fn.dataTableExt.oSort['date-dd-mmm-yyyy-asc'] = function (a, b) {
		
		    var ordA = self.getFechaFromString(a),
		        ordB = self.getFechaFromString(b);
		    
		    return (ordA.getTime() < ordB.getTime()) ? 1 : ((ordA.getTime() > ordB.getTime()) ? -1 : 0);
		};
  jQuery.fn.dataTableExt.oSort['importe-desc'] = function (a, b) {
        	  
        	  var valorUno=a.replace(/,/g,'');
  			valorUno.replace(/./g,'');
  		    var valorDos=b.replace(/,/g,'');
  		    valorDos.replace(/./g,'');

  		  return (parseFloat(valorUno) < parseFloat(valorDos)) ? 1 : ((parseFloat(valorUno) > parseFloat(valorDos)) ? -1 : 0);
		};
		jQuery.fn.dataTableExt.oSort['importe-asc'] = function (a, b) {
		
			var valorUno=a.replace(/,/g,'');
			valorUno.replace(/./g,'');
		    var valorDos=b.replace(/,/g,'');
		    valorDos.replace(/./g,'');

		    return (parseFloat(valorUno) > parseFloat(valorDos)) ? 1 : ((parseFloat(valorUno) < parseFloat(valorDos)) ? -1 : 0);
		};
		appStatus.actualTable =$('#configurationTable')
			.dataTable({ "aoColumns":[
										null,
										{ sType: 'date-dd-mmm-yyyy' },
										null,
										null,
										null,
										null,
										{ sType: 'importe' },
										{ sType: 'importe' },
										null,
										{ sType: 'importe' },
										null,
										null,
										null,
										null,
										{ sType: 'importe' },
										null,
										{ sType: 'importe' }
			                      ],
			                      "aLengthMenu" : [ 10, 25, 50, 100, 150, 200 ],
									 "iDisplayLength":50,
			                      sDom : 'T<"clear">lfrtip',
			                      oTableTools : {
										"sSwfPath" : "resources/media/swf/copy_csv_xls_pdf.swf",
										"aButtons" : [ "copy", {
											"sExtends" : "csv",
											"sTitle" : self.getTitleExport(),
											"sFileName" : "*.csv"
										}, {
											"sExtends" : "xls",
											"sTitle" : self.getTitleExport(),
											"sFileName" : "*.xls"
										}, {
											"sExtends" : "pdf",
											"sTitle" : self.getTitleExport(),
											"sFileName" : "*.pdf"
										}, "print" ]
									},
									"fnDrawCallback" : function(nRow, aData,
											iDisplayIndex, iDisplayIndexFull) {
										self.afterDataTable();

									}
			
			})

	},
	creaDatatable:function(data){
		appStatus.actualTable.fnClearTable();
		appStatus.actualTable.fnAddData(data.aaData)
		//$('#configurationTable').dataTable({aaData:data.aaData,"destroy": true});
	},
	fillSearchForm : function(result) {
		// Agrego el valor del tipo de entidad
		$("#entidadCombo").find('option').remove();
		$('#contTipoEntidadInput').val("")
		$("#entidadCombo").append(new Option("",""))
		
		// $("."+formToFind).find('#entidadCombo').append(new Option("",""))
		// $("."+formToFind).find('.contTipoEntidadInput').val("")

		// Cargo el Combo de Entidades
		if (result.aaData[0]) {
			if (result.aaData[0][1]) {
				if (result.aaData[0][1].length >0){
					$("#entidadCombo").append(new Option("TODOS","-1"))
				}
				for ( var i = 0; i < result.aaData[0][1].length; i++) {
					var id = result.aaData[0][1][i]["id"];
					var text = result.aaData[0][1][i]["nombre"];
					$("#entidadCombo").append(new Option(text, id));
				}
			}
			$('#contTipoEntidadInput').val(result.aaData[0][0]["tipoEntidad"]["nombre"])	
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

documentoAplicadoMovRender = new DocumentoAplicadoMov()