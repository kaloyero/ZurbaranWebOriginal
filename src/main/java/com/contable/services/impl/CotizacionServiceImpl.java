package com.contable.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.utils.DateUtil;
import com.contable.hibernate.dao.CotizacionDao;
import com.contable.hibernate.model.Cotizacion;
import com.contable.manager.MonedaManager;
import com.contable.services.CotizacionService;

@Service("cotizacionService")
public class CotizacionServiceImpl extends AbstractServiceImpl<Cotizacion> implements CotizacionService{

	@Autowired
    private CotizacionDao cotizacionDao;

	@Autowired
    private MonedaManager monedaManager;

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

	@Transactional
	public Double obtenerCotizacionPorFechaProxima(int idMoneda, String fechaStr) {
		Double value = 1.0;
		Date fecha = DateUtil.convertStringToDate(fechaStr);
		Cotizacion cotires = cotizacionDao.obtenerCotizacionPorFechaProxima(fecha,idMoneda);
		if (cotires != null){
			value = cotires.getCotizacion();
		}
		return  value;
	}

	
	@Transactional
	public Map<Integer,List<Cotizacion>> obtenerListadoCotizacionAnuales(int idMoneda) {
		Map<Integer,List<Cotizacion>> listado = new HashMap<Integer, List<Cotizacion>>();
		int anioInicial = 2014;
		int anioFinal = DateUtil.getYear(new Date());
		
		for (int anio = anioInicial; anio <= anioFinal; ++anio) {
			String fechaDesde = "01-01-"+anio;
			String fechaHasta = "31-12-"+anio;
			
			List<Cotizacion> cotizaciones = obtenerHistorico(idMoneda, fechaDesde, fechaHasta);
			if (cotizaciones != null && ( ! cotizaciones.isEmpty() )){
				listado.put(anio, cotizaciones) ;
			}
			
		}
		
		return listado;
	}


	
}