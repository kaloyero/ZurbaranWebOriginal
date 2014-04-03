package com.contable.manager;

import java.util.Date;

import com.contable.common.ConfigurationManager;
import com.contable.form.CotizacionForm;
import com.contable.hibernate.model.Cotizacion;

public interface CotizacionManager extends ConfigurationManager<Cotizacion,CotizacionForm>{
	
	/**
	 * Obtiene la cotizacion mas reciente a la fecha actual
	 * 
	 * @param monedaId
	 * @return
	 */
	public CotizacionForm getUltimaCotizacion(int monedaId);

	/**
	 * Obtiene la cotizacion en la fecha indicada
	 * 
	 * @param monedaId
	 * @param fecha
	 * @return
	 */
	public CotizacionForm getCotizacionByDate(int monedaId, Date fecha);

}
