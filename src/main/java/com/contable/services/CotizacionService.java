package com.contable.services;

import java.util.Date;
import java.util.List;

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


	/**
	 * Devuelve el Historico de la cotización de monedas
	 * Si no se le pasa la fecha ini o fecha fin trae todo
	 * 
	 * @param idMoneda
	 * @param fechaIni
	 * @param fechaFin
	 * @return
	 */
	public List<Cotizacion> obtenerHistorico(int idMoneda, String fechaIni, String fechaFin);
}
