var TipoEntidad = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="administracion";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administraciones";
    },

    onListTest:function(data){
        //$( ".contenidoPrincipal" ).load( "TipoEntidadesTable.html", function() {

       // });
    }


});

tipoEntidadRender=new TipoEntidad()