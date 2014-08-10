package com.contable.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;


@Transactional
public interface GenericDao<E,PK  extends Serializable> extends GenericBaseDao<E> {
	
	public static final String VALUE_TOTAL_RECORDS_DISPLAY = "totalDisplay";
	
	public static final String VALUE_TOTAL_RECORDS = "total";
	
	public static final String VALUE_LIST = "lista";
	
	public PK save(E newInstance);
    
	public void update(E transientObject);
    
	public void saveOrUpdate(E transientObject);
    
	public boolean delete(E persistentObject);
    
    public boolean delete(int idDocumento);
    
    public E findById(int id);
    
    public List<E> findAll(Boolean orderByAscId);
    
    /**
     * List all filtrando por un campo
     * 
     * @param propertyName
     * @param value
     * @param valueNull Filtra propertyName por NULL tambien 
     * @return
     */
    List<E> findAllByProperty(String propertyName,Object value,boolean valueNull);
    
    /**
   	 * Devuelve un listado de id + campo field. 
     *
     * @param campoNombre
     * @param campoReferencia
     * @param campoFiltroAdm
     * @param campoFiltroEstado
     * @param campoOrder
     * @param orderByAscId
     * @return
     */
    List<ConfigBean> findComboListByFilterConfig(String campoNombre,String campoReferencia, Property campoFiltroAdm, Property campoFiltroEstado
				, String campoOrder,Boolean orderByAscId);
    
    /**
     * 
     * @param preObjeto el objeto que va antes del Id y del nombre por ejemplo> 
     * @param campoNombre como se llama el campo nombre
     * @param campoInactivo
     * @param filtros
     * @param campoOrderBy
     * @param orderAsc
     * @return
     */
    List<ConfigBean> findComboListByFilters(String campoNombre,String campoReferencia, String campoInactivo, List<Property> filtros, String campoOrderBy ,boolean orderAsc,String alias);
    				 
    List<ConfigBean> findComboListByFilters(String campoNombre,String campoReferencia, String campoInactivo, List<Property> filtros, String campoOrderBy ,boolean orderAsc);
    
	E findEntityByProperty(String propertyName, Object value,boolean orderAsc);

    E findEntityByPropertyList(List<Property> properties, boolean primero);
    
    List<E> listByPropertiesPagin(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc);
    
    List<E> listFilterByProperties(String alias,List<Property> filtros,String campoOrderBy, boolean orderAsc);
        
    Map<String, Integer> listByPropertiesTotals(List<Property> properties, String searchText);
  	
    List<E> findByPagin(int pagIni,int qtRows, String orderByProperty, boolean asc);
    
//    <T> List<T> findByNamedParam(Class<T> entityClass, 
//  			String query,Map<String, ?> params) throws DataAccessException;
//  	
//    <T> List<T> findByNamedParam(Class<T> entityClass, 
//  			String query,String[] paramNames, Object[] values) throws DataAccessException;
    
    
    /**
     * Ejecuta un update sobre la lista de campos en setList. Y filtra por la lista whereClause
     * 
     * @param setList
     * @param whereClause
     * @return devuelve cuantas filas modifico
     */
    int updateFieldsByWhereClause(List<Property> setList, List<Property> whereClause);
    
	/**
	 * Valida si un "valor" existe en un campo requerido.
	 * 
	 * @param nombreCampo
	 * @param valorComparar
	 * @return True si existe. False si no existe
	 */
	boolean validarValorExistente(String nombreCampo, String valorComparar);
	
}