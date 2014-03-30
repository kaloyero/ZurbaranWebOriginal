package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoValorTerceMovDao;
import com.contable.hibernate.model.DocumentoValorTerceMov;

@Repository("documentoValorTerceMovDao")
public class DocumentoValorTerceMovDaoImpl extends GenericDaoImpl<DocumentoValorTerceMov, Integer> implements DocumentoValorTerceMovDao{

	@Override
	protected Class<DocumentoValorTerceMov> getEntityClass() {
		return DocumentoValorTerceMov.class;
	}

}
