package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.EstructuraContenidoCuentaDao;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

@Repository("estructuraContenidoCuentaDao")
public class EstructuraContenidoCuentaDaoImpl extends GenericDaoImpl<EstructuraContenidoCuenta, Integer> implements EstructuraContenidoCuentaDao{

	@Override
	protected Class<EstructuraContenidoCuenta> getEntityClass() {
		return EstructuraContenidoCuenta.class;
	}

}
