package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.CotizacionDao;
import com.contable.hibernate.model.Cotizacion;
import com.contable.services.CotizacionService;

@Service("cotizacionService")
public class CotizacionServiceImpl extends AbstractServiceImpl<Cotizacion> implements CotizacionService{

	@Autowired
    private CotizacionDao cotizacionDao;

	protected GenericDao<Cotizacion, Integer> getDao() {
		return cotizacionDao;
	}
	

}
