package com.contable.common;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;

//public abstract class GenericDaoImpl<E, PK extends Serializable> extends
//            HibernateDaoSupport implements GenericDao<E, PK> {
      
public abstract class GenericDaoImpl<E, PK extends Serializable> implements GenericDao<E, PK> {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
    protected abstract Class<E> getEntityClass();
    
    protected DetachedCriteria createDetachedCriteria() {
          return DetachedCriteria.forClass(getEntityClass());
    }

    protected DetachedCriteria createDetachedCriteria(Class c) {
        return DetachedCriteria.forClass(c);
    }
    
    protected Session getSession(){
  	  return sessionFactory.getCurrentSession();
    }
	
	
	  @SuppressWarnings("unchecked")
	  public PK save(E newInstance) {
		  return (PK) getSession().save(newInstance);
      }

      public void update(E transientObject) {
    	  //getSession().merge(transientObject);
    	  getSession().update(transientObject);
      }

      public void saveOrUpdate(E transientObject) {
    	  getSession().merge(transientObject);
    	  getSession().saveOrUpdate(transientObject);
//    	  getSession().flush();
      }

      public void delete(E persistentObject) {
    	  getSession().delete(persistentObject);
      }

      @SuppressWarnings("unchecked")
      public E findById(int id) {
            return (E) getSession().get(getEntityClass(), id);
      }
      
      @SuppressWarnings("unchecked")
      public List<E> findAll(Boolean orderByAscId) {
//          DetachedCriteria criteria = createDetachedCriteria();
//          return (List<E>) criteria.getExecutableCriteria(getSession()).list();
    	  Criteria criteria = getSession().createCriteria(getEntityClass());
    	  if (orderByAscId !=null) {
    		if (orderByAscId){
    			criteria.addOrder(Order.asc("id"));
    		} else {
    			criteria.addOrder(Order.desc("id"));
    		}
    		  
    	  }
    	  
    	  return (List<E>) criteria.list();
      }
      
      /**
       * @param pagIni
       * @param qtRows
       * @param orderByProperty
       * @param asc Si es true orderBy asc.
       * @return
       */
      @SuppressWarnings("unchecked")
      public List<E> findByPagin(int pagIni,int qtRows, String orderByProperty, boolean asc) {
    	  Criteria criteria = getSession().createCriteria(getEntityClass());
    	  criteria.setFirstResult(pagIni);
    	  criteria.setMaxResults(qtRows);
    	  if (StringUtils.isNotBlank(orderByProperty)){
    	  	if (asc){
    	  		criteria.addOrder(Order.asc(orderByProperty));		
    	  	} else {
    	  		criteria.addOrder(Order.desc(orderByProperty));
    	  	}
    	  }
    	  
          return (List<E>) criteria.list();
      }

    @SuppressWarnings("unchecked")
    public List<E> listByPropertiesPagin(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc) {
    	Criteria criteria = getSession().createCriteria(getEntityClass());
    	criteria.setFirstResult(pagIni);
    	criteria.setMaxResults(qtRows);
    	//Filtro sobre los campos
    	if (StringUtils.isNotBlank(searchText) && properties != null){
	    	for (Property property : properties) {
	    		if (Property.TYPE_CADENA.equals(property.getType()) ){
	    			criteria.add(Restrictions.like(property.getName(), "%"+searchText+"%"));	
	    		}
	     		if (Property.TYPE_ENTERO.equals(property.getType()) ){
	    			//TODO Hacer que busque por los campos de tipo entero	
	    		}
	     		if (Property.TYPE_FECHA.equals(property.getType()) ){
	     			//TODO Hacer que busque por los campos de tipoFecha	
	    		}
			}
    	}
    	//Defino el orden
    	if (StringUtils.isNotBlank(orderByProperty)){
			  	if (asc){
			  		criteria.addOrder(Order.asc(orderByProperty));		
			  	} else {
			  		criteria.addOrder(Order.desc(orderByProperty));
			  	}
		}
          return (List<E>) criteria.list();
    }    
      
      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public List<E> findAllByProperty(String propertyName, Object value) {
            DetachedCriteria criteria = createDetachedCriteria();
            criteria.add(Restrictions.eq(propertyName, value));
            return (List<E>) criteria.getExecutableCriteria(getSession()).list();
      }

      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public E findEntityByProperty(String propertyName, Object value) {
            DetachedCriteria criteria = createDetachedCriteria();
            criteria.add(Restrictions.eq(propertyName, value));
            return (E) criteria.getExecutableCriteria(getSession()).uniqueResult();
      }

    /**
   	 * Devuelve un listado de id + campo field. 
   	 * Filtra por campo propertyFilter
   	 * 
     * @param field
     * @param propertyFilter
     * @param value
     * @param orderByAscId
     * @return
     */
    @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public List<ConfigBean> findComboListByFilter(String field, String propertyFilter,Integer idAdministracion, Object value,Boolean orderByAscId) {
    		Criteria criteria = getSession().createCriteria(getEntityClass());
    	
    	
            //DetachedCriteria criteria = createDetachedCriteria();
            //Select
            criteria.setProjection(Projections.projectionList()
            	      				.add(Projections.property("id"),"id")
            	      				.add(Projections.property(field),field));
            //Where
            criteria.add(Restrictions.eq(propertyFilter, value));
            if (idAdministracion != null){
            	criteria.add(Restrictions.eq("administracion.id", idAdministracion));
            }
            //OrderBy
            if (orderByAscId !=null) {
          		if (orderByAscId){
          			criteria.addOrder(Order.asc("id"));
          		} else {
          			criteria.addOrder(Order.desc("id"));
          		}
          	  }
            criteria.setResultTransformer(Transformers.aliasToBean(ConfigBean.class));

            List<ConfigBean> list = criteria.list();

            return list;

      }


    public void updateFieldsByWhereClause(List<Property> setList, List<Property> whereClause) {
//       	String query = "UPDATE * from "
//
//    	if (setList != null){
//        	//Campos que voy actualizar	    	
//    		for (Property property : setList) {
//    			criteria.add(Restrictions.like(property.getName(), property.getValue()));	
//			}
//	    	//Where Clause
//        	if (whereClause != null){
//    	    	for (Property property : whereClause) {
//    	    		if (Property.TYPE_CADENA.equals(property.getType()) ){
//    	    			criteria.add(Restrictions.like(property.getName(), "%"+property.getValue()+"%"));	
//    	    		}
//    	     		if (Property.TYPE_ENTERO.equals(property.getType()) ){
//    	     			criteria.add(Restrictions.eq(property.getName(), Integer.valueOf(property.getValue())));
//    	    		}
//    	     		if (Property.TYPE_FECHA.equals(property.getType()) ){
//    	     			criteria.add(Restrictions.eq(property.getName(), property.getValue()));
//    	    		}
//    			}
//        	}
//    	}
//    	getSession().update
   	
    	
    }
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}