package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;

public interface CuentaService extends AbstractService<Cuenta>{

	void saveCuentaMoneda(List<CuentaMoneda> dto);
	
	void updateCuentaMoneda(List<Integer> idsMonedas, int idCuenta);

	List<CuentaMoneda> findCuentaMoneda(int idCuenta);

	List<ConfigBean> findCuentaMonedaConfig(int idCuenta);
}
