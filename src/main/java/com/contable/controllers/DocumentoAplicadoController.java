package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.beans.FiltroDocAplicacionBean;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.DocumentoAplicacionMovimientoForm;
import com.contable.manager.DocumentoManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/documentoAplicado")
public class DocumentoAplicadoController {

	@Autowired
	private DocumentoManager documentoManager;

	private FiltroDocAplicacionBean filtrosDeBusqueda = new FiltroDocAplicacionBean(); 
	
	@RequestMapping(value = "/getBySearch", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearch(@RequestBody FiltroDocAplicacionBean busqueda){
		
		//Guardo los Filtros para exportar la lista.
		setFiltrosDeBusqueda(busqueda); 
		
		//Obtengo los documentos por filtros
		List<DocumentoAplicacionMovimientoForm> documentos =documentoManager.buscarDocumentosAplicadosPorFiltros(busqueda);

		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        
        	for (DocumentoAplicacionMovimientoForm formRow : documentos) {
        		List <String> row =new ArrayList<String>();
        		row.add(ConvertionUtil.StrValueOf(formRow.getDocAplicaAdministracionId()));
        		row.add(formRow.getFechaIngreso());
        		row.add(formRow.getTipoDocumentoNombre());
        		row.add("<a href='#' class='contView'>" + formRow.getNumeroFormateado() + "</a> " );
        		row.add(formRow.getDescripcion());
        		row.add(formRow.getMonedaCodigo());
        		row.add(formRow.getImporteTotal());
        		row.add(formRow.getCotizacion());
        		row.add(formRow.getMonedaMostrarCodigo());
        		row.add(formRow.getImporteMostrarTotal());
        		row.add(formRow.getDocAplicaTipoDocumentoNombre());
        		row.add("<a href='#' class='contView'>" + formRow.getDocAplicaNumeroFormateado() + "</a> " );
        		row.add(formRow.getDocAplicaDescripcion());
        		row.add(formRow.getMonedaCodigo());
        		row.add(formRow.getDocAplicaTotal());
        		row.add(formRow.getMonedaMostrarCodigo());
        		row.add(formRow.getDocAplicaMostrarTotal());
        		
        		
        		dataTable.getAaData().add(row);
        	}

        	
	    return dataTable;
	}

	public void setFiltrosDeBusqueda(FiltroDocAplicacionBean filtrosDeBusqueda) {
		this.filtrosDeBusqueda = filtrosDeBusqueda;
	}
	
}
