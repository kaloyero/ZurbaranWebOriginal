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
								self.fillCombo(data, $("#tipoDocumentoCombo"),true);							
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
	  makeDatatable:function() {
   	   var self=this;
          console.log("TYPE",this.type,appStatus.currentType)
         appStatus.actualTable=$('#configurationTable').dataTable({
                   
                                 //Este CallBack se ejecuta cuando esta lista la tabla
                            "fnDrawCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
           							self.afterDataTable();
    							
                                 }
                      });
         },
        
     bindListEvents:function() {
    	 	var self=this;
        	self.parent();
        	
        	$(".contAnular").unbind( "click" );
        	$(".contDelete").unbind( "click" );

        	$(".contAnular").click(function() {
        		var elementId=self.getIdFromGrid(this);
        		self.crearPopup("Desea anular el documento?",function(){translator.anularById(elementId)})
        	
        	});
        	$(".contDelete").click(function() {
        		var elementId=self.getIdFromGrid(this);
        		self.crearPopup("Desea cancelar el documento?",function(){translator.deleteDocumentoById(elementId);})
        	});
      
     },
     crearPopup:function(mensaje,execute){
    	 
    		$('<div></div>').appendTo('body')
  		  .html('<div><h6>'+mensaje+'</h6></div>')
  		  .dialog({
  		      modal: true, title: 'Confirmar', zIndex: 10000, autoOpen: true,
  		      width: 'auto', resizable: false,
  		      buttons: {
  		          Si: function () {
  		        	  execute();
  		              $(this).dialog("close");
  		          },
  		          No: function () {
  		              $(this).dialog("close");
  		          }
  		      },
  		      close: function (event, ui) {
  		          $(this).remove();
  		      }
  		});
 
    	 
     },
     onAnulado:function(data) {
    	 console.log("data",data)
    	 if (data.valido==false){
    		 $.jGrowl(data.descripcion, {
    	   			theme : 'error'
    	   		});
    	 }else{
    		 $.jGrowl("Anulado con Exito.", {
    	   			theme : 'success'
    	   		});
    	 }
     },
     onDeleted:function(data) {
    	 if (data.valido==false){
    		 $.jGrowl(data.descripcion, {
    	   			theme : 'error'
    	   		});
    	 }else{
    		 $.jGrowl("Borrado con Exito.", {
    	   			theme : 'success'
    	   		});
    	 }
    	 console.log("data",data)
     },
     
	cleanSearchForm:function(){
    	$('#entidadCombo').find('option').remove();
    },

	fillDocumentSearch : function(data) {
		// cargo las entidades
		$('#entidadCombo').append("<option></option>")
		$("#entidadCombo").append(new Option("TODOS","-1"))
		$('#contTipoEntidadInput').val("")
		$("#entidadCombo").select2("val", "");
		
		for ( var i = 0; i < data.aaData[0][1].length; i++) {
			var id=data.aaData[0][1][i]["id"];
			var text=data.aaData[0][1][i]["nombre"];
			$("#entidadCombo").append(new Option(text, id));

		}
		

		$('#contTipoEntidadInput').val(data.aaData[0][0]["tipoEntidad"]["nombre"])
        $('#contTipoEntidadId').val(data.aaData[0][0]["tipoEntidad"]["id"])

		//$(".contTipoEntidad").val(data.cuenta.tipoEntidad.nombre)

	},
	 createCombosEspeciales:function(r){
	    
	    		$("select").select2({placeholder: "Choose an option..."});
	    	
	    },
	 createDate:function(){
	    $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });
	    $(".contVencimientoHasta").datepicker("setDate",new Date());
	       	
	 },
	createValidation : function() {

	},
	createJson : function() {
		var searchObject=new Object();
    	searchObject.administracionId=$(".contAdministracionCombo" ).select2('data').id;
    	searchObject.entidadId=$("#entidadCombo" ).select2('data').id;
    	searchObject.cuentaId=$(".contCuentaCombo" ).select2('data').id;
    	searchObject.monedaId=$(".contMonedaCombo" ).select2('data').id;
    	searchObject.tipoDocumentoId=$("#tipoDocumentoCombo" ).select2('data').id;
    	searchObject.fechaDesde=$(".contVencimientoDesde" ).val();
    	searchObject.fechaHasta=$(".contVencimientoHasta" ).val();
    	searchObject.referencia=$("#contReferencia" ).val();
    	
    	if ($("#ingreso").is(':checked')){
    		searchObject.tipoFecha=true;
    	}else{
    		searchObject.tipoFecha=false
    	}
    		
    	
    	$(".contAdministracionCombo").removeClass("errorInput")
          if (searchObject.administracionId==""){
        	  $(".contAdministracionCombo" ).addClass('errorInput');
          }else{
        	  this.crearBusqueda(searchObject);
          }
	},
	crearBusqueda:function(searchObject){
		var self=this;
		$.ajax({type: 'POST',
    		url: 'documento/getBySearch/',
    		contentType: "application/json",
    		data : JSON.stringify(searchObject),
    		success: function(data) {
    			self.creaDatatable(data)
    			console.log("Data",data)
			}});
    	
  
	},
	creaDatatable:function(data){
		appStatus.actualTable.fnClearTable()
		appStatus.actualTable.fnAddData(data.aaData)
		//$('#configurationTable').dataTable({aaData:data.aaData,"destroy": true});
	}

});

documentoListadoRender = new DocumentoListado()