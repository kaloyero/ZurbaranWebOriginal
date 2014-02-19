package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.ConceptoDao;
import com.contable.hibernate.model.Concepto;
import com.contable.services.ConceptoService;

@Service("conceptoService")
public class ConceptoServiceImpl extends AbstractServiceImpl<Concepto> implements ConceptoService{

	@Autowired
    private ConceptoDao conceptoDao;

	protected GenericDao<Concepto, Integer> getDao() {
		return conceptoDao;
	}
	

}
