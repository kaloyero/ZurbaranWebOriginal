package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.CuentaMoneda;

public interface CuentaMonedaDao extends GenericDao<CuentaMoneda, Integer> {

	public void save(List<CuentaMoneda> dtoList);

	List<CuentaMoneda> getMonedasByIdCuenta(int idCuenta);
}
