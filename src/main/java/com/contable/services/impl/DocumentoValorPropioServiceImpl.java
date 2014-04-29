package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.dao.DocumentoMovimientoVp_VDao;
import com.contable.hibernate.dao.DocumentoValorPropioDao;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;
import com.contable.hibernate.model.DocumentoValorPropio;
import com.contable.services.DocumentoValorPropioService;

@Service("documentoValorPropioService")
public class DocumentoValorPropioServiceImpl extends AbstractServiceImpl<DocumentoValorPropio> implements DocumentoValorPropioService{

	@Autowired
    private DocumentoValorPropioDao documentoValorPropioDao;

	@Autowired
    private DocumentoMovimientoVp_VDao documentoMovimientoVp_VDao;

	
	protected GenericDao<DocumentoValorPropio, Integer> getDao() {
		return documentoValorPropioDao;
	}

	public List<DocumentoMovimientoVp_V> buscarPorFiltros(
			FiltroValPropiosBean filtros, String campoOrden, boolean orderByAsc) {
		List<DocumentoMovimientoVp_V> list = documentoMovimientoVp_VDao.buscarEnValoresPropiosByFiltros(filtros, campoOrden, orderByAsc);
		return list;

	}
	
}
