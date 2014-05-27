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
    	toggleMenuHidden()
    	var self=this;
    	this.parent();
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
    		var selectedId=$(this).select2('data').id;
    		self.cleanNumeracion();
    		translator.getDocumentoHeader(selectedId,function(data){
    			console.log("DAta",data)
    				self.cleanCombos();
    				self.resetTabs();
    				self.cleanTotals();
    				self.fillDocumentHeader(data);
    				self.createEgresoTab(data)
    				self.toogleTabs(data);
    			})
    		self.getLastNumeracion();	
    	});
    	$(".contFormNew").find(".contFechaIngreso").change(function() {
    		self.getLastNumeracion();
    	})
    	
    	
    	$(".contFormNew").find("#monedaCombo").change(function() {
    		var selectedId=$(this).select2('data').id;
    		self.getAplicaciones();
    		self.getCotizacion(selectedId)
    		
    	});
    	
    	$(".contFormNew").find("#entidadCombo").change(function() {
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

    	var cancelacionSearch=self.getCancelacionSearch()
		translator.getAplicaciones(cancelacionSearch,function(data){
			self.fillComboCell(data,$(".contCancelacionesCombo"))

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
    	var seleccion =$(row).find("td").eq(2).text() + "/"+$(row).find("td").eq(3).text()+ "/"+$(row).find("td").eq(7).text();
    	$('.contCancelacionesAreaSeleccion').textext()[0].tags().addTags([seleccion]);
    	var indexFinal=parseInt($(row).index()) +parseInt(this.egresoTabla.fnPagingInfo().iStart)
    	$(".text-tag :last").find(".idEgreso").val($(row).find("td").eq(1).text())
    	$(".text-tag :last").find(".rowIndex").val(indexFinal)
    	$(".text-tag :last").find(".rowImporte").val($(row).find("td").eq(7).text())
    	 this.refreshTotales()

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

    	$(selector).change(function() {
    		var table=$(this).parent().parent().parent().parent();
    		$(this).val(parseFloat($(this).val()).toFixed(2))
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
    		var totalFilasEnTabla=$(row).parent().parent().find("tbody > tr").length
    		if (totalFilasEnTabla!=1){
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
    	$(".contCancelacionesTotal").val(parseFloat(total).toFixed(2));
    },
    mostrarTotales:function(table){
		var total=0;
		console.log("table",table)
    	var cotizacionTotal=parseFloat($("#headerCotizacion").val())
		$(table).find(".contImporte").each(function( index,element ) {
			var valor=parseFloat($(element).find("input").val());
			var monedaId=$(this).parent().find("#monedaId").select2('data').id;

			console.log("valor",valor)

			if ($(this).parent().find(".contImputacionesCuenta").text()!="" && monedaId){
				if ($(this).parent().find(".contCotizacion").find("input").length>0){
    				total+=(valor * parseFloat($(this).parent().find(".contCotizacion").find("input").val()))/cotizacionTotal;
				}else{
					total+=valor/cotizacionTotal;
				}
			}

		});		
		
		console.log("total",total)
		$("."+$(table).attr("id")+"Total").val(parseFloat(total).toFixed(2));
		
		var totales=parseFloat(parseFloat($(".contIngresoTotal").val()) +parseFloat($(".contPropiosTotal").val())+parseFloat($(".contImputacionesTotal").val())-parseFloat($(".contEgresoTotal").val())).toFixed(2);
		$(".contDebito").val(totales);
		$(".contCredito").val(totales);
    },
    createEgresoTab:function(data){
    	
    	var self=this;
    	
    	$('.contCancelacionesAreaSeleccion').textext({
            plugins: 'tags',
            html: {
                tag: '<div class="text-tag"><input class="idEgreso" type="hidden"><input  class="rowIndex"  type="hidden"><input  class="rowImporte"  type="hidden"><div class="text-button"><span class="text-label" style="font-size:13px; color:#538b01; font-weight:bold; font-style:italic;"/><a class="custom-edit"/></div></div>'
            }
        }).bind('tagClick', function(e, tag, value, callback)
        {
        	//var id=$(tag).find(".idCancelacion").val();
        	var rowIndex=$(tag).find(".rowIndex").val();
        	self.egresoTabla.fnUpdate( "<input class ='contEgresoCheck' type='checkbox'onclick='documentoRender.crearBindInputCancelacion(this)' >", parseInt(rowIndex), 0);
        	//Remuevo el Tag
        	 $(tag).remove();
        	 self.refreshTotales()
        })
        if (self.createdEgresoDatatable!=true){
        	if (data.docsValTerceDatatable) { 
        		self.egresoTabla=$('.egreso').dataTable({aaData:data.docsValTerceDatatable.aaData,"destroy": true});
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
    		$(clon).find(".contImporte").find("input").val(1);
    		$(clon).find(".contImporte").find("input").val(1);
    		$(clon).find(".contPropioNumero").find("input").val("");
    		$(clon).find(".contIngresoNumero").find("input").val("");
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
    	if (data.entidades.length ==1){
    		$("#entidadCombo").select2("val",data.entidades[0].id);
    		this.getAplicaciones();
    	}else{
    		$("#entidadCombo").select2("val", "");
    	}
    	

    	for (var i = 0; i < data.monedas.length; i++) { 
    		var id=data.monedas[i]["id"];
    		var text=data.monedas[i]["nombre"];
    		$("#monedaCombo").append(new Option(text,id));
    		
    	}
    	if (data.monedas.length ==1){
    		$("#monedaCombo").select2("val",data.monedas[0].id);
    		this.getAplicaciones();
    		this.getCotizacion(data.monedas[0].id)
    	}else{
    		$("#monedaCombo").select2("val", "");
    	}
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

    createNumeracionMask:function(numeracion){
    	console.log("NUMMASK")
    	this.cleanNumeracion();
    	//console.log("hghh",$('#contNumeracion').val("vacio"))
    	//$('#contNumeracion').val("");
    	if (numeracion.numeroAnio!=null){
    		if (numeracion.numeroAnio==""){
        		$(".contAnio").attr("readonly",false)
    		}else{
    			$(".contAnio").val(numeracion.numeroAnio)
    			$(".contAnio").attr("readonly",true)
    		}
    	}else{
    		$(".contAnio").attr("readonly",true)
    	}
    	if (numeracion.numeroDia!=null){
    		if (numeracion.numeroDia==""){
        		$(".contDia").attr("readonly",false)
    		}else{
    			$(".contDia").val(numeracion.numeroDia)
    			$(".contDia").attr("readonly",true)
    		}
    	}else{
    		$(".contDia").attr("readonly",true)
    	}
		console.log("numeracionESTAESs",numeracion.numeroEstablecimiento)

    	if (numeracion.numeroEstablecimiento!=null){
    		console.log("numeracionESTA")
    		if (numeracion.numeroEstablecimiento==""){
    			console.log("ESTAVACI")
        		$(".contEstablecimiento").attr("readonly",false)
    		}else{
    			$(".contEstablecimiento").val(numeracion.numeroEstablecimiento)
    			$(".contEstablecimiento").attr("readonly",true)
    		}
    	}else{
    		$(".contEstablecimiento").attr("readonly",true)
    	}
    	if (numeracion.numeroLetra!=null){
    		if (numeracion.numeroLetra==""){
    			console.log("LETRAA")
        		$(".contLetra").attr("disabled",false)
    		}else{
    			$(".contLetra").val(numeracion.numeroLetra)
    			$(".contLetra").attr("disabled",true)
    		}
    	}else{
    		$(".contLetra").attr("disabled",true)
    	}
    	if (numeracion.numero!=null){
    		if (numeracion.numero==""){
    			console.log("ENTRANUMERO")
        		$(".contNumeroFinal").attr("readonly",false)
    		}else{
    			$(".contNumeroFinal").val(numeracion.numero)
    			$(".contNumeroFinal").attr("readonly",true)
    		}
    	}else{
    		$(".contNumeroFinal").attr("readonly",true)
    	}
    	if (numeracion.numeroMes!=null){
    		if (numeracion.numeroMes==""){
        		$(".contMes").attr("readonly",false)
    		}else{
    			$(".contMes").val(numeracion.numeroMes)
    			$(".contMes").attr("readonly",true)
    		}
    	}else{
    		$(".contMes").attr("readonly",true)
    	}
    	

    },
    fillImputacionesRow:function(row,data){
    	
    	$(row).find(".contImputacionesCuenta").text(data.cuenta.nombre)
    	$(row).find(".contImputacionesEntidad").empty();
    	$(row).find(".contImputacionesTipoEntidad").text("")
    	if (data.cuenta.tipoEntidad.nombre!=null){
    		
        	$(row).find(".contImputacionesTipoEntidad").text(data.cuenta.tipoEntidad.nombre);
        	$(row).find(".contImputacionesEntidad").append("<select id='entidadId' name='entidadId' class='span12 step2' placeholder='Seleccione'></select>")

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
    	this.refreshTotales();

    },
    fillCancelacionRow:function(row,data){
    	$(row).find(".contCancelacionPendiente").empty();
		$(row).find(".contCancelacionPendiente").append("<input class='span6' type='number' min=1 max="+data.importePendiente+" value="+data.importePendiente+">")
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