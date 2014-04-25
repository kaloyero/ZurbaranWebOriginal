package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoAplicaciones_VDao;
import com.contable.hibernate.model.DocumentoAplicaciones_V;

@Repository("documentoAplicacionPendiente_VDao")
public class DocumentoAplicaciones_VDaoImpl extends GenericDaoImpl<DocumentoAplicaciones_V, Integer> implements DocumentoAplicaciones_VDao{

	@Override
	protected Class<DocumentoAplicaciones_V> getEntityClass() {
		return DocumentoAplicaciones_V.class;
	}

}
