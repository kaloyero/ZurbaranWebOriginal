var Render = new Class({
    initialize: function(name){
        this.name = name;
        this.currentStatus;
    },

    cleanCanvas: function(){
    },

    getForm: function(){
    },

    onShow: function(data){
    	this.getContainer().html(data);
    	this.makeDatatable();
      	this.bindAddEvents();
    },

    onList: function(data){
        this.getContainer().append(data);
       
	},
	onGetForm:function(data){ 
	    	this.removeEditForm();
	      	this.getContainer().append(data);
	  		this.showEditForm();
		  	this.bindUpdateEvents();
	  		this.bindSubmitUpdateEvent();
	  		this.createUpdateValidation();
	  	
	},
    onUpdated: function(data){
    	this.hideEditForm();
    	this.showSucessUpdateMessage();
    },

    onSaved: function(){
    	this.hideAltaForm();
    	this.showSucessMessage();

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
     
//////Binds////////////////
    bindListEvents:function() {
     	var self=this;

    	self.getViewButtons().click(function() {
    		var elementId=self.getIdFromGrid(this);
	  		translator.getFormById(self.getType(),elementId);
    	});

     },

     getIdFromGrid:function(element){
    	 return $(element).parent().siblings(":first").text()
     },
     bindAddEvents:function() {
     	var self=this;
     	this.getNewButton().click(function() {	
 			self.resetForm();
 			self.showNewForm();
    	 	});
 		this.bindSubmitNewEvent();
 		this.createValidation();

     },

      bindUpdateEvents:function() {

      },
      //Encargado de ejecutar los save
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
      //Encargado de ejecutar los update

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

//////END Binds////////////////


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
      
       afterDataTable:function(){
            	this.bindListEvents();

      	},

        fillCombo:function(result,selector){
        	console.log("ENTRa",result)
        	selector.find('option').remove()

        	for (var i = 0; i < result.iTotalRecords; i++) { 
        		console.log("Data",result.aaData[i][0])
        		console.log("Data1aa",result.aaData[i][1])
        		var id=result.aaData[i][0];
        		var text=result.aaData[i][1];
        		selector.append(new Option(text,id));
        		
        	}

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
    
      createUpdateValidation:function(){
    	  
      },
      //FORMS///
      resetForm:function(){
    	  $(".contFormNew")[0].reset();
        },
      removeEditForm:function(){
    	  $(".contEdit").remove()
      },
      showEditForm:function(){
      	  $(".contEdit").modal();
      },
      showNewForm:function(){
    	  $(".contNew").modal();
      },
      hideAltaForm:function(){
       	$(".contNew").modal('hide');
      },
      hideEditForm:function(){
       	$(".contEdit").modal('hide');
       },
       //END FORMS///

       
       //////GETS////////////////
       
       getContainer:function() {
           return  $(".contenidoPrincipal");

         },

       getSelectedRowId:function(selectedRow) {

        },
        getNewButton:function() {
      	  return $( ".nuevo" );
        },
        getViewButtons:function() {
      	  return $( ".contView" );
        },    
        getType:function(){
        	  return this.type;
         },

});

render=new Render();