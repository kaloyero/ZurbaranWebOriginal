package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.manager.TipoDocumentoManager;
import com.contable.mappers.TipoDocumentoMapper;
import com.contable.services.TipoDocumentoService;

@Service("tipoDocumentoManager")
public class TipoDocumentoManagerImpl extends ConfigurationManagerImpl<TipoDocumento,TipoDocumentoForm> implements TipoDocumentoManager{

	@Autowired
	TipoDocumentoService tipoDocumentoService;
	
	@Override
	protected AbstractService<TipoDocumento> getRelatedService() {
		return tipoDocumentoService;
	}

	@Override
	protected Mapper<TipoDocumento,TipoDocumentoForm> getMapper() {
		return new TipoDocumentoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(TipoDocumento.fieldNombre());
		list.add(TipoDocumento.fieldEstado());
		return list;
	}

	@Override
	public List<TipoDocumentoForm> getLista() {
		TipoDocumentoMapper mapper = new TipoDocumentoMapper();
		
		tipoDocumentoService.getListaView();
		List<TipoDocumentoForm> list = mapper.getFormViewList(tipoDocumentoService.getListaView());
		
		return list;
	}


}
