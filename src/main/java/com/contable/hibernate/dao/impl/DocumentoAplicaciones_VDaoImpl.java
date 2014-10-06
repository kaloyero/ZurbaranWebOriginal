package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoAplicaciones_VDao;
import com.contable.hibernate.model.DocumentoAplicaciones_V;

@Repository("documentoAplicaciones_VDao")
public class DocumentoAplicaciones_VDaoImpl extends GenericDaoImpl<DocumentoAplicaciones_V, Integer> implements DocumentoAplicaciones_VDao{

	@Override
	protected Class<DocumentoAplicaciones_V> getEntityClass() {
		return DocumentoAplicaciones_V.class;
	}

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public List<DocumentoAplicaciones_V> listAplicacionesByDocIdsList(Set<Integer> ids){
		List<DocumentoAplicaciones_V> lista =new ArrayList<DocumentoAplicaciones_V>();
		
		//Si la lista de Ids esta vacia devuelvo una lista vacia
		if (ids != null && ( ! ids.isEmpty()) ){
			Criteria criteria = getSession().createCriteria(getEntityClass());
			
	    	/* Agrega los filtros */
			criteria.add(Restrictions.in("documentoId", ids));
	  	  
			/* ORDEN */
	    	setOrderBy(criteria,"documentoId",true);
	  	
		  	/* Obtengo la lista */
		  	lista = (List<DocumentoAplicaciones_V>)criteria.list();
		}
  	
	  	return lista;
  	  
    }

}
