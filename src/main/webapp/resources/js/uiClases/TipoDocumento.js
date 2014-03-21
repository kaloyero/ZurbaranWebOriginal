var TipoDocumento = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="tipoDocumento";
        this.breadcrumb='Tipo Documento';
        this.descripcion="Desde aqui gestiones los Tipo de Documentos";
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
    		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){self.fillTipoDocumentoForm(data,"contFormNew");})
    	});

    },
    fillTipoDocumentoForm:function(result,formToFind) {
    	
    	//Cargo el Combo de Entidades
    	
    	$("."+formToFind).find('#entidadCombo').find('option').remove();
    	for (var i = 0; i < result.aaData[0][1].length; i++) { 
    		var id=result.aaData[0][1][i]["id"];
    		var text=result.aaData[0][1][i]["nombre"];
    		$("."+formToFind).find('#entidadCombo').append(new Option(text,id));
    		
    	}
    	//Cargo el Combo de Monedas
    },
 createValidation:function(){
	   $(".contFormNew").validate({
   		rules: {
   			'nombre': "required"
   		},
   		messages: {
   			nombre: "Por favor ingresa un nombre"
   		}
   	});
    	
    },
 cleanCombos:function(formToFind) {
    	
    }


});

tipoDocumentoRender=new TipoDocumento();