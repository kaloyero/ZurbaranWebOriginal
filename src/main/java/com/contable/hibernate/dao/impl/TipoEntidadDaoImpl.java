package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.TipoEntidadDao;
import com.contable.hibernate.model.TipoEntidad;

@Repository("tipoEntidadDao")
public class TipoEntidadDaoImpl extends GenericDaoImpl<TipoEntidad, Integer> implements TipoEntidadDao{

	@Override
	protected Class<TipoEntidad> getEntityClass() {
		return TipoEntidad.class;
	}

}
