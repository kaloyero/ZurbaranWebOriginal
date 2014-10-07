package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
	
	@SuppressWarnings("unchecked")
	public List<ChequeraNoDisponible> getChequeNoDisponible(int chequeraId, int numero) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		criteria.add(Restrictions.eq("chequera.id", chequeraId));
		criteria.add(Restrictions.eq("numero", numero));

       	List<ChequeraNoDisponible> list = criteria.list();
		
		return list;
	
	}


}
