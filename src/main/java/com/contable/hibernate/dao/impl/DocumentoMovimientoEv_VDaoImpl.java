package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoMovimientoEv_VDao;
import com.contable.hibernate.model.DocumentoMovimientoEv_V;

@Repository("documentoMovimientoEv_VDao")
public class DocumentoMovimientoEv_VDaoImpl extends GenericDaoImpl<DocumentoMovimientoEv_V, Integer> implements DocumentoMovimientoEv_VDao{

	@Override
	protected Class<DocumentoMovimientoEv_V> getEntityClass() {
		return DocumentoMovimientoEv_V.class;
	}

}
