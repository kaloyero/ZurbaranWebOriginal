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
    			$(".contFormNew").find(".contPeriodo").attr("checked", false);
    		}else{
    			$(".contFormNew").find(".contControl").attr("disabled", true);
    			$(".contFormNew").find(".contControl").attr("checked", false);
    			$(".contFormNew").find(".contPeriodo").removeAttr("disabled");
    		}
    	}
    	);
    	

    },
    bindUpdateEvents:function() {

    	var self=this;
    	this.parent();
    	console.log("VALO ",$(".contFormEdit").find(".tipoNumeracion").val())
    	if ($("#NumeracionTipo1").is(':checked')){
    		$(".contFormEdit").find(".contControl").removeAttr("disabled");
			$(".contFormEdit").find(".contPeriodo").attr("disabled", true);
		}else{
			$(".contFormEdit").find(".contControl").attr("disabled", true);
			$(".contFormEdit").find(".contPeriodo").removeAttr("disabled");
		}
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
    		console.log("ENTRa")
    		if ($(this).val()=='M'){
    			$(".contFormEdit").find(".contControl").removeAttr("disabled");
    			$(".contFormEdit").find(".contPeriodo").attr("disabled", true);
    			$(".contFormEdit").find(".contPeriodo").attr("checked", false);
    		}else{
    			$(".contFormEdit").find(".contControl").attr("disabled", true);
    			$(".contFormEdit").find(".contControl").attr("checked", false);
    			$(".contFormEdit").find(".contPeriodo").removeAttr("disabled");
    		}
    	}
    	);
    	

    },
    fillTipoDocumentoForm:function(result,formToFind) {
    	
    	//Cargo el Combo de Entidades
    	
    	$("."+formToFind).find('#entidadCombo').find('option').remove();
    	$("."+formToFind).find('#monedaCombo').find('option').remove();
    	$("."+formToFind).find('#monedaCombo').append(new Option("",""))
    	//$("."+formToFind).find('#entidadCombo').append(new Option("",""))
    	if (result.aaData[0]){
    		if (result.aaData[0][1]){
    			for (var i = 0; i < result.aaData[0][1].length; i++) { 
    				var id=result.aaData[0][1][i]["id"];
    				var text=result.aaData[0][1][i]["nombre"];
    				$("."+formToFind).find('#entidadCombo').append(new Option(text,id));
    		
    			}
    		}
    		for (var i = 0; i < result.aaData[0][2].length; i++) { 
    			var id=result.aaData[0][2][i]["id"];
    			var text=result.aaData[0][2][i]["nombre"];
    			$("."+formToFind).find('#monedaCombo').append(new Option(text,id));
    		
    		}
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
    specialFormValidation : function() {
    	if ($('#PermiteIngValTer').is(':checked')|| $('#PermiteValProp').is(':checked')|| $('#PermiteImputaciones').is(':checked') ||$('#PermiteEgrValTer').is(':checked')
    			||$('#PermiteAplicaciones').is(':checked')) {
    		return true
    	}else{
    		alert("No se han elegido permisos")
    		return false
    	}
	},
 cleanCombos:function(formToFind) {
    	
    }


});

tipoDocumentoRender=new TipoDocumento();