package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.ChequeraNoDisponibleDao;
import com.contable.hibernate.model.ChequeraNoDisponible;

@Repository("chequeraNoDisponibleDao")
public class ChequeraNoDisponibleDaoImpl extends GenericDaoImpl<ChequeraNoDisponible, Integer> implements ChequeraNoDisponibleDao{

	@Override
	protected Class<ChequeraNoDisponible> getEntityClass() {
		return ChequeraNoDisponible.class;
	}

}
