package com.contable.common;

import java.util.List;

public interface AbstractManager<E,F> {

	/**
	 * Obtiene la lista completa
	 * 
	 * @return
	 */
	public List<F> getLista();


}
