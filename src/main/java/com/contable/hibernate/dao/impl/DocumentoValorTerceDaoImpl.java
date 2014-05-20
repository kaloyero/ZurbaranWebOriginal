package com.contable.hibernate.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.DocumentoValorTerceDao;
import com.contable.hibernate.model.DocumentoValorTerce;

@Repository("documentoValorTerceDao")
public class DocumentoValorTerceDaoImpl extends GenericDaoImpl<DocumentoValorTerce, Integer> implements DocumentoValorTerceDao{

	@Override
	protected Class<DocumentoValorTerce> getEntityClass() {
		return DocumentoValorTerce.class;
	}

	public void anularValoresTerceroByListIds(Collection<Integer> valorTerceId){
		if (valorTerceId != null && valorTerceId.isEmpty() == false){
			StringBuilder queryStr = new StringBuilder();
		    
			queryStr.append("update `documentovalorester` set `Estado`='"+ Constants.DOCUMENTO_ESTADO_ANULADO +"'");
			queryStr.append(" WHERE `id` in (:idList) ");
			Query query = getSession().createSQLQuery(queryStr.toString());
			
			query.setParameterList("idList", valorTerceId);

			query.executeUpdate();
		}
		
	}

	
}
