package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoTipoConceptoDao;
import com.contable.hibernate.model.TipoDocumentoConcepto;

@Repository("documentoTipoConceptoDao")
public class DocumentoTipoConceptoDaoImpl extends GenericDaoImpl<TipoDocumentoConcepto, Integer> implements DocumentoTipoConceptoDao{

	@Override
	protected Class<TipoDocumentoConcepto> getEntityClass() {
		return TipoDocumentoConcepto.class;
	}

}
