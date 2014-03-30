package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.RolDao;
import com.contable.hibernate.model.Rol;

@Repository("rolDao")
public class RolDaoImpl extends GenericDaoImpl<Rol, Integer> implements RolDao{

	@Override
	protected Class<Rol> getEntityClass() {
		return Rol.class;
	}

}
