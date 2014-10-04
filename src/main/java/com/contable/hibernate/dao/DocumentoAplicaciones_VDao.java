package com.contable.hibernate.dao;

import java.util.List;
import java.util.Set;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroDocAplicacionBean;
import com.contable.hibernate.model.DocumentoAplicaciones_V;

public interface DocumentoAplicaciones_VDao extends GenericDao<DocumentoAplicaciones_V, Integer> {

	
	/**
	 * Retorna un listado de aplicaciones en base a una lista de ids.
	 * 
	 * @param ids
	 * @return
	 */
	public List<DocumentoAplicaciones_V> listAplicacionesByDocIdsList(Set<Integer> ids);
	
	

}
