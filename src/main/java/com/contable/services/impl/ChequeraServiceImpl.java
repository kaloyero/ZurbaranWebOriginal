package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.ChequeraDao;
import com.contable.hibernate.model.Chequera;
import com.contable.services.ChequeraService;

@Service("chequeraService")
public class ChequeraServiceImpl extends AbstractServiceImpl<Chequera> implements ChequeraService{

	@Autowired
    private ChequeraDao chequeraDao;

	protected GenericDao<Chequera, Integer> getDao() {
		return chequeraDao;
	}
	

}
