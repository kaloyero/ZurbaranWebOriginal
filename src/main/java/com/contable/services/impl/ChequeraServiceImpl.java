package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.ChequeraDao;
import com.contable.hibernate.dao.Chequera_VDao;
import com.contable.hibernate.model.Chequera;
import com.contable.hibernate.model.Chequera_V;
import com.contable.services.ChequeraService;

@Service("chequeraService")
public class ChequeraServiceImpl extends AbstractServiceImpl<Chequera> implements ChequeraService{

	@Autowired
    private ChequeraDao chequeraDao;

	@Autowired
    private Chequera_VDao chequera_VDao;

	protected GenericDao<Chequera, Integer> getDao() {
		return chequeraDao;
	}

	public List<Chequera_V> getListaView() {
		List<Chequera_V> list = new ArrayList<Chequera_V>();
		list = chequera_VDao.findAll(false);
		
		return list;
	}

	public Chequera_V findViewById(int id) {
		return chequera_VDao.findById(id);
	}
	

}
