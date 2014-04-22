package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericBaseDaoImpl;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.hibernate.dao.DocumentoMovimientoTotales_VDao;
import com.contable.hibernate.model.DocumentoMovimientoTotales_V;

@Repository("documentoMovimientoTotales_VDao")
public class DocumentoMovimientoTotales_VDaoImpl extends GenericBaseDaoImpl<DocumentoMovimientoTotales_V> implements DocumentoMovimientoTotales_VDao{

	@Override
	protected Class<DocumentoMovimientoTotales_V> getEntityClass() {
		return DocumentoMovimientoTotales_V.class;
	}

	@SuppressWarnings("unchecked")
	public List<ConsultasGeneralesBean> getMovimientosTotales(int documentoId) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		criteria.setProjection(	Projections.projectionList()
									.add(Projections.property("documentoId"),"id")
									.add(Projections.property("totalMovimiento"),"campoDecimal1")
									.add(Projections.property("totalMovimientoMonedaDoc"),"campoDecima2")
									.add(Projections.property("codigoMovimiento"),"campoCadena1"));

		criteria.add(Restrictions.eq("this.documentoId", documentoId));

		/* Explico que tipo de bean va devolver */
	   	criteria.setResultTransformer(Transformers.aliasToBean(ConsultasGeneralesBean.class));

	    List<ConsultasGeneralesBean> list = criteria.list();

	    return list;

	}

}
