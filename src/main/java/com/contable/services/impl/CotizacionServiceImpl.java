package com.contable.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public Cotizacion getUltimaCotizacion(int monedaId) {
		Cotizacion dto = getCotizacionByDate(monedaId,null);
		return dto;
	}

	@Transactional
	public Cotizacion getCotizacionByDate(int monedaId, Date fecha) {
		Cotizacion dto = new Cotizacion();
		if (monedaId > 0){
			dto = cotizacionDao.obtenerUltimaCotizacion(fecha, monedaId);
		}
		return dto;
	}

}
