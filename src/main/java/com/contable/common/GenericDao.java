package com.contable.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;


@Transactional
public interface GenericDao<E,PK  extends Serializable> {
	
	public static final String VALUE_TOTAL_RECORDS_DISPLAY = "totalDisplay";
	
	public static final String VALUE_TOTAL_RECORDS = "total";
	
	public static final String VALUE_LIST = "lista";
	
    PK save(E newInstance);
    
    void update(E transientObject);
    
    void saveOrUpdate(E transientObject);
    
    void delete(E persistentObject);
    
    E findById(int id);
    
    List<E> findAll(Boolean orderByAscId);
    
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
   	 * Filtra por campo propertyFilter
   	 * 
     * @param field
     * @param propertyFilter
     * @param filterId
     * @param id
     * @param value
     * @param orderByAscId
     * @return
     */
    List<ConfigBean> findComboListByFilter(String field, String propertyFilter, String filterId,Integer id, Object value,Boolean orderByAscId);
    
	E findEntityByProperty(String propertyName, Object value,boolean orderAsc);

    E findEntityByPropertyList(List<Property> properties,boolean orderAsc);
    
    List<E> listByPropertiesPagin(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc);
        
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
}