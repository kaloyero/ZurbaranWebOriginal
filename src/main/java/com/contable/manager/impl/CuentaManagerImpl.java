package com.contable.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.Mapper;
import com.contable.form.CuentaForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.manager.CuentaManager;
import com.contable.mappers.CuentaMapper;
import com.contable.services.CuentaService;

@Service("cuentaManager")
public class CuentaManagerImpl extends AbstractManagerImpl<Cuenta,CuentaForm> implements CuentaManager{

	@Autowired
	CuentaService cuentaService;
	
	@Override
	protected AbstractService<Cuenta> getRelatedService() {
		return cuentaService;
	}

	@Override
	protected Mapper<Cuenta,CuentaForm> getMapper() {
		return new CuentaMapper();
	}
	
}
