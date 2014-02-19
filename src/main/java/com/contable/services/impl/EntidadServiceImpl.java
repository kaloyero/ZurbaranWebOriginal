package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.EntidadDao;
import com.contable.hibernate.model.Entidad;
import com.contable.services.EntidadService;

@Service("entidadService")
public class EntidadServiceImpl extends AbstractServiceImpl<Entidad> implements EntidadService{

	@Autowired
    private EntidadDao entidadDao;

	protected GenericDao<Entidad, Integer> getDao() {
		return entidadDao;
	}
	

}
