package com.contable.common;

import java.util.List;

import com.contable.common.beans.ConfigBean;


public interface AbstractService<E> {

	void save(E dto);
	
	void update(E dto);
	
	void delete(E  dto);
	
//	E findById(PK id);
//	
	List<E> listAll();

	
	/**
	 * Sirve para las configuraciones
	 * Trae un listado de Id + Nombre
	 * Filtra por el campo Inactivo
	 * 
	 * @return
	 */
	List<ConfigBean> getConfigNameList();

}
