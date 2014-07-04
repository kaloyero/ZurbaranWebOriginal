package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.ChequeraNoDisponibleDao;
import com.contable.hibernate.model.ChequeraNoDisponible;
import com.contable.services.ChequeraNoDisponibleService;

@Service("chequeraNoDisponibleService")
public class ChequeraNoDisponibleServiceImpl extends AbstractServiceImpl<ChequeraNoDisponible> implements ChequeraNoDisponibleService{

	@Autowired
    private ChequeraNoDisponibleDao chequeraNoDisponibleDao;

	protected GenericDao<ChequeraNoDisponible, Integer> getDao() {
		return chequeraNoDisponibleDao;
	}

}
