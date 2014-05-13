package com.contable.services;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Moneda;

public interface MonedaService extends AbstractService<Moneda>{

	public void poneMonedaLocalEnFalsoParaTodas();

	public Moneda obtenerMonedaLocal();
}
