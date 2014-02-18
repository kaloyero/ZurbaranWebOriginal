var Cotizacion = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="cotizacion";
        this.breadcrumb='Cotizacion';
        this.descripcion="Desde aqui gestiones las Cotizaciones";
    },

    afterDataTable:function(){

    }


});

cotizacionRender=new Cotizacion();