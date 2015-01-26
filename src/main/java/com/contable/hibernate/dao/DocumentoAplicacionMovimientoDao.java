package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroDocAplicacionBean;
import com.contable.hibernate.model.DocumentoAplicacionMovimiento_V;

public interface DocumentoAplicacionMovimientoDao extends GenericDao<DocumentoAplicacionMovimiento_V, Integer> {

	/**
	 * Retorna un listado de aplicaciones filtrado.
	 * 
	 * @param FiltroDocAplicacionBean filtro
	 * @return
	 */
	public List<DocumentoAplicacionMovimiento_V> getAplicacionesByFilters(FiltroDocAplicacionBean filtro);
	
	public List<DocumentoAplicacionMovimiento_V> getAplicacionesByMuestraMonedaEn(FiltroDocAplicacionBean filtro);
}
