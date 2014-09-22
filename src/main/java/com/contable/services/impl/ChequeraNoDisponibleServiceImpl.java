package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

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

	public List<ChequeraNoDisponible> getListaChequesNoDisponiblesByChequera(
			int idChequera) {
		List<ChequeraNoDisponible> list = new ArrayList<ChequeraNoDisponible>();	
		
		list = chequeraNoDisponibleDao.findAllByProperty("chequera.id", idChequera, false);
		
		return list;
	}

	public List<ChequeraNoDisponible> getListaChequeNoDisponible(int chequeraId, int numero) {
		
		List<ChequeraNoDisponible> list = chequeraNoDisponibleDao.getChequeNoDisponible(chequeraId, numero);
		return list;
	}

	public Integer getUltimoNumeroChequeByChequera(int chequeraId) {
		Integer res = 0;
		ChequeraNoDisponible numero = chequeraNoDisponibleDao.findEntityByProperty("chequera.id", chequeraId, false);
		if (numero!=null && numero.getNumero() != 0){
			res =numero.getNumero(); 
		}
		
		return res;
	}

}
