package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.CotizacionForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.manager.CotizacionManager;
import com.contable.mappers.CotizacionMapper;
import com.contable.services.CotizacionService;

@Service("cotizacionManager")
public class CotizacionManagerImpl extends ConfigurationManagerImpl<Cotizacion,CotizacionForm> implements CotizacionManager{

	@Autowired
	CotizacionService cotizacionService;
	
	@Override
	protected AbstractService<Cotizacion> getRelatedService() {
		return cotizacionService;
	}

	@Override
	protected Mapper<Cotizacion,CotizacionForm> getMapper() {
		return new CotizacionMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(Cotizacion.fieldMoneda());
		list.add(Cotizacion.fieldFecha());
		return list;
	}

}
