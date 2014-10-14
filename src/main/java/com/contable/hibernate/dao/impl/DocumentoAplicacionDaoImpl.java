package com.contable.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoAplicacionDao;
import com.contable.hibernate.model.DocumentoAplicacion;

@Repository("documentoAplicacionDao")
public class DocumentoAplicacionDaoImpl extends GenericDaoImpl<DocumentoAplicacion, Integer> implements DocumentoAplicacionDao{

	@Override
	protected Class<DocumentoAplicacion> getEntityClass() {
		return DocumentoAplicacion.class;
	}
	
    public double sumaTotalAplicaciones(int idDocomento) {
  	    double res = 0.0;
    	Criteria criteria = getSession().createCriteria(getEntityClass());

       criteria.setProjection(Projections.sum("importe"));
  	   criteria.add(Restrictions.eq("idDocumentoAplica", idDocomento));
  	   
       Double total= (Double) criteria.uniqueResult();
       
       if (total != null){
    	   res =total.doubleValue(); 
       }
       return res;
    }

}
