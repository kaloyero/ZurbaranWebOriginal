package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.TipoEntidadForm;
import com.contable.hibernate.model.TipoEntidad;
import com.contable.manager.TipoEntidadManager;
import com.contable.mappers.TipoEntidadMapper;
import com.contable.services.TipoEntidadService;

@Service("tipoEntidadManager")
public class TipoEntidadManagerImpl extends ConfigurationManagerImpl<TipoEntidad,TipoEntidadForm> implements TipoEntidadManager{

	@Autowired
	TipoEntidadService tipoEntidadService;
	
	@Override
	public AbstractService<TipoEntidad> getRelatedService() {
		return tipoEntidadService;
	}

	@Override
	public Mapper<TipoEntidad,TipoEntidadForm> getMapper() {
		return new TipoEntidadMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(TipoEntidad.fieldNombre());
		list.add(TipoEntidad.fieldDescripcion());
		list.add(TipoEntidad.fieldAdministracion());
		return list;
	}
	
}
