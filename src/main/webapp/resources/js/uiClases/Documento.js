var Documento = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="tipoDocumento";
        this.breadcrumb='Tipo Documento';
        this.descripcion="Desde aqui gestiones los Tipo de Documentos";
    },

    createValidation:function(){
     
    	
    },
    bindAddEvents:function() {
    	var self=this;
    	this.parent();
    	$(".contFormNew").find(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("tipoDocumento",$(this).val(),function(data){
    			self.cleanForm();
    			self.fillCombo(data,$(".contFormNew").find("#tipoDocumentoCombo"));
    			})
    	});
    	
    	$(".contFormNew").find("#tipoDocumentoCombo").change(function() {
    		translator.getDocumentoHeader($(this).val(),function(data){
    				self.cleanCombos();
    				self.fillDocumentHeader(data);
    				self.toogleTabs(data);
    			})
    	});

    	
    	
    	//this.createComboAutocomplete(".contImputacionesConcepto")
    	 this.createDateCell();
    	 this.calculateTotals(".contImporte")
    	 this.createEgresoTab();
    	 this.createCombosEspeciales();

    	 
 
    },
    crearTagSeleccion:function(row){
    	var seleccion =$(row).find(".contCancelacionNumero").text() + "/"+$(row).find(".contCancelacionBanco").text()+ "/"+$(row).find(".contCancelacionImporte").text();
    	$('.contCancelacionesAreaSeleccion').textext()[0].tags().addTags([seleccion]);
    },
    cleanCombos:function(){
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();

    	
    },
    createCombosEspeciales:function(row){
    	if (row==null)
    	   $(".contImputacionesConcepto").select2();
    	
    },
    createDateCell:function(){
   	 $('.datepicker').datepicker({showOtherMonths:true });
    	
    },
    calculateTotals:function(selector){
    	$(selector).change(function() {
    		var table=$(this).parent().parent().parent();
    		//console.log("VAL",String.parseInt($("."+$(table).attr("id")+"Total").val()))
    		$("."+$(table).attr("id")+"Total").val($(this).find("input").val())

   	});
 
    },
    createEgresoTab:function(){
    	var self=this;
    	$('.contCancelacionesAreaSeleccion').textext({ plugins: 'tags' });
    	$('.cancelaciones').dataTable();
    	$(".contFormNew").find(".contCancelacionCheck").click(function() {
    		var row=$(this).parent().parent();
    		self.crearTagSeleccion(row);

    	});

    },
    
    createComboAutocomplete:function(combo){
    	var self=this;
    	$(".contFormNew").find(combo).change(function() {
			var row=$(this).parent().parent().parent();
				self.createClonedRow(row); 
				translator.getImputacionesInformation($(this).val(),function(data){
				self.fillImputacionesRow(row,data);
	})
});
    	
    },
    cleanRow:function(row){
    	
    	$(row).find("#entidadId").remove();
    	$(row).find("#monedaId").remove();

    	
    },
    createClonedRow:function(row){
    	var clon=$(row).clone();
	  		$(row).after(clon);
	  		$(clon).find(".contImputacionesConcepto").val("")
	  		$(clon).find(".contImputacionesConcepto").next().remove();
	  		this.createComboAutocomplete($(clon).find(".contImputacionesConcepto"))
    },
    cleanForm:function(){
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();
    	$(".contCuentaId").val("");
    	$(".contCuentaNombre").val("");
    	
    },
    fillDocumentHeader:function(data){
    	var tipoMovimiento;
    	//cargo las entidades
    	for (var i = 0; i < data.entidades.length; i++) { 
    		var id=data.entidades[i]["id"];
    		var text=data.entidades[i]["nombre"];
    		$("#entidadCombo").append(new Option(text,id));
    		
    	}
    	for (var i = 0; i < data.monedas.length; i++) { 
    		var id=data.monedas[i]["id"];
    		var text=data.monedas[i]["nombre"];
    		$("#monedaCombo").append(new Option(text,id));
    		
    	}
    	$(".contCuentaId").val(data.cuenta.id)
    	$(".contCuentaNombre").val(data.cuenta.nombre)
    	if (data.tipoDocumento.tipoMovimiento=="C"){
    		tipoMovimiento="Credito"
    	}else{
    		tipoMovimiento="Debito"
    	}
    	$("#tipoMovimiento").val(tipoMovimiento)


    	
    },
    fillImputacionesRow:function(row,data){
    	
    	$(row).find(".contImputacionesCuenta").text(data.cuenta.nombre)
    	$(row).find(".contImputacionesTipoEntidad").text(data.cuenta.tipoEntidad.nombre)
    	$(row).find(".contImputacionesEntidad").append("<select id='entidadId' name='entidadId' class='span12'></select>")
    	$(row).find(".contImputacionesMoneda").append("<select id='monedaId' name='monedaId' class='span12'></select>")
    	$(row).find(".contImputacionesTipoMovimiento").text($("#tipoMovimiento").val())

    	this.fillComboCell(data.monedas,$(row).find("#monedaId"));
    	this.fillComboCell(data.entidades,$(row).find("#entidadId"));

    },
    fillComboCell:function(result,selector){
    	for (var i = 0; i < result.length; i++) { 
    		var id=result[i].id;
    		var text=result[i].nombre;
    		selector.append(new Option(text,id));
    		
    	}

    },
    toogleTabs:function(data){
    	var primero=null;
    	if (data.tipoDocumento.permiteImputaciones =='N'){
    		$(".contImputaciones").hide();
    	}else{
    		$(".contImputaciones").show();
    		primero=$(".contImputaciones");
    	}
    	if (data.tipoDocumento.permiteAplicaciones =='N'){
    		$(".contCancelaciones").hide();
    	}else{
    		
    		$(".contCancelaciones").show();
    		if (!primero)
    			primero=$(".contCancelaciones");
    	}
    	if (data.tipoDocumento.permiteEgrValTer =='N'){
    		$(".contEgreso").hide();
    	}else{

    		$(".contEgreso").show();
    		if (!primero)
    			primero=$(".contEgreso");
    	}
    	if (data.tipoDocumento.permiteIngValTer =='N'){
    		$(".contIngreso").hide();
    	}else{

    		$(".contIngreso").show();
    		if (!primero)
    			primero=$(".contIngreso");

    	}
    	if (data.tipoDocumento.permiteValProp =='N'){
    		$(".contValores").hide();
    	}else{

    		$(".contValores").show();
    		if (!primero)
    			primero=$(".contValores");
    	}
    	$(primero).find("a").trigger('click');

    },
    resetForm:function(){
    	this.parent();
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();
    	$('#tipoDocumentoCombo').find('option').remove();

      }


});

documentoRender=new Documento();