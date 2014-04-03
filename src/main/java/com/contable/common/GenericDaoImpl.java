package com.contable.common;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
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
    
    //protected abstract String getTableName();
    
    protected DetachedCriteria createDetachedCriteria() {
          return DetachedCriteria.forClass(getEntityClass());
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
      public List<E>  listByPropertiesPagin(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc) {
    	  	List<E>  list  = new ArrayList<E>();
      	
    	  	Criteria criteria = getSession().createCriteria(getEntityClass());

			//Filtro sobre los campos
			if (StringUtils.isNotBlank(searchText) && properties != null){
				Disjunction disjunction = Restrictions.disjunction();
				for (Property property : properties) {
					if (Property.TYPE_CADENA.equals(property.getType()) ){
						disjunction.add(Restrictions.like(property.getName(), "%"+searchText+"%").ignoreCase());	
				}
				if (Property.TYPE_ENTERO.equals(property.getType()) ){
					//TODO Hacer que busque por los campos de tipo entero	
				}
				if (Property.TYPE_FECHA.equals(property.getType()) ){
					//TODO Hacer que busque por los campos de tipoFecha	
					}
				}
				criteria.add(disjunction);
			}
			//Cantidad de registros
			criteria.setFirstResult(pagIni);
			criteria.setMaxResults(qtRows);
			
			//Defino el orden
			if (StringUtils.isNotBlank(orderByProperty)){
				  	if (asc){
				  		criteria.addOrder(Order.asc(orderByProperty));		
				  	} else {
				  		criteria.addOrder(Order.desc(orderByProperty));
				  	}
			}
			  
			list = criteria.list();
			
			return list;

      }    

    public Map<String, Integer> listByPropertiesTotals(List<Property> properties, String searchText) {
    	Map<String, Integer> res  = new HashMap<String, Integer>();
    	
    	Criteria criteria = getSession().createCriteria(getEntityClass());
      	/*Obtiene el total de Registros en la tabla*/
      	Integer total = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
    	
    	//Filtro sobre los campos
    	if (StringUtils.isNotBlank(searchText) && properties != null){
    		Disjunction disjunction = Restrictions.disjunction();
	    	for (Property property : properties) {
	    		if (Property.TYPE_CADENA.equals(property.getType()) ){
	    			disjunction.add(Restrictions.like(property.getName(), "%"+searchText+"%").ignoreCase());	
	    		}
	     		if (Property.TYPE_ENTERO.equals(property.getType()) ){
	    			//TODO Hacer que busque por los campos de tipo entero	
	    		}
	     		if (Property.TYPE_FECHA.equals(property.getType()) ){
	     			//TODO Hacer que busque por los campos de tipoFecha	
	    		}
			}
	    	criteria.add(disjunction);
    	}

      	/*Obtiene el total de Registros filtrados*/
      	Integer totalDisplay = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
    	
    	res.put(VALUE_TOTAL_RECORDS_DISPLAY, totalDisplay);
    	res.put(VALUE_TOTAL_RECORDS, total);
    	
    	return res;
    }        
    
    
      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public List<E> findAllByProperty(String propertyName, Object value,boolean valueNull) {
            DetachedCriteria criteria = createDetachedCriteria();
            if (value == null) {
            	//Si el valor enviado es NULL
            	criteria.add(Restrictions.isNull(propertyName));
            } else {
            	//Si el valor no es nulo
            	criteria.add(Restrictions.eq(propertyName, value));
                if (valueNull) {
                	criteria.add(Restrictions.isNull(propertyName));
                }
            }
            
            return (List<E>) criteria.getExecutableCriteria(getSession()).list();
      }
      
      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public E findEntityByProperty(String propertyName, Object value,boolean orderAsc) {
            DetachedCriteria criteria = createDetachedCriteria();
            criteria.add(Restrictions.eq(propertyName, value));
      		if (orderAsc){
      			criteria.addOrder(Order.asc("id"));
      		} else {
      			criteria.addOrder(Order.desc("id"));
      		}
            return (E) criteria.getExecutableCriteria(getSession()).uniqueResult();
      }

      @SuppressWarnings("unchecked")
	  @Transactional(readOnly = true)
      public E findEntityByPropertyList(List<Property> properties,boolean orderAsc){
    	  
    	Criteria criteria = getSession().createCriteria(getEntityClass());

    	Disjunction disjunction = Restrictions.disjunction();
    	for (Property property : properties) {
			if (Property.OPERATOR_OR.equals(property.getOperator())){
				disjunction.add((Criterion) property.getRestriction());	
			} if (Property.OPERATOR_AND.equals(property.getOperator()) || property.getOperator() == null){
				criteria.add((Criterion) property.getRestriction());	
			}
		}
      	criteria.add(disjunction);

  		if (orderAsc){
  			criteria.addOrder(Order.asc("id"));
  		} else {
  			criteria.addOrder(Order.desc("id"));
  		}
    	
      	return (E) criteria.uniqueResult();
		
    	}
    	
	  @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public List<ConfigBean> findComboListByFilter(String field, String propertyFilter, String filterId,Integer id, Object value,Boolean orderByAscId) {
    		Criteria criteria = getSession().createCriteria(getEntityClass());
    	
            //DetachedCriteria criteria = createDetachedCriteria();
            //Select
            criteria.setProjection(Projections.projectionList()
            	      				.add(Projections.property("id"),"id")
            	      				.add(Projections.property(field),field));
            //Where
            criteria.add(Restrictions.eq(propertyFilter, value));

            //Valida que filterId no este vació, osea exista un campor por cual filtrar
            if (StringUtils.isNotBlank(filterId)){
	            if (id != null){
	            	criteria.add(Restrictions.eq(filterId, id));
	            } else {
	            	criteria.add(Restrictions.isNull(filterId));
	            }
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


    public int updateFieldsByWhereClause(List<Property> setList, List<Property> whereClause) {
    	int affectedRows = 0;
    	
   	  if (setList != null && !setList.isEmpty()){
    		String qs = "UPDATE "+ getEntityClass().getSimpleName() + " ";
    		//Campos a modificar
    		for (Property property : setList) {
				qs += " SET " + property.getName() + " = '" + property.getValue() + "' ";
			}
    		//WHERE clause
    		if (whereClause != null && !whereClause.isEmpty()){
    			qs += " WHERE ";
	    		for (Property property : whereClause) {
	    			qs += " "+ property.getName() + " = '" + property.getValue() + "' AND ";
	    		}
	    		qs = qs.substring(0, qs.length()-4); 
    		}
    		//Ejecutar query
    		affectedRows = getSession().createQuery(qs).executeUpdate();
		}
    		
   	  	return affectedRows;
    		   	
    	
    }
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}