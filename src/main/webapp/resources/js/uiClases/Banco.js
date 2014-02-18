var Banco = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="banco";
        this.breadcrumb='Banco';
        this.descripcion="Desde aqui gestiones los Bancos";
    },

    afterDataTable:function(){

    }


});

bancoRender=new Banco()