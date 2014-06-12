var SideBarController = new Class({
    initialize: function(){

    },
    onOptionSelected: function(objectType){
    	if (objectType=="resumenCuenta"){
    		translator.showResumenCuenta(objectType);

    	}else if (objectType=="saldoCuenta"){
    		translator.showSaldoCuenta(objectType);

    	}else if (objectType=="saldoEstructura"){
    		translator.showSaldoEstructura(objectType);
    	}else if (objectType=="saldoEstructuraMovimiento"){
    		translator.showSaldoEstructuraMovimiento(objectType);
    	}else{
    		translator.show(objectType);
    	}
    	//renderTranslator.getRender(objectType).show(objectType);
    	//tipoEntidadRender.onNew();
    },

    bindMenuOptionsEvents:function() {
    	jQuery('.option').bind("click", function(e) {
    		
    		var objectId=jQuery(this).attr("id");
    		console.log("Type",objectId)
    		sideBarController.onOptionSelected(objectId);
    });

    },

});
var sideBarController=new SideBarController();

