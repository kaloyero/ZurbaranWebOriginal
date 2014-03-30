package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.EstructuraContenidoDao;
import com.contable.hibernate.model.EstructuraContenido;

@Repository("estructuraContenidoDao")
public class EstructuraContenidoDaoImpl extends GenericDaoImpl<EstructuraContenido, Integer> implements EstructuraContenidoDao{

	@Override
	protected Class<EstructuraContenido> getEntityClass() {
		return EstructuraContenido.class;
	}

}
