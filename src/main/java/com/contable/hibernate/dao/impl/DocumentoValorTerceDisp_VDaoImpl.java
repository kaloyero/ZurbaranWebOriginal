package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoValorTerceDisp_VDao;
import com.contable.hibernate.model.DocumentoValorTerceDisp_V;

@Repository("documentoValorTerceDisp_VDao")
public class DocumentoValorTerceDisp_VDaoImpl extends GenericDaoImpl<DocumentoValorTerceDisp_V, Integer> implements DocumentoValorTerceDisp_VDao{

	@Override
	protected Class<DocumentoValorTerceDisp_V> getEntityClass() {
		return DocumentoValorTerceDisp_V.class;
	}

}
