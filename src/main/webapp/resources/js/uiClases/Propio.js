var Propio = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="propio";
        this.breadcrumb='Tercero';
        this.descripcion="Desde aqui gestiones las Administracion";
    },
    getTitleExport:function(){
		
		return "ValoresPropios"
	},
    createValidation:function(){

    	
    	
    },

    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();

    	
    	
    },
 
    bindAddEvents:function() {

    	var self=this;
    	this.parent();
    	this.createCombosEspeciales();
      	$('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });
      	$(".contEmitidoHasta").datepicker("setDate",new Date());
      	$(".contVencimientoHasta").datepicker("setDate",new Date());

      	

    	$(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("cuenta",$(this).val(),function(data){
    			self.cleanCombos();
    			self.fillCombo(data,$("#contCuentaCombo"));
    			})
    	});
    	$("#contCuentaCombo").change(function() {
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){self.fillSearchForm(data,"contFormNew");})
    	});
    	$(".contBuscar").click(function() {
    		self.createJsonSearch();
    	});

    },
    bindListEvents:function() {
     	var self=this;
     	$(self.getViewButtons()).unbind( "click" );

    	self.getViewButtons().click(function() {
    		var elementId=self.getIdFromGrid(this);
	  		translator.getFormById("documento",elementId);
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
     makeDatatable:function() {
   	   var self=this;
          console.log("TYPE",this.type,appStatus.currentType)
          jQuery.fn.dataTableExt.oSort['importe-desc'] = function (a, b) {
        	  
        	  var valorUno=a.replace(/,/g,'')
  			valorUno.replace(/./g,'')
  		    var valorDos=b.replace(/,/g,'')
  		    valorDos.replace(/./g,'')

  		  return (parseFloat(valorUno) < parseFloat(valorDos)) ? 1 : ((parseFloat(valorUno) > parseFloat(valorDos)) ? -1 : 0);
		};
		jQuery.fn.dataTableExt.oSort['importe-asc'] = function (a, b) {
		
			var valorUno=a.replace(/,/g,'')
			valorUno.replace(/./g,'')
		    var valorDos=b.replace(/,/g,'')
		    valorDos.replace(/./g,'')

		    return (parseFloat(valorUno) > parseFloat(valorDos)) ? 1 : ((parseFloat(valorUno) < parseFloat(valorDos)) ? -1 : 0);
		};
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
		
		
		
		
         appStatus.actualTable=$('#configurationTable').dataTable({
        	 "aoColumns":[
                          null,                 
                          null,
                          { sType: 'date-dd-mmm-yyyy' },
                          { sType: 'date-dd-mmm-yyyy' },
                          null,
                          null,
                          null,
                          null,
                          { sType: 'importe' },
                          null,
   

                      ],
        	 "aLengthMenu" : [ 10, 25, 50, 100, 150, 200 ],
			 "iDisplayLength":50,
			 "bProcessing" : true,
                                 //Este CallBack se ejecuta cuando esta lista la tabla
                            "fnDrawCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
           							self.afterDataTable();
    							
                                 }
                      });
         },
    createJsonSearch:function() {
    	var searchObject=new Object();
    	searchObject.administracionId=$(".contAdministracionCombo" ).select2('data').id;
    	searchObject.cuentaId=$("#contCuentaCombo" ).select2('data').id;
    	searchObject.entidadId=$("#entidadCombo" ).select2('data').id;
    	searchObject.monedaId=$(".contMonedaCombo" ).select2('data').id;
    	searchObject.fechaVtoDesde=$(".contVencimientoDesde" ).val();
    	searchObject.fechaVtoHasta=$(".contVencimientoHasta" ).val();
    	searchObject.tipoEntidadId = $("#contTipoEntidadId").val();
    	searchObject.fechaEmisionDesde=$(".contEmitidoDesde").val(); 
    	searchObject.fechaEmisionHasta=$(".contEmitidoHasta").val();
    	
    	$(".contAdministracionCombo").removeClass("errorInput")
    	//Donde va mostrar en y Al?
          if (searchObject.administracionId==""){
        	  $(".contAdministracionCombo" ).addClass('errorInput');
          }else{
        	  this.crearBusqueda(searchObject);
          }
	},
	crearBusqueda:function(searchObject){
		var self=this;
		$.ajax({type: 'POST',
    		url: 'propio/getBySearch/',
    		contentType: "application/json",
    		data : JSON.stringify(searchObject),
    		success: function(data) {
    			self.creaDatatable(data);
			}});
    	
  
	},
	creaDatatable:function(data){
		
		appStatus.actualTable.fnClearTable()
		appStatus.actualTable.fnAddData(data.aaData)
		//$('#configurationTable').dataTable({aaData:data.aaData,"destroy": true});
	},
    cleanCombos:function() {
    	$("#entidadCombo").find('option').remove();
    	$("#contCuentaCombo").find('option').remove();
    },
    fillSearchForm:function(result) {
    	//Agrego el valor del tipo de entidad
    	$("#entidadCombo").find('option').remove();
    	$("#entidadCombo").append(new Option("",""))
    	$('#contTipoEntidadInput').val("")
    	//$("."+formToFind).find('#entidadCombo').append(new Option("",""))
    	//$("."+formToFind).find('.contTipoEntidadInput').val("")
    	
    	//Cargo el Combo de Entidades
    	if (result.aaData[0]){
    		if (result.aaData[0][1]){
    			if (result.aaData[0][1].length >0){
					$("#entidadCombo").append(new Option("TODOS","-1"))
				}
    			for (var i = 0; i < result.aaData[0][1].length; i++) { 
    				var id=result.aaData[0][1][i]["id"];
    				var text=result.aaData[0][1][i]["nombre"];
    				$("#entidadCombo").append(new Option(text,id));
    			}
    	}
    
        $('#contTipoEntidadInput').val(result.aaData[0][0]["tipoEntidad"]["nombre"])
        $('#contTipoEntidadId').val(result.aaData[0][0]["tipoEntidad"]["id"])
        
    	}
    	$("#entidadCombo").select2("val", "");
    	
    	//Cargo el Combo de Monedas
    },
    createCombosEspeciales:function(r){
	    
		$("select").select2({placeholder: "Choose an option..."});
	
    },


});

propioRender=new Propio();