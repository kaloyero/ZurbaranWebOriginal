package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.hibernate.model.DocumentoValorTerceDisp_V;

public interface DocumentoValorTerceDisp_VDao extends GenericDao<DocumentoValorTerceDisp_V, Integer> {

	public List<DocumentoValorTerceDisp_V> buscarEnValoresTerceByFiltros(FiltroValTercerosBean filtro, String campoOrder, boolean orderByAsc);

}
