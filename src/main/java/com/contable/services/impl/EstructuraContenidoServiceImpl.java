package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.EstructuraContenidoDao;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.services.EstructuraContenidoService;

@Service("estructuraContenidoService")
public class EstructuraContenidoServiceImpl extends AbstractServiceImpl<EstructuraContenido> implements EstructuraContenidoService{

	@Autowired
    private EstructuraContenidoDao estructuraContenidoDao;

	protected GenericDao<EstructuraContenido, Integer> getDao() {
		return estructuraContenidoDao;
	}

}
