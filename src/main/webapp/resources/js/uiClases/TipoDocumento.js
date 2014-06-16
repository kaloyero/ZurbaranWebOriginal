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
    			$(".contFormNew").find("#general").attr("checked", true);
    			$(".contFormNew").find("#contAutomatica").show();
    			$(".contFormNew").find("#contManual").hide();

    			//$(".contFormNew").find(".contControl").hide();
    			//$(".contFormNew").find(".contPeriodo").show();
    			//$(".contFormNew").find(".contPeriodo").attr("checked", false);

    		}else{
    			$(".contFormNew").find(".contControl").attr("disabled", true);
    			$(".contFormNew").find(".contControl").attr("checked", false);
    			$(".contFormNew").find(".contPeriodo").removeAttr("disabled");
    			$(".contFormNew").find("#hist").attr("checked", true);
    			$(".contFormNew").find("#contAutomatica").hide();
    			$(".contFormNew").find("#contManual").show();
    			
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
			$(".contFormEdit").find("#contAutomatica").show();
			$(".contFormEdit").find("#contManual").hide();
		}else{
			$(".contFormEdit").find(".contControl").attr("disabled", true);
			$(".contFormEdit").find(".contPeriodo").removeAttr("disabled");
			$(".contFormEdit").find("#contAutomatica").hide();
			$(".contFormEdit").find("#contManual").show();
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
    			$(".contFormEdit").find("#general").attr("checked", true);
    			$(".contFormEdit").find("#contAutomatica").show();
    			$(".contFormEdit").find("#contManual").hide();
    		}else{
    			$(".contFormEdit").find(".contControl").attr("disabled", true);
    			$(".contFormEdit").find(".contControl").attr("checked", false);
    			$(".contFormEdit").find(".contPeriodo").removeAttr("disabled");
    			$(".contFormEdit").find("#hist").attr("checked", true);
    			$(".contFormEdit").find("#contAutomatica").hide();
    			$(".contFormEdit").find("#contManual").show();
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
    	$("."+formToFind).find('.contTipoEntidadInput').val(result.aaData[0][0].tipoEntidad.nombre)

    	
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
    specialFormValidation : function(placeToFind) {
    	var findIn=$(".contFormNew")
    	console.log("Sele",$(".contConceptos option:selected"))
    	var continueSave=true;
    	if (placeToFind){
    		findIn=placeToFind;
    	}
    	if (findIn.find('#permiteIngValTer').is(':checked')|| findIn.find('#permiteValProp').is(':checked')|| findIn.find('#permiteImputaciones').is(':checked')||findIn.find('#permiteEgrValTer').is(':checked')
    			||findIn.find('#permiteAplicaciones').is(':checked')) {
    		continueSave= true
    	}else{
    		alert("No se han elegido permisos")
    		continueSave=  false
    	}
    	if (continueSave){
    		if (findIn.find(".contConceptos option:selected").length>0){
    			return true;
    		}else{
    			//alert("No se han elegido conceptos")
    			return true;
    		}
    	}else{
    		return continueSave;
    	}
    	
	},
 cleanCombos:function(formToFind) {
    	
    },
	resetForm:function(){
		this.parent();
		$(".contFormNew").find(".contControl").removeAttr("disabled");
		$(".contFormNew").find(".contPeriodo").attr("disabled", true);
		$(".contFormNew").find(".contPeriodo").attr("checked", false);
		$(".contFormNew").find("#general").attr("checked", false);
		$(".contFormNew").find("#contAutomatica").show();
		$(".contFormNew").find("#contManual").hide();

	}


});

tipoDocumentoRender=new TipoDocumento();