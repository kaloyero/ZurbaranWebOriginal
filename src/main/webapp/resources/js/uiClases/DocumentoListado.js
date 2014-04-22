var DocumentoListado = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="documento";
        this.breadcrumb='Documentos';
        this.descripcion="Desde aqui gestiones los Documentos";
    },
    
createValidation:function(){
	
}


});

documentoListadoRender=new DocumentoListado()