package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

public interface EstructuraContenidoCuentaService extends AbstractService<EstructuraContenidoCuenta>{

	public ErrorRespuestaBean update(List<EstructuraContenidoCuenta> listado,int idContenido);
}
