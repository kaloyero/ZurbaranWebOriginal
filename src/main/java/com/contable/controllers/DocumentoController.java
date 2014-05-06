package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.AbstractControllerImpl;
import com.contable.common.AbstractManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.DocumentoAplicacionesSearch;
import com.contable.common.beans.DocumentoHeaderBean;
import com.contable.common.beans.DocumentoMovimientoBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.common.beans.NumeroBean;
import com.contable.common.utils.DataTable;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoGenericForm;
import com.contable.form.DocumentoGenericMapper;
import com.contable.form.DocumentoValTerceForm;
import com.contable.form.NumeracionForm;
import com.contable.form.NumeracionSearch;
import com.contable.hibernate.model.Documento;
import com.contable.manager.AdministracionManager;
import com.contable.manager.BancoManager;
import com.contable.manager.ConceptoManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.DocumentoManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.NumeracionManager;
import com.contable.manager.TipoDocumentoManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/documento")
public class DocumentoController extends AbstractControllerImpl<Documento,DocumentoForm>{

	@Autowired
	private DocumentoManager documentoManager;
	@Autowired
	private TipoDocumentoManager tipoDocumentoManager;
	@Autowired
	private AdministracionManager administracionManager;
	@Autowired
	private MonedaManager monedaManager;
	@Autowired
	private ConceptoManager conceptoManager;
	@Autowired
	private BancoManager bancoManager;
	@Autowired
	private CuentaManager cuentaManager;
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private NumeracionManager numeracionManager;
	
	private DocumentoGenericMapper mapperDocumento=new DocumentoGenericMapper();

	
	@Override
	protected AbstractManager<Documento, DocumentoForm> getRelatedManager() {
		return documentoManager;
	}

	@Override
	protected List<String> getRowDataList(DocumentoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(String.valueOf(formRow.getId()));
		row.add(formRow.getAdministracionNombre());
		row.add(formRow.getTipoDocumentoNombre());
		row.add(formRow.getNumeroFormateado());
		row.add(formRow.getFechaIngreso());
		row.add(formRow.getFechaVencimiento());
		row.add(formRow.getMonedaNombre());
		row.add(String.valueOf(formRow.getImporteTotal()));
		row.add("</a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}
	@RequestMapping(value = "/listadoShow", method = RequestMethod.GET)
	public String showInitListado(Locale locale, Model model,		HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		List<ConfigBean> listadocuentas =cuentaManager.getConfigNameList();

		model.addAttribute("cuentas", listadocuentas);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("administraciones", listadoAdministraciones);


		model.addAttribute("Documento", new DocumentoForm());
		return "configuraciones/documentoListado";
		
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,		HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		List<ConfigBean> listadoTipoDocumentos = tipoDocumentoManager.getConfigNameList();
		List<ConfigBean> listadoConceptos = conceptoManager.getConfigNameList();
		List<ConfigBean> listadoBancos = bancoManager.getConfigNameList();


		model.addAttribute("Documento", new DocumentoForm());
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("tipoDocumentos", listadoTipoDocumentos);
		model.addAttribute("conceptos", listadoConceptos);
		model.addAttribute("bancos", listadoBancos);

		
		return "documento";
	}

	@RequestMapping(value = "/getDocumentoHeader/{id}", method = RequestMethod.GET)
	public @ResponseBody DocumentoHeaderBean getByIdAdmin(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{

		DocumentoHeaderBean documentoForm =tipoDocumentoManager.getDocumentHeaderByTipodocumento(id);
		
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        
        if(documentoForm.getDocsValTerce() != null){
        	for (DocumentoValTerceForm row : documentoForm.getDocsValTerce()) {
        		List <String> rowData =new ArrayList<String>();
        		rowData.add("<input class='contEgresoCheck' type='checkbox' >");
        		rowData.add(String.valueOf(row.getId()));
        		rowData.add(String.valueOf(row.getNumero()));
        		rowData.add(row.getBancoNombre());
        		rowData.add(row.getEmisor());
				rowData.add(String.valueOf(row.getImporte()));
				dataTable.getAaData().add(rowData);
        	}
        	dataTable.setTotals(documentoForm.getDocsValTerce().size(),10,2);
        	documentoForm.setDocsValTerceDatatable(dataTable);
        }
		return documentoForm;
	}

	@RequestMapping(value = "/getDocumentoTabInfo/{id}", method = RequestMethod.GET)
	public @ResponseBody DocumentoMovimientoBean impGetConceptoInfo(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		
		DocumentoMovimientoBean bean =conceptoManager.getDocumentMovByConcept(id);

		return bean;
	}
	@RequestMapping(value = "/getLastDocNumeracion", method = RequestMethod.POST)
	public @ResponseBody NumeroBean getLastDocNumeration(@RequestBody NumeracionForm numeracion) {
		
		//ALEX TENES QUE AGREGARLE LA LETRA Y EL ESTABLECIMIENTO, si no los tenes podes mandar NULL o ""
		//NumeroBean numero =numeracionManager.getLastDocNumeration(numeracion.getAdministracionId(), numeracion.getTipoDocumentoId(), numeracion.getFechaReal());
		//return numero;
		return null;
	}
	@RequestMapping(value = "/validarNumero", method = RequestMethod.POST)
	public @ResponseBody ErrorRespuestaBean isValidNumero(@RequestBody NumeracionSearch numeracion) {
		//ALEX aca tenes que agregarle el tipo de Entidad
		//ErrorRespuestaBean error= numeracionManager.validarNumeroNoRepetido(numeracion.getAdministracionId(), numeracion.getTipoDocumentoId(), numeracion.getEntidadId(), numeracion.getNumero(), numeracion.getNumeroLetra(), numeracion.getNumeroEstablecimiento());
		
		//return error;
		return null;
	}
	
	
	
	@RequestMapping(value = "/testSave", method = RequestMethod.POST)
    public @ResponseBody String saveUser(@RequestBody DocumentoGenericForm[] listado) {
    	DocumentoForm header = new DocumentoForm();
		documentoManager.guardarNuevo(mapperDocumento.getDocumentoForm(listado));
		return "a";
    } 
	@RequestMapping(value = "/getAplicaciones", method = RequestMethod.POST)
    public @ResponseBody List<ConfigBean> getAplicaciones(@RequestBody DocumentoAplicacionesSearch searchAplicacion) {
		                                                                    
		List<ConfigBean> beanList = documentoManager.getDocAplicacionesLista(searchAplicacion.getTipoDocumentoId(),searchAplicacion.getCuentaId(), searchAplicacion.getEntidadId(),searchAplicacion.getMonedaId());
		return beanList;
	}
	@RequestMapping(value = "/getAplicacionById/{id}", method = RequestMethod.GET)
	public @ResponseBody DocumentoAplicacionForm getAplicacionById(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		                                                                    
		DocumentoAplicacionForm aplicacion = documentoManager.getDocAplicacioneByIdDoc(id);
		return aplicacion;
	}
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		DocumentoForm documento =documentoManager.findDocumentoById(id);

		model.addAttribute("Documento", documento);
	    return "configuraciones/editDocumento";
	}
	@RequestMapping(value = "/getBySearch", method = RequestMethod.POST)
	public @ResponseBody String getBySearch(@RequestBody FiltroDocumentoBean busqueda){
		List<DocumentoForm> documentos =documentoManager.buscarPorFiltros(busqueda, "", false);

	    return "configuraciones/editDocumento";
	}
	
}
