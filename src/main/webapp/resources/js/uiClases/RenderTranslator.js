var RenderTranslator = new Class({
    initialize: function(){

    },

    getRender: function(type){
    	switch (type) {
		case "moneda":
			return monedaRender;
			break;
		case "administracion":
			return administracionRender;
			break;
		case "banco":
			return bancoRender;
			break;
		case "concepto":
			return conceptoRender;
			break;
		case "cotizacion":
			return cotizacionRender;
			break;
		case "cuenta":
			return cuentaRender;
			break;
		case "entidad":
			return entidadRender;
			break;	
		case "tipoDocumento":
			return tipoDocumentoRender;
			break;
		case "documento":
			return documentoRender;
			break;
		case "documentoListado":
			return documentoListadoRender;
			break;
		case "tipoEntidad":
			return tipoEntidadRender;
		case "estructura":
			return estructuraRender;
		case "estructuraContenido":
				return estructuraContenidoRender;
		case "saldoEstructura":
			return saldoEstructuraRender;
		case "saldoEstructuraMovimiento":
			return saldoEstructuraMovimientoRender;
		case "resumenCuenta":
			return resumenCuentaRender;
		case "saldoCuenta":
			return saldoCuentaRender;
		case "tercero":
			return terceroRender;
		case "chequera":
			return chequeraRender;
		case "periodo":
			return usuarioRender;
		case "usuario":
			return usuarioRender;
		case "rol":
			return rolRender;
		case "propio":
			return propioRender;
			break;
		case "DocumentoAplicadoMov":
			return documentoAplicadoMov;
		
	}
 }

});

renderTranslator=new RenderTranslator();