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
    	screenBig();
    	var self=this;
    	this.parent();
    	this.hideTabs()
    	this.createdEgresoDatatable=false;
   	    this.createCombosEspeciales();
    	
    	$(".contFormNew").find(".contAdministracionCombo").change(function() {
    		translator.getListByAdmin("tipoDocumento",$(this).val(),function(data){
    			self.cleanForm();
    			self.fillCombo(data,$(".contFormNew").find("#tipoDocumentoCombo"));
    			$(".contFormNew").find("#tipoDocumentoCombo").select2("val", "");
    			
    			})
    	});
    	
    	$(".contFormNew").find("#tipoDocumentoCombo").change(function() {
    		console.log(" Entra TipoD")
    		var selectedId=$(this).select2('data').id;
    		self.cleanNumeracion();
    		translator.getDocumentoHeader(selectedId,function(data){
    			console.log("DAta",data)
    				self.cleanCombos();
    				self.resetTabs();
    				self.cleanTotals();
    				self.cleanLegendasMoneda();
    				self.fillDocumentHeader(data);
    				self.createEgresoTab(data)
    				self.toogleTabs(data);
    				self.fillConceptos(data);
    			})
    		self.getLastNumeracion();	
    	});
    	$(".contFormNew").find(".contFechaIngreso").change(function() {
    		self.getLastNumeracion();
    	})
    	
    	
    	$(".contFormNew").find("#monedaCombo").change(function() {
    		var selectedId=$(this).select2('data').id;
    		var selectedText=$(this).select2('data').text;
    		self.getAplicaciones();
    		self.getCotizacion(selectedId)
    		self.escribirCodigoEnTotales(selectedText)
    		
    	});
    	
    	$(".contFormNew").find("#entidadCombo").change(function() {
    			console.log(" Entra")
    			self.getAplicaciones();
    	});
    	
    	
    	$(".guardar").click(function() {
    		$(this).attr("disabled",true)
			self.documentoJson.createJson()

    	})
    		$(".contEstablecimiento").change(function(e) {
    			$(this).val(self.padding_left($(this).val(),"0",4))
    		});
    		
    	$(".contEstablecimiento").keydown(function(e) {
    		if (e.which!=8){
			 if(!$.isNumeric(String.fromCharCode(e.which))){
				 e.preventDefault()
			 }
    		}
    			
	});

		$(".contNumeroFinal").change(function(e) {
			$(this).val(self.padding_left($(this).val(),"0",8))
		});
		
	$(".contNumeroFinal").keydown(function(e) {
		if (e.which!=8){
		 if(!$.isNumeric(String.fromCharCode(e.which))){
			 e.preventDefault()
		 }
		}
	
});
    	
    	
    	
    	
    	
    	this.bindCombos();
    	this.bindDeleteRow($(".contDelete"))
    	this.bindCancelacionCombo()
    	this.bindIngresoValores()
    	this.bindIngresoPropios()
    	
    	//this.createComboAutocomplete(".contImputacionesConcepto")
    	 this.createDateCell();
    	 this.calculateTotals($(".contImporte").find("input"))
    	 //this.createEgresoTab();
    	 this.initializeTotals();
    	 this.initializeMasks();
    },
    initializeMasks:function(){
    	$(".contImporte").find("input").number( true, 2 )
    },
    cleanLegendasMoneda:function(){
     	$("#contLabelImputacionTotal").val("")
    	$("#contLabelIngresoTotal").val("")
    	$("#contLabelEgresoTotal").val("")
    	$("#contLabelCancelacionTotal").val("")
    	$("#contLabelPropioTotal").val("")
    	$("#contLabelDebitoTotal").val("")
    	$("#contLabelCreditoTotal").val("")
    },
    escribirCodigoEnTotales:function(sufijo){
    	console.log("e",sufijo,$("#contLabelImputacionTotal").text())
    	$("#contLabelImputacionTotal").val(sufijo)
    	$("#contLabelIngresoTotal").val( sufijo)
    	$("#contLabelEgresoTotal").val(sufijo)
    	$("#contLabelCancelacionTotal").val(sufijo)
    	$("#contLabelPropioTotal").val( sufijo)
    	$("#contLabelDebitoTotal").val( sufijo)
    	$("#contLabelCreditoTotal").val( sufijo)
    	
    },
    initializeTotals:function(){
    	$(".contImputacionesTotal").maskMoney({thousands:',', decimal:'.', allowZero:true})
    	$(".contCancelacionesTotal").maskMoney({thousands:',', decimal:'.', allowZero:true})
    	$(".contPropiosTotal").maskMoney({thousands:',', decimal:'.', allowZero:true})
    	$(".contEgresoTotal").maskMoney({thousands:',', decimal:'.', allowZero:true})
    	$(".contIngresoTotal").maskMoney({thousands:',', decimal:'.', allowZero:true})
    	$(".contDebito").maskMoney({thousands:',', decimal:'.', allowZero:true})
    	$(".contCredito").maskMoney({thousands:',', decimal:'.', allowZero:true})
    	
    	
    	
    },
    getCotizacion:function(selectedId){
    	var self =this;
    	translator.getCotizacionyByMonedaId(selectedId,function(data){
			if (data==0){
				$("#headerCotizacion").val(1);

			}else{
				$("#headerCotizacion").val(data);

			}
			self.refreshTotales();
			})  
    },
    getAplicaciones:function(){
		var self=this;
		$("#contCancelacionesBody >tr").not(':last').remove();
		$("#contCancelacionesBody >tr").find("select").children('option:not(:first)').remove();
		this.mostrarTotalCancelacion();
    	var cancelacionSearch=self.getCancelacionSearch()
		translator.getAplicaciones(cancelacionSearch,function(data){
			self.fillComboCell(data,$("select.contCancelacionesCombo"))
			$(".contCancelacionesCombo").select2("val", "");

			})
    },
    cleanNumeracion:function(){
    	$(".contEstablecimiento").val("")
    	$(".contAnio").val("")
    	$(".contMes").val("")
    	$(".contDia").val("")
    	$(".contNumeroFinal").val("")
    	$(".contLetra").select2("val", "");
    },
    getLastNumeracion:function(row){
    	var numeracion = new Object();
    	numeracion.administracionId =$(".contAdministracionCombo").select2('data').id;
    	numeracion.tipoDocumentoId =$(".contTipoDocCombo").select2('data').id;
    	numeracion.fechaReal=$(".contFechaIngreso").val();
    	numeracion.numeroLetra =$(".contLetra").select2('data').id
    	numeracion.numeroEstablecimiento =$(".contEstablecimiento").val();
 
    	
    	if (numeracion.fechaReal!=""&&numeracion.tipoDocumentoId!=""){
    	
    			var self=this;
    				$.ajax({type: 'POST',
    					url: 'documento/getLastDocNumeracion/',
    					contentType: "application/json",
    					data : JSON.stringify(numeracion),
    					success: function(data) {
    						console.log("DATaNUUU",data);
    						self.createNumeracionMask(data);
    					}});
    	 
    	}

    },
    crearTagSeleccion:function(row){
    	var importe=parseFloat($(row).find("td").eq(9).text())*parseFloat($(row).find("td").eq(8).text())/parseFloat($("#headerCotizacion").val())
    	console.log()
    	if (isNaN(importe)){
    		importe=1;
    	}
    	var seleccion =$(row).find("td").eq(2).text() + "/"+$(row).find("td").eq(3).text()+ "/"+importe;
    	$('.contCancelacionesAreaSeleccion').textext()[0].tags().addTags([seleccion]);
    	var indexFinal=parseInt($(row).index()) +parseInt(this.egresoTabla.fnPagingInfo().iStart)
    	$(".text-tag :last").find(".idEgreso").val($(row).find("td").eq(1).text())
    	$(".text-tag :last").find(".rowIndex").val(indexFinal)
    	$(".text-tag :last").find(".rowImporte").val(importe)
    	 this.refreshTotales()

    },
    cleanCombos:function(){
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();
    },
    cleanTotals:function(){
   
    	$('.contImputacionesTotal').val(0);
    	$('.contCancelacionesTotal').val(0);
    	$('.contPropiosTotal').val(0);
    	$('.contEgresoTotal').val(0);
    	$('.contIngresoTotal').val(0);
    	$('.contDebito').val(0);
    	$('.contCredito').val(0);
    	 	
    },
    changeEgresoData:function(){
    	
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
    	console.log("Entracombo",placeHolder)
    		$(placeHolder).find(".contCancelacionesCombo").change(function() {
    			var selectId=$(this).select2('data').id;
    			var row=$(this).parent().parent();
    			console.log("TT",$(row).index()+1,$(row).parent().parent().find("tbody > tr").length)
    			if ($(row).index()+1 == $(row).parent().parent().find("tbody > tr").length){
    				self.createClonedRowCancelacion(row)
    			}
    			translator.getAplicacionById(selectId,function(data){
					self.fillCancelacionRow(row,data);
				});
    		})
    	
    },
    bindIngresoValores:function(row){
    	var placeHolder=".contFormNew";
    	
    	if (row!=null){
    		placeHolder=row;
    	}
    	$(placeHolder).find(".contIngresoNumero").maskMoney();
    	
    },
    bindIngresoPropios:function(row){
    	var placeHolder=".contFormNew";
    	
    	if (row!=null){
    		placeHolder=row;
    	}
    	$(placeHolder).find(".contPropioNumero").maskMoney();
    	
    },
    createDateCell:function(){
   	 $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy'});
   	 $(".datepicker").datepicker("setDate",new Date());
    },
    createDateElement:function(element){
    	$(element).removeClass("hasDatepicker")
    	$(element).attr("id","")
      	 $(element).datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });
       	
       },
    calculateTotals:function(selector){
    	var self=this;
    	this.calculateTotalsEgreso();

    	$(selector).keyup(function() {
    		console.log("cammmbia")
    		var table=$(this).parent().parent().parent().parent();
    		//$(this).val(parseFloat($(this).val()).toFixed(2))
    		self.mostrarTotales(table);

   	});
 
    },
    calculateTotalsEgreso:function(selector){
		var total=0

    	$(".text-tag").each(function( index,element ) {
    		total+= parseFloat($(this).find(".rowImporte").val());
    	})
    	$(".contEgresoTotal").val(parseFloat(total).toFixed(2));
 
    },
    bindDeleteRow:function(buttonDelete){
    	var self=this;
    	$(buttonDelete).click(function() {
    		var row=$(this).parent().parent()
    		var indiceFila=$(row).index();
    		var totalFilasEnTabla=$(row).parent().parent().find("tbody > tr").length
    		console.log("INDe",$(row).index(),totalFilasEnTabla)
    		if (totalFilasEnTabla!=1 && indiceFila+1!=totalFilasEnTabla){
        		$(row).remove();
        		self.refreshTotales()

    		}
    	})
    },	
    deleteRow:function(row){
    	
    },
    refreshTotales:function(table){
    	this.cleanTotals();
    	this.calculateTotalsEgreso()
    	this.mostrarTotales($("#contPropios"));
    	this.mostrarTotales($("#contImputaciones"))
    	this.mostrarTotales($("#contIngreso"));
    	this.mostrarTotalCancelacion();


    },
    mostrarTotalCancelacion:function(){
    	var total=0;
    	console.log("ENTTtt")
    	$("#contCancelacionesBody >tr").not(':last').each(function( index,element ) {
    		console.log("ENERERe",$(this).find("input"))
    		total+=parseFloat($(this).find(".contCancelacionPendiente").find("input").val());
    	})
    	$(".contCancelacionesTotal").maskMoney('mask',total);
    },
    fillConceptos:function(data){
    	$('#contImputaciones').find(".contImputacionesConceptoCombo").find('option').remove();
    	$('#contImputaciones').find(".contImputacionesConceptoCombo").append("<option></option>")
    	
    	$('#contPropios').find(".contImputacionesConceptoCombo").find('option').remove();
    	$('#contPropios').find(".contImputacionesConceptoCombo").append("<option></option>")
    	
    	$('#contIngreso').find(".contImputacionesConceptoCombo").find('option').remove();
    	$('#contIngreso').find(".contImputacionesConceptoCombo").append("<option></option>")
    	
    	if (data.conceptoImp) {
    		for (var i = 0; i < data.conceptoImp.length; i++) { 
    			var id=data.conceptoImp[i]["id"];
    			var text=data.conceptoImp[i]["nombre"];
    			$('#contImputaciones').find("select.contImputacionesConceptoCombo").append(new Option(text,id));
    		}
    	}
    	if (data.conceptoValProp) {
    		for (var i = 0; i < data.conceptoValProp.length; i++) { 
    			var id=data.conceptoValProp[i]["id"];
    			var text=data.conceptoValProp[i]["nombre"];
    			$('#contPropios').find("select.contImputacionesConceptoCombo").append(new Option(text,id));
    		
    		}
    	}
    	if (data.conceptoIngValTer) {
    		for (var i = 0; i < data.conceptoIngValTer.length; i++) { 
    			var id=data.conceptoIngValTer[i]["id"];
    			var text=data.conceptoIngValTer[i]["nombre"];
    			$('#contIngreso').find("select.contImputacionesConceptoCombo").append(new Option(text,id));
    		
    		}
    	}
    },
    mostrarTotales:function(table){
		var total=0;
		console.log("table",table)
    	var cotizacionTotal=parseFloat($("#headerCotizacion").val())
		$(table).find(".contImporte").each(function( index,element ) {
			
			if ($(element).find("input").val()==""){
				var valorFila="0"
			}else{
				var valorFila=$(element).find("input").val().replace(/\,/g, '');
			}
			
			var valor=parseFloat(valorFila);
			console.log("valorFIl",valorFila)
			console.log("totalVal",valor)
			var monedaId=$(this).parent().find("#monedaId").select2('data').id;


			if ($(this).parent().find(".contImputacionesCuenta").text()!="" && monedaId){
				if ($(this).parent().find(".contCotizacion").find("input").length>0){
    				total+=(valor * parseFloat($(this).parent().find(".contCotizacion").find("input").val()))/cotizacionTotal;
    				console.log("ValPor",total)
				}else{
					total+=valor/cotizacionTotal;
					console.log("ValPorDos",total)
				}
			}

		});		
		
		console.log("total",total,$(table).attr("id")+"Total")
		
		$("."+$(table).attr("id")+"Total").maskMoney('mask',parseFloat(total));

		console.log("sdad",parseFloat($(".contImputacionesTotal").val().replace(',','')))
		console.log("sin",parseFloat($(".contImputacionesTotal").val()))
		var totales=parseFloat($(".contIngresoTotal").val().replace(/\,/g, '')) +parseFloat($(".contPropiosTotal").val().replace(/\,/g, ''))+parseFloat($(".contImputacionesTotal").val().replace(/\,/g, ''))+parseFloat($(".contEgresoTotal").val().replace(/\,/g, ''));
		
		console.log("totales",totales)
		$(".contDebito").maskMoney('mask',totales);
		$(".contCredito").maskMoney('mask',totales);
    },
    createEgresoTab:function(data){
    	
    	var self=this;
    	
    	$('.contCancelacionesAreaSeleccion').textext({
            plugins: 'tags',
            html: {
                tag: '<div class="text-tag span12"><input class="idEgreso" type="hidden"><input  class="rowIndex"  type="hidden"><input  class="rowImporte"  type="hidden"><div class="text-button"><span class="text-label" style="font-size:13px; color:#538b01; font-weight:bold; font-style:italic;"/><a class="custom-edit"/></div></div>'
            }
        }).bind('tagClick', function(e, tag, value, callback)
        {
        	//var id=$(tag).find(".idCancelacion").val();
        	var rowIndex=$(tag).find(".rowIndex").val();
        	self.egresoTabla.fnUpdate( "<input class ='contEgresoCheck' type='checkbox'onclick='documentoRender.crearBindInputCancelacion(this)' >", parseInt(rowIndex), 0);
        	//Remuevo el Tag
        	console.log("A veee")
        	 $(tag).remove();
        	 self.refreshTotales()
        })
        if (self.createdEgresoDatatable!=true){
        	if (data.docsValTerceDatatable) { 
        		self.egresoTabla=$('.egreso').dataTable({aaData:data.docsValTerceDatatable.aaData,"destroy": true});
        		
                //$('.egreso').find('td:nth-child(2),th:nth-child(2)').hide();
        		self.createdEgresoDatatable=true;
        	}
        }
    	$(".contFormNew").find(".contEgresoCheck").die('click');
    	$(".contFormNew").find(".contEgresoCheck").live("click",function() {
    		self.crearBindInputCancelacion(this);

    	});

    },
    padding_left:function(s, c, n) {
    	 if (! s || ! c || s.length >= n) {
    	        return s;
    	    }

    	    var max = (n - s.length)/c.length;
    	    for (var i = 0; i < max; i++) {
    	        s = c + s;
    	    }

    	    return s;
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
    		$(clon).find(".contImporte").find("input").val("");
    		$(clon).find(".contPropioNumero").find("input").val("");
    		$(clon).find(".contIngresoNumero").find("input").val("");
    		$(clon).find(".contImporte").find("input").number( true, 2 )

	  		$(row).after(clon);
	  		this.createCombosEspeciales(clon);
	  		this.createDateElement($(clon).find(".datepicker"))
	  		this.bindDeleteRow ($(clon).find(".contDelete"))
	  		
	  		this.bindCombos(clon);
	  		this.bindIngresoValores(clon);
	  		this.bindIngresoPropios(clon)
	  		this.calculateTotals($(clon).find(".contImporte").find("input"));
    },
    createClonedRowCancelacion:function(row){
    	var clon=$(row).clone();
    		$(clon).find(".select2-container").remove();
    		$(clon).find("select").removeClass('select2-offscreen');
	  		$(row).after(clon);
	  		this.createCombosEspeciales(clon);
	  		this.bindCancelacionCombo(clon)
	  		this.bindDeleteRow ($(clon).find(".contDelete"))
	  		
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

    	$(".contCuentaId").val(data.cuenta.id)
    	$(".contCuentaNombre").val(data.cuenta.nombre)
    	 $(".contTipoEntidad").val(data.cuenta.tipoEntidad.nombre)
    	
    	for (var i = 0; i < data.entidades.length; i++) { 
    		var id=data.entidades[i]["id"];
    		var text=data.entidades[i]["nombre"];
    		$("#entidadCombo").append(new Option(text,id));
    		
    	}
    	if (data.entidades.length ==1){
    		$("#entidadCombo").select2("val",data.entidades[0].id);
    		this.getAplicaciones();
    	}else{
    		$("#entidadCombo").select2("val", "");
    	}
    	

    	for (var i = 0; i < data.monedas.length; i++) { 
    		var id=data.monedas[i]["id"];
    		var text=data.monedas[i]["codigo"];
    		$("#monedaCombo").append(new Option(text,id));
    		
    	}
    	if (data.monedas.length ==1){
    		$("#monedaCombo").select2("val",data.monedas[0].id);
    		this.getAplicaciones();
    		this.getCotizacion(data.monedas[0].id)
    		this.escribirCodigoEnTotales(data.monedas[0].codigo)
    	}else{
    		$("#monedaCombo").select2("val", "");
    	}
    	

    	
    	
    	if (data.tipoDocumento.tipoMovimiento=="C"){
    		tipoMovimiento="C"
    	}else{
    		tipoMovimiento="D"
    	}
    	$("#tipoMovimiento").val(tipoMovimiento)

    	$("#headerCotizacion").val(data.monedas[0].cotizacion)
    	
    },

    createNumeracionMask:function(numeracion){
    	console.log("NUMMASK")
    	this.cleanNumeracion();
    	//console.log("hghh",$('#contNumeracion').val("vacio"))
    	//$('#contNumeracion').val("");
    	if (numeracion.numeroAnio!=null){
    		if (numeracion.numeroAnio==""){
        		$(".contAnio").attr("readonly",false);
        		$(".contAnio").show();
    		}else{
    			$(".contAnio").val(numeracion.numeroAnio);
    			$(".contAnio").attr("readonly",true);
    			$(".contAnio").show();
    		}
    	}else{
    		$(".contAnio").attr("readonly",true)
    		$(".contAnio").hide();
    	}
    	if (numeracion.numeroDia!=null){
    		if (numeracion.numeroDia==""){
        		$(".contDia").attr("readonly",false);
        		$(".contDia").show();
    		}else{
    			$(".contDia").val(numeracion.numeroDia);
    			$(".contDia").attr("readonly",true);
    			$(".contDia").show();
    		}
    	}else{
    		$(".contDia").attr("readonly",true);
    		$(".contDia").hide();
    	}
		console.log("numeracionESTAESs",numeracion.numeroEstablecimiento)

    	if (numeracion.numeroEstablecimiento!=null){
    		console.log("numeracionESTA")
    		if (numeracion.numeroEstablecimiento==""){
    			console.log("ESTAVACI");
        		$(".contEstablecimiento").attr("readonly",false);
    			$(".contEstablecimiento").show();
    		}else{
    			$(".contEstablecimiento").val(numeracion.numeroEstablecimiento);
    			$(".contEstablecimiento").attr("readonly",true);
    			$(".contEstablecimiento").show();
    		}
    	}else{
    		$(".contEstablecimiento").attr("readonly",true);
    		$(".contEstablecimiento").hide();
    	}
    	if (numeracion.numeroLetra!=null){
    		if (numeracion.numeroLetra==""){
    			console.log("LETRAA")
        		$(".contLetra").attr("disabled",false);
    			$(".contLetra").show();
    		}else{
    			$(".contLetra").val(numeracion.numeroLetra);
    			$(".contLetra").attr("disabled",true);
    			$(".contLetra").show();
    		}
    	}else{
    		$(".contLetra").attr("disabled",true)
    		$(".contLetra").hide();
    	}
    	if (numeracion.numero!=null){
    		if (numeracion.numero==""){
    			console.log("ENTRANUMERO")
        		$(".contNumeroFinal").attr("readonly",false);
        		$(".contNumeroFinal").show();
    		}else{
    			$(".contNumeroFinal").val(numeracion.numero);
    			$(".contNumeroFinal").attr("readonly",true);
    			$(".contNumeroFinal").show();
    		}
    	}else{
    		$(".contNumeroFinal").attr("readonly",true);
    		$(".contNumeroFinal").hide();
    	}
    	if (numeracion.numeroMes!=null){
    		if (numeracion.numeroMes==""){
        		$(".contMes").attr("readonly",false);
        		$(".contMes").show();
    		}else{
    			$(".contMes").val(numeracion.numeroMes);
    			$(".contMes").attr("readonly",true)
    			$(".contMes").show();
    		}
    	}else{
    		$(".contMes").attr("readonly",true);
    		$(".contMes").hide();
    	}
    	

    },
    fillImputacionesRow:function(row,data){
    	
    	$(row).find(".contImputacionesCuenta").text(data.cuenta.nombre)
    	$(row).find(".contImputacionesEntidad").empty();
    	$(row).find(".contImputacionesTipoEntidad").text("")
    	if (data.cuenta.tipoEntidad.nombre!=null){
    		
        	$(row).find(".contImputacionesTipoEntidad").text(data.cuenta.tipoEntidad.nombre);
        	$(row).find(".contImputacionesEntidad").append("<select id='entidadId' name='entidadId'  class='span12 step2' placeholder='Seleccione'></select>")

    	}
    	$(row).find(".contCotizacion").find("input").remove();
    	$(row).find(".contImputacionesMoneda").empty();
    	$(row).find(".contImputacionesMoneda").append("<select id='monedaId' name='monedaId' class='span12 step2' placeholder='Seleccione'></select>")
    	if ($("#tipoMovimiento").val()=="Debito"){
        	//$(row).find(".contImputacionesTipoMovimiento").text("Credito")

    	}else{
        	//$(row).find(".contImputacionesTipoMovimiento").text("Debito")

    	}
    	
    	
    	this.bindMonedaCombo($(row).find("#monedaId"));

    	this.fillComboCell(data.monedas,$(row).find("#monedaId"));
    	this.fillComboCell(data.entidades,$(row).find("#entidadId"));
    	this.createCombosEspeciales(null,$(row).find(".step2"))
    	console.log("ANTEs")
    	this.getCotizacionForSelectedMoneda(row)
    	this.getNumeroChequeValoresPropios(row);
    	this.refreshTotales();
    	

    },
    getCotizacionForSelectedMoneda:function(row){
    	console.log("ENTRa")
    	var selectedId=$(row).find(".contImputacionesMoneda").find("select").select2('data').id;
    	console.log("ENTRaDos",selectedId)
    	console.log("VALMO",$(row).find(".contImputacionesMoneda").find("select").select2('data'))
    	var self=this;
    	translator.getCotizacionyByMonedaId(selectedId,function(data){
			self.fillCotizacion(row,data);
	  		self.mostrarTotales($(row).parent().parent());

		}) 
    },
    getNumeroChequeValoresPropios:function(row){
    	//Me fijo si esta en valores propios para hacer la consulta o no
    	console.log("ROW",$(row).parent(),$(row).parent().attr("id"))
    	var tipoTab=$(row).parent().attr("id");
    	if (tipoTab=="contPropiosBody"){
    		var datos=new Object();
    		datos.entidadId=$(row).find(".contImputacionesEntidad").find("select").select2('data').id;
    		datos.conceptoId=$(row).find(".contImputacionesConcepto").find("select").select2('data').id;;
    		datos.administracionId=$(".contAdministracionCombo").select2('data').id;
    		$.ajax({type: 'POST',
        		url: 'chequera/getNumeroChequeByCuenta/',
        		contentType: "application/json",
        		data : JSON.stringify(datos),
        		success: function(data) {
        			$(row).find(".contPropioNumero").removeClass('errorRango')
        			$(row).find(".contPropioNumero").find("input").val("")
        			if (data!=null && data == -1){
            			$(row).find(".contPropioNumero").find("input").val("Chequera Agotado")
        				$(row).find(".contPropioNumero").find("input").css("color","red")
            			$(row).find(".contPropioNumero").addClass('errorRango')

        			}else{
        				$(row).find(".contPropioNumero").find("input").attr("readonly", false);
        				$(row).find(".contPropioNumero").find("input").val(data)
        			}
        			console.log("NUMEEEEEEE",data)
    			}});
    	}
    	 
    
    },
    fillCancelacionRow:function(row,data){
    	$(row).find(".contCancelacionPendiente").empty();
		$(row).find(".contCancelacionPendiente").append("<input class='campo-importe'  type='number' min=1 max="+data.importePendiente+" value="+data.importePendiente+">")
		//$(row).find(".contCancelacionPendiente").find("input").maskMoney("mask");
		this.mostrarTotalCancelacion();
		this.bindImportePendienteCancelacion($(row).find(".contCancelacionPendiente").find("input"))
    },
    bindImportePendienteCancelacion:function(combo){
    	var self=this;
    	$(combo).change(function() {
    		self.mostrarTotalCancelacion();
    	})
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
    	if (result.length ==1){
    		console.log("Selector",selector)
    		selector.val(result[0].id)
    	}else{
    		selector.select2("val", "");
    	}
    	


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
		}else{
			$(row).find(".contCotizacion").append("<input class='span8' type='text' value=1 readonly>")
		}

    },
   hideTabs:function(){
	   $(".contImputaciones").hide();
	   $(".contCancelaciones").hide();
	   $(".contEgreso").hide();
	   $(".contValores").hide();
	   $(".contIngreso").hide();
   },
    toogleTabs:function(data){
    	var primero=null;
    	if (data.tipoDocumento.permiteImputaciones =='N'){
    		$(".contImputaciones").hide();
    		$("#contImputacionesTotalLabel").hide();
    	}else{
    		$(".contImputaciones").show();
    		primero=$(".contImputaciones");
    		$("#contImputacionesTotalLabel").show();
    	}
    	if (data.tipoDocumento.permiteAplicaciones =='N'){
    		$(".contCancelaciones").hide();
    		$("#contCancelacionesTotalLabel").hide();
    	}else{
    		
    		$(".contCancelaciones").show();
    		if (!primero)
    			primero=$(".contCancelaciones");
    		$("#contCancelacionesTotalLabel").show();
    	}
    	if (data.tipoDocumento.permiteEgrValTer =='N'){
    		$(".contEgreso").hide();
    		$("#contEgresoTotalLabel").hide();
    	}else{

    		$(".contEgreso").show();
    		if (!primero)
    			primero=$(".contEgreso");
    		$("#contEgresoTotalLabel").show();
    	}
    	if (data.tipoDocumento.permiteIngValTer =='N'){
    		$(".contIngreso").hide();
    		$("#contIngresoTotalLabel").hide();
    	}else{

    		$(".contIngreso").show();
    		$("#contIngresoTotalLabel").show();
    		if (!primero)
    			primero=$(".contIngreso");

    	}
    	if (data.tipoDocumento.permiteValProp =='N'){
    		$(".contValores").hide();
    		$("#contPropiosTotalLabel").hide();
    	}else{

    		$(".contValores").show();
    		if (!primero)
    			primero=$(".contValores");
    		$("#contPropiosTotalLabel").show();
    	}
    	$(primero).find("a").trigger('click');

    },
    resetForm:function(){
    	this.parent();
    	$('#entidadCombo').find('option').remove();
    	$('#monedaCombo').find('option').remove();
    	$('#tipoDocumentoCombo').find('option').remove();

      },
      bindUpdateEvents:function() {
    
      	var self=this;
      	this.parent();
      	var primero=null;
    	if ($(".contImputaciones").length>0){
    		primero=$(".contImputaciones");
    		$(".contImputaciones").show();
    	}
    	if ($(".contCancelaciones").length>0){
    		primero=$(".contCancelaciones");
    		$(".contCancelaciones").show();
    	}
    	if ($(".contEgreso").length>0){
    		primero=$(".contEgreso");
    		$(".contEgreso").show();
    	}
    	if ($(".contIngreso").length>0){
    		console.log("entra")
    		primero=$(".contIngreso");
    		$(".contIngreso").show();
    	}
    		
    	if ($(".contValores").length>0){
    		primero=$(".contValores");
    		$(".contValores").show();
    	}
    		console.log("primer",primero)
    	$(primero).find("a").trigger('click');
      	
      	},


});

documentoRender=new Documento();