package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;
import com.contable.manager.ConceptoManager;
import com.contable.mappers.ConceptoMapper;
import com.contable.services.ConceptoService;

@Service("conceptoManager")
public class ConceptoManagerImpl extends ConfigurationManagerImpl<Concepto,ConceptoForm> implements ConceptoManager{

	@Autowired
	ConceptoService conceptoService;
	
	@Override
	protected AbstractService<Concepto> getRelatedService() {
		return conceptoService;
	}

	@Override
	protected Mapper<Concepto,ConceptoForm> getMapper() {
		return new ConceptoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(Concepto.fieldNombre());
		list.add(Concepto.fieldAdministracion());
		list.add(Concepto.fieldCodigo());
		list.add(Concepto.fieldCuenta());
		list.add(Concepto.fieldDescripcion());
		list.add(Concepto.fieldEntidad());
		list.add(Concepto.fieldMoneda());
		list.add(Concepto.fieldNombre());
		list.add(Concepto.fieldEstado());
		return list;
	}

}
