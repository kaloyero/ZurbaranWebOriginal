package com.contable.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.Mapper;
import com.contable.form.AdministracionForm;
import com.contable.hibernate.model.Administracion;
import com.contable.manager.AdministracionManager;
import com.contable.mappers.AdministracionMapper;
import com.contable.services.AdministracionService;

@Service("administracionManager")
public class AdministracionManagerImpl extends AbstractManagerImpl<Administracion,AdministracionForm> implements AdministracionManager{

	@Autowired
	AdministracionService administracionService;

	@Override
	public AbstractService<Administracion> getRelatedService() {
		return administracionService;
	}

	@Override
	public Mapper<Administracion, AdministracionForm> getMapper() {
		return new AdministracionMapper();
	}
	
}
