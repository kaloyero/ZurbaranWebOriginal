package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.RolOpcionDao;
import com.contable.hibernate.model.RolOpcion;

@Repository("rolOpcionDao")
public class RolOpcionDaoImpl extends GenericDaoImpl<RolOpcion, Integer> implements RolOpcionDao{

	@Override
	protected Class<RolOpcion> getEntityClass() {
		return RolOpcion.class;
	}

}
