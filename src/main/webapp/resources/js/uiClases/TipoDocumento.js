var TipoDocumento = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="tipoDocumento";
        this.breadcrumb='Tipo Documento';
        this.descripcion="Desde aqui gestiones los Tipo de Documentos";
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
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){
    			console.log("DATArear",data)
    			self.fillTipoDocumentoForm(data,"contFormNew");
    			})
    	});
    	$(".contFormNew").find(".tipoNumeracion").change(function() {
    		console.log("VA:",$(this).val())
    		if ($(this).val()=='M'){
    			$(".contFormNew").find(".contControl").removeAttr("disabled");
    			$(".contFormNew").find(".contPeriodo").attr("disabled", true);
    		}else{
    			$(".contFormNew").find(".contControl").attr("disabled", true);
    			$(".contFormNew").find(".contPeriodo").removeAttr("disabled");
    		}
    	}
    	);
    	

    },
    bindUpdateEvents:function() {

    	var self=this;
    	this.parent();
    	
    	$(".contFormEdit").find(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("cuenta",$(this).val(),function(data){
    			self.cleanCombos("contFormEdit");
    			self.fillCombo(data,$(".contFormEdit").find("#cuentaCombo"));
    			})
    	});
    	$(".contFormEdit").find(".contCuentaCombo").change(function() {
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){self.fillTipoDocumentoForm(data,"contFormEdit");})
    	});
    	$(".contFormEdit").find(".tipoNumeracion").change(function() {
    		if ($(this).val()=='M'){
    			$(".contFormEdit").find(".contControl").removeAttr("disabled");
    			$(".contFormEdit").find(".contPeriodo").attr("disabled", true);
    		}else{
    			$(".contFormEdit").find(".contControl").attr("disabled", true);
    			$(".contFormEdit").find(".contPeriodo").removeAttr("disabled");
    		}
    	}
    	);
    	

    },
    fillTipoDocumentoForm:function(result,formToFind) {
    	
    	//Cargo el Combo de Entidades
    	
    	$("."+formToFind).find('#entidadCombo').find('option').remove();

    	for (var i = 0; i < result.aaData[0][1].length; i++) { 
    		var id=result.aaData[0][1][i]["id"];
    		var text=result.aaData[0][1][i]["nombre"];
    		$("."+formToFind).find('#entidadCombo').append(new Option(text,id));
    		
    	}
    	$("."+formToFind).find('#monedaCombo').find('option').remove();

    	for (var i = 0; i < result.aaData[0][2].length; i++) { 
    		var id=result.aaData[0][2][i]["id"];
    		var text=result.aaData[0][2][i]["nombre"];
    		$("."+formToFind).find('#monedaCombo').append(new Option(text,id));
    		
    	}
    	
    	//Cargo el Combo de Monedas
    },
 createValidation:function(){
	   $(".contFormNew").validate({
   		rules: {
   			'nombre': "required",
   			'NumeracionTipo':'required',
   			'NumeracionPeriodo':'required',
   		    'cuentaId':'required',
   		    'administracion.id':'required'
   		},
   		messages: {
   			nombre: "Requerido",
   			'NumeracionTipo': "Requerido",
   			'NumeracionPeriodo':"Requerido",
   			'cuentaId':'Requerido',
   			'administracion.id':'Requerido'
   		}
   	});
    	
    },
    createUpdateValidation:function(){
    	   $(".contFormEdit").validate({
    		   rules: {
    	   			'nombre': "required",
    	   			'NumeracionTipo':'required',
    	   			'NumeracionPeriodo':'required',
    	   		    'cuentaId':'required',
    	   		    'administracion.id':'required'
    	   		},
    	   		messages: {
    	   			nombre: "Requerido",
    	   			'NumeracionTipo': "Requerido",
    	   			'NumeracionPeriodo':"Requerido",
    	   			'cuentaId':'Requerido',
    	   			'administracion.id':'Requerido'
    	   		}
    	   	});
    },
 cleanCombos:function(formToFind) {
    	
    }


});

tipoDocumentoRender=new TipoDocumento();