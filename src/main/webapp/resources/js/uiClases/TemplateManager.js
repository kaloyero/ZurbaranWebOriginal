var TemplateManager = new Class({
    initialize: function(){

    },
    getTableTemplate: function(type){
        	switch (type) {
    		case "moneda":
    			return "resources/template/MonedaTable.html";
    			break;
    		case "administracion":
    			return "resources/template/AdministracionTable.html";
    			break;
           
    		case "banco":
    			return "resources/template/BancoTable.html";
    			break;
    		case "concepto":
    			return "resources/template/ConceptoTable.html";
    			break;
    		case "tipoDocumento":
    			return "resources/template/TipoDocumentoTable.html";
    			break;
    		case "cuenta":
    			return "resources/template/CuentaTable.html";
    			break;
    		case "entidad":
    			return "resources/template/EntidadTable.html";
    			break;
    		case "tipoEntidad":
    			return "resources/template/TipoEntidadTable.html";
    			break;
	 }

    }

});
var templateManager=new TemplateManager();

