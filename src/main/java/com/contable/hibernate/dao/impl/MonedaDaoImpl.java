package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.MonedaDao;
import com.contable.hibernate.model.Moneda;

@Repository("monedaDao")
public class MonedaDaoImpl extends GenericDaoImpl<Moneda, Integer> implements MonedaDao{

	@Override
	protected Class<Moneda> getEntityClass() {
		return Moneda.class;
	}

}
