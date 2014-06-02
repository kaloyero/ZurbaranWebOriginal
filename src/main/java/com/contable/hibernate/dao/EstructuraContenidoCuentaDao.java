package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

public interface EstructuraContenidoCuentaDao extends GenericDao<EstructuraContenidoCuenta, Integer> {

	public void update(List<EstructuraContenidoCuenta> idsCuentas,int idContenido);
}
