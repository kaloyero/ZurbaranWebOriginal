package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoMovimientoIv_VDao;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;

@Repository("documentoMovimientoIv_VDao")
public class DocumentoMovimientoIv_VDaoImpl extends GenericDaoImpl<DocumentoMovimientoIv_V, Integer> implements DocumentoMovimientoIv_VDao{

	@Override
	protected Class<DocumentoMovimientoIv_V> getEntityClass() {
		return DocumentoMovimientoIv_V.class;
	}

}
