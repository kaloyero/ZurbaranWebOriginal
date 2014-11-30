package com.contable.common;

import java.util.List;
import java.util.Map;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Property;


public interface AbstractService<E> {

	Integer save(E dto);
	
	void update(E dto);
	
	public ErrorRespuestaBean delete(E  dto);
	
	public ErrorRespuestaBean delete(int idDocumento);
	
	E findById(int id);
	
	public E findById(int id,boolean orderAsc);

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
	 * @param alias
	 * @return
	 */
	List<E> listPaginByFilter(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc);
	
	/**
	 * Devuelve los TOTALES de la lista paginando
	 * 
	 * @param properties
	 * @param searchText
	 * @return
	 */
	Map<String,Integer> listPaginTotalesByFilter(List<Property> properties, String searchText);
	
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
	public List<ConfigBean> getConfigNameListByAdm(Integer idAdministracion);


	/**
	 * Este metodo cambia el campo estado ('Inactivo' en la BD)
	 * 
	 * @param estado
	 * @param id
	 * @return devuelve cuantas lineas se afectaron
	 */
	public int changeValueToStatus(String estado, int id);
	
	/**
	 * Este metodo actualiza el estado En Activo si esta Inactivo o Inactivo si esta Activo
	 * 
	 * @param id
	 */
	void changeToogleStatus(int id);

	
	/**
	 * Valida que el atributo "Codigo" este repetido
	 * 
	 * @param codigo
	 * @return true si esta repetido. False si no esta repetido
	 */
	boolean validarCodigoNoRepetido(String codigo);

	/**
	 * Valida que el atributo "Codigo" este repetido
	 * 
	 * @param codigo
//	 	 * @param id En caso de que se quiera omitir el ID. Sirve para modificar cuando ya existe el codigo. 
	 * @return true si esta repetido. False si no esta repetido
	 */
	public boolean validarCodigoNoRepetido(String codigo, int id);
}
