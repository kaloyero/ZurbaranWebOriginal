package com.contable.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.MonedaDao;
import com.contable.hibernate.model.Moneda;

@Repository("monedaDao")
public class MonedaDaoImpl extends GenericDaoImpl<Moneda, Integer> implements MonedaDao{

	@Override
	protected Class<Moneda> getEntityClass() {
		return Moneda.class;
	}

	public void poneMonedaLocalEnFalsoParaTodas(){
		StringBuilder queryStr = new StringBuilder();
	    
		queryStr.append("update `Monedas` set `MonedaLocal`='"+ Constants.BD_INACTIVO +"'");
		Query query = getSession().createSQLQuery(queryStr.toString());

		query.executeUpdate();

	}
	
	@Transactional
	public Moneda obtenerMonedaLocal(){
  	  Criteria criteria = getSession().createCriteria(getEntityClass());
      criteria.add(Restrictions.eq("monedaLocal", Constants.BD_ACTIVO));
		
      return (Moneda) criteria.uniqueResult();
	}
}
