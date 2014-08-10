package com.contable.common;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericBaseDaoImpl<E> implements GenericBaseDao<E> {

	@Autowired
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
    protected abstract Class<E> getEntityClass();
    
    protected DetachedCriteria createDetachedCriteria() {
          return DetachedCriteria.forClass(getEntityClass());
    }

    protected Session getSession(){
  	  return sessionFactory.getCurrentSession();
    }
 
    public SessionFactory getSessionFactory() {
 		return sessionFactory;
 	}

 	public void setSessionFactory(SessionFactory sessionFactory) {
 		this.sessionFactory = sessionFactory;
 	}

}