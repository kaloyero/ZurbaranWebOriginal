package com.contable.hibernate.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoMovimientoIm_VDao;
import com.contable.hibernate.model.DocumentoMovimientoIm_V;

@Repository("documentoMovimientoIm_VDao")
public class DocumentoMovimientoIm_VDaoImpl extends GenericDaoImpl<DocumentoMovimientoIm_V, Integer> implements DocumentoMovimientoIm_VDao{

	@Override
	protected Class<DocumentoMovimientoIm_V> getEntityClass() {
		return DocumentoMovimientoIm_V.class;
	}

	@Transactional
	public Collection<Integer> buscarPorReferenciaEnDocumentos(String referencia) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
    	
		/* SELECT */
		
		/*  Seteo el SELECT. Traigo Projection List  */
		criteria.setProjection( Projections.projectionList().add(Projections.distinct(Projections.property("documentoId"))) );
       	/* Explico que tipo de bean va devolver */
       	//criteria.setResultTransformer(Transformers.aliasToBean(Integer.class));

       	/* WHERE */
       	//Filtro estado
   		criteria.add(Restrictions.like("referencia", referencia, MatchMode.ANYWHERE).ignoreCase());
       	
        @SuppressWarnings("unchecked")
		List<Integer> list = criteria.list();

        return list;
	}

}
