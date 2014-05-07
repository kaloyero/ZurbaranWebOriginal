package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.hibernate.model.CuentaSaldo_V;

public interface CuentaSaldo_VDao extends GenericDao<CuentaSaldo_V, Integer> {

	public List<CuentaSaldo_V> buscarSaldoCuentaByFiltros(	FiltroCuentaBean filtro, Integer anio, Integer mes, String campoOrder, boolean orderByAsc);
	
	public List buscarSaldoCuentaActualByFiltros(	FiltroCuentaBean filtro, Integer anio, Integer mes, String campoOrder, boolean orderByAsc);
}
