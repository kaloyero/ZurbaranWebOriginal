package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.model.DocumentoValorPropio;

public interface DocumentoValorPropioDao extends GenericDao<DocumentoValorPropio, Integer> {

	public List<DocumentoValorPropio> buscarEnValoresPropiosByFiltros(FiltroValPropiosBean filtro, String campoOrder, boolean orderByAsc);

}
