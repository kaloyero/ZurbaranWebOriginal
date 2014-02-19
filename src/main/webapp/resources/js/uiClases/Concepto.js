var Concepto = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="concepto";
        this.breadcrumb='Concepto';
        this.descripcion="Desde aqui gestiones los Conceptos";
    },

    afterDataTable:function(){

    }


});

conceptoRender=new Concepto()