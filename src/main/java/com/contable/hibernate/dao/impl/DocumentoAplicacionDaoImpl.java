package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoAplicacionDao;
import com.contable.hibernate.model.DocumentoAplicacion;

@Repository("documentoAplicacionDao")
public class DocumentoAplicacionDaoImpl extends GenericDaoImpl<DocumentoAplicacion, Integer> implements DocumentoAplicacionDao{

	@Override
	protected Class<DocumentoAplicacion> getEntityClass() {
		return DocumentoAplicacion.class;
	}

}
