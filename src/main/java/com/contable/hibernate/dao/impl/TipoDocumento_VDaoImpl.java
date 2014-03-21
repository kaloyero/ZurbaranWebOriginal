package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.TipoDocumento_VDao;
import com.contable.hibernate.model.TipoDocumento_v;

@Repository("tipoDocumento_VDao")
public class TipoDocumento_VDaoImpl extends GenericDaoImpl<TipoDocumento_v, Integer> implements TipoDocumento_VDao{

	@Override
	protected Class<TipoDocumento_v> getEntityClass() {
		return TipoDocumento_v.class;
	}

}
