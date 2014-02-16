var SideBarController = new Class({
    initialize: function(){

    },
    onOptionSelected: function(objectType){
    	//translator.show(objectType);
    	render.show(objectType);
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

