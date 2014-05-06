package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.hibernate.model.ValorTercero_v;

public interface ValorTercero_VDao extends GenericDao<ValorTercero_v, Integer> {

	public List<ValorTercero_v> buscarEnValoresTerceByFiltros(FiltroValTercerosBean filtro, String campoOrder, boolean orderByAsc);
	
	
}
