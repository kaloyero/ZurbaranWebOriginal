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
    	this.parent();
    	
    	$(".contFormNew").find(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("cuenta",$(this).val(),function(data){
    			self.cleanCombos("contFormNew");
    			self.fillCombo(data,$(".contFormNew").find("#cuentaCombo"));
    			})
    	});
    	$(".contFormNew").find(".contCuentaCombo").change(function() {
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){self.fillConceptoForm(data,"contFormNew");})
    	});

    },
    bindUpdateEvents:function() {

    	var self=this;    	
    	$(".contFormEdit").find(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("cuenta",$(this).val(),function(data){
    			self.cleanCombos("contFormEdit");
    			self.fillCombo(data,$(".contFormEdit").find("#cuentaCombo"))
    			;})
    	});
    	$(".contFormEdit").find(".contCuentaCombo").change(function() {
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){self.fillConceptoForm(data,"contFormEdit");})
    	});

    },  
    cleanCombos:function(formToFind) {
    	$("."+formToFind).find('#entidadCombo').find('option').remove();
    	$("."+formToFind).find('.contTipoEntidadInput').val("")
    },
    fillConceptoForm:function(result,formToFind) {
    	//Agrego el valor del tipo de entidad
    	console.log("RESI",result)
    	$("."+formToFind).find('.contTipoEntidadInput').val(result.aaData[0][0]["tipoEntidad"]["nombre"])
    	
    	//Cargo el Combo de Entidades
    	
    	$("."+formToFind).find('#entidadCombo').find('option').remove();
    	for (var i = 0; i < result.aaData[0][1].length; i++) { 
    		var id=result.aaData[0][1][i]["id"];
    		var text=result.aaData[0][1][i]["nombre"];
    		$("."+formToFind).find('#entidadCombo').append(new Option(text,id));
    		
    	}
    	$("."+formToFind).find('#monedaCombo').find('option').remove();
    	for (var i = 0; i < result.aaData[0][2].length; i++) { 
    		var id=result.aaData[0][2][i]["id"];
    		var text=result.aaData[0][2][i]["nombre"];
    		$("."+formToFind).find('#monedaCombo').append(new Option(text,id));
    		
    	}
    	//Cargo el Combo de Monedas
    },

    createValidation:function(){
    	
        $(".contFormNew").validate({
    		rules: {
    			'nombre': "required",
    			'cuenta.id':"required"
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre",
    			'cuenta.id':"Por favor,elija una cuenta"
    		}
    	});
    	
    	
    },
    createUpdateValidation:function(){
        $(".contFormEdit").validate({
    		rules: {
    			nombre: "required",
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre"

    		}
    	});
    	
    },
    resetForm:function(){
    	this.parent();
    	$(".contFormNew").find('#entidadCombo').find('option').remove();
    	$(".contFormNew").find('#cuentaCombo').find('option').remove();


      },


});

conceptoRender=new Concepto()