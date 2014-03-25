package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.DocumentoForm;
import com.contable.hibernate.model.Documento;
import com.contable.manager.DocumentoManager;
import com.contable.mappers.DocumentoMapper;
import com.contable.services.DocumentoService;

@Service("documentoManager")
public class DocumentoManagerImpl extends ConfigurationManagerImpl<Documento,DocumentoForm> implements DocumentoManager{

	@Autowired
	DocumentoService documentoService;

	@Override
	protected AbstractService<Documento> getRelatedService() {
		return documentoService;
	}

	@Override
	protected Mapper<Documento,DocumentoForm> getMapper() {
		return new DocumentoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 

		return list;
	}

	@Override
	public List<DocumentoForm> getLista() {
		DocumentoMapper mapper = new DocumentoMapper();

		documentoService.getListaView();
		List<DocumentoForm> list = mapper.getFormViewList(documentoService.getListaView());

		return list;
	}

}
