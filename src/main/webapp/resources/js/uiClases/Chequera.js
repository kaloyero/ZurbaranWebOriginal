var Chequera = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="chequera";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administracion";
    },

    createValidation:function(){
        //this.setDefaultValidationStyle();
    	
        $(".contFormNew").validate({
    		rules: {
    			numeroFin: {
  			      required: true,
  			      number: true
  			    },
  			  numeroIni: {
			      required: true,
			      number: true
			    }
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre"

    		}
    	});
    	
    	
    },

    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
        $(".contFormEdit").validate({
    		rules: {
    			nombre: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre"

    		}
    	});
    	
    	
    }


});

chequeraRender=new Chequera();