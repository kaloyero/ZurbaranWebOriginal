package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.hibernate.model.DocumentoValorTerce;
import com.contable.hibernate.model.DocumentoValorTerceDisp_V;
import com.contable.hibernate.model.ValorTercero_v;

public interface DocumentoValorTerceService extends AbstractService<DocumentoValorTerce>{
	
	
	/**
	 * Devuelve la lista de Documentos Disponibles de Terceros
	 * 
	 * @return
	 */
	public List<DocumentoValorTerceDisp_V> getListaDocumentosDisponiblesTerceros();

	public List<ValorTercero_v> buscarPorFiltros(FiltroValTercerosBean filtros, String campoOrden, boolean orderByAsc);
	
}
