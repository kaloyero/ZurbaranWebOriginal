package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.ConceptoDao;
import com.contable.hibernate.model.Concepto;

@Repository("conceptoDao")
public class ConceptoDaoImpl extends GenericDaoImpl<Concepto, Integer> implements ConceptoDao{

	@Override
	protected Class<Concepto> getEntityClass() {
		return Concepto.class;
	}

}
