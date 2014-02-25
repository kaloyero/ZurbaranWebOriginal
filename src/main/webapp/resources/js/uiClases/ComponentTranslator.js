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
			add : function(objectType,dataToSend) {

			},

			save : function(objectType,callback) {
		    	serverManager.save({
					object : objectType,
					form : utils.getForm(),
					onSuccess : function(data) {
								$.jGrowl("Creado con exito.", {
									theme : 'success'
								});
					}
				});
			},

			update : function(objectType,formData) {

    			},

			 view : function(objectType,idObject) {

    		}
		});

var translator = new ComponentTranslator();
