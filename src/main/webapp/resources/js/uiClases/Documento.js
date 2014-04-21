var Documento = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="tipoDocumento";
        this.breadcrumb='Tipo Documento';
        this.descripcion="Desde aqui gestiones los Tipo de Documentos";
        this.documentoJson=new DocumentoJson();
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
    			console.log("DAta",data)
    				self.cleanCombos();
    				self.resetTabs();
    				self.cleanTotals();
    				self.fillDocumentHeader(data);
    				self.toogleTabs(data);
    			})
    	});
    	
    	$(".contFormNew").find("#monedaCombo").change(function() {
    		var cancelacionSearch=self.getCancelacionSearch()
    		var selectedId=$(this).select2('data').id;
    		translator.getAplicaciones(cancelacionSearch,function(data){
    			console.log("DAtaMoneda",data)
    
    			})

    		translator.getCotizacionyByMonedaId(selectedId,function(data){
    			if (data==0){
					$("#headerCotizacion").val(1);

    			}else{
					$("#headerCotizacion").val(data);

    			}
    			self.refreshTotales();
    			})  
    		
    		
    	});
    	
    	$(".contFormNew").find("#entidadCombo").change(function() {
    		console.log("Entidad")
    		var cancelacionSearch=self.getCancelacionSearch()
    		
    		translator.getAplicaciones(cancelacionSearch,function(data){
    			self.fillComboCell(data,$(".contCancelacionesCombo"))
    			console.log("DAtaEntidad",data)
    
    			})
    	});
    	
    	
    	$(".guardar").click(function() {
			self.documentoJson.createJson()

    	})
    	this.bindCombos();
    	this.bindCancelacionCombo()
    	
    	//this.createComboAutocomplete(".contImputacionesConcepto")
    	 this.createDateCell();
    	 this.calculateTotals($(".contImporte").find("input"))
    	 this.createEgresoTab();

    },
    crearTagSeleccion:function(row){
    	var seleccion =$(row).find(".contCancelacionNumero").text() + "/"+$(row).find(".contCancelacionBanco").text()+ "/"+$(row).find(".contCancelacionImporte").text();
    	$('.contCancelacionesAreaSeleccion').textext()[0].tags().addTags([seleccion]);
    	var indexFinal=parseInt($(row).index()) +parseInt(this.egresoTabla.fnPagingInfo().iStart)
    	$(".text-tag :last").find(".idCancelacion").val($(row).find(".contCancelacionNumero").text())
    	$(".text-tag :last").find(".rowIndex").val(indexFinal)

    },
    cleanCombos:function(){
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();
    },
    cleanTotals:function(){
    	$('.contImputacionesTotal').val(0)
    	$('.contCancelacionesTotal').val(0)
    	$('.contPropiosTotal').val(0)
    	$('.contEgresoTotal').val(0)
    	$('.contIngresoTotal').val(0)
    	$('.contDebito').val(0)
    	$('.contCredito').val(0)
    	 	
    },
    getCancelacionSearch:function(){
    	 var search=new Object();
         
    	 search.cuentaId =$(".contCuentaId").val();
    	 search.tipoDocumentoId =$(".contTipoDocCombo").select2('data').id;
    	 search.monedaId =$("#monedaCombo").select2('data').id;
    	 search.entidadId =$("#entidadCombo").select2('data').id;
    	 return search;
    },
    resetTabs:function(){
    	var self=this;
				
    	$("#contImputacionesBody >tr").not(':last').remove();

		$("#contPropiosBody >tr").not(':last').remove();
		$("#contIngresoBody >tr").not(':last').remove();
		$("#contCancelacionesBody >tr").not(':last').remove();
		$("#contCancelacionesBody >tr").find("select").children('option:not(:first)').remove();
		//Remuevo las cosas de Egreso
		$(".text-tag").each(function( index,element ) {
			var rowIndex=$(this).find(".rowIndex").val()
        	self.egresoTabla.fnUpdate( "<input class ='contEgresoCheck' type='checkbox'onclick='documentoRender.crearBindInputCancelacion(this)' >", parseInt(rowIndex), 0);
			$(this).remove();
		})
		
    },
    createCombosEspeciales:function(row,specialSelector){
    	if (specialSelector){
    		$(specialSelector).select2();
    	}else if (row==null){
     	   $("select").select2();
    	}else{
    		console.log("Accc",$(row))
    		$(row).find("select").select2({placeholder: "Choose an option..."});
    	}
    	
    },
    bindCombos:function(row){
    	var self=this;
    	var placeHolder=".contFormNew";
    	
    	if (row!=null){
    		placeHolder=row;
    	}
    		$(placeHolder).find(".contImputacionesConceptoCombo").change(function() {
    			var selectId=$(this).select2('data').id;
    			var row=$(this).parent().parent();

    			if ($(row).index()+1 == $(row).parent().parent().find("tbody > tr").length){
    				self.createClonedRow(row); 

    			}
    			
				translator.getImputacionesInformation(selectId,function(data){
					self.fillImputacionesRow(row,data);
				});
    		});
    },
    bindCancelacionCombo:function(row){
    	var self=this;
    	var placeHolder=".contFormNew";
    	
    	if (row!=null){
    		placeHolder=row;
    	}
    		$(placeHolder).find(".contCancelacionesCombo").change(function() {
    			var selectId=$(this).select2('data').id;
    			var row=$(this).parent().parent();
    			if ($(row).index()+1 == $(row).parent().parent().find("tbody > tr").length){
    				self.createClonedRowCancelacion(row)
    			}
    			translator.getAplicacionById(selectId,function(data){
					self.fillCancelacionRow(row,data);
				});
    		})
    	
    },
    createDateCell:function(){
   	 $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });
    	
    },
    calculateTotals:function(selector){
    	var self=this;
    	$(selector).change(function() {
    		var table=$(this).parent().parent().parent().parent();
    		self.mostrarTotales(table);

   	});
 
    },
    refreshTotales:function(table){
    	this.cleanTotals();
    	this.mostrarTotales($("#contPropios"));
    	this.mostrarTotales($("#contImputaciones"))
    	this.mostrarTotales($("#contIngreso"));


    },
    mostrarTotales:function(table){
		var total=0;
		console.log("table",table)
    	var cotizacionTotal=parseInt($("#headerCotizacion").val())
		$(table).find(".contImporte").each(function( index,element ) {
			var valor=parseInt($(element).find("input").val());
			var monedaId=$(this).parent().find("#monedaId").select2('data').id;

			console.log("PPP1",$(this).parent().parent())

			if ($(this).parent().find(".contImputacionesCuenta").text()!="" && monedaId){
				if ($(this).parent().find(".contCotizacion").find("input").length>0){
					console.log("PPP")
    				total+=(valor * parseInt($(this).parent().find(".contCotizacion").find("input").val()))/cotizacionTotal;
				}else{
					total+=valor/cotizacionTotal;
				}
			}

		});		
		
	

		$("."+$(table).attr("id")+"Total").val(total);
		
		var totales=parseFloat(parseInt($(".contIngresoTotal").val()) +parseInt($(".contPropiosTotal").val())+parseInt($(".contImputacionesTotal").val())-parseInt($(".contEgresoTotal").val())).toFixed(2);
		$(".contDebito").val(totales);
		$(".contCredito").val(totales);
    },
    createEgresoTab:function(){
    	
    	var self=this;
    	$('.contCancelacionesAreaSeleccion').textext({
            plugins: 'tags',
            html: {
                tag: '<div class="text-tag"><input class="idCancelacion" type="hidden"><input  class="rowIndex"  type="hidden"><div class="text-button"><span class="text-label" style="font-size:13px; color:#538b01; font-weight:bold; font-style:italic;"/><a class="custom-edit"/></div></div>'
            }
        }).bind('tagClick', function(e, tag, value, callback)
        {
        	//var id=$(tag).find(".idCancelacion").val();
        	var rowIndex=$(tag).find(".rowIndex").val();
        	console.log("IN",rowIndex)
        	self.egresoTabla.fnUpdate( "<input class ='contEgresoCheck' type='checkbox'onclick='documentoRender.crearBindInputCancelacion(this)' >", parseInt(rowIndex), 0);
        	//Remuevo el Tag
        	 $(tag).remove();
        })
    	self.egresoTabla=$('.egreso').dataTable();
    	$(".contFormNew").find(".contEgresoCheck").die('click');
    	$(".contFormNew").find(".contEgresoCheck").live("click",function() {
    		self.crearBindInputCancelacion(this);

    	});

    },
    crearBindInputCancelacion:function(input){
    	var row=$(input).parent().parent();    
    	$(input).attr("disabled", true);
		this.crearTagSeleccion(row);
    },
    cleanRow:function(row){  	
    	$(row).find("#entidadId").remove();
    	$(row).find("#monedaId").remove();
    },
    createClonedRow:function(row){
    	var clon=$(row).clone();
    		$(clon).find(".select2-container").remove();
    		$(clon).find("select").removeClass('select2-offscreen');
    		$(clon).find(".contImporte").find("input").val(1);
	  		$(row).after(clon);
	  		this.createCombosEspeciales(clon);
	  		this.bindCombos(clon);
	  		this.calculateTotals($(clon).find(".contImporte").find("input"));
    },
    createClonedRowCancelacion:function(row){
    	var clon=$(row).clone();
    		$(clon).find(".select2-container").remove();
    		$(clon).find("select").removeClass('select2-offscreen');
	  		$(row).after(clon);
	  		this.createCombosEspeciales(clon);
	  		this.bindCancelacionCombo(clon)
	  		
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
    	$('#entidadCombo').append("<option></option>")
    	$('#monedaCombo').append("<option></option>")

    	
    	for (var i = 0; i < data.entidades.length; i++) { 
    		var id=data.entidades[i]["id"];
    		var text=data.entidades[i]["nombre"];
    		$("#entidadCombo").append(new Option(text,id));
    		
    	}
    	$("#entidadCombo").select2("val", "");

    	for (var i = 0; i < data.monedas.length; i++) { 
    		var id=data.monedas[i]["id"];
    		var text=data.monedas[i]["nombre"];
    		$("#monedaCombo").append(new Option(text,id));
    		
    	}
    	$("#monedaCombo").select2("val", "");

    	$(".contCuentaId").val(data.cuenta.id)
    	$(".contCuentaNombre").val(data.cuenta.nombre)
    	    	$(".contTipoEntidad").val(data.cuenta.tipoEntidad.nombre)

    	
    	
    	if (data.tipoDocumento.tipoMovimiento=="C"){
    		tipoMovimiento="C"
    	}else{
    		tipoMovimiento="D"
    	}
    	$("#tipoMovimiento").val(tipoMovimiento)

    	$("#headerCotizacion").val(data.monedas[0].cotizacion)
    	
    },
    fillImputacionesRow:function(row,data){
    	
    	$(row).find(".contImputacionesCuenta").text(data.cuenta.nombre)
    	$(row).find(".contImputacionesTipoEntidad").text(data.cuenta.tipoEntidad.nombre);
    	
    	$(row).find(".contImputacionesEntidad").empty();
    	$(row).find(".contImputacionesEntidad").append("<select id='entidadId' name='entidadId' class='span12 step2' placeholder='Seleccione Entidad'></select>")
    	$(row).find(".contImputacionesMoneda").empty();
    	$(row).find(".contImputacionesMoneda").append("<select id='monedaId' name='monedaId' class='span12 step2' placeholder='Seleccione Moneda'></select>")
    	if ($("#tipoMovimiento").val()=="Debito"){
        	//$(row).find(".contImputacionesTipoMovimiento").text("Credito")

    	}else{
        	//$(row).find(".contImputacionesTipoMovimiento").text("Debito")

    	}
    	
    	
    	this.bindMonedaCombo($(row).find("#monedaId"));

    	this.fillComboCell(data.monedas,$(row).find("#monedaId"));
    	this.fillComboCell(data.entidades,$(row).find("#entidadId"));
    	this.createCombosEspeciales(null,$(row).find(".step2"))

    },
    fillCancelacionRow:function(row,data){
    	$(row).find(".contCancelacionPendiente").empty();
		$(row).find(".contCancelacionPendiente").append("<input class='span6' type='number' min=1 max="+data.importePendiente+" value="+data.importePendiente+">")

    },
    
    bindMonedaCombo:function(combo){
    	var self=this;
    	$(combo).change(function() {
    	
    		var selectedId=$(this).select2('data').id;
    		var row=$(this).parent().parent();

    		if(selectedId==""){
    			self.removeCotizacion(row)
    			self.mostrarTotales($(row).parent());
    		}

    		translator.getCotizacionyByMonedaId(selectedId,function(data){
					self.fillCotizacion(row,data);
			  		self.mostrarTotales($(row).parent().parent());

    			})    	
    		});
    },
    fillComboCell:function(result,selector){
    	$(selector).find('option').remove();
    	selector.append("<option></option>")
    	for (var i = 0; i < result.length; i++) { 
    		var id=result[i].id;
    		var text=result[i].nombre;
    		selector.append(new Option(text,id));
    		
    	}
    	selector.select2("val", "");


    },
    removeCotizacion:function(row){
    	$(row).find(".contCotizacion").find("input").remove();
    },
    fillCotizacion:function(row,data){
    		$(row).find(".contCotizacion").find("input").remove();

		if (data==1){
			$(row).find(".contCotizacion").append("<input class='span8' type='text' value=1 readonly>")
		}else if (data!=0){
			$(row).find(".contCotizacion").append("<input class='span8' type='text' value="+data+" readonly>")
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