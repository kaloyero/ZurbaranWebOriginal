package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoValorPropioDao;
import com.contable.hibernate.model.DocumentoValorPropio;

@Repository("documentoValorPropioDao")
public class DocumentoValorPropioDaoImpl extends GenericDaoImpl<DocumentoValorPropio, Integer> implements DocumentoValorPropioDao{

	@Override
	protected Class<DocumentoValorPropio> getEntityClass() {
		return DocumentoValorPropio.class;
	}

}
