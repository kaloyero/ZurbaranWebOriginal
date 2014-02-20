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

    },
    
    update: function(config){

    },   
    show: function(config){
    	$.ajax({
			type: 'GET',
			url: config.object+'/show',
			success: function(data) {
				config.onSuccess(data);
			}
		});
    }
   
});

serverManager=new ServerManager();