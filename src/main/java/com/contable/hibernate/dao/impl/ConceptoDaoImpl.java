package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.hibernate.dao.ConceptoDao;
import com.contable.hibernate.model.Concepto;

@Repository("conceptoDao")
public class ConceptoDaoImpl extends GenericDaoImpl<Concepto, Integer> implements ConceptoDao{

	@Override
	protected Class<Concepto> getEntityClass() {
		return Concepto.class;
	}


	@SuppressWarnings("unchecked")
	public List<ConsultasGeneralesBean> getConceptoInfoParaDocumentoMov(List<Integer> conceptoIds) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		criteria.createAlias("cuenta", "cuenta",Criteria.LEFT_JOIN);

		
		criteria.setProjection(	Projections.projectionList()
									.add(Projections.property("id"),"id")
									.add(Projections.property("cuenta.id"),"campoEntero1")
									.add(Projections.property("cuenta.tipoEntidad.id"),"campoEntero2")
									.add(Projections.property("entidad.id"),"campoEntero3"));

		//criteria.add(Restrictions.in("id", conceptoIds));

		/* Explico que tipo de bean va devolver */
	   	criteria.setResultTransformer(Transformers.aliasToBean(ConsultasGeneralesBean.class));

	    List<ConsultasGeneralesBean> list = criteria.list();

	    return list;
		
	}

	
}
