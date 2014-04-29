package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;

public interface DocumentoAplicacionPendiente_VDao extends GenericDao<DocumentoAplicacionPendiente_V, Integer> {

	
	/**
	 * Devuelve un listado de Documentos pendientes de Aplicacion
	 * 
	 * @param cuenta
	 * @param tipoEntidad
	 * @param entidad
	 * @param moneda
	 * @return
	 */
	List<DocumentoAplicacionPendiente_V> getListaDocsAplicationPendiente(String tipoMovimiento,Integer cuenta,
			Integer tipoEntidad, Integer entidad, Integer moneda);
}
