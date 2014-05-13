package com.contable.hibernate.dao;

import java.util.Date;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Cotizacion;

public interface CotizacionDao extends GenericDao<Cotizacion, Integer> {

	public Cotizacion obtenerUltimaCotizacion(Date fecha, Integer monedaId);
}
