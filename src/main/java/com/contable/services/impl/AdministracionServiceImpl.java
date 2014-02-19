package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.AdministracionDao;
import com.contable.hibernate.model.Administracion;
import com.contable.services.AdministracionService;

@Service("administracionService")
public class AdministracionServiceImpl extends AbstractServiceImpl<Administracion> implements AdministracionService{

	@Autowired
    private AdministracionDao administracionDao;

	protected GenericDao<Administracion, Integer> getDao() {
		return administracionDao;
	}
	

}
