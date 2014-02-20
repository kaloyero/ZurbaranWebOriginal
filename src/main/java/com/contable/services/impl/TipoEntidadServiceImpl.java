package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.TipoEntidadDao;
import com.contable.hibernate.model.TipoEntidad;
import com.contable.services.TipoEntidadService;

@Service("tipoEntidadService")
public class TipoEntidadServiceImpl extends AbstractServiceImpl<TipoEntidad> implements TipoEntidadService{

	@Autowired
    private TipoEntidadDao tipoEntidadDao;

	protected GenericDao<TipoEntidad, Integer> getDao() {
		return tipoEntidadDao;
	}
	

}
