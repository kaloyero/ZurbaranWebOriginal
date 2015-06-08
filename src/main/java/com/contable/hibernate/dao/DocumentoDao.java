package com.contable.hibernate.dao;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Documento;

public interface DocumentoDao extends GenericDao<Documento, Integer> {

	public void actualizarEstadoDocumento(int idDocumento, String estado);
	
	public void setDocumentoAnuladoPor(int idDocumento, int idDocumentoAnulador);
	public String getUltimaFechaDocumento(int id);
	
}
