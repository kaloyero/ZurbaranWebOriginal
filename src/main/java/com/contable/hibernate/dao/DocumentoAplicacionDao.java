package com.contable.hibernate.dao;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.DocumentoAplicacion;

public interface DocumentoAplicacionDao extends GenericDao<DocumentoAplicacion, Integer> {

	/**
	 * Devuelve el total de los documentos aplicados.
	 * 
	 * @param idDocomento
	 * @return
	 */
	public double sumaTotalAplicaciones(int idDocomento);

}
