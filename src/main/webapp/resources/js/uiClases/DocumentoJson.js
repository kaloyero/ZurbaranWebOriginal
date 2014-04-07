var DocumentoJson = new Class({
    initialize: function(name){

    },

    createJson:function(form){
    	
    	var imputaciones = [];
    	var propios = [];
    	var ingreso = [];
        var header=new Object();
    	
        
        header.administracion =$(".contAdministracionCombo").select2('data').id;
        header.tipoDoc =$(".contTipoDocCombo").select2('data').id; id="descripcion"
        header.descripcion =$("#descripcion").text();
        header.moneda =$("#monedaCombo").select2('data').id;
        header.entidad =$("#entidadCombo").select2('data').id;

console.log("HE",header)
        
        
    	$("#contImputacionesBody >tr").not(':last').each(function( index,element ) {
    		var nuevoElemento=new Object();
    		nuevoElemento.concepto=$(this).find(".contImputacionesConcepto").find("select").select2('data').id;

    		nuevoElemento.cuenta=$(this).find(".contImputacionesCuenta").text();
    		nuevoElemento.tipoEntidad=$(this).find(".contImputacionesTipoEntidad").text();
    		nuevoElemento.entidad=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;
    		nuevoElemento.moneda=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		nuevoElemento.cotizacion=$(this).find(".contCotizacion").find("input").val();
    		nuevoElemento.importe=$(this).find(".contImporte").find("input").val();
    		imputaciones.push(nuevoElemento);
    	})
    	
    	
    	$("#contPropiosBody >tr").not(':last').each(function( index,element ) {
    		var nuevoElemento=new Object();
    		
    		nuevoElemento.concepto=$(this).find(".contImputacionesConcepto").find("select").select2('data').id;

    		nuevoElemento.cuenta=$(this).find(".contImputacionesCuenta").text();
    		nuevoElemento.tipoEntidad=$(this).find(".contImputacionesTipoEntidad").text();
    		nuevoElemento.entidad=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;
    		nuevoElemento.moneda=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		nuevoElemento.cotizacion=$(this).find(".contCotizacion").find("input").val();
    		nuevoElemento.importe=$(this).find(".contImporte").find("input").val();
    		nuevoElemento.numero=$(this).find(".contImputacionesNumero").find("input").val();
    		nuevoElemento.fechaVen=$(this).find(".contImputacionesFechaVto").find("input").val();
    		propios.push(nuevoElemento);
    	})
    	$("#contIngresoBody >tr").not(':last').each(function( index,element ) {
    		var nuevoElemento=new Object();
    		nuevoElemento.concepto=$(this).find(".contImputacionesConcepto").find("select").select2('data').id;

    		nuevoElemento.cuenta=$(this).find(".contImputacionesCuenta").text();
    		nuevoElemento.tipoEntidad=$(this).find(".contImputacionesTipoEntidad").text();
    		nuevoElemento.entidad=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;
    		nuevoElemento.moneda=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		nuevoElemento.cotizacion=$(this).find(".contCotizacion").find("input").val();
    		nuevoElemento.importe=$(this).find(".contImporte").find("input").val();
    		nuevoElemento.numero=$(this).find(".contImputacionesNumero").find("input").val();
    		nuevoElemento.fechaVen=$(this).find(".contImputacionesFechaVto").find("input").val();
    		nuevoElemento.banco=$(this).find(".contImputacionesBanco").find("select").select2('data').id;

    		ingreso.push(nuevoElemento);
    	})
    	console.log("imputaciones",imputaciones)

    	console.log("propis",propios)

    	console.log("ingreso",ingreso)

    }

    
    

});

