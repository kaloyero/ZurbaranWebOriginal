package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.model.ValorPropio_v;

public interface ValorPropio_VDao extends GenericDao<ValorPropio_v, Integer> {

	public List<ValorPropio_v> buscarEnValoresPropiosByFiltros(FiltroValPropiosBean filtro, String campoOrder, boolean orderByAsc);
	
}
