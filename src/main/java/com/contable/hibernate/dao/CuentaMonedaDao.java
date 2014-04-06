package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.hibernate.model.CuentaMoneda;

public interface CuentaMonedaDao extends GenericDao<CuentaMoneda, Integer> {

	void save(List<CuentaMoneda> dtoList);
	
	void update(List<Integer> idsMonedas,int idCuenta);

	List<CuentaMoneda> getMonedasByIdCuenta(int idCuenta);
	
	List<ConfigBean> getMonedasConfigByIdCuenta(int idCuenta);
}
