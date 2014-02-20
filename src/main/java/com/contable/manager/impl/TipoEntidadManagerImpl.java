package com.contable.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.Mapper;
import com.contable.form.TipoEntidadForm;
import com.contable.hibernate.model.TipoEntidad;
import com.contable.manager.TipoEntidadManager;
import com.contable.mappers.TipoEntidadMapper;
import com.contable.services.TipoEntidadService;

@Service("tipoEntidadManager")
public class TipoEntidadManagerImpl extends AbstractManagerImpl<TipoEntidad,TipoEntidadForm> implements TipoEntidadManager{

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
	
}
