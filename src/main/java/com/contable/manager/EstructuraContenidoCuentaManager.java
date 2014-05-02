package com.contable.manager;

import com.contable.common.ConfigurationManager;
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

public interface EstructuraContenidoCuentaManager extends ConfigurationManager<EstructuraContenidoCuenta,EstructuraContenidoCuentaForm>{
	public void guardarNuevo(EstructuraContenidoCuentaForm[] listado);
		
	
}
