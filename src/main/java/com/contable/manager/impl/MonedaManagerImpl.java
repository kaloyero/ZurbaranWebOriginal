package com.contable.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Moneda;
import com.contable.manager.MonedaManager;
import com.contable.mappers.MonedaMapper;
import com.contable.services.MonedaService;

@Service("monedaManager")
public class MonedaManagerImpl extends ConfigurationManagerImpl<Moneda,MonedaForm> implements MonedaManager{

	@Autowired
	MonedaService monedaService;
	
	@Override
	protected AbstractService<Moneda> getRelatedService() {
		return monedaService;
	}

	@Override
	protected Mapper<Moneda,MonedaForm> getMapper() {
		return new MonedaMapper();
	}
	
}
