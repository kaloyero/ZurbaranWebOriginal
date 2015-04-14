var Chequera = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="chequera";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administracion";
    },
    getTitleExport:function(){
		
		return "Chequera"
	},
	bindListEvents:function(){
    	this.parent()
    	var self=this;
    	$(".contAddNoDisponible").click(function() {
    		self.elementoIdCelda = self.getIdFromGrid(this);
    		$(".contNoDisponibleForm").find("form")[0].reset();
    		$(".contNoDisponibleForm").modal();
    		$(".contNoDisponibleForm .datepicker").datepicker("setDate",new Date());
        	$("#contImporte").number( true, 2 )

    		//translator.getNoDisponibleForm("estructuraContenido",elementId);
    		
    	})
    		$(".contListadoCheques").click(function() {
			
    		var elementId = self.getIdFromGrid(this);
    		
        	 $.ajax({type: 'GET',
         		url: 'chequera/getChequesByChequera/'+elementId,
         		contentType: "application/json",
         		success: function(data) {
         			$(".contListadoCheque").remove()
         			
         			self.getContainer().append(data);
         			self.makeDatatableListadoCheques()
         			$(".contListadoCheque").modal();
         			

     			}});

	})
    	console.log("DLIST")
    	
    },
    bindAddEvents:function() {

    	var self=this;
    	this.parent();
    	$(".contFormNew").find(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("cuenta",$(this).val(),function(data){
    			self.cleanCombos("contFormNew");
    			self.fillCombo(data,$(".contFormNew").find("#cuentaCombo"));
    			})
    	});
    	$(".contFormNew").find(".contCuentaCombo").change(function() {
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){self.fillChequeraForm(data,"contFormNew");})
    	});
    	$(".contGuardarNoDisponible").click(function() {
    		var nuevoCheque=new Object();
    		nuevoCheque.numero=$("#contNumCheque").val()
    		nuevoCheque.motivo=$("#contMotivo").val()
    		nuevoCheque.beneficiario=$("#contBeneficiario").val()
    		nuevoCheque.importe=$("#contImporte").val()
    		nuevoCheque.fechaEmision=$("#contFechaEmision").val()
    		nuevoCheque.fechaVto=$("#contFechaVto").val()
    		nuevoCheque.idChequera=self.elementoIdCelda;
    		
        	 $.ajax({type: 'POST',
         		url: 'chequera/saveNodisponible/',
         		contentType: "application/json",
         		data : JSON.stringify(nuevoCheque),
         		success: function(data) {
         			$(".contNoDisponibleForm").modal('hide');
         			console.log("DATA",data)
         			if (data.valido==true){
         				$.jGrowl("Operacion Exitosa", {
             	   			theme : 'success'
             	   		});
         			}else{
         				$.jGrowl(data.descripcion, {
        					theme : 'error'
        				});
         			}
         			

     			}});

	})
	

		$('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy'});	
    },
    cleanCombos:function(formToFind) {
    	$("."+formToFind).find('#entidadCombo').find('option').remove();
    	$("."+formToFind).find('.contTipoEntidadInput').val("")
    },
    fillChequeraForm:function(result,formToFind) {
    	//Agrego el valor del tipo de entidad
    	$("."+formToFind).find('#entidadCombo').find('option').remove();
    	$("."+formToFind).find('#monedaCombo').find('option').remove();
    	$("."+formToFind).find('#monedaCombo').append(new Option("",""))
    	//$("."+formToFind).find('#entidadCombo').append(new Option("",""))
    	$("."+formToFind).find('.contTipoEntidadInput').val("")
    	
    	//Cargo el Combo de Entidades
    	if (result.aaData[0]){
    		if (result.aaData[0][1]){
    			for (var i = 0; i < result.aaData[0][1].length; i++) { 
    				var id=result.aaData[0][1][i]["id"];
    				var text=result.aaData[0][1][i]["nombre"];
    				if (id>-1)
    				  $("."+formToFind).find('#entidadCombo').append(new Option(text,id));
    			}
    	}
    	
    	for (var i = 0; i < result.aaData[0][2].length; i++) { 
    		var id=result.aaData[0][2][i]["id"];
    		var text=result.aaData[0][2][i]["nombre"];
    		$("."+formToFind).find('#monedaCombo').append(new Option(text,id));
    		
    	}
        	$("."+formToFind).find('.contTipoEntidadInput').val(result.aaData[0][0]["tipoEntidad"]["nombre"])
        	$("."+formToFind).find('.contTipoEntidadIdInput').val(result.aaData[0][0]["tipoEntidad"]["id"])

    	}
    	
    	//Cargo el Combo de Monedas
    },
    createValidation:function(){
        //this.setDefaultValidationStyle();
    	$.validator.addMethod(
    		    "greaterThan",
    		    function(value,element,params) {
    		        if (value > $(params).val()) {
    		            return true;
    		        }
    		        return false;
    		    },
    		    "EL numero debe ser mas grande que el Inicial"
    		);
    	
        $(".contFormNew").validate({
    		rules: {
    			numeroFin: {
  			      required: true,
  			      number: true,
  			      min: 1,
  			      greaterThan: '#numeroIni'
  			    },
  			  numeroIni: {
			      required: true,
			      number: true,
			      min: 1
			    }
    		},
    		messages: {
    			numeroIni: {
    		           min: "Ingrese un numero correcto"
    		       },
    		    numeroFin: {
    		           min: "Ingrese un numero correcto"
    		       },
    		}
    	});
    	
    	
    },

    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
        $(".contFormEdit").validate({
    		
    	});
    	
    	
    },
    makeDatatableListadoCheques : function() {
		var self = this;
		
		console.log("TYPE", this.type, appStatus.currentType)
		appStatus.actualTable = $('#configurationTableCheques')
				.dataTable(
						{
							"aaSorting": [self.getOrderTable()],
							"bFilter": false,
							"bLengthChange": false,
							"oLanguage" : {
								"sProcessing" : "Procesando...",
								"sSearch" : "Busqueda:",
								"sLengthMenu" : "Mostrar _MENU_ registros",
								"sZeroRecords" : "No se encontraron resultados",
								"sEmptyTable" : "Ningún dato disponible en esta tabla",
								"sInfo" : "Mostrando _START_ hasta _END_ de un total de  _TOTAL_ registros",
								"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
								"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
								"sLoadingRecords" : "Cargando...",
								"oPaginate" : {
									"sNext" : "Proxima",
									"sFirst" : "Primera",
									"sLast" : "Ultima",
									"sPrevious" : "Previo"

								}
							},
							
							// Este CallBack se ejecuta cuando esta
							// lista la tabla
							"fnDrawCallback" : function(nRow, aData,
									iDisplayIndex, iDisplayIndexFull) {
								console.log("AFFF")
								self.afterDataTable();

							}
						});
	},


});

chequeraRender=new Chequera();