package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.BancoDao;
import com.contable.hibernate.model.Banco;
import com.contable.services.BancoService;

@Service("bancoService")
public class BancoServiceImpl extends AbstractServiceImpl<Banco> implements BancoService{

	@Autowired
    private BancoDao bancoDao;

	protected GenericDao<Banco, Integer> getDao() {
		return bancoDao;
	}
	

}
