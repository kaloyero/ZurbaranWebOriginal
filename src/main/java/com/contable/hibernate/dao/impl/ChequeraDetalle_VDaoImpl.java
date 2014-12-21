package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

    @SuppressWarnings("unchecked")
	public List<ChequeraDetalle_V> findChequeraDetalleList(Integer chequeraId) {
    	
    	Criteria criteria = getSession().createCriteria(getEntityClass());
         if (chequeraId == null) {
         	//Si el valor enviado es NULL
         	criteria.add(Restrictions.isNull("chequeraId"));
         } else {
         	//Si el valor no es nulo
         	criteria.add(Restrictions.eq("chequeraId", chequeraId));
         }
         criteria.addOrder(Order.desc("numero"));
         
         
         return (List<ChequeraDetalle_V>) criteria.list();
    }
	
}
