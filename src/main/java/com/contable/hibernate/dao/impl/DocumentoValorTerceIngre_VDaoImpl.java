package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoValorTerceIngre_VDao;
import com.contable.hibernate.model.DocumentoValorTerceIngre_V;

@Repository("documentoValorTerceDao_v")
public class DocumentoValorTerceIngre_VDaoImpl extends GenericDaoImpl<DocumentoValorTerceIngre_V, Integer> implements DocumentoValorTerceIngre_VDao{

	@Override
	protected Class<DocumentoValorTerceIngre_V> getEntityClass() {
		return DocumentoValorTerceIngre_V.class;
	}

}
