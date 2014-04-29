package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;
import com.contable.hibernate.model.DocumentoValorPropio;

public interface DocumentoValorPropioService extends AbstractService<DocumentoValorPropio>{
	
	public List<DocumentoMovimientoVp_V> buscarPorFiltros(FiltroValPropiosBean filtros,String campoOrden,boolean orderByAsc);
	
}
