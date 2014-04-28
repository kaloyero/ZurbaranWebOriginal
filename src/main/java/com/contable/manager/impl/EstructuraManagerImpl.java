package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Estructura;
import com.contable.manager.EstructuraManager;
import com.contable.mappers.EstructuraMapper;
import com.contable.services.EstructuraService;

@Service("estructuraManager")
public class EstructuraManagerImpl extends ConfigurationManagerImpl<Estructura,EstructuraForm> implements EstructuraManager{

	@Autowired
	EstructuraService estructuraService;
	
	@Override
	protected AbstractService<Estructura> getRelatedService() {
		return estructuraService;
	}

	@Override
	protected Mapper<Estructura,EstructuraForm> getMapper() {
		return new EstructuraMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

}
