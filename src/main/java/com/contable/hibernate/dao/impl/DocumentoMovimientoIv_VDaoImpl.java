package com.contable.hibernate.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoMovimientoIv_VDao;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;

@Repository("documentoMovimientoIv_VDao")
public class DocumentoMovimientoIv_VDaoImpl extends GenericDaoImpl<DocumentoMovimientoIv_V, Integer> implements DocumentoMovimientoIv_VDao{

	@Override
	protected Class<DocumentoMovimientoIv_V> getEntityClass() {
		return DocumentoMovimientoIv_V.class;
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoMovimientoIv_V> findMovimientosIngreValorByValorTerceIdList(Collection<Integer> valorTerceId){
		
		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		//Filtro por los ids de Valores de Terceros
		criteria.add(Restrictions.in("valorTerceId", valorTerceId));
       
		List<DocumentoMovimientoIv_V> list =  (List<DocumentoMovimientoIv_V>) criteria.list();
		
		return list;
	}
	
}
