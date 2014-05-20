package com.contable.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.hibernate.dao.DocumentoValorTerceDao;
import com.contable.hibernate.dao.DocumentoValorTerceDisp_VDao;
import com.contable.hibernate.dao.ValorTercero_VDao;
import com.contable.hibernate.model.DocumentoValorTerce;
import com.contable.hibernate.model.DocumentoValorTerceDisp_V;
import com.contable.hibernate.model.ValorTercero_v;
import com.contable.services.DocumentoValorTerceService;

@Service("documentoValorTerceService")
public class DocumentoValorTerceServiceImpl extends AbstractServiceImpl<DocumentoValorTerce> implements DocumentoValorTerceService{

	@Autowired
    private DocumentoValorTerceDao documentoValorTerceDao;

	@Autowired
    private DocumentoValorTerceDisp_VDao documentoValorTerceDisp_VDao;

	@Autowired
    private ValorTercero_VDao valorTercero_VDao;

	protected GenericDao<DocumentoValorTerce, Integer> getDao() {
		return documentoValorTerceDao;
	}
	
	@Transactional
	public List<DocumentoValorTerceDisp_V> getListaDocumentosDisponiblesTerceros() {
		List<DocumentoValorTerceDisp_V> list = new ArrayList<DocumentoValorTerceDisp_V>();
		list = documentoValorTerceDisp_VDao.findAll(false);
		
		return list;
	}

	public List<ValorTercero_v> buscarPorFiltros(FiltroValTercerosBean filtros, String campoOrden, boolean orderByAsc) {
		List<ValorTercero_v> list = valorTercero_VDao.buscarEnValoresTerceByFiltros(filtros, campoOrden, orderByAsc);
		return list;
	}

	public void anularValoresTerceroByListIds(Collection<Integer> valorTerceId) {
		
		documentoValorTerceDao.anularValoresTerceroByListIds(valorTerceId);
	}

	
}
