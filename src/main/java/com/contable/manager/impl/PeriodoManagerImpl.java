package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Periodo;
import com.contable.manager.PeriodoManager;
import com.contable.mappers.PeriodoMapper;
import com.contable.services.PeriodoService;

@Service("periodoManager")
public class PeriodoManagerImpl extends ConfigurationManagerImpl<Periodo,PeriodoForm> implements PeriodoManager{

	@Autowired
	PeriodoService periodoService;
	
	@Override
	protected AbstractService<Periodo> getRelatedService() {
		return periodoService;
	}

	@Override
	protected Mapper<Periodo,PeriodoForm> getMapper() {
		return new PeriodoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

}

