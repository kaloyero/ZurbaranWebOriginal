var DocumentoJson = new Class({
    initialize: function(name){
      this.procederAGuardar = true;
    },

    createJson:function(form){
    	
    	var imputaciones = [];
        var header=new Object()
        procederAGuardar=true;
        this.validateForm();
        
     
        if (procederAGuardar){
        	
        		header.administracionId =$(".contAdministracionCombo").select2('data').id;
        		header.cuentaId =$(".contCuentaId").val(); 
        		header.tipoDocumentoId =$(".contTipoDocCombo").select2('data').id;
        		header.descripcion =$("#descripcion").text();
        		header.monedaId =$("#monedaCombo").select2('data').id;
        		header.cotizacion =$("#headerCotizacion").val();
        		header.entidadId =$("#entidadCombo").select2('data').id;
        		header.sector="Header";
        		header.fechaReal=$(".contFechaReal").val();
        		header.fechaIngreso=$(".contFechaIngreso").val();
        		header.fechaVencimiento=$(".contFechaVto").val();
        		header.importeTotal=$(".contDebito").val();
        		header.tipoMovimiento=$("#tipoMovimiento").val();
        		header.numeroLetra=$(".contLetra").select2('data').id
        		header.numeroEstablecimiento=$(".contEstablecimiento").val()
        		header.numeroAnio=$(".contAnio").val()
        		header.numeroMes=$(".contMes").val()
        		header.numeroDia=$(".contDia").val()
        		header.numero=$(".contNumeroFinal").val()

        		imputaciones.push(header);
        
        
    	$("#contImputacionesBody >tr").not(':last').each(function( index,element ) {
    		var nuevoElemento=new Object();
    		nuevoElemento.conceptoId=$(this).find(".contImputacionesConcepto").find("select").select2('data').id;

    		//nuevoElemento.cuentaId=$(this).find(".contImputacionesCuenta").text();
    		//nuevoElemento.tipoEntidadId=$(this).find(".contImputacionesTipoEntidad").text();
    		nuevoElemento.entidadId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;
    		nuevoElemento.monedaId=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		nuevoElemento.cotizacion=$(this).find(".contCotizacion").find("input").val();
    		nuevoElemento.importeTotal=$(this).find(".contImporte").find("input").val();
    		
    		nuevoElemento.sector="imputaciones";
    		imputaciones.push(nuevoElemento);
    	})
    	
    	
    	$("#contPropiosBody >tr").not(':last').each(function( index,element ) {
    		var nuevoElemento=new Object();
    		
    		nuevoElemento.conceptoId=$(this).find(".contImputacionesConcepto").find("select").select2('data').id;
    		nuevoElemento.monedaId=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		if($(this).find(".contImputacionesEntidad").find("select").select2('data')){
        		nuevoElemento.entidadId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;

    		}else{
    			nuevoElemento.entidadId="";
    		}

    		nuevoElemento.cotizacion=$(this).find(".contCotizacion").find("input").val();
    		nuevoElemento.importeTotal=$(this).find(".contImporte").find("input").val();
    		nuevoElemento.numero=$(this).find(".contImputacionesNumero").find("input").val();
    		nuevoElemento.fechaVencimiento=$(this).find(".contImputacionesFechaVto").find("input").val();
    		nuevoElemento.beneficiario=$(this).find(".contImputacionesBeneficiario").find("input").val();
    		nuevoElemento.tipoMovimiento=$("#tipoMovimiento").val();
    		nuevoElemento.sector="propios";

    		imputaciones.push(nuevoElemento);
    	})
    	$("#contIngresoBody >tr").not(':last').each(function( index,element ) {
    		var nuevoElemento=new Object();
    		nuevoElemento.conceptoId=$(this).find(".contImputacionesConcepto").find("select").select2('data').id;    		
    		nuevoElemento.monedaId=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		nuevoElemento.entidadId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;

    		nuevoElemento.cotizacion=$(this).find(".contCotizacion").find("input").val();
    		nuevoElemento.importeTotal=$(this).find(".contImporte").find("input").val();
    		nuevoElemento.numero=$(this).find(".contImputacionesNumero").find("input").val();
    		nuevoElemento.fechaVencimiento=$(this).find(".contImputacionesFechaVto").find("input").val();
    		nuevoElemento.bancoId=$(this).find(".contImputacionesBanco").find("select").select2('data').id;
    		nuevoElemento.tipoMovimiento=$("#tipoMovimiento").val();
    		nuevoElemento.sector="ingreso";


    		imputaciones.push(nuevoElemento);
    	})
    	
    	$("#contCancelacionesBody >tr").not(':last').each(function( index,element ) {
    		var nuevoElemento=new Object();
    		nuevoElemento.importeAplicado=$(this).find(".contCancelacionPendiente").find("input").val();
    		nuevoElemento.documentoAplicaId=$(this).find(".contCancelacionesCombo").select2('data').id;  
    		nuevoElemento.sector="cancelacion";
    		imputaciones.push(nuevoElemento);
    	})
    	//Preparo Egreso
    	$(".text-tag").each(function( index,element ) {
    		var nuevoElemento=new Object();
    		nuevoElemento.valorTerceId= $(this).find(".idEgreso").val()
    		nuevoElemento.sector="egreso";
    		imputaciones.push(nuevoElemento);
    	})

    	
    	
    	//myMap["people"] = nuevoElemento;

    	$.ajax({type: 'POST',
    		url: 'documento/testSave/',
    		contentType: "application/json",
    		data : JSON.stringify(imputaciones),
    		success: function(data) {
    			$.jGrowl("Documento guardado", {
    	   			theme : 'success'
    	   		});
    			sideBarController.onOptionSelected("documento");
			}});
    	
        }else{
        	$(".guardar").attr("disabled",false)
        }
        
   
    	
    },
    validateForm:function(){
    	$(".error").remove();
    	$( "*" ).removeClass("errorInput")
    	//$(".errorInput").remove();

    	this.validateHeader();
    	this.validateImputaciones();
    	this.validatePropios();
    	this.validateIngresos();
    	this.validateTotal();
    },
    validateHeader:function(){
    	administracionId=$(".contAdministracion").find("select").select2('data').id;
    	tipoDocumentoId=$(".contTipoDoc").find("select").select2('data').id;
    	entidadId=$(".contEntidad").find("select").select2('data').id;
    	monedaId=$(".contMoneda").find("select").select2('data').id;
    	
    	fechaVto=$(".contFechaVto").val();
    	fechaIngreso=$(".contFechaIngreso").val();
    	fechaReal=$(".contFechaReal").val();
    	tipoEntidad=$(".contTipoEntidad").val();

    	

    	if (fechaVto==""){
    		procederAGuardar=false;
    		$(".contFechaVto").before('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    	}
    	if (fechaIngreso==""){
    		procederAGuardar=false;

    		$(".contFechaIngreso").before('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    	}
    	if (fechaReal==""){
    		procederAGuardar=false;

    		$(".contFechaReal").before('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    	}
    	if (tipoDocumentoId==""){
    		procederAGuardar=false;
    		
    		$("#tipoDocumentoCombo").addClass('errorInput');
   			//$(".contTipoDoc").addClass('errorInput');

    		//$(".contTipoDoc").append('<p class="error help-block"><span class="label label-important">Complete el Tipo de Doc</span></p>');

    	}
    	if (administracionId==""){
    		procederAGuardar=false;
   			$(".contAdministracion").addClass('errorInput');

    		//$(".contAdministracion").append('<p class="error help-block"><span class="label label-important">Complete la Administracion</span></p>');

    	}
    	if (tipoEntidad!=""){
    		if (entidadId==""){
    			procederAGuardar=false;
    		
    			$("#entidadCombo").addClass('errorInput');
    			//$(".contEntidad").addClass('errorInput');

    			//$(".contEntidad").append('<p class="error help-block"><span class="label label-important">Complete la entidad</span></p>');

    		}
    	}
       	if (monedaId==""){
    		procederAGuardar=false;
   			$("#monedaCombo").addClass('errorInput');

    		//$(".contMoneda").append('<p class="error help-block"><span class="label label-important">Complete la moneda</span></p>');

       	}
       	if (!$("#contNumeracion").attr("disabled")){
       		if ($(".contLetra").find('option:selected').text()==""){
       			$(".contLetra").addClass('errorInput');

        		//$(".contLetra").after('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

       		}
       	}

       	if (!$(".contEstablecimiento").is('[readonly]')){
       		if ($(".contEstablecimiento").val()==""){
       			$(".contEstablecimiento").addClass('errorInput');

        		//$(".contEstablecimiento").after('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

       		}
       	}
       	if (!$(".contAnio").is('[readonly]')){
       		if ($(".contAnio").val()==""){
       			$(".contAnio").addClass('errorInput');
        		//$(".contAnio").after('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

       		}
		
       	}
       	if (!$(".contMes").is('[readonly]')){
       		if ($(".contMes").val()==""){
       			$(".contMes").addClass('errorInput');

        		//$(".contMes").after('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

       		}
       	}
   	 	if (!$(".contDia").is('[readonly]')){
       		if ($(".contDia").val()==""){
       			$(".contDia").addClass('errorInput');

        		//$(".contMes").after('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

       		}
   	 	}
       	 	if (!$(".contNumeroFinal").is('[readonly]')){
           		if ($(".contNumeroFinal").val()==""){
           			$(".contNumeroFinal").addClass('errorInput');


           		}
}

       	
       	
       	
    },
    validateImputaciones:function(){
    	$("#contImputacionesBody >tr").not(':last').each(function( index,element ) {
    		//id=$(this).find(".contImputacionesConcepto").find("select").select2('data').id
    		if ($(this).find(".contImputacionesEntidad").find("select").select2('data')){
        		entidadId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;
        		if (entidadId==""){
            		procederAGuardar=false;
        		    $(this).find(".contImputacionesEntidad").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');
        		}
    		}
    		if($(this).find(".contImputacionesMoneda").find("select").select2('data')){
        		monedaId=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
        		if (monedaId==""){
        		    $(this).find(".contImputacionesMoneda").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

        		}
    		}

    		

    		

    	})
    },
    validatePropios:function(){
    	$("#contPropiosBody >tr").not(':last').each(function( index,element ) {
    		//id=$(this).find(".contImputacionesConcepto").find("select").select2('data').id
    		if($(this).find(".contImputacionesEntidad").find("select").select2('data')){
        		entidadId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;

    		}else{
    			entidadId="sinEntidad";
    		}
    		monedaId=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		fecha=$(this).find(".contImputacionesFechaVto").find("input").val();

    		if (entidadId==""){
    			procederAGuardar=false;
    		    $(this).find(".contImputacionesEntidad").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    		}

    		if (monedaId==""){
    			procederAGuardar=false;
    		    $(this).find(".contImputacionesMoneda").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    		}
    		
    		if (fecha==""){
    			procederAGuardar=false;
    		    $(this).find(".contImputacionesFechaVto").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    		}
    	})
    },
    validateIngresos:function(){
    	$("#contIngresoBody >tr").not(':last').each(function( index,element ) {
    		//id=$(this).find(".contImputacionesConcepto").find("select").select2('data').id
    		entidadId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;
    		monedaId=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		fecha=$(this).find(".contImputacionesFechaVto").find("input").val();

    		if (entidadId==""){
    			procederAGuardar=false;
    		    $(this).find(".contImputacionesEntidad").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    		}

    		if (monedaId==""){
    			procederAGuardar=false;
    		    $(this).find(".contImputacionesMoneda").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    		}

    		if (fecha==""){
    			procederAGuardar=false;
    		    $(this).find(".contImputacionesFechaVto").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');

    		}
    	
    	})
    },
    validateTotal:function(){
    	totalCancelacion=$(".contCancelacionesTotal").val();
    	totalDocumento=$(".contDebito").val();
    	if (totalCancelacion!=0){
    		if (totalDocumento!=totalCancelacion){
    			procederAGuardar=false;

    			$(".contDebito").before('<p class="error help-block"><span class="label label-important">El Total del documento debe coincidir con el total de aplicaciones</span></p>');
    		}
    	}
    }

    
    

});

