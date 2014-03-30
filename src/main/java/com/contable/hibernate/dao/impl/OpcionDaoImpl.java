package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.OpcionDao;
import com.contable.hibernate.model.Opcion;

@Repository("opcionDao")
public class OpcionDaoImpl extends GenericDaoImpl<Opcion, Integer> implements OpcionDao{

	@Override
	protected Class<Opcion> getEntityClass() {
		return Opcion.class;
	}

}
