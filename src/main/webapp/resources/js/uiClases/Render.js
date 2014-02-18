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
    	$( ".nuevo" ).click(function() {
    			$("#modal-simple").modal();
    	
    	});
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
           var self=this;
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
                           "sPaginationType": "full_numbers",
                           "sAjaxSource":this.type,
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

      setValidationMessage:function(){

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

      generateValidation:function(){

      },


});

render=new Render();