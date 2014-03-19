package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.MonedaDao;
import com.contable.hibernate.model.Moneda;
import com.contable.services.MonedaService;

@Service("monedaService")
public class MonedaServiceImpl extends AbstractServiceImpl<Moneda> implements MonedaService{

	@Autowired
    private MonedaDao monedaDao;

	protected GenericDao<Moneda, Integer> getDao() {
		return monedaDao;
	}
	
}
