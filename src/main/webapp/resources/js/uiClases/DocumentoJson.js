var DocumentoJson = new Class({
    initialize: function(name){

    },

    createJson:function(form){
    	
    	var imputaciones = [];
    	var propios = [];
    	var ingreso = [];
        var header=new Object();
    	
        
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
      
         imputaciones.push(header);
console.log("HEgg",header)
        
        
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
    		

    		
    		nuevoElemento.conceptoId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;
    		nuevoElemento.monedaId=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		nuevoElemento.entidadId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;

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

    	
    	
    	//myMap["people"] = nuevoElemento;

    	$.ajax({type: 'POST',url: 'documento/testSave/',contentType: "application/json",data : JSON.stringify(imputaciones)});
    	
    	
    	
    	
    },
    calculateTotals:function(){
    }

    
    

});

