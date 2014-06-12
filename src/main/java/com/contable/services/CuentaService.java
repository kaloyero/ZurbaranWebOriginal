package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;

public interface CuentaService extends AbstractService<Cuenta>{

	void saveCuentaMoneda(List<CuentaMoneda> dto);
	
	void updateCuentaMoneda(List<Integer> idsMonedas, int idCuenta);

	List<CuentaMoneda> findCuentaMoneda(int idCuenta);

	List<ConfigBean> findCuentaMonedaConfig(int idCuenta);
	
	public List<CuentaBusquedaForm> buscarResumenPorFiltros(FiltroCuentaBean filtros);

//	public List<CuentaBusquedaForm> buscarSaldoCuenta(FiltroCuentaBean filtros, String campoOrden, boolean orderByAsc);
	
	public List<CuentaBusquedaForm> buscarSaldoPorFiltros(FiltroCuentaBean filtros, String fecha, String campoOrden, boolean orderByAsc);
	
	public List<CuentaBusquedaForm> buscarSaldoCuentaActualByFiltros(FiltroCuentaBean filtro, String fecha, String campoOrden, boolean orderByAsc);
}
