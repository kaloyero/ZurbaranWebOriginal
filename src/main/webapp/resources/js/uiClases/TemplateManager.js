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
            }

    },

});
var templateManager=new TemplateManager();

