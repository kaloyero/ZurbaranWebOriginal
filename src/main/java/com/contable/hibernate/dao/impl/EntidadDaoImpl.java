package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.EntidadDao;
import com.contable.hibernate.model.Entidad;

@Repository("entidadDao")
public class EntidadDaoImpl extends GenericDaoImpl<Entidad, Integer> implements EntidadDao{

	@Override
	protected Class<Entidad> getEntityClass() {
		return Entidad.class;
	}

}
