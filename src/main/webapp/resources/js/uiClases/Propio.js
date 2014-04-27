var Propio = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="propio";
        this.breadcrumb='Tercero';
        this.descripcion="Desde aqui gestiones las Administracion";
    },

    createValidation:function(){

    	
    	
    },

    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();

    	
    	
    },
    makeDatatable:function() {
    	
    },
    createJsonSearch:function() {
    	var searchObject=new Object();
    	searchObject.administracionId=$(".contAdministracionCombo" ).val();
    	searchObject.cuentaId=$("#contCuentaCombo" ).val();
    	searchObject.entidadId=$("#entidadCombo" ).val();
    	searchObject.monedaId=$("#monedaCombo" ).val();
    	searchObject.bancoId=$(".contBancoCombo" ).val();
    	searchObject.vencimientoDesde=$(".contVencimientoDesde" ).val();
    	searchObject.vencimientoHasta=$(".contVencimientoHasta" ).val();
    	
    	console.log("SEARCH",searchObject)
    },


});

propioRender=new Propio();