package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.CuentaForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cuenta;

public interface CuentaManager extends ConfigurationManager<Cuenta,CuentaForm>{

	List<MonedaForm> getMonedasByCuenta(Integer cuentaId, boolean cotizacion);
	
	public List<ConfigBean> getMonedasConfigByCuenta(Integer cuentaId);
	public List<ConfigBean> getMonedasConfigByCuenta(Integer cuentaId,String extraRow);
	
	public List<CuentaBusquedaForm> buscarResumenCuenta(FiltroCuentaBean filtros);
	
	public double buscarSaldosCuentaParaResumen(FiltroCuentaBean filtros,String fecha, String campoOrden,boolean orderByAsc);
	
	public List<CuentaBusquedaForm> buscarSaldosCuenta(FiltroCuentaBean filtros,String fecha,boolean mostrarSaldosEnZero, String campoOrden,boolean orderByAsc);
	
	public void exportSaldoExcel(FiltroCuentaBean filtros);
	
	public void exportResumenExcel(FiltroCuentaBean filtros);
}
