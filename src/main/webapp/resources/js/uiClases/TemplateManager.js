var TemplateManager = new Class({
    initialize: function(){

    },
    getTableTemplate: function(type){
        	switch (type) {
    		case "tipoEntidad":
    			return "TipoEntidadesTable.html";
    			break;
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
	 }

    }

});
var templateManager=new TemplateManager();

