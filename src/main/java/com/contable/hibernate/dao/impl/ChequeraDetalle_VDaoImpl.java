package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.ChequeraDetalle_VDao;
import com.contable.hibernate.model.ChequeraDetalle_V;

@Repository("chequeraDetalle_VDao")
public class ChequeraDetalle_VDaoImpl extends GenericDaoImpl<ChequeraDetalle_V, Integer> implements ChequeraDetalle_VDao{

	@Override
	protected Class<ChequeraDetalle_V> getEntityClass() {
		return ChequeraDetalle_V.class;
	}

	
}
