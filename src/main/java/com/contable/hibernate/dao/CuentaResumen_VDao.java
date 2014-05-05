package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.hibernate.model.CuentaResumen_V;

public interface CuentaResumen_VDao extends GenericDao<CuentaResumen_V, Integer> {

	public List<CuentaResumen_V> buscarResumenByFiltros(FiltroCuentaBean filtro, String campoOrder, boolean orderByAsc);
	
}
