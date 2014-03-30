package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.PeriodoDao;
import com.contable.hibernate.model.Periodo;

@Repository("periodoDao")
public class PeriodoDaoImpl extends GenericDaoImpl<Periodo, Integer> implements PeriodoDao{

	@Override
	protected Class<Periodo> getEntityClass() {
		return Periodo.class;
	}

}
