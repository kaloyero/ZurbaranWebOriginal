package com.contable.services.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.utils.DateUtil;
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

	@Transactional
	public List<Cotizacion> obtenerHistorico(int idMoneda, String fechaIni, String fechaFin) {
		Date fechaDesde = null;
		Date fechaHasta = null;
		if(StringUtils.isNotBlank(fechaIni)){
			fechaDesde = DateUtil.convertStringToDate(fechaIni);
		}
		if(StringUtils.isNotBlank(fechaFin)){
			fechaHasta = DateUtil.convertStringToDate(fechaFin);
		}
		return cotizacionDao.obtenerHistoricoByFecha(idMoneda, fechaDesde, fechaHasta);
	}

}
