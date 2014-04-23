package com.contable.hibernate.dao;

import java.util.Collection;
import java.util.List;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;

public interface DocumentoMovimientoIv_VDao extends GenericDao<DocumentoMovimientoIv_V, Integer> {

	public List<DocumentoMovimientoIv_V> findMovimientosIngreValorByValorTerceIdList(Collection<Integer> valorTerceId);
	
}
