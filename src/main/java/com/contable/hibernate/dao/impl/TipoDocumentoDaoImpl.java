package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.TipoDocumentoDao;
import com.contable.hibernate.model.TipoDocumento;

@Repository("tipoDocumentoDao")
public class TipoDocumentoDaoImpl extends GenericDaoImpl<TipoDocumento, Integer> implements TipoDocumentoDao{

	@Override
	protected Class<TipoDocumento> getEntityClass() {
		return TipoDocumento.class;
	}

	
}
