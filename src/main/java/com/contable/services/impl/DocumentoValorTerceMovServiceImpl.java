package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.DocumentoValorTerceMovDao;
import com.contable.hibernate.model.DocumentoValorTerceMov;
import com.contable.services.DocumentoValorTerceMovService;

@Service("documentoValorTerceMovService")
public class DocumentoValorTerceMovServiceImpl extends AbstractServiceImpl<DocumentoValorTerceMov> implements DocumentoValorTerceMovService{

	@Autowired
    private DocumentoValorTerceMovDao documentoValorTerceMovDao;

	
	protected GenericDao<DocumentoValorTerceMov, Integer> getDao() {
		return documentoValorTerceMovDao;
	}
	

}
