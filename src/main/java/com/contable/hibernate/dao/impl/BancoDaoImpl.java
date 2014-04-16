package com.contable.hibernate.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.Property;
import com.contable.hibernate.dao.BancoDao;
import com.contable.hibernate.model.Banco;

@Repository("bancoDao")
public class BancoDaoImpl extends GenericDaoImpl<Banco, Integer> implements BancoDao{

	@Override
	protected Class<Banco> getEntityClass() {
		return Banco.class;
	}

}
