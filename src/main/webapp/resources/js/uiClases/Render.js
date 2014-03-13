var Render = new Class({
    initialize: function(name){
        this.name = name;
        this.currentStatus;
    },

    cleanCanvas: function(){
    },

    getForm: function(){
    },

    show: function(){
        this.loadTableTemplate();
    },
    onShow: function(data){
    	this.getContainer().html(data);
    	this.makeDatatable();
      	this.bindAddEvents();
    },
    afterDataTable:function(){
      	this.bindListEvents();

	},

    onList: function(data){
        this.getContainer().append(data);
       
	},

    onNew: function(data){
        this.getContainer().append("data");
        
    },

    onView: function(data){


    },
    onUpdated: function(data){
    	this.hideEditForm();
    	this.showSucessUpdateMessage();
    },

    onSaved: function(){
    	this.hideAltaForm();
    	this.showSucessMessage();
    	//console.log("appStatus",appStatus)
    	//$("#configurationTable").dataTable().fnReloadAjax();
    	//appStatus.actualTable.fnDraw();
      },
      
     showSucessMessage:function(){
 		$.jGrowl("Creado con exito.", {
			theme : 'success'
		});
     },
     showSucessUpdateMessage:function(){
  		$.jGrowl("Actualizado con exito.", {
 			theme : 'success'
 		});
      },
     hideAltaForm:function(){
     	$(".contNew").modal('hide');
     },
     hideEditForm:function(){
      	$(".contEdit").modal('hide');
      },

    bindListEvents:function() {
     	var self=this;

    	$( ".contView" ).click(function() {
	  		translator.getFormById(self.getType());

    	});

     },

     bindAddEvents:function() {
     	var self=this;
    	 $( ".nuevo" ).click(function() {	
 			self.resetForm();
 			$(".contNew").modal();
    	 	});
 		this.bindSubmitNewEvent();
 		this.createValidation();

     },

      bindEditEvents:function() {

      },

     getContainer:function() {
         return  $(".contenidoPrincipal");

       },

     getSelectedRowId:function(selectedRow) {

      },

     addLoader:function() {

      },

     removeLoader:function() {
     },

    makeDatatable:function() {
    	   var self=this;
           console.log("TYPE",this.type)
          appStatus.actualTable=$('#configurationTable').dataTable({
                           "bProcessing": true,
                           "bServerSide": true,
                           "iDisplayStart": 1,
                           "DisplayLength":10,
						   "aLengthMenu": [10, 25, 50, 100, 150, 200],
						   "iDisplayLength":[100],
                           "bPaginate": true,
						   "bFiltered": true,
                           "sAjaxSource":this.type+"/lista",
/*							"oLanguage": {
								"sUrl": "dataTables.german.txt"
							},
*/
                           "oLanguage": {
									"sProcessing":     	"Procesando...",
                                    "sSearch": 			"Busqueda:",
									"sLengthMenu":     	"Mostrar _MENU_ registros",
									"sZeroRecords":    	"No se encontraron resultados",
									"sEmptyTable":     	"Ningún dato disponible en esta tabla",
									"sInfo": 			"Mostrando _START_ hasta _END_ de un total de  _TOTAL_ registros",
									"sInfoEmpty":      	"Mostrando registros del 0 al 0 de un total de 0 registros",
									"sInfoFiltered":   	"(filtrado de un total de _MAX_ registros)",
									"sLoadingRecords": "Cargando...",
                                    "oPaginate": {
                                            "sNext": "Proxima",
                                            "sFirst": "Primera",
                                            "sLast": "Ultima",
                                            "sPrevious": "Previo"

                                          }
                                  },
                                  //Este CallBack se ejecuta cuando esta lista la tabla
                             "fnDrawCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
       							   self.afterDataTable();
                                  }
                       });
          },

      resetForm:function(){
    	  $("form")[0].reset();
        },
        fillCombo:function(result,comboId){
        	console.log("ENTRa",result)
        	$('#'+comboId).find('option').remove()

        	for (var i = 0; i < result.iTotalRecords; i++) { 
        		console.log("Data",result.aaData[i][0])
        		console.log("Data1aa",result.aaData[i][1])
        		var id=result.aaData[i][0];
        		var text=result.aaData[i][1];
        		$('#'+comboId).append(new Option(text,id));
        		
        	}

        },
       getType:function(){
      	  return this.type;
          },
      
       
      loadTableTemplate:function(){
    	  var self=this;
          this.getContainer().load( templateManager.getTableTemplate(this.type), function() {
        	  self.makeDatatable();
        	  self.bindListEvents();
          });
        },

      //Estilo y como posicionar los Errores en general
        bindSubmitNewEvent:function(){
          var self =this;
    	  $.validator.setDefaults(
    			  {
    			  	submitHandler: function() { 
    			  		translator.save(self.getType());
    			  	},
    			  	showErrors: function(map, list)
    			  	{
    			  		self.validateFormErrors(this,map,list)
    			  	}
    			  });
      },
      bindSubmitUpdateEvent:function(){
          var self =this;
    	  $.validator.setDefaults(
    			  {
    			  	submitHandler: function() { 
    			  		translator.update(self.getType());
    			  	},
    			  	showErrors: function(map, list)
    			  	{
    			  		self.validateFormErrors(this,map,list)
    			  	}
    			  });
      },
      
      validateFormErrors:function(form,map, list){
    	  form.currentElements.parents('label:first, .controls:first').find('.error').remove();
    	  form.currentElements.parents('.control-group:first').removeClass('error');

	  		$.each(list, function(index, error)
	  		{
	  			var ee = $(error.element);
	  			var eep = ee.parents('label:first').length ? ee.parents('label:first') : ee.parents('.controls:first');

	  			ee.parents('.control-group:first').addClass('error');
	  			eep.find('.error').remove();
	  			eep.append('<p class="error help-block"><span class="label label-important">' + error.message + '</span></p>');
	  		});
      },
      onGetForm:function(data){ 
      	$(".contEdit").remove()
      	this.getContainer().append(data);
  		$(".contEdit").modal();
  		this.bindSubmitUpdateEvent();
  		this.createUpdateValidation();
  	
      },
      createUpdateValidation:function(){
    	  
      }


});

render=new Render();