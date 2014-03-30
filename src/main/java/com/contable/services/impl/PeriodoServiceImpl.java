package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.PeriodoDao;
import com.contable.hibernate.model.Periodo;
import com.contable.services.PeriodoService;

@Service("periodoService")
public class PeriodoServiceImpl extends AbstractServiceImpl<Periodo> implements PeriodoService{

	@Autowired
    private PeriodoDao periodoDao;

	protected GenericDao<Periodo, Integer> getDao() {
		return periodoDao;
	}
	

}
