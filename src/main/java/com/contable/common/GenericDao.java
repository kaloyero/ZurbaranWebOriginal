package com.contable.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.Property;


@Transactional
public interface GenericDao<E,PK  extends Serializable> {
    PK save(E newInstance);
    
    void update(E transientObject);
    
    void saveOrUpdate(E transientObject);
    
    void delete(E persistentObject);
    
    E findById(PK id);
    
    List<E> findAll(Boolean orderByAscId);
    
    List<E> findAllByProperty(String propertyName,Object value);
    
    public E findEntityByProperty(String propertyName, Object value);
    
    List<E> listByPropertiesPagin(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc);
  	
    List<E> findByPagin(int pagIni,int qtRows, String orderByProperty, boolean asc);
    
//    <T> List<T> findByNamedParam(Class<T> entityClass, 
//  			String query,Map<String, ?> params) throws DataAccessException;
//  	
//    <T> List<T> findByNamedParam(Class<T> entityClass, 
//  			String query,String[] paramNames, Object[] values) throws DataAccessException;
}