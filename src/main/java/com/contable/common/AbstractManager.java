package com.contable.common;

import java.util.List;

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
	 * @param filtertext
	 * @param filterBy
	 * @param OrderAsc
	 * @return
	 */
	List<F> getListaDataTable(int pagina,int cantRegistros, String filterText, String filterBy, boolean orderAsc);
	
}
