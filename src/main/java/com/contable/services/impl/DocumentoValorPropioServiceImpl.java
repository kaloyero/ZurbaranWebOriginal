package com.contable.services.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.dao.DocumentoValorPropioDao;
import com.contable.hibernate.dao.ValorPropio_VDao;
import com.contable.hibernate.model.DocumentoValorPropio;
import com.contable.hibernate.model.ValorPropio_v;
import com.contable.services.DocumentoValorPropioService;

@Service("documentoValorPropioService")
public class DocumentoValorPropioServiceImpl extends AbstractServiceImpl<DocumentoValorPropio> implements DocumentoValorPropioService{

	@Autowired
    private DocumentoValorPropioDao documentoValorPropioDao;

	@Autowired
    private ValorPropio_VDao valorPropio_VDao;

	
	protected GenericDao<DocumentoValorPropio, Integer> getDao() {
		return documentoValorPropioDao;
	}

	public List<ValorPropio_v> buscarPorFiltros(
			FiltroValPropiosBean filtros, String campoOrden, boolean orderByAsc) {
			List<ValorPropio_v> list = valorPropio_VDao.buscarEnValoresPropiosByFiltros(filtros, campoOrden, orderByAsc);
		return list;

	}

	public void anularValoresPropioByListIds(Collection<Integer> valorPropioId) {
		documentoValorPropioDao.anularValoresPropiosByListIds(valorPropioId);
	}

	public Integer getUltimoNumeroChequeByChequera(int chequeraId) {
		Integer res = 0;
		DocumentoValorPropio numero = documentoValorPropioDao.findEntityByProperty("chequera.id", chequeraId, false);
		if (numero !=null && numero.getNumero() != 0 ){
			res =numero.getNumero(); 
		}
		
		return res;
	}

}
