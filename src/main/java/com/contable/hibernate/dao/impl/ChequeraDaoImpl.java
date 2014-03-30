package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.ChequeraDao;
import com.contable.hibernate.model.Chequera;

@Repository("chequeraDao")
public class ChequeraDaoImpl extends GenericDaoImpl<Chequera, Integer> implements ChequeraDao{

	@Override
	protected Class<Chequera> getEntityClass() {
		return Chequera.class;
	}

}
