package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.hibernate.model.Documento_v;

public interface Documento_VDao extends GenericDao<Documento_v, Integer> {

	public List<Documento_v> buscarEnDocumentosByFiltros(FiltroDocumentoBean filtro, String campoOrder, boolean orderByAsc);
}
