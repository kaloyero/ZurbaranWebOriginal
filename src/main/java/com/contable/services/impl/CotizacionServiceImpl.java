package com.contable.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.Property;
import com.contable.hibernate.dao.CotizacionDao;
import com.contable.hibernate.model.Cotizacion;
import com.contable.services.CotizacionService;

@Service("cotizacionService")
public class CotizacionServiceImpl extends AbstractServiceImpl<Cotizacion> implements CotizacionService{

	@Autowired
    private CotizacionDao cotizacionDao;

	protected GenericDao<Cotizacion, Integer> getDao() {
		return cotizacionDao;
	}

	@Transactional
	public Cotizacion getUltimaCotizacion(int monedaId) {
		Cotizacion dto = getCotizacionByDate(monedaId,null);
		return dto;
	}

	@Transactional
	public Cotizacion getCotizacionByDate(int monedaId, Date fecha) {
		Cotizacion dto = new Cotizacion();
		List<Property> properties = new ArrayList<Property>();
		
		properties.add(new Property(Restrictions.eq("moneda.id", monedaId), Property.OPERATOR_AND));
		if (fecha != null){ 
			properties.add(new Property(Restrictions.eq("fecha", fecha), Property.OPERATOR_AND));
		}
		
		dto = cotizacionDao.findEntityByPropertyList(properties,false);

		return dto;
	}

}
