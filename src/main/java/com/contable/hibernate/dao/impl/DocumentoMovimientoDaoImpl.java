package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoMovimientoDao;
import com.contable.hibernate.model.DocumentoMovimiento;

@Repository("documentoMovimientoDao")
public class DocumentoMovimientoDaoImpl extends GenericDaoImpl<DocumentoMovimiento, Integer> implements DocumentoMovimientoDao{

	@Override
	protected Class<DocumentoMovimiento> getEntityClass() {
		return DocumentoMovimiento.class;
	}

}
