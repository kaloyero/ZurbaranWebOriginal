package com.contable.hibernate.dao;

import java.util.Date;
import java.util.List;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Cotizacion;

public interface CotizacionDao extends GenericDao<Cotizacion, Integer> {

	public Cotizacion obtenerUltimaCotizacion(Date fecha, Integer monedaId);
	
	public List<Cotizacion> obtenerHistoricoByFecha(int idMoneda,Date fechaDesde,Date fechaHasta);
}
