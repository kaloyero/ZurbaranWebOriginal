var Periodo = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="periodo";
        this.breadcrumb='Concepto';
        this.descripcion="Desde aqui gestiones los Conceptos";
    },
    
    bindAddEvents:function() {

    	var self=this;
    	this.parent();
    	 $('.datepicker').datepicker({showOtherMonths:true ,dateFormat: 'dd-mm-yy' });
     	 $(".datepicker").datepicker("setDate",new Date());
    	
     	 $(".contFormNew").find(".contAdministracionCombo").change(function() {
     		 console.log(" VALO",$(this).val())
     		 if ($(this).val()!=0){
     			 translator.getPeriodoFechaInicialByAdmin($(this).val(),function(data){self.fillPeriodoForm(data);})
     		 }else{
     			 self.cleanFechaIni();
     		 }
    	});
    

    },
 
    cleanFechaIni:function(formToFind) {
    	$("#fechaIniText").val("")
    	$("#fechaIni").val("")
    },
    fillPeriodoForm:function(result) {
    	$("#fechaIniText").val(result)
    	$("#fechaIni").val(result)
    },
    validateFormErrors : function(form, map, list) {
    	if ($("#fechaIni").val()==""){
    		$("#fechaIni").append('<p class="error help-block"><span class="label label-important">Requerido</span></p>');
    	}
    	
    	this.parent(form, map, list);
    },

    createValidation:function(){
    	$.validator.addMethod(
    		    "greaterThan",
    		    function(value,element,params) {
    		    	var d1 = new Date($(params).val());
    		    	var d2 = new Date(value);
    		    	    		        if (d2 > d1) {
    		            return true;
    		        }
    		        return false;
    		    },
    		    "La fecha final debe ser > que la inicial"
    		);
    	
    	 $(".contFormNew").validate({
     		rules: {
     			
     			'fechaIni':"required",
     	   		//'moneda.id':'required',
     	   		'administracion.id':'required',
     	   	fechaFin: {
			      required: true,
			      greaterThan: '#fechaIni'
			    },
     		},
     		messages: {
     			"fechaFin": "Requerido",
     			'fechaIni':"Requerido",
     			'administracion.id':"Requerido"
     		}
     	});

    	
    },
    createUpdateValidation:function(){

    	
    },
    resetForm:function(){
    	this.parent();
      },


});

periodoRender=new Periodo()