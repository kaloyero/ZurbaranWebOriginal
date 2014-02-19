package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.CotizacionDao;
import com.contable.hibernate.model.Cotizacion;

@Repository("CotizacionDao")
public class CotizacionDaoImpl extends GenericDaoImpl<Cotizacion, Integer> implements CotizacionDao{

	@Override
	protected Class<Cotizacion> getEntityClass() {
		return Cotizacion.class;
	}

}
