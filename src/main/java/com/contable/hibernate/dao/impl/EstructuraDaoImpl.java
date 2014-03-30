package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.EstructuraDao;
import com.contable.hibernate.model.Estructura;

@Repository("estructuraDao")
public class EstructuraDaoImpl extends GenericDaoImpl<Estructura, Integer> implements EstructuraDao{

	@Override
	protected Class<Estructura> getEntityClass() {
		return Estructura.class;
	}

}
