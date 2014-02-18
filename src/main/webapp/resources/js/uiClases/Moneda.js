var Moneda = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="moneda";
        this.breadcrumb='Moneda';
        this.descripcion="Desde aqui gestiones las Monedas";
    },

    afterDataTable:function(){

    }


});

monedaRender=new Moneda();