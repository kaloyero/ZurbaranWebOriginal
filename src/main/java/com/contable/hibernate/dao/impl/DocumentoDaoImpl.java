package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoDao;
import com.contable.hibernate.model.Documento;

@Repository("documentoDao")
public class DocumentoDaoImpl extends GenericDaoImpl<Documento, Integer> implements DocumentoDao{

	@Override
	protected Class<Documento> getEntityClass() {
		return Documento.class;
	}

}
