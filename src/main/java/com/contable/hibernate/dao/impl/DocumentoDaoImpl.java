package com.contable.hibernate.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoDao;
import com.contable.hibernate.model.Documento;

@Repository("documentoDao")
public class DocumentoDaoImpl extends GenericDaoImpl<Documento, Integer> implements DocumentoDao{

	@Override
	protected Class<Documento> getEntityClass() {
		return Documento.class;
	}

	@Transactional
	public void actualizarEstadoDocumento(int idDocumento, String estado) {
		StringBuilder queryStr = new StringBuilder();
		
		queryStr.append("update `documentos` set `Estado`='"+ estado +"'");
		queryStr.append(" WHERE `id` = '" + idDocumento + "' ");

		Query query = getSession().createSQLQuery(queryStr.toString());
		
		query.executeUpdate();
		
	}

	@Transactional
	public void setDocumentoAnuladoPor(int idDocumento, int idDocumentoAnulador) {
		StringBuilder queryStr = new StringBuilder();
		
		queryStr.append("update `documentos` set `IdDocumentoAnuladoPor`='"+ idDocumentoAnulador +"'");
		queryStr.append(" WHERE `id` = '" + idDocumento + "' ");

		Query query = getSession().createSQLQuery(queryStr.toString());
		
		query.executeUpdate();

		
	}

}
