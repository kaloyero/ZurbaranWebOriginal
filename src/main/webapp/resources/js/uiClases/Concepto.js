var Concepto = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="concepto";
        this.breadcrumb='Concepto';
        this.descripcion="Desde aqui gestiones los Conceptos";
    },
    
    bindAddEvents:function() {
    	var self=this;
    	$(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("cuenta",$(this).val(),function(data){self.fillCombo(data,"cuentaCombo");})
    	});
    	$(".contCuentaCombo").change(function() {
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){self.fillConceptoForm(data);})
    	});

    },   
    fillConceptoForm:function(result) {
    	console.log("RES*T",result)
    	//Agrego el valor del tipo de entidad
  
    	$('.contTipoEntidadInput').val(result.aaData[0][0]["tipoEntidad"]["nombre"])
    	
    	//Cargo el Combo de Entidades
    	
    	$('#entidadCombo').find('option').remove();
    	for (var i = 0; i < result.aaData[0][1].length; i++) { 
    		var id=result.aaData[0][1][i]["id"];
    		var text=result.aaData[0][1][i]["nombre"];
    		$('#entidadCombo').append(new Option(text,id));
    		
    	}
    	//Cargo el Combo de Monedas
    },

    createValidation:function(){
        this.setDefaultValidationStyle();
    	
        $("form").validate({
    		rules: {
    			nombre: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre"

    		}
    	});
    	
    	
    }


});

conceptoRender=new Concepto()