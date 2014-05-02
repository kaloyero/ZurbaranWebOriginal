package com.contable.common;

import java.util.List;
import java.util.Map;

import com.contable.common.beans.ErrorRespuestaBean;

public interface AbstractManager<E,F> {

	/**
	 * Obtiene la lista completa
	 * 
	 * @return
	 */
	List<F> getLista();

	
	/**
	 * Obtiene la lista completa.
	 * Filtra por texto y Pagina 
	 * 
	 * @param pagina
	 * @param cantRegistros
	 * @param filterText
	 * @param filterBy
	 * @param orderAsc
	 * @return
	 */
	List<F> getListaDataTable(int pagina,int cantRegistros, String filterText, String orderBy, boolean orderAsc);
	
	/**
	 * Obtiene los totales de la lista
	 * 
	 * @param filterText
	 * @param filterBy
	 * @return
	 */
	Map<String,Integer> getListaDateTableTotales(String filterText);
	
	ErrorRespuestaBean guardarNuevo(F form);
	
	/**
	 * Actualiza la entidad
	 * 
	 * @param form
	 */
	public ErrorRespuestaBean update(F form);

	/**
	 * Obtiene el form por el id
	 * 
	 * @param id
	 * @return
	 */
	public F findById(Integer id);
	
}
