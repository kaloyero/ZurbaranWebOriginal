var Chequera = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="chequera";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administracion";
    },
    getTitleExport:function(){
		
		return "Chequera"
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
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){self.fillChequeraForm(data,"contFormNew");})
    	});

    },
    cleanCombos:function(formToFind) {
    	$("."+formToFind).find('#entidadCombo').find('option').remove();
    	$("."+formToFind).find('.contTipoEntidadInput').val("")
    },
    fillChequeraForm:function(result,formToFind) {
    	//Agrego el valor del tipo de entidad
    	$("."+formToFind).find('#entidadCombo').find('option').remove();
    	$("."+formToFind).find('#monedaCombo').find('option').remove();
    	$("."+formToFind).find('#monedaCombo').append(new Option("",""))
    	//$("."+formToFind).find('#entidadCombo').append(new Option("",""))
    	$("."+formToFind).find('.contTipoEntidadInput').val("")
    	
    	//Cargo el Combo de Entidades
    	if (result.aaData[0]){
    		if (result.aaData[0][1]){
    			for (var i = 0; i < result.aaData[0][1].length; i++) { 
    				var id=result.aaData[0][1][i]["id"];
    				var text=result.aaData[0][1][i]["nombre"];
    				$("."+formToFind).find('#entidadCombo').append(new Option(text,id));
    			}
    	}
    	
    	for (var i = 0; i < result.aaData[0][2].length; i++) { 
    		var id=result.aaData[0][2][i]["id"];
    		var text=result.aaData[0][2][i]["nombre"];
    		$("."+formToFind).find('#monedaCombo').append(new Option(text,id));
    		
    	}
        	$("."+formToFind).find('.contTipoEntidadInput').val(result.aaData[0][0]["tipoEntidad"]["nombre"])
        	$("."+formToFind).find('.contTipoEntidadIdInput').val(result.aaData[0][0]["tipoEntidad"]["id"])

    	}
    	
    	//Cargo el Combo de Monedas
    },
    createValidation:function(){
        //this.setDefaultValidationStyle();
    	$.validator.addMethod(
    		    "greaterThan",
    		    function(value,element,params) {
    		        if (value > $(params).val()) {
    		            return true;
    		        }
    		        return false;
    		    },
    		    "EL numero debe ser mas grande que el Inicial"
    		);
    	
        $(".contFormNew").validate({
    		rules: {
    			numeroFin: {
  			      required: true,
  			      number: true,
  			      min: 1,
  			      greaterThan: '#numeroIni'
  			    },
  			  numeroIni: {
			      required: true,
			      number: true,
			      min: 1
			    }
    		},
    		messages: {
    			numeroIni: {
    		           min: "Ingrese un numero correcto"
    		       },
    		    numeroFin: {
    		           min: "Ingrese un numero correcto"
    		       },
    		}
    	});
    	
    	
    },

    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
        $(".contFormEdit").validate({
    		
    	});
    	
    	
    }


});

chequeraRender=new Chequera();