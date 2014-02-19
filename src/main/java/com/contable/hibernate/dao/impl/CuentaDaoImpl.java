package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.CuentaDao;
import com.contable.hibernate.model.Cuenta;

@Repository("cuentaDao")
public class CuentaDaoImpl extends GenericDaoImpl<Cuenta, Integer> implements CuentaDao{

	@Override
	protected Class<Cuenta> getEntityClass() {
		return Cuenta.class;
	}

}
