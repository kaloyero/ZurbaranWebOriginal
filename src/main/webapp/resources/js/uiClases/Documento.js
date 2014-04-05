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
    	
   	    this.createCombosEspeciales();

    	
    	
    	$(".contFormNew").find(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("tipoDocumento",$(this).val(),function(data){
    			self.cleanForm();
    			self.fillCombo(data,$(".contFormNew").find("#tipoDocumentoCombo"));
    			})
    	});
    	
    	$(".contFormNew").find("#tipoDocumentoCombo").change(function() {
    		var selectedId=$(this).select2('data').id;
    		
    		translator.getDocumentoHeader(selectedId,function(data){
    				self.cleanCombos();
    				self.fillDocumentHeader(data);
    				self.toogleTabs(data);
    			})
    	});
    	
    	$(".cancelaciones tr").draggable({
    	      helper: "clone",
              start: function(event, ui) {
          
              }
    	    })
    	$(".tableTest").droppable({
    	      accept: 'tr',
    	      tolerance: "pointer",
    	      drop: function (event, ui) {
    	    	  $(this).append('<tr><td>Col1</td><td>Col2</td><td>Col3</td><td>Col3</td></tr>');
    	    	  console.log("Sel")
    	        
    	      }
    	    });
    	this.bindCombos();
    	
    	//this.createComboAutocomplete(".contImputacionesConcepto")
    	 this.createDateCell();
    	 this.calculateTotals(".contImporte")
    	 this.createEgresoTab();

    	 
 
    },
    crearTagSeleccion:function(row){
    	var seleccion =$(row).find(".contCancelacionNumero").text() + "/"+$(row).find(".contCancelacionBanco").text()+ "/"+$(row).find(".contCancelacionImporte").text();
    	$('.contCancelacionesAreaSeleccion').textext()[0].tags().addTags([seleccion]);
    	console.log()
    	$(".text-tag :last").find("input").val("ajaja")
    },
    cleanCombos:function(){
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();

    	
    },
    createCombosEspeciales:function(row,specialSelector){
    	if (specialSelector){
    		$(specialSelector).select2();
    	}else if (row==null){
     	   $("select").select2();
    	}else{
    		$(row).find("select").select2();
    	}
    	
    },
    bindCombos:function(row){
    	var self=this;
    	var placeHolder=".contFormNew";
    	
    	if (row!=null){
    		placeHolder=row;
    	}
    		$(placeHolder).find(".contImputacionesConcepto").change(function() {
    			var selectId=$(this).select2('data').id;
    			var row=$(this).parent().parent().parent();
				self.createClonedRow(row); 
				translator.getImputacionesInformation(selectId,function(data){
					self.fillImputacionesRow(row,data);
				});
    		});
    },
    createDateCell:function(){
   	 $('.datepicker').datepicker({showOtherMonths:true });
    	
    },
    calculateTotals:function(selector){
    	$(selector).change(function() {
    		var table=$(this).parent().parent().parent();
    		var total=0
    		//console.log("VAL",String.parseInt($("."+$(table).attr("id")+"Total").val()))
    		$(table).find(".contImporte").each(function( index,element ) {
    			var valor=parseInt($(element).find("input").val());
    			total=+valor;
    		});
    		$("."+$(table).attr("id")+"Total").val(total);

   	});
 
    },
    createEgresoTab:function(){
    	var self=this;
    	$('.contCancelacionesAreaSeleccion').textext({
            plugins: 'tags',
            items: [ 'PHP', 'Closure', 'Java' ],

            html: {
                tag: '<div class="text-tag"><input type="hidden"><div class="text-button"><span class="text-label"/><a class="custom-edit"/><a class="text-remove"/></div></div>'
            }
        }).bind('tagClick', function(e, tag, value, callback)
        {
            console.log("Value",value)
        })

    	$('.cancelaciones').dataTable();
    	$(".contFormNew").find(".contCancelacionCheck").click(function() {
    		var row=$(this).parent().parent();
    		self.crearTagSeleccion(row);

    	});

    },
    cleanRow:function(row){
    	
    	$(row).find("#entidadId").remove();
    	$(row).find("#monedaId").remove();

    	
    },
    createClonedRow:function(row){
    	var clon=$(row).clone();
    		$(clon).find(".select2-container").remove();
    		$(clon).find("select").removeClass('select2-offscreen');;
	  		$(row).after(clon);
	  		this.createCombosEspeciales(clon);
	  		this.bindCombos(clon);
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
    	$(row).find(".contImputacionesEntidad").append("<select id='entidadId' name='entidadId' class='span12 step2'></select>")
    	$(row).find(".contImputacionesMoneda").append("<select id='monedaId' name='monedaId' class='span12 step2'></select>")
    	$(row).find(".contImputacionesTipoMovimiento").text($("#tipoMovimiento").val())

    	this.fillComboCell(data.monedas,$(row).find("#monedaId"));
    	this.fillComboCell(data.entidades,$(row).find("#entidadId"));
    	this.createCombosEspeciales(null,$(row).find(".step2"))

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