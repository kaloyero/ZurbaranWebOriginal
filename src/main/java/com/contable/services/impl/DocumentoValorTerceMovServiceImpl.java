package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.DocumentoValorTerceMovDao;
import com.contable.hibernate.model.DocumentoValorTerceMov;
import com.contable.services.DocumentoValorTerceMovService;
import com.contable.services.DocumentoValorTerceService;

@Service("documentoValorTerceMovService")
public class DocumentoValorTerceMovServiceImpl extends AbstractServiceImpl<DocumentoValorTerceMov> implements DocumentoValorTerceMovService{

	@Autowired
    private DocumentoValorTerceMovDao documentoValorTerceMovDao;

	@Autowired
    private DocumentoValorTerceService documentoValorTerceService;
	
	protected GenericDao<DocumentoValorTerceMov, Integer> getDao() {
		return documentoValorTerceMovDao;
	}
	
	@Transactional
	@Override
	public Integer save(DocumentoValorTerceMov dto) {
		//Guardo el valor de tercero si es nuevo
		if (dto.getValorTerce().getId() == 0){
			documentoValorTerceService.save(dto.getValorTerce());
		}
		//Guardo el movimiento
		return (Integer) getDao().save(dto);
	}


}
