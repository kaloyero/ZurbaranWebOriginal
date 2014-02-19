package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.EntidadTipoDao;
import com.contable.hibernate.model.TipoEntidad;

@Repository("entidadTipoDao")
public class EntidadTipoDaoImpl extends GenericDaoImpl<TipoEntidad, Integer> implements EntidadTipoDao{

	@Override
	protected Class<TipoEntidad> getEntityClass() {
		return TipoEntidad.class;
	}

}
