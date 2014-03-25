package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.Documento_VDao;
import com.contable.hibernate.model.Documento_v;

@Repository("documento_VDao")
public class Documento_VDaoImpl extends GenericDaoImpl<Documento_v, Integer> implements Documento_VDao{

	@Override
	protected Class<Documento_v> getEntityClass() {
		return Documento_v.class;
	}

}
