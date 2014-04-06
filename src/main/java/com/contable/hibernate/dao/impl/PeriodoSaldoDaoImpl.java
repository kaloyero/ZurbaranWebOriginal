package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.PeriodoSaldoDao;
import com.contable.hibernate.model.PeriodoSaldo;

@Repository("periodoSaldoDao")
public class PeriodoSaldoDaoImpl extends GenericDaoImpl<PeriodoSaldo, Integer> implements PeriodoSaldoDao{

	@Override
	protected Class<PeriodoSaldo> getEntityClass() {
		return PeriodoSaldo.class;
	}

}
