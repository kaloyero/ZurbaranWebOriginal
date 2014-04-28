package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.model.DocumentoValorPropio;

public interface DocumentoValorPropioService extends AbstractService<DocumentoValorPropio>{
	
	public List<DocumentoValorPropio> buscarPorFiltros(FiltroValPropiosBean filtros,String campoOrden,boolean orderByAsc);
	
}
