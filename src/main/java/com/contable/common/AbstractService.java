package com.contable.common;

import java.util.List;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;


public interface AbstractService<E> {

	void save(E dto);
	
	void update(E dto);
	
	void delete(E  dto);
	
	E findById(int id);

	List<E> listAll();

	/**
	 * Devuelve la lista paginando
	 * Tambien tiene un listado de filtros.
	 * 
	 * @param pagIni
	 * @param qtRows
	 * @param properties
	 * @param searchText
	 * @param orderByProperty
	 * @param asc
	 * @return
	 */
	public List<E> listPaginByFilter(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc);
	
	/**
	 * Sirve para las configuraciones
	 * Trae un listado de Id + Nombre
	 * Filtra por el campo Inactivo
	 * 
	 * @return
	 */
	List<ConfigBean> getConfigNameList();
	
	
	/**
	 * Sirve para las configuraciones. se le debe pasar el id administracion
	 * Trae un listado de Id + Nombre
	 * @param idadministracion
	 * @return
	 */
	public List<ConfigBean> getConfigNameListByAdm(int idAdministracion);

}
