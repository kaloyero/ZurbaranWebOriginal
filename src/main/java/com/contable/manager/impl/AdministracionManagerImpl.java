package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.AdministracionForm;
import com.contable.hibernate.model.Administracion;
import com.contable.manager.AdministracionManager;
import com.contable.mappers.AdministracionMapper;
import com.contable.services.AdministracionService;

@Service("administracionManager")
public class AdministracionManagerImpl extends ConfigurationManagerImpl<Administracion,AdministracionForm> implements AdministracionManager{

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

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(Administracion.fieldNombre());
		return list;
	}

}
