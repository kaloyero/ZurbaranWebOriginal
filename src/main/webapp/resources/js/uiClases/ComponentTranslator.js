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
			getListByAdmin : function(objectType,id,callback) {
					serverManager.getByAdmin({
						object : objectType,
						idAdmin:id,
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
				getDocumentoHeader : function(tipoDocumentoId,callback) {
				serverManager.getDocumentoHeader({
					tipoDocumentoId:tipoDocumentoId,
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
							render.onSaved();

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
