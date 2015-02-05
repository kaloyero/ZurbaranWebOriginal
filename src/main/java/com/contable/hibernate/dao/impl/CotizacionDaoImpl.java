package com.contable.hibernate.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.CotizacionDao;
import com.contable.hibernate.model.Cotizacion;

@Repository("CotizacionDao")
public class CotizacionDaoImpl extends GenericDaoImpl<Cotizacion, Integer> implements CotizacionDao{

	@Override
	protected Class<Cotizacion> getEntityClass() {
		return Cotizacion.class;
	}

    public Cotizacion obtenerUltimaCotizacion(Date fecha, Integer monedaId){
  	  
    	Criteria criteria = getSession().createCriteria(getEntityClass());

	    //Seteo que solo traiga un resultado
		criteria.setMaxResults(1);
	  	
		criteria.add(Restrictions.eq("moneda.id", monedaId));
		if (fecha != null){ 
			criteria.add(Restrictions.eq("fecha", fecha));
		}
  	
		criteria.addOrder(Order.desc("fecha"));
		criteria.addOrder(Order.desc("id"));

    	return (Cotizacion) criteria.uniqueResult();
		
  	}

    public Cotizacion obtenerUltimaCotizacionOrderId(Date fecha, Integer monedaId){
    	  
    	Criteria criteria = getSession().createCriteria(getEntityClass());

	    //Seteo que solo traiga un resultado
		criteria.setMaxResults(1);
	  	
		criteria.add(Restrictions.eq("moneda.id", monedaId));
		if (fecha != null){ 
			criteria.add(Restrictions.eq("fecha", fecha));
		}
  	
		criteria.addOrder(Order.asc("id"));

    	return (Cotizacion) criteria.uniqueResult();
		
  	}
    
    
    @SuppressWarnings("unchecked")
	public List<Cotizacion> obtenerHistoricoByFecha(int idMoneda,Date fechaDesde,Date fechaHasta){
    	  
    	Criteria criteria = getSession().createCriteria(getEntityClass());
	  	
		criteria.add(Restrictions.eq("moneda.id", idMoneda));
		if (fechaDesde != null){ 
			criteria.add(Restrictions.ge("fecha", fechaDesde));
		}
		if (fechaHasta != null){ 
			criteria.add(Restrictions.le("fecha", fechaHasta));
		}
		criteria.addOrder(Order.desc("fecha"));
		criteria.addOrder(Order.desc("cotizacion"));

    	return (List<Cotizacion>) criteria.list();
		
  	}

    public Cotizacion obtenerCotizacionPorFechaProxima(Date fecha, Integer monedaId){
    	
    	Criteria criteria = getSession().createCriteria(getEntityClass());
	  	
		criteria.add(Restrictions.eq("moneda.id", monedaId));
		if (fecha != null){ 
			criteria.add(Restrictions.le("fecha", fecha));
		}
		criteria.addOrder(Order.desc("fecha"));
		criteria.addOrder(Order.desc("cotizacion"));
		
		criteria.setMaxResults(1);

		return (Cotizacion) criteria.uniqueResult();
		
  	}
    
}