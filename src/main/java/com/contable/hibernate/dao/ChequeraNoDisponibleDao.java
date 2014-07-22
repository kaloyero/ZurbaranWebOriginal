package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.ChequeraNoDisponible;

public interface ChequeraNoDisponibleDao extends GenericDao<ChequeraNoDisponible, Integer> {

	public List<ChequeraNoDisponible> getChequeNoDisponible(int chequeraId, int numero);
	
}
