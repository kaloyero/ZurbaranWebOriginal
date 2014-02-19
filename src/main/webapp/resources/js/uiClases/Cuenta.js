var Cuenta = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="cuenta";
        this.breadcrumb='Cuenta';
        this.descripcion="Desde aqui gestiones las Cuentas";
    },

    afterDataTable:function(){

    }


});

cuentaRender=new Cuenta()