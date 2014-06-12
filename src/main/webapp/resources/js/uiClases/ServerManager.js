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
    getCuentaByContenido: function(config){
    	console.log("CONFIG")
    	$.ajax({
			type: 'GET',
			url: 'estructuraContenido/getCuentaByContenidoId/'+config.idContenido,
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
    	if (config.object=="documentoListado"){
    		$.ajax({
    			type: 'GET',
    			url: 'documento/listadoShow',
    			success: function(data) {
    				config.onSuccess(data);
    			}
    		});
    	}else{
    		$.ajax({
    			type: 'GET',
    			url: config.object+'/show',
    			success: function(data) {
    				config.onSuccess(data);
    			}
    		});
    	}
    },
    showResumenCuenta: function(config){
    		$.ajax({
    			type: 'GET',
    			url: 'cuenta/resumenCuenta',
    			success: function(data) {
    				config.onSuccess(data);
    			}
    		});

    },
    showSaldoCuenta: function(config){
		$.ajax({
			type: 'GET',
			url: 'cuenta/saldoCuenta',
			success: function(data) {
				config.onSuccess(data);
			}
		});

},
showSaldoEstructura: function(config){
	$.ajax({
		type: 'GET',
		url: 'estructura/saldoEstructura',
		success: function(data) {
			config.onSuccess(data);
		}
	});

},
showSaldoEstructuraMovimiento: function(config){
	$.ajax({
		type: 'GET',
		url: 'estructura/saldoEstructuraMovimiento',
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
    anularById: function(config){
    	$.ajax({
			type: 'GET',
			url: 'documento/anularDocumentoById/'+config.idDocumento,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    deleteDocumentoById: function(config){
    	$.ajax({
			type: 'GET',
			url: 'documento/borrarDocumentoById/'+config.idDocumento,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    getMonedaByCuentaId: function(config){
    	$.ajax({
			type: 'GET',
			url: config.object+'/getMonedaByCuentaId/'+config.idCuenta,
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
    getPeriodoFechaInicialByAdmin: function(config){
    	$.ajax({
			type: 'GET',
			url: 'periodo/getFechaInicialbyAdmin/'+config.idAdministracion,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    
    
    
    
    getImputacionesInformation: function(config){
    	$.ajax({
			type: 'GET',
			url: 'documento/getDocumentoTabInfo/'+config.idConcepto,


			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    getAplicacionById: function(config){
    	$.ajax({
			type: 'GET',
			url: 'documento/getAplicacionById/'+config.idAplicacion,

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
    },
    getCotizacionyByMonedaId: function(config){
    	$.ajax({
			type: 'GET',
			url: 'moneda/getCotizacionyByMonedaId/'+config.idMoneda,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    getAplicaciones: function(config){
    	$.ajax({
			type: 'POST',
			url: 'documento/getAplicaciones',
			contentType: "application/json",
			data : JSON.stringify(config.data),
			success: function(data) {
				config.onSuccess(data);
			}
		});
    }
    
    
    
    

});

serverManager=new ServerManager();