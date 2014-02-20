package com.contable.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.form.BancoForm;
import com.contable.hibernate.model.Banco;
import com.contable.manager.BancoManager;
import com.contable.mappers.BancoMapper;
import com.contable.services.BancoService;

@Service("bancoManager")
public class BancoManagerImpl extends ConfigurationManagerImpl<Banco,BancoForm> implements BancoManager{

	@Autowired
	BancoService bancoService;
	
	@Override
	protected AbstractService<Banco> getRelatedService() {
		return bancoService;
	}

	@Override
	protected Mapper<Banco,BancoForm> getMapper() {
		return new BancoMapper();
	}
	
}
