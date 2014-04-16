package com.contable.manager;

import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.form.DocumentoValTerceForm;
import com.contable.hibernate.model.DocumentoValorTerce;

public interface DocumentoTerceManager extends AbstractManager<DocumentoValorTerce,DocumentoValTerceForm>{

	/**
	 * Devuelve la lista de Documentos Disponibles de Terceros
	 * 
	 * @return
	 */
	List<DocumentoValTerceForm> getListaDocumentosDisponiblesTerceros();
	
	public List<DocumentoValTerceForm> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc);
	
}
