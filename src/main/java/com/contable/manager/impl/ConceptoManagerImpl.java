package com.contable.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.Mapper;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;
import com.contable.manager.ConceptoManager;
import com.contable.mappers.ConceptoMapper;
import com.contable.services.ConceptoService;

@Service("conceptoManager")
public class ConceptoManagerImpl extends AbstractManagerImpl<Concepto,ConceptoForm> implements ConceptoManager{

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
	
}
