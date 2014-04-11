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
        header.entidadId =$("#entidadCombo").select2('data').id;
        header.sector="Header";
        header.fechaReal=$(".contFechaReal").val();
        header.fechaIngreso=$(".contFechaIngreso").val();
        header.fechaVencimiento=$(".contFechaVto").val();
      
         imputaciones.push(header);
console.log("HE",header)
        
        
    	$("#contImputacionesBody >tr").not(':last').each(function( index,element ) {
    		var nuevoElemento=new Object();
    		nuevoElemento.conceptoId=$(this).find(".contImputacionesConcepto").find("select").select2('data').id;

    		//nuevoElemento.cuentaId=$(this).find(".contImputacionesCuenta").text();
    		//nuevoElemento.tipoEntidadId=$(this).find(".contImputacionesTipoEntidad").text();
    		nuevoElemento.entidadId=$(this).find(".contImputacionesEntidad").find("select").select2('data').id;
    		nuevoElemento.monedaId=$(this).find(".contImputacionesMoneda").find("select").select2('data').id;
    		nuevoElemento.cotizacion=$(this).find(".contCotizacion").find("input").val();
    		nuevoElemento.importe=$(this).find(".contImporte").find("input").val();
    		nuevoElemento.sector="imputaciones";
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
    	
    	var nuevoElemento=new Object();
var nuevoElemento2=new Object();
var nuevoElemento3=new Object();



nuevoElemento2.id=1
nuevoElemento2.nombre="d"
nuevoElemento2.referencia="a";
nuevoElemento2.array="a";

nuevoElemento3.id=1

nuevoElemento.id=1
nuevoElemento.doc=nuevoElemento3;
nuevoElemento2.array="a";
var myMap = [];
var myMapTest = [];

//myMapTest.push(nuevoElemento3);

nuevoElemento.doc=nuevoElemento3;
//nuevoElemento2.array=myMapTest;

myMap.push(nuevoElemento)


    	//myMap["people"] = nuevoElemento;

    	//$.ajax({type: 'POST',url: 'documento/testSave/',contentType: "application/json",data : JSON.stringify(imputaciones)});
    	
    	
    	
    	
    },
    calculateTotals:function(){
    }

    
    

});

