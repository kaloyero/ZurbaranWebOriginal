package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoMovimientoVp_VDao;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;

@Repository("documentoMovimientoVp_VDao")
public class DocumentoMovimientoVp_VDaoImpl extends GenericDaoImpl<DocumentoMovimientoVp_V, Integer> implements DocumentoMovimientoVp_VDao{

	@Override
	protected Class<DocumentoMovimientoVp_V> getEntityClass() {
		return DocumentoMovimientoVp_V.class;
	}

}
