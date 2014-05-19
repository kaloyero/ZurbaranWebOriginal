package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.excel.WriteValorPropioExcel;
import com.contable.form.DocumentoValPropioForm;
import com.contable.form.ValorPropioForm;
import com.contable.hibernate.model.DocumentoValorPropio;
import com.contable.manager.DocumentoPropioManager;
import com.contable.mappers.DocumentoValorPropioMapper;
import com.contable.services.DocumentoValorPropioService;

@Service("documentoPropioManager")
public class DocumentoPropioManagerImpl extends AbstractManagerImpl<DocumentoValorPropio,DocumentoValPropioForm> implements DocumentoPropioManager{

	@Autowired
	DocumentoValorPropioService documentoValorPropioService;
	
	@Override
	protected AbstractService<DocumentoValorPropio> getRelatedService() {
		return documentoValorPropioService;
	}

	@Override
	protected Mapper<DocumentoValorPropio,DocumentoValPropioForm> getMapper() {
		return new DocumentoValorPropioMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 

		return list;
	}

	@Transactional
	public List<ValorPropioForm> buscarPorFiltros(FiltroValPropiosBean filtros,String campoOrden,boolean orderByAsc) {
		DocumentoValorPropioMapper mapper = new DocumentoValorPropioMapper();

		List<ValorPropioForm> list = mapper.getFormBuscaList(documentoValorPropioService.buscarPorFiltros(filtros,campoOrden,orderByAsc));
		
		return list;
	}

	public void exportExcel(FiltroValPropiosBean filtros) {
		String nombre = "Listado_Valores_Propios";
		List<ValorPropioForm> exportList = buscarPorFiltros(filtros, "", false);			
		
		WriteValorPropioExcel xls = new WriteValorPropioExcel();
		xls.setOutputFile(nombre);
		xls.write(exportList);

	}

}
