package com.contable.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;


@Transactional
public interface GenericDao<E,PK  extends Serializable> {
	
    PK save(E newInstance);
    
    void update(E transientObject);
    
    void saveOrUpdate(E transientObject);
    
    void delete(E persistentObject);
    
    E findById(int id);
    
    List<E> findAll(Boolean orderByAscId);
    
    List<E> findAllByProperty(String propertyName,Object value);
    
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
    
    
    public E findEntityByProperty(String propertyName, Object value);
    
    List<E> listByPropertiesPagin(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc);
  	
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
     */
    public void updateFieldsByWhereClause(List<Property> setList, List<Property> whereClause);
}