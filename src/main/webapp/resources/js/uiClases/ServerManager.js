var ServerManager = new Class({
    initialize: function(name){
        this.name = name;
        this.services={};
        this.services['moneda']={};
        this.services['moneda']["load"]="moneda/load/";
        this.services['moneda']["save"]="moneda/create";
       
    },

    get: function(config){

    },
    getJson: function(config){

    },
    getAll: function(config){

    },
   
    save: function(config){
    	console.log("Config",config.form.serialize())
    	$.ajax( {
		      type: "POST",
		      url: config.object+'/save',
		      data: config.form.serialize(),
		      success: function(data) {
		    	  config.onSuccess(data);
				}
		    } );
    },
    update: function(config){
    	console.log("Config",config.form.serialize())
    	$.ajax( {
		      type: "POST",
		      url: config.object+'/update',
		      data: config.form.serialize(),
		      success: function(data) {
		    	  config.onSuccess(data);
				}
		    } );
    },
    
    getFormById: function(config){
    	$.ajax({
			type: 'GET',
			url: config.object+'/getEntidadById/'+config.idEntidad,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    	
    }, 
    changeStatus: function(config){
    	$.ajax({
			type: 'GET',
			url: config.object+'/changeStatus/'+config.idEntidad,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    	
    }, 
    show: function(config){
    	$.ajax({
			type: 'GET',
			url: config.object+'/show',
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    
    getByAdmin: function(config){
    	$.ajax({
			type: 'GET',
			url: config.object+'/listByAdminId/'+config.idAdmin,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    getDocumentoHeader: function(config){
    	$.ajax({
			type: 'GET',
			url: 'documento/getDocumentoHeader/'+config.tipoDocumentoId,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    getImputacionesInformation: function(config){
    	$.ajax({
			type: 'GET',
			url: 'documento/getPermiteImputacionInfo/'+config.idConcepto,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    getDataToFillConceptoFormByCuentaId: function(config){
    	$.ajax({
			type: 'GET',
			url: config.object+'/getDataForConcepto/'+config.idCuenta,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    }

});

serverManager=new ServerManager();