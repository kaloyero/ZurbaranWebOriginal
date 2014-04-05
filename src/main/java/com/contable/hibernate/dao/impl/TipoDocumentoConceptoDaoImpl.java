package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.TipoDocumentoConceptoDao;
import com.contable.hibernate.model.TipoDocumentoConcepto;

@Repository("documentoTipoConceptoDao")
public class TipoDocumentoConceptoDaoImpl extends GenericDaoImpl<TipoDocumentoConcepto, Integer> implements TipoDocumentoConceptoDao{

	@Override
	protected Class<TipoDocumentoConcepto> getEntityClass() {
		return TipoDocumentoConcepto.class;
	}
	
}
