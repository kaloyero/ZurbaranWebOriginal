var TipoEntidad = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="tipoEntidad";
        this.breadcrumb='Tipo Entidad';
        this.descripcion="Desde aqui gestiones los Tipo de Entidades";
    }


});

tipoEntidadRender=new TipoEntidad();