package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.EntidadTipoDao;
import com.contable.hibernate.model.TipoEntidad;
import com.contable.services.EntidadTipoService;

@Service("entidadTipoService")
public class EntidadTipoServiceImpl extends AbstractServiceImpl<TipoEntidad> implements EntidadTipoService{

	@Autowired
    private EntidadTipoDao entidadTipoDao;

	protected GenericDao<TipoEntidad, Integer> getDao() {
		return entidadTipoDao;
	}
	

}
