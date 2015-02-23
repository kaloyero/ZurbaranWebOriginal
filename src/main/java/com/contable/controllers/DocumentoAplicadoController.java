package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroDocAplicacionBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.DocumentoAplicacionMovimientoForm;
import com.contable.form.EstructuraForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.CotizacionManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.DocumentoManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.TipoEntidadManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/documentoAplicado")
public class DocumentoAplicadoController {

	@Autowired
	private DocumentoManager documentoManager;

	private FiltroDocAplicacionBean filtrosDeBusqueda = new FiltroDocAplicacionBean(); 
	
	@Autowired
	private CuentaManager cuentaManager;
	@Autowired
	private AdministracionManager adminManager;
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private MonedaManager monedaManager;
	@Autowired
	private CotizacionManager cotizacionManager;
	
	
	@RequestMapping(value = "/exporEx", method = RequestMethod.POST)
	public @ResponseBody String exporEx(@RequestBody FiltroDocAplicacionBean busqueda) throws ParseException{
		
		List<DocumentoAplicacionMovimientoForm> documentos =documentoManager.buscarDocumentosAplicadosPorFiltros(busqueda);
		
		documentoManager.exportDocumentoAplicadoExcel(documentos, busqueda);
		return "OK";
		
	}
	
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
        		row.add(ConvertionUtil.StrValueOf(formRow.getDocAplicaId()));
        		row.add(ConvertionUtil.StrValueOf(formRow.getDocumentoId()));        		
        		row.add(formRow.getFechaIngreso());
        		row.add(formRow.getTipoDocumentoNombre());
        		row.add("<a href='#' class='contViewAplica'>" + formRow.getNumeroFormateado() + "</a> " );
        		row.add(formRow.getDescripcion());
        		row.add(formRow.getDocAplicaCuentaNombre());
        		row.add(formRow.getDocAplicaEntidadNombre());
        		row.add(formRow.getDocAplicaMonedaCodigo());
        		row.add(formRow.getImporteTotal());
        		if (busqueda.getMonedaMuestraId() != null 
    	  				&& busqueda.getMonedaMuestraId() > 0){
	        		row.add(formRow.getMonedaMostrarCodigo());
	        		row.add(formRow.getImporteMostrarTotal());
        		} else {
	        		row.add("");
	        		row.add("");        			
        		}
        		row.add(formRow.getDocAplicaTipoDocumentoNombre());
        		row.add("<a href='#' class='contView'>" + formRow.getDocAplicaNumeroFormateado() + "</a> " );
        		row.add(formRow.getDocAplicaDescripcion());
        		row.add(formRow.getMovMonedaCodigo());
        		row.add(formRow.getMovImporte());
        		
        		dataTable.getAaData().add(row);
        	}

        	
	    return dataTable;
	}

	public void setFiltrosDeBusqueda(FiltroDocAplicacionBean filtrosDeBusqueda) {
		this.filtrosDeBusqueda = filtrosDeBusqueda;
	}
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);
		List<ConfigBean> listadoMonedasEn =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_BLANCO);
		
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("monedasEN", listadoMonedasEn);

		model.addAttribute("documentoAplicado", new EstructuraForm());
		
		
		
	   return "listado/documentoAplicadoMov";
	}
	
}
