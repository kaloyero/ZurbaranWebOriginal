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
				
				
				
			add : function(objectType,dataToSend) {

			},

			save : function(objectType,callback) {
		    	serverManager.save({
					object : objectType,
					form : utils.getForm(),
					onSuccess : function(data) {
							render.onSaved();

					}
				});
			},

			update : function(objectType,formData) {

    			},

			 view : function(objectType,idObject) {

    		}
		});

var translator = new ComponentTranslator();
