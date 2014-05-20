package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.Chequera_VDao;
import com.contable.hibernate.model.Chequera_V;

@Repository("chequera_VDao")
public class Chequera_VDaoImpl extends GenericDaoImpl<Chequera_V, Integer> implements Chequera_VDao{

	@Override
	protected Class<Chequera_V> getEntityClass() {
		return Chequera_V.class;
	}

}
