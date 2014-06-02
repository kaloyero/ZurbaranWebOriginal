package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ErrorRespuestaBean;
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

	@Transactional
	public ErrorRespuestaBean update(List<EstructuraContenidoCuenta> listado,int idContenido){
		
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		estructuraContenidoCuentaDao.update(listado, idContenido);
		return res;
		
	}
}
