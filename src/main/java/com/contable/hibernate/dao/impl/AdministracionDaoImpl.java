package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.AdministracionDao;
import com.contable.hibernate.model.Administracion;

@Repository("administracionDao")
public class AdministracionDaoImpl extends GenericDaoImpl<Administracion, Integer> implements AdministracionDao{

	@Override
	protected Class<Administracion> getEntityClass() {
		return Administracion.class;
	}

}
