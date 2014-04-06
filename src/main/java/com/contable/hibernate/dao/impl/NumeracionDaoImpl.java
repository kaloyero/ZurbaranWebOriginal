package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.NumeracionDao;
import com.contable.hibernate.model.Numeracion;

@Repository("numeracionDao")
public class NumeracionDaoImpl extends GenericDaoImpl<Numeracion, Integer> implements NumeracionDao{

	@Override
	protected Class<Numeracion> getEntityClass() {
		return Numeracion.class;
	}

}
