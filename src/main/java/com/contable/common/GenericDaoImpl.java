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
import org.hibernate.criterion.ProjectionList;
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
	  @Transactional
	  public PK save(E newInstance) {
		  return (PK) getSession().save(newInstance);
      }

	  @Transactional
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
      @Transactional(readOnly=true)
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
      @Transactional(readOnly=true)
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
      @Transactional(readOnly=true)
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

      @Transactional(readOnly=true)
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
      @Transactional()
      public List<E> findAllByProperty(String propertyName, Object value,boolean valueNull) {
    	   Criteria criteria = getSession().createCriteria(getEntityClass());
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
            
            return (List<E>) criteria.list();
      }
      
      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public E findEntityByProperty(String propertyName, Object value,boolean orderAsc) {
    	  Criteria criteria = getSession().createCriteria(getEntityClass());
            criteria.add(Restrictions.eq(propertyName, value));
      		if (orderAsc){
      			criteria.addOrder(Order.asc("id"));
      		} else {
      			criteria.addOrder(Order.desc("id"));
      		}
      	    //Seteo que solo traiga un resultado
      		criteria.setMaxResults(1);
      		
            return (E) criteria.uniqueResult();
      }

      @SuppressWarnings("unchecked")
	  @Transactional(readOnly = true)
      public E findEntityByPropertyList(List<Property> properties, boolean primero){
    	  
    	Criteria criteria = getSession().createCriteria(getEntityClass());

    	/* Agrega los filtros */
    	setCriteriaProperties(criteria, properties);

  	    //Seteo que solo traiga un resultado
  		criteria.setMaxResults(1);
  		//En el caso de que traiga mas de un resultado devuellve el primero o el ultimo registro
  		if (primero){
  			criteria.addOrder(Order.asc("id"));
  		} else {
  			criteria.addOrder(Order.desc("id"));
  		}

      	return (E) criteria.uniqueResult();
		
    	}
    	
      private ProjectionList getProjectionList(String fieldNombre,String fieldReferencia,String alias){
    	  
	  		//Si no se setea el campo referencia lo devuelve vacío
	  		if (StringUtils.isBlank(fieldReferencia)){
	  			fieldReferencia = "";
	  		}

			if (StringUtils.isNotBlank(fieldReferencia)){
				return Projections.projectionList()
	    				.add(Projections.property(alias+"id"),"id")
	    				.add(Projections.property(alias+fieldNombre),"nombre")
	    				.add(Projections.property(alias+fieldReferencia),"referencia");
				
			} else {
				return Projections.projectionList()
	    				.add(Projections.property("id"),"id")
	    				.add(Projections.property(alias+fieldNombre),"nombre");
			}
          
      }
      
      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public List<ConfigBean> findComboListByFilterConfig(String campoNombre,String campoReferencia, Property campoFiltroAdm, Property campoFiltroEstado
    		  											, String campoOrder,Boolean orderByAscId) {
    		Criteria criteria = getSession().createCriteria(getEntityClass());
    	
    		/* SELECT */
    		
    		/*  Seteo el SELECT. Traigo Projection List  */
    		criteria.setProjection( getProjectionList(campoNombre,campoReferencia,"") );
           	/* Explico que tipo de bean va devolver */
           	criteria.setResultTransformer(Transformers.aliasToBean(ConfigBean.class));

           	/* WHERE */
           	//Filtro estado
           	if (campoFiltroEstado != null){
           		criteria.add(Restrictions.like(campoFiltroEstado.getName(), campoFiltroEstado.getValue()));
           	}
           	
           	//Filtro Administracion
           	if (campoFiltroAdm  != null){
           		filtroParaAdministracionById(criteria, campoFiltroAdm.getName(), (Integer)campoFiltroAdm.getValue());
           	}
           	
        	/* Agrega el orden */
           	setOrderBy(criteria,campoOrder,orderByAscId);

            List<ConfigBean> list = criteria.list();

            return list;

      }

      @Transactional(readOnly = true)
      public List<ConfigBean> findComboListByFilters(String campoNombre,String campoReferencia, String campoInactivo, 
    		  											List<Property> filtros, String campoOrderBy ,boolean orderAsc) {
            return findComboListByFilters(campoNombre,campoReferencia, campoInactivo, filtros, campoOrderBy ,orderAsc, "");

      }
      
      @SuppressWarnings("unchecked")
      @Transactional(readOnly=true)
      public List<ConfigBean> findComboListByFilters(String campoNombre,String campoReferencia, String campoInactivo, List<Property> filtros, String campoOrderBy ,boolean orderAsc,String alias) {
    		Criteria criteria = getSession().createCriteria(getEntityClass());
    	
    		if (StringUtils.isNotBlank(alias)){
   				criteria.createAlias(alias, alias);
   				alias = alias+".";
    		} else {
    			alias = "";
    		}
    		
    		/*  Seteo el SELECT. Traigo Projection List  */
    		criteria.setProjection( getProjectionList(campoNombre,campoReferencia,alias) );
           	/* Explico que tipo de bean va devolver */
           	criteria.setResultTransformer(Transformers.aliasToBean(ConfigBean.class));
            
            /* WHERE */
            if (StringUtils.isNotBlank(campoInactivo)){
            	criteria.add(Restrictions.like(alias+"estado", campoInactivo));	
            }
        	/* Agrega los filtros */
            setCriteriaProperties(criteria, filtros);

        	/* ORDEN */
        	setOrderBy(criteria,campoOrderBy,orderAsc);
        	
        	
            List<ConfigBean> lista = (List<ConfigBean>)criteria.list();

            return lista;

      }

      @SuppressWarnings("unchecked")
      @Transactional(readOnly=true)
	public List<E> listFilterByProperties(String alias,List<Property> filtros,String campoOrderBy, boolean orderAsc){

  		Criteria criteria = getSession().createCriteria(getEntityClass());
  		
  		if (StringUtils.isNotBlank(alias)){
 				criteria.createAlias(alias, alias);
  		}
    	  
      	/* Agrega los filtros */
  		setCriteriaProperties(criteria, filtros);
    	  
    	/* ORDEN */
      	setOrderBy(criteria,campoOrderBy,orderAsc);
    	
    	/* Obtengo la lista */
    	List<E> lista = (List<E>)criteria.list();
    	
    	return lista;
    	  
      }
      
      @Transactional()
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

	protected Criteria setCriteriaProperties(Criteria criteria, List<Property> properties){
    	
		if (properties != null){
			Disjunction disjunction = Restrictions.disjunction();
	    	for (Property property : properties) {
	    		
	    		if ("administracion.id".equals(property.getName()) || "administracionId".equals(property.getName()) ){
	    			/* FILTRO para Id Administracion  */
	    			filtroParaAdministracionById(criteria, property.getName(), (Integer)property.getValue());
	    		} else {
	    			
					if (Property.OPERATOR_OR.equals(property.getOperator())){
						disjunction.add((Criterion) property.getRestriction());	
					} if (Property.OPERATOR_AND.equals(property.getOperator()) || property.getOperator() == null){
						criteria.add((Criterion) property.getRestriction());	
					}
	    		}
			}
	      	criteria.add(disjunction);
		}

      	return criteria;
	}


	
	protected Criteria setOrderBy(Criteria criteria, String camposOrderBy,boolean orderByAsc){
		
		if (StringUtils.isNotBlank(camposOrderBy)){
			String delimitadores= "[ ,;?!¡¿\'\"\\[\\]]+";
			String[] orderList = camposOrderBy.split(delimitadores);
			
			for (String orderBy : orderList) {
				if (orderByAsc){
					criteria.addOrder(Order.asc(orderBy));
				} else {
					criteria.addOrder(Order.desc(orderBy));
				}
			}
		} else {
			criteria.addOrder(Order.desc("id"));
		}
		return criteria;
	}

	/**
	 * Crea el filtro para  Id administracion
	 * Si el id es nulo => filtra por Id administracion = null (Todas)
	 * Si el id NO es nulo => Id administracion= id y(or) Id administracion = null (Todas).
	 * 
	 * @param idAdm
	 * @return
	 */
	protected void filtroParaAdministracionById (Criteria criteria,String campoFiltroAdm,Integer idAdm){
            //Valida que filterId no este vació, osea exista un campor por cual filtrar
            if (StringUtils.isNotBlank(campoFiltroAdm)){
	            if (idAdm == null){
	            	//Trae la configuracion para administracion TODAS (null)
	            	criteria.add(Restrictions.isNull(campoFiltroAdm));
	            } else {

	            	//trae la configuracion para la administracion X y para TODAS (null)
	            	Disjunction disjunction = Restrictions.disjunction();
	            	//filtro por idAdministracion
					disjunction.add(Restrictions.eq(campoFiltroAdm, idAdm));
					//filtro por idAdministracion = null (TODAS)
					disjunction.add(Restrictions.isNull(campoFiltroAdm));
					criteria.add(disjunction);
	            }
            }
		
	}

}