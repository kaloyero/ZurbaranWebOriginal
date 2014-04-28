var Estructura = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="estructura";
        this.breadcrumb='Moneda';
        this.descripcion="Desde aqui gestiones las Monedas";
    },

    createValidation:function(){
  
    	
    	
    },
    createUpdateValidation:function(){
     
    	
    }


});

estructuraRender=new Estructura();