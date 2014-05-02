package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.EstructuraContenidoCuentaDao;
import com.contable.hibernate.model.EstructuraContenidoCuenta;
import com.contable.services.EstructuraContenidoCuentaService;

@Service("estructuraContenidoCuentaService")
public class EstructuraContenidoCuentaServiceImpl extends AbstractServiceImpl<EstructuraContenidoCuenta> implements EstructuraContenidoCuentaService{

	@Autowired
    private EstructuraContenidoCuentaDao estructuraContenidoCuentaDao;

	protected GenericDao<EstructuraContenidoCuenta, Integer> getDao() {
		return estructuraContenidoCuentaDao;
	}

}
