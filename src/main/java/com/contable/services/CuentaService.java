package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.hibernate.model.CuentaResumen_V;
import com.contable.hibernate.model.CuentaSaldo_V;

public interface CuentaService extends AbstractService<Cuenta>{

	void saveCuentaMoneda(List<CuentaMoneda> dto);
	
	void updateCuentaMoneda(List<Integer> idsMonedas, int idCuenta);

	List<CuentaMoneda> findCuentaMoneda(int idCuenta);

	List<ConfigBean> findCuentaMonedaConfig(int idCuenta);
	
	public List<CuentaResumen_V> buscarResumenPorFiltros(FiltroCuentaBean filtros, String campoOrden, boolean orderByAsc);

	public List<CuentaSaldo_V> buscarSaldoPorFiltros(FiltroCuentaBean filtros, String campoOrden, boolean orderByAsc);

}
