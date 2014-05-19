package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.excel.WriteValorTerceExcel;
import com.contable.form.DocumentoValTerceForm;
import com.contable.form.ValorTerceForm;
import com.contable.hibernate.model.DocumentoValorTerce;
import com.contable.manager.DocumentoTerceManager;
import com.contable.mappers.DocumentoValorTerceMapper;
import com.contable.services.DocumentoValorTerceService;

@Service("documentoTerceManager")
public class DocumentoTerceManagerImpl extends AbstractManagerImpl<DocumentoValorTerce,DocumentoValTerceForm> implements DocumentoTerceManager{

	@Autowired
	DocumentoValorTerceService documentoValorTerceService;
	
	@Override
	protected AbstractService<DocumentoValorTerce> getRelatedService() {
		return documentoValorTerceService;
	}

	@Override
	protected Mapper<DocumentoValorTerce,DocumentoValTerceForm> getMapper() {
		return new DocumentoValorTerceMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 

		return list;
	}

	/**
	 * Devuelve la lista de Documentos Disponibles de Terceros
	 * 
	 * @return
	 */
	public List<DocumentoValTerceForm> getListaDocumentosDisponiblesTerceros(){
		List<DocumentoValTerceForm> list = ((DocumentoValorTerceMapper) getMapper()).getFormListView(documentoValorTerceService.getListaDocumentosDisponiblesTerceros());
		
		return list;
	}

	@Transactional
	public List<ValorTerceForm> buscarPorFiltros(FiltroValTercerosBean filtros,String campoOrden,boolean orderByAsc) {
		DocumentoValorTerceMapper mapper = new DocumentoValorTerceMapper();

		List<ValorTerceForm> list = mapper.getFormBuscaList(documentoValorTerceService.buscarPorFiltros(filtros,campoOrden,orderByAsc));
		
		return list;
	}

	public void exportExcel(FiltroValTercerosBean filtros) {
		String nombre = "Listado_Valores_de_Terceros";
		List<ValorTerceForm> exportList = buscarPorFiltros(filtros, "", false);			
		
		WriteValorTerceExcel xls = new WriteValorTerceExcel();
		xls.setOutputFile(nombre);
		xls.write(exportList);

	}
	
}
