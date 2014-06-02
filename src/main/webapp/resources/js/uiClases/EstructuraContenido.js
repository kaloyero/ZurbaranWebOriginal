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
    		self.estructuraContenidoId=elementId;
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
    	 var self=this;
    	 $(".contCuentaCombo").change(function() {
    		 var row=$(this).parent().parent()
     		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){
     			self.fillCombosRow(data,row);
     			

    			if ($(row).index()+1 == $(row).parent().parent().find("tbody > tr").length){
    				self.createClonedRow(row); 

    			}
     			//self.createClonedRow(row);
     			})
     	});
    	 $(".contDelete").click(function() {
    		 console.log("ID", $(this).parent().parent().find(".contId").text())
    		 if ( $(this).parent().parent().find(".contId").text()!=""){
        		 $(this).parent().parent().remove();

    		 }
    	 })
    	 	 $(".contGuardar").click(function() {
    		    self.createJson();
    	 })
    	 
    	 
     } ,
     createJson:function(row){
    	 var cuentas = [];
    	 var self=this;
    	 $("#contCuentasBody >tr").not(':last').each(function( index,element ) {
    		 var nuevaCuenta=new Object();
    		 if ($(this).find(".contId").text()!=""){
    			 nuevaCuenta.id= $(this).find(".contId").text();
    		 }else{
        		 nuevaCuenta.cuentaId=$(this).find(".contCuentaCombo").val();
        		 nuevaCuenta.entidadId=$(this).find(".contEntidadCombo").val();
        		 nuevaCuenta.monedaId=$(this).find(".contMonedaCombo").val();
        		 nuevaCuenta.estructuraContenidoId=self.estructuraContenidoId;
    		 }
    		 
     		cuentas.push(nuevaCuenta);
     	})
       this.saveCuenta(cuentas);
     },
     saveCuenta:function(cuentas){
    	 console.log("ID",+this.estructuraContenidoId)
    	 var self=this;
    	 $.ajax({type: 'POST',
     		url: 'estructuraContenidoCuenta/saveCuenta/'+self.estructuraContenidoId,
     		contentType: "application/json",
     		data : JSON.stringify(cuentas),
     		success: function(data) {
     			$.jGrowl("Cuentas guardadas", {
     	   			theme : 'success'
     	   		});
     			self.hideCuentaForm()
     			sideBarController.onOptionSelected("estructuraContenido");
 			}});
     	
     },
     
     bindCuentaCombo:function(row){
    	 var self=this;
    	 $(row).find(".contCuentaCombo").change(function() {
    		 var row=$(this).parent().parent()
     		translator.getDataToFillConceptoFormByCuentaId("cuenta",$(this).val(),function(data){
     			self.fillCombosRow(data,row);
     			if ($(row).index()+1 == $(row).parent().parent().find("tbody > tr").length){
    				self.createClonedRow(row); 

    			}
     			})
     	});
     },
     fillCombosRow:function(result,row){
    	 $(row).find('#entidadCombo').find('option').remove();
     	 $(row).find('#monedaCombo').find('option').remove();
    	 if (result.aaData[0]){
     		if (result.aaData[0][1]){
     			for (var i = 0; i < result.aaData[0][1].length; i++) { 
     				var id=result.aaData[0][1][i]["id"];
     				var text=result.aaData[0][1][i]["nombre"];
     				$(row).find('#entidadCombo').append(new Option(text,id));
     			}
     	}
     	
     	for (var i = 0; i < result.aaData[0][2].length; i++) { 
     		var id=result.aaData[0][2][i]["id"];
     		var text=result.aaData[0][2][i]["nombre"];
     		$(row).find('#monedaCombo').append(new Option(text,id));
     		
     	}

     	}
     },
     createClonedRow:function(row){
     	  var clon=$(row).clone();	
 	  		$(row).after(clon);
 	  		this.bindCuentaCombo(clon);
 
     },
     showCuentaForm:function(){
      	  $(".contFormCuenta").modal();
      },
      hideCuentaForm:function(){
         	$(".contFormCuenta").modal('hide');
         },
    createValidation:function(){
    	$(".contFormNew").validate({
    		rules: {
    			estructuraId:"required",
    			codigo: "required",
    		},
    		messages: {
    			estructuraId: "Requerido",
    			codigo: "Por favor ingresa un codigo"

    		}
    	});
    	
    },
    createUpdateValidation:function(){
    	$(".contFormEdit").validate({
    		rules: {
    			estructuraId:"required",
    			codigo: "required",
    		},
    		messages: {
    			estructuraId: "Requerido",
    			codigo: "Por favor ingresa un codigo"

    		}
    	});
    	
    }


});

estructuraContenidoRender=new EstructuraContenido();