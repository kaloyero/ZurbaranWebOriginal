var ComponentTranslator = new Class(
		{

		    show : function(objectType) {
				serverManager.show({
					object : objectType,
					onSuccess : function(data) {
					    var renderInstace = renderTranslator.getRender(objectType);
                        renderInstace.onShow(data);
					}
				});
			},
			 showResumenCuenta : function(objectType) {
					serverManager.showResumenCuenta({
						object : objectType,
						onSuccess : function(data) {
						    var renderInstace = renderTranslator.getRender(objectType);
	                        renderInstace.onShow(data);
						}
					});
				},
				 showSaldoCuenta : function(objectType) {
						serverManager.showSaldoCuenta({
							object : objectType,
							onSuccess : function(data) {
							    var renderInstace = renderTranslator.getRender(objectType);
		                        renderInstace.onShow(data);
							}
						});
					},
					showSaldoEstructura : function(objectType) {
						serverManager.showSaldoEstructura({
							object : objectType,
							onSuccess : function(data) {
							    var renderInstace = renderTranslator.getRender(objectType);
		                        renderInstace.onShow(data);
							}
						});
					},
			getListByAdmin : function(objectType,id,callback) {
					serverManager.getByAdmin({
						object : objectType,
						idAdmin:id,
						onSuccess : function(data) {
						    callback(data);
						}
					});
				},
				getAplicaciones : function(cancelacionSearch,callback) {
					serverManager.getAplicaciones({
						data:cancelacionSearch,
						onSuccess : function(data) {
						    callback(data);
						}
					});
				},
				
				getDataToFillConceptoFormByCuentaId : function(objectType,id,callback) {
					serverManager.getDataToFillConceptoFormByCuentaId({
						object : objectType,
						idCuenta:id,
						onSuccess : function(data) {
						    callback(data);
						}
					});
				},
				
				getMonedaByCuentaId : function(objectType,id,callback) {
					serverManager.getMonedaByCuentaId({
						object : objectType,
						idCuenta:id,
						onSuccess : function(data) {
						    callback(data);
						}
					});
				},
				
			getFormById : function(objectType,entidadId) {
				serverManager.getFormById({
					object : objectType,
					idEntidad:entidadId,
					onSuccess : function(data) {
						var renderInstace = renderTranslator.getRender(objectType);
                        renderInstace.onGetForm(data);
					}
				});
			},
			getCuentaByContenido : function(objectType,contenidoId) {
				serverManager.getCuentaByContenido({
					idContenido:contenidoId,
					onSuccess : function(data) {
						var renderInstace = renderTranslator.getRender(objectType);
                        renderInstace.showCuentas(data);
					}
				});
			},
			getImputacionesInformation : function(conceptoId,callback) {
				serverManager.getImputacionesInformation({
					idConcepto:conceptoId,
					onSuccess : function(data) {
						callback(data);
						//var renderInstace = renderTranslator.getRender(objectType);
                        //renderInstace.onGetForm(data);
					}
				});
			},
			getAplicacionById : function(aplicacionId,callback) {
				serverManager.getAplicacionById({
					idAplicacion:aplicacionId,
					onSuccess : function(data) {
						callback(data);
						//var renderInstace = renderTranslator.getRender(objectType);
                        //renderInstace.onGetForm(data);
					}
				});
			},
			anularById : function(documentoId) {
				serverManager.anularById({
					idDocumento:documentoId,
					onSuccess : function(data) {
						documentoListadoRender.onAnulado(data);
					}
				});
			},
			deleteDocumentoById : function(documentoId) {
				serverManager.deleteDocumentoById({
					idDocumento:documentoId,
					onSuccess : function(data) {
						documentoListadoRender.onDeleted(data);
					}
				});
			},
			getCotizacionyByMonedaId : function(monedaId,callback) {
				serverManager.getCotizacionyByMonedaId({
					idMoneda:monedaId,
					onSuccess : function(data) {
						callback(data);

					}
				});
			},
			
		getDocumentoHeader : function(tipoDocumentoId,callback) {
				serverManager.getDocumentoHeader({
					tipoDocumentoId:tipoDocumentoId,
					onSuccess : function(data) {
						 callback(data);
					}
				});
			},
			getPeriodoFechaInicialByAdmin : function(administracionId,callback) {
				serverManager.getPeriodoFechaInicialByAdmin({
					idAdministracion:administracionId,
					onSuccess : function(data) {
						 callback(data);
					}
				});
			},
			
			
			
			
			
			
			
			
			changeStatus : function(objectType,entidadId) {
				serverManager.changeStatus({
					object : objectType,
					idEntidad:entidadId,
					onSuccess : function(data) {
						var renderInstace = renderTranslator.getRender(objectType);
                        renderInstace.onChanged(data);
					}
				});
			},
			

			save : function(objectType,callback) {
		    	serverManager.save({
					object : objectType,
					form : utils.getFormNew(),
					onSuccess : function(data) {
							render.onSaved(data);

					}
				});
			},

			update : function(objectType,formData) {
				serverManager.update({
					object : objectType,
					form : utils.getFormUpdate(),
					onSuccess : function(data) {
							render.onUpdated();

					}
				});
    			},

			 view : function(objectType,idObject) {

    		}
		});

var translator = new ComponentTranslator();
