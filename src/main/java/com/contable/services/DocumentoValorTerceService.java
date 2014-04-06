package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.DocumentoValorTerce;
import com.contable.hibernate.model.DocumentoValorTerceDisp_V;

public interface DocumentoValorTerceService extends AbstractService<DocumentoValorTerce>{
	
	
	/**
	 * Devuelve la lista de Documentos Disponibles de Terceros
	 * 
	 * @return
	 */
	public List<DocumentoValorTerceDisp_V> getListaDocumentosDisponiblesTerceros();
	
}
