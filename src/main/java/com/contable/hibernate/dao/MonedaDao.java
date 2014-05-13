package com.contable.hibernate.dao;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Moneda;

public interface MonedaDao extends GenericDao<Moneda, Integer> {

	public void poneMonedaLocalEnFalsoParaTodas();
	
	public Moneda obtenerMonedaLocal();
}
