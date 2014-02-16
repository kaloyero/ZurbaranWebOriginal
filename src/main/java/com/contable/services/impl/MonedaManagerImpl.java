package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.MonedaDao;
import com.contable.hibernate.model.Moneda;
import com.contable.services.MonedaManager;

@Service("monedaManager")
public class MonedaManagerImpl extends AbstractManagerImpl<Moneda> implements MonedaManager{

	@Autowired
    private MonedaDao monedaDao;

	protected GenericDao<Moneda, Integer> getDao() {
		return monedaDao;
	}
	

}
