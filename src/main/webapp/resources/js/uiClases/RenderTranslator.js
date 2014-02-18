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
		case "tipoEntidad":
			return tipoEntidadRender;
			break;
	}
 }

});

renderTranslator=new RenderTranslator();