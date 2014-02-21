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

    },

    onSaved: function(data){

      },


    bindListEvents:function() {
    	var self=this;
    	$( ".nuevo" ).click(function() {
    			self.resetForm();
    			$("#modal-simple").modal();
    	});
		this.createValidation();

     },


     bindAddEvents:function() {


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
           console.log("TYPE",this.type)
           $('#configurationTable').dataTable({
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
                                  }
                       });
          },

      resetForm:function(){
    	  $("form")[0].reset();
        },

      afterDataTable:function(){

    	},
      loadTableTemplate:function(){
    	  var self=this;
          this.getContainer().load( templateManager.getTableTemplate(this.type), function() {
        	  self.makeDatatable();
        	  self.bindListEvents();
          });
        },

      //Estilo y como posicionar los Errores en general
        setDefaultValidationStyle:function(){
    	  $.validator.setDefaults(
    			  {
    			  	submitHandler: function() { alert("Gracias!"); },
    			  	showErrors: function(map, list)
    			  	{
    			  		this.currentElements.parents('label:first, .controls:first').find('.error').remove();
    			  		this.currentElements.parents('.control-group:first').removeClass('error');

    			  		$.each(list, function(index, error)
    			  		{
    			  			var ee = $(error.element);
    			  			var eep = ee.parents('label:first').length ? ee.parents('label:first') : ee.parents('.controls:first');

    			  			ee.parents('.control-group:first').addClass('error');
    			  			eep.find('.error').remove();
    			  			eep.append('<p class="error help-block"><span class="label label-important">' + error.message + '</span></p>');
    			  		});
    			  	}
    			  });
      },


});

render=new Render();