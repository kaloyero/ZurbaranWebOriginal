package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoValorTerceDao;
import com.contable.hibernate.model.DocumentoValorTerce;

@Repository("documentoValorTerceDao")
public class DocumentoValorTerceDaoImpl extends GenericDaoImpl<DocumentoValorTerce, Integer> implements DocumentoValorTerceDao{

	@Override
	protected Class<DocumentoValorTerce> getEntityClass() {
		return DocumentoValorTerce.class;
	}

}
