var Administracion = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="administracion";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administracion";
    },

    afterDataTable:function(){

    }


});

administracionRender=new Administracion();