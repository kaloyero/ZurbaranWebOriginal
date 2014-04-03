package com.contable.services;

import java.util.Date;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Cotizacion;

public interface CotizacionService extends AbstractService<Cotizacion>{

	/**
	 * Obtiene la cotizacion mas reciente a la fecha actual
	 * 
	 * @param monedaId
	 * @return
	 */
	public Cotizacion getUltimaCotizacion(int monedaId);

	/**
	 * Obtiene la cotizacion en la fecha indicada
	 * 
	 * @param monedaId
	 * @param fecha
	 * @return
	 */
	public Cotizacion getCotizacionByDate(int monedaId, Date fecha);


}
