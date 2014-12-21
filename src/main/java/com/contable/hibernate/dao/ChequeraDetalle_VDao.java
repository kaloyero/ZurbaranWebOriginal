package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.ChequeraDetalle_V;

public interface ChequeraDetalle_VDao extends GenericDao<ChequeraDetalle_V, Integer> {

	
	public List<ChequeraDetalle_V> findChequeraDetalleList(Integer chequeraId);
}
