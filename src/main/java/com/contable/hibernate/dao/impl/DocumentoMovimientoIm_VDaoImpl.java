package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoMovimientoIm_VDao;
import com.contable.hibernate.model.DocumentoMovimientoIm_V;

@Repository("documentoMovimientoIm_VDao")
public class DocumentoMovimientoIm_VDaoImpl extends GenericDaoImpl<DocumentoMovimientoIm_V, Integer> implements DocumentoMovimientoIm_VDao{

	@Override
	protected Class<DocumentoMovimientoIm_V> getEntityClass() {
		return DocumentoMovimientoIm_V.class;
	}

}
