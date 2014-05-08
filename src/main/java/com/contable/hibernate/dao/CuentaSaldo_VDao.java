package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.model.CuentaSaldo_V;

public interface CuentaSaldo_VDao extends GenericDao<CuentaSaldo_V, Integer> {

	List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltros(	FiltroCuentaBean filtro, Integer anio, Integer mes, String campoOrder, boolean orderByAsc);
	
	public List<CuentaBusquedaForm> buscarSaldoCuentaActualByFiltros(	FiltroCuentaBean filtro, String campoOrder, boolean orderByAsc);
}
