package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

public interface EstructuraContenidoCuentaManager extends ConfigurationManager<EstructuraContenidoCuenta,EstructuraContenidoCuentaForm>{
	
	public ErrorRespuestaBean update(int idContenido, List<EstructuraContenidoCuentaForm> listadoForm);
	
}
