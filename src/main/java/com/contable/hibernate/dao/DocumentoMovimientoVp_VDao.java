package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;

public interface DocumentoMovimientoVp_VDao extends GenericDao<DocumentoMovimientoVp_V, Integer> {

	public List<DocumentoMovimientoVp_V> buscarEnValoresPropiosByFiltros(FiltroValPropiosBean filtro, String campoOrder, boolean orderByAsc);
}
