var Render = new Class(
		{
			initialize : function(name) {
				this.name = name;
				this.currentStatus;
			},

			cleanCanvas : function() {
			},

			getForm : function() {
			},

			onShow : function(data) {
				this.getContainer().html(data);
				appStatus.currentType = this.type;
				this.makeDatatable();
				this.bindExtraFields();
				this.bindAddEvents();
			},

			onList : function(data) {
				this.getContainer().append(data);

			},
			bindExtraFields : function() {

			},
			onGetForm : function(data) {
				this.removeEditForm();
				this.getContainer().append(data);
				this.showEditForm();
				this.bindUpdateEvents();
				this.bindSubmitUpdateEvent();
				this.createUpdateValidation();

			},
			onUpdated : function(data) {
				this.hideEditForm();
				this.showSucessUpdateMessage();
				this.refreshTable();
			},
			refreshTable : function() {
				sideBarController.onOptionSelected(appStatus.currentType);

			},
			onSaved : function(data) {
				console.log("DATA SAVE",data)
				if (data.valido==true){
					this.hideAltaForm();
					this.showSucessMessage();
					this.refreshTable();
				}else{
					this.showErrorMessage(data.descripcion);
				}
				
				// console.log("VA",$($(".pagination").find('li')[1]).trigger('click')
				// )

			},
			onChanged : function() {
				this.showChangedMessage();

			},

			showSucessMessage : function() {
				$.jGrowl("Creado con exito.", {
					theme : 'success'
				});
			},
			showErrorMessage : function(mensaje) {
				$.jGrowl(mensaje, {
					theme : 'error'
				});
			},
			showSucessUpdateMessage : function() {
				$.jGrowl("Actualizado con exito.", {
					theme : 'success'
				});
			},
			showChangedMessage : function() {
				$.jGrowl("Estado cambiado con exito.", {
					theme : 'success'
				});
			},

			// ////Binds////////////////
			bindListEvents : function() {
				console.log("ENB")
				var self = this;
				$(self.getViewButtons()).unbind("click");
				$(self.getChangeButtons()).unbind("click");

				self.getViewButtons().click(function() {
					var elementId = self.getIdFromGrid(this);
					translator.getFormById(self.getType(), elementId);
				});
				self.getChangeButtons().click(function() {
					var elementId = self.getIdFromGrid(this);
					translator.changeStatus(self.getType(), elementId);
				});

			},

			getIdFromGrid : function(element) {
				return $(element).parent().siblings(":first").text()
			},
			bindAddEvents : function() {
				var self = this;
				this.getNewButton().click(function() {
					self.resetForm();
					self.showNewForm();
				});
				this.bindSubmitNewEvent();
				this.createValidation();

			},

			bindUpdateEvents : function() {

			},
			// Encargado de ejecutar los save
			bindSubmitNewEvent : function() {
				var self = this;
				$.validator.setDefaults({
					submitHandler : function() {
						
						if (self.specialFormValidation()){
							translator.save(self.getType());
						}
					},
					showErrors : function(map, list) {
						console.log("ENTRaError")
						
						self.validateFormErrors(this, map, list)
					}
				});
			},
			specialFormValidation : function() {
				return true
			},
			// Encargado de ejecutar los update

			bindSubmitUpdateEvent : function() {
				var self = this;
				$.validator.setDefaults({
					submitHandler : function() {
						translator.update(self.getType());
					},
					showErrors : function(map, list) {
						self.validateFormErrors(this, map, list)
					}
				});
			},

			// ////END Binds////////////////

			makeDatatable : function() {
				var self = this;
				console.log("TYPE", this.type, appStatus.currentType)
				appStatus.actualTable = $('#configurationTable')
						.dataTable(
								{
									"bProcessing" : true,
									// "bServerSide": true,
									// "iDisplayStart": 0,
									// "DisplayLength":10,
									"aLengthMenu" : [ 10, 25, 50, 100, 150, 200 ],
									// "iDisplayLength":[10],
									// "bPaginate": true,
									// "bFiltered": true,
									"sAjaxSource" : appStatus.currentType
											+ "/lista",
									/*
									 * "oLanguage": { "sUrl":
									 * "dataTables.german.txt" },
									 * 
									 */sDom : 'T<"clear">lfrtip',
									oTableTools : {
										"sSwfPath" : "resources/media/swf/copy_csv_xls_pdf.swf",
										"aButtons" : [ "copy", {
											"sExtends" : "csv",
											"sTitle" : "titleExport csv",
											"sFileName" : "*.csv"
										}, {
											"sExtends" : "xls",
											"sTitle" : "titleExportxls",
											"sFileName" : "*.xls"
										}, {
											"sExtends" : "pdf",
											"sTitle" : "titleExportpdf",
											"sFileName" : "*.pdf"
										}, "print" ]
									},
									"oLanguage" : {
										"sProcessing" : "Procesando...",
										"sSearch" : "Busqueda:",
										"sLengthMenu" : "Mostrar _MENU_ registros",
										"sZeroRecords" : "No se encontraron resultados",
										"sEmptyTable" : "Ningún dato disponible en esta tabla",
										"sInfo" : "Mostrando _START_ hasta _END_ de un total de  _TOTAL_ registros",
										"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
										"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
										"sLoadingRecords" : "Cargando...",
										"oPaginate" : {
											"sNext" : "Proxima",
											"sFirst" : "Primera",
											"sLast" : "Ultima",
											"sPrevious" : "Previo"

										}
									},
									// Este CallBack se ejecuta cuando esta
									// lista la tabla
									"fnDrawCallback" : function(nRow, aData,
											iDisplayIndex, iDisplayIndexFull) {
										console.log("AFFF")
										self.afterDataTable();

									}
								});
			},

			afterDataTable : function() {

				this.bindListEvents();

			},

			fillCombo : function(result, selector, valTodos) {
				selector.find('option').remove()
				selector.append(new Option("", ""));
				if (valTodos) {
					selector.append(new Option("TODOS", "-1"))
				}
				for ( var i = 0; i < result.iTotalRecords; i++) {
		
					var id = result.aaData[i][0];
					var text = result.aaData[i][1];
					selector.append(new Option(text, id));

				}

			},

			validateFormErrors : function(form, map, list) {
				form.currentElements.parents('label:first, .controls:first')
						.find('.error').remove();
				form.currentElements.parents('.control-group:first')
						.removeClass('error');

				$
						.each(
								list,
								function(index, error) {
									var ee = $(error.element);
									var eep = ee.parents('label:first').length ? ee
											.parents('label:first')
											: ee.parents('.controls:first');

									ee.parents('.control-group:first')
											.addClass('error');
									eep.find('.error').remove();
									eep
											.append('<p class="error help-block"><span class="label label-important">'
													+ error.message
													+ '</span></p>');
								});
			},

			createUpdateValidation : function() {

			},
			// FORMS///
			resetForm : function() {
				$(".contFormNew")[0].reset();
			},
			removeEditForm : function() {
				$(".contEdit").remove()
			},
			showEditForm : function() {
				$(".contEdit").modal();
			},
			showNewForm : function() {
				$(".contNew").modal();
			},
			hideAltaForm : function() {
				$(".contNew").modal('hide');
			},
			hideEditForm : function() {
				$(".contEdit").modal('hide');
			},
			// END FORMS///

			// ////GETS////////////////

			getContainer : function() {
				return $(".contenidoPrincipal");

			},

			getSelectedRowId : function(selectedRow) {

			},
			getNewButton : function() {
				return $(".nuevo");
			},
			getViewButtons : function() {
				return $(".contView");
			},
			getChangeButtons : function() {
				return $(".contChange");
			},
			getType : function() {
				return this.type;
			},

		});

render = new Render();