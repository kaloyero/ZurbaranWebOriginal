package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.EntidadForm;
import com.contable.hibernate.model.Entidad;
import com.contable.manager.EntidadManager;
import com.contable.mappers.EntidadMapper;
import com.contable.services.EntidadService;

@Service("entidadManager")
public class EntidadManagerImpl extends ConfigurationManagerImpl<Entidad,EntidadForm> implements EntidadManager{

	@Autowired
	EntidadService entidadService;
	
	@Override
	public AbstractService<Entidad> getRelatedService() {
		return entidadService;
	}

	@Override
	public Mapper<Entidad,EntidadForm> getMapper() {
		return new EntidadMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(Entidad.fieldNombre());
		list.add(Entidad.fieldCodigoReferencia());
		list.add(Entidad.fieldTipoEntidad());
		list.add(Entidad.fieldEstado());
		return list;
	}

}
