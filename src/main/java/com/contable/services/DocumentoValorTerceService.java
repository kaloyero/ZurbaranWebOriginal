package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;
import com.contable.hibernate.model.DocumentoValorTerce;
import com.contable.hibernate.model.DocumentoValorTerceDisp_V;

public interface DocumentoValorTerceService extends AbstractService<DocumentoValorTerce>{
	
	
	/**
	 * Devuelve la lista de Documentos Disponibles de Terceros
	 * 
	 * @return
	 */
	public List<DocumentoValorTerceDisp_V> getListaDocumentosDisponiblesTerceros();

	public List<DocumentoMovimientoIv_V> buscarPorFiltros(FiltroValTercerosBean filtros,String campoOrden,boolean orderByAsc);
}
