var Rol = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="rol";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administracion";
    },
    getTitleExport:function(){
		
		return "Rol"
	},
    bindAddEvents:function() {

    	var self=this;
    	this.parent();
    	$("#allToRight").click(function() {
			self.moveAll('from', 'to');
		});
    	$("#allToLeft").click(function() {
    		self.moveAll('to', 'from')
		});
    	$("#selectedToLeft").click(function() {
    		self.moveSelected('to', 'from')
		});
    	$("#selectedToRight").click(function() {
    		self.moveSelected('from', 'to')
		});
    
   

    },
    moveAll:function(from,to) {
    	$('#'+from+' option').remove().appendTo('#'+to); 
    },
    moveSelected:function(from,to) {
    	 $('#'+from+' option:selected').remove().appendTo('#'+to); 
    },
    
    cleanCombos:function(formToFind) {
    	
    },
  
    createValidation:function(){

    	
        $(".contFormNew").validate({
    		
    	});
    	
    	
    },

    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
        $(".contFormEdit").validate({
    		
    	});
    	
    	
    }


});

rolRender=new Rol();