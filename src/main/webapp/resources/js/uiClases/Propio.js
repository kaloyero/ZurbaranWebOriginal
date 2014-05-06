var Propio = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="propio";
        this.breadcrumb='Tercero';
        this.descripcion="Desde aqui gestiones las Administracion";
    },

    createValidation:function(){

    	
    	
    },

    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();

    	
    	
    },
    makeDatatable:function() {
    	
    },  
    bindAddEvents:function() {

    	var self=this;
    	this.parent();
    	this.createCombosEspeciales();
      	$('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });

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
    makeDatatable:function() {
    	
    },
    createJsonSearch:function() {
    	var searchObject=new Object();
    	searchObject.administracionId=$(".contAdministracionCombo" ).val();
    	searchObject.cuentaId=$("#contCuentaCombo" ).val();
    	searchObject.entidadId=$("#entidadCombo" ).val();
    	//searchObject.monedaId=$("#monedaCombo" ).val(); //FALTA JAVA
    	searchObject.fechaVtoDesde=$(".contVencimientoDesde" ).val();
    	searchObject.fechaVtoHasta=$(".contVencimientoHasta" ).val();
    	searchObject.fechaEmisionDesde=$(".contEmitidoDesde").val(); 
    	searchObject.fechaEmisionHasta=$(".contEmitidoHasta").val();
    	
    	this.crearBusqueda(searchObject);
	},
	crearBusqueda:function(searchObject){
		$.ajax({type: 'POST',
    		url: 'propio/getBySearch/',
    		contentType: "application/json",
    		data : JSON.stringify(searchObject),
    		success: function(data) {
    			
			}});
    	
  
	},
    cleanCombos:function() {
    	$("#entidadCombo").find('option').remove();
    	$("#monedaCombo").find('option').remove();
    	$("#contCuentaCombo").find('option').remove();
    },
    fillSearchForm:function(result) {
    	//Agrego el valor del tipo de entidad
    	$("#entidadCombo").find('option').remove();
    	$("#monedaCombo").find('option').remove();
    	$("#monedaCombo").append(new Option("",""))
    	$('#contTipoEntidadInput').val("")
    	//$("."+formToFind).find('#entidadCombo').append(new Option("",""))
    	//$("."+formToFind).find('.contTipoEntidadInput').val("")
    	
    	//Cargo el Combo de Entidades
    	if (result.aaData[0]){
    		if (result.aaData[0][1]){
    			for (var i = 0; i < result.aaData[0][1].length; i++) { 
    				var id=result.aaData[0][1][i]["id"];
    				var text=result.aaData[0][1][i]["nombre"];
    				$("#entidadCombo").append(new Option(text,id));
    			}
    	}
    	
    	for (var i = 0; i < result.aaData[0][2].length; i++) { 
    		var id=result.aaData[0][2][i]["id"];
    		var text=result.aaData[0][2][i]["nombre"];
    		$("#monedaCombo").append(new Option(text,id));
    		
    	}
        $('#contTipoEntidadInput').val(result.aaData[0][0]["tipoEntidad"]["nombre"])

    	}
    	
    	//Cargo el Combo de Monedas
    },
    createCombosEspeciales:function(r){
	    
		$("select").select2({placeholder: "Choose an option..."});
	
    },


});

propioRender=new Propio();