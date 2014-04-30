var EstructuraContenido = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="estructuraContenido";
        this.breadcrumb='Moneda';
        this.descripcion="Desde aqui gestiones las Monedas";
    },
    bindListEvents:function(){
    	this.parent()
    	var self=this;
    	$(".contCuenta").click(function() {
    		var elementId=self.getIdFromGrid(this);
    		translator.getCuentaByContenido("estructuraContenido",elementId);
    		
    	})
    },
    removeCuentaForm:function(){
  	  $(".contFormCuenta").remove()
    },
    showCuentas:function(data){
    	console.log("SS")
    	this.removeCuentaForm();
      	this.getContainer().append(data);
      	this.showCuentaForm();
      	this.bindCuenta();
      },
     bindCuenta:function(){
    	 $(".contCuentaCombo").change(function() {
    		 alert("Seere")
    	 })
    	 $(".contDelete").click(function() {
    		 console.log("ID", $(this).parent().parent().find(".contId").text())
    		 if ( $(this).parent().parent().find(".contId").text()!=""){
        		 $(this).parent().parent().remove()

    		 }
    	 })
    	 
    	 
     } ,
      
     showCuentaForm:function(){
      	  $(".contFormCuenta").modal();
      },
    createValidation:function(){
    	$(".contFormNew").validate({
    		rules: {
    			codigo: "required",
    		},
    		messages: {
    			codigo: "Por favor ingresa un codigo"

    		}
    	});
    	
    },
    createUpdateValidation:function(){
    	$(".contFormEdit").validate({
    		rules: {
    			codigo: "required",
    		},
    		messages: {
    			codigo: "Por favor ingresa un codigo"

    		}
    	});
    	
    }


});

estructuraContenidoRender=new EstructuraContenido();