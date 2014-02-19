package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.CuentaMonedaDao;
import com.contable.hibernate.model.CuentaMoneda;

@Repository("cuentaMonedaDao")
public class CuentaMonedaDaoImpl extends GenericDaoImpl<CuentaMoneda, Integer> implements CuentaMonedaDao{

	@Override
	protected Class<CuentaMoneda> getEntityClass() {
		return CuentaMoneda.class;
	}

}
