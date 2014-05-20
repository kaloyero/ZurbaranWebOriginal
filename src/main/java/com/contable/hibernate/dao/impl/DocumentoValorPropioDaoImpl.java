package com.contable.hibernate.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.DocumentoValorPropioDao;
import com.contable.hibernate.model.DocumentoValorPropio;

@Repository("documentoValorPropioDao")
public class DocumentoValorPropioDaoImpl extends GenericDaoImpl<DocumentoValorPropio, Integer> implements DocumentoValorPropioDao{

	@Override
	protected Class<DocumentoValorPropio> getEntityClass() {
		return DocumentoValorPropio.class;
	}


	public void anularValoresPropiosByListIds(Collection<Integer> valorPropId) {
		
		if (valorPropId != null && valorPropId.isEmpty() == false){
			StringBuilder queryStr = new StringBuilder();
		    
			queryStr.append("update `documentovalorespro` set `Estado`='"+ Constants.DOCUMENTO_ESTADO_ANULADO +"'");
			queryStr.append(" WHERE `id` in (:idList) ");
			Query query = getSession().createSQLQuery(queryStr.toString());
			query.setParameterList("idList", valorPropId);
	
			query.executeUpdate();
		}
	}
	

}
