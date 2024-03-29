package com.contable.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
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
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DataTable;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoGenericForm;
import com.contable.form.DocumentoGenericMapper;
import com.contable.form.DocumentoValTerceForm;
import com.contable.form.NumeracionForm;
import com.contable.form.NumeracionSearch;
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Documento;
import com.contable.manager.AdministracionManager;
import com.contable.manager.BancoManager;
import com.contable.manager.ConceptoManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.DocumentoManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.NumeracionManager;
import com.contable.manager.PeriodoManager;
import com.contable.manager.TipoDocumentoManager;

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
	@Autowired
	private PeriodoManager periodoManager;

	
	private FiltroDocumentoBean filtrosDeBusqueda = new FiltroDocumentoBean(); 
	
	private DocumentoGenericMapper mapperDocumento=new DocumentoGenericMapper();

	
	@Override
	protected AbstractManager<Documento, DocumentoForm> getRelatedManager() {
		return documentoManager;
	}

	@Override
	protected List<String> getRowDataList(DocumentoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getAdministracionNombre());

		row.add(formRow.getTipoDocumentoNombre());
		row.add(formRow.getNumeroFormateado());
		row.add(formRow.getFechaIngreso());
		row.add(formRow.getFechaVencimiento());
		row.add(formRow.getCuentaNombre());
		row.add(formRow.getTipoEntidadNombre());
		row.add(formRow.getEntidadNombre());
		row.add(formRow.getMonedaCodigo());
		row.add(FormatUtil.format2DecimalsStr(formRow.getImporteTotal()));
		row.add("</a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}
	@RequestMapping(value = "/listadoShow", method = RequestMethod.GET)
	public String showInitListado(Locale locale, Model model,		HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadocuentas =cuentaManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);

		model.addAttribute("cuentas", listadocuentas);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("administraciones", listadoAdministraciones);


		model.addAttribute("Documento", new DocumentoForm());
		return "configuraciones/documentoListado";
		
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,		HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);
		List<ConfigBean> listadoTipoDocumentos = tipoDocumentoManager.getConfigNameList();
		List<ConfigBean> listadoConceptos = conceptoManager.getConfigNameList();
		List<ConfigBean> listadoBancos = bancoManager.getConfigNameList();
//TODO SACAR, eliminar xq se hace en  getByIdAdmin. 
		List<ConfigBean> listadoConceptosImpu=conceptoManager.getConfigNameListByFiltro(null, Constants.TIPODOCUMENTO_TIPOVALOR_NOVALOR);
		List<ConfigBean> listadoConceptosTercero=conceptoManager.getConfigNameListByFiltro(null, Constants.TIPODOCUMENTO_TIPOVALOR_VALTERCE);
		List<ConfigBean> listadoConceptosPropio=conceptoManager.getConfigNameListByFiltro(null, Constants.TIPODOCUMENTO_TIPOVALOR_VALPROPIO);

		model.addAttribute("Documento", new DocumentoForm());
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("tipoDocumentos", listadoTipoDocumentos);
		model.addAttribute("conceptos", listadoConceptos);
		model.addAttribute("conceptosImpu", listadoConceptosImpu);
		model.addAttribute("conceptosTercero", listadoConceptosTercero);
		model.addAttribute("conceptosPropio", listadoConceptosPropio);
		model.addAttribute("bancos", listadoBancos);


		//Reseteo los filtros de B�squeda
		setFiltrosDeBusqueda(new FiltroDocumentoBean()); 

		
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
        		rowData.add(ConvertionUtil.StrValueOf(row.getId()));
        		rowData.add(ConvertionUtil.StrValueOf(row.getNumero()));
        		rowData.add(row.getBancoNombre());
        		rowData.add(row.getCuentaNombre());
        		rowData.add(row.getEntidadNombre());
        		rowData.add(row.getTipoEntidadNombre());
        		rowData.add(row.getMonedaCodigo());
        		rowData.add(FormatUtil.format2DecimalsStr(row.getCotizacion()));
				rowData.add(FormatUtil.format2DecimalsStr(row.getImporte()));
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
		NumeroBean numero =numeracionManager.getLastDocNumeration(numeracion.getAdministracionId(), numeracion.getTipoDocumentoId(), numeracion.getFechaReal(),numeracion.getNumeroLetra(),numeracion.getNumeroEstablecimiento());
		return numero;
	}
	@RequestMapping(value = "/getLastDocFechaByAdministracion/{id}", method = RequestMethod.GET)
	public @ResponseBody String getLastDocFechaByAdministracion(Locale locale, Model model,@PathVariable int id, HttpServletRequest request){
		
		String valor = documentoManager.getUltimaFechaDocumento(id);
		return valor;
	}
	@RequestMapping(value = "/validarNumero", method = RequestMethod.POST)
	public @ResponseBody ErrorRespuestaBean isValidNumero(@RequestBody NumeracionSearch numeracion) {
		//ALEX aca tenes que agregarle el tipo de Entidad
		//ErrorRespuestaBean error= numeracionManager.validarNumeroNoRepetido(numeracion.getAdministracionId(), numeracion.getTipoDocumentoId(), numeracion.getEntidadId(), numeracion.getNumero(), numeracion.getNumeroLetra(), numeracion.getNumeroEstablecimiento());
		
		//return error;
		return null;
	}
	
	
	
	@RequestMapping(value = "/testSave", method = RequestMethod.POST)
    public @ResponseBody ErrorRespuestaBean saveUser(@RequestBody DocumentoGenericForm[] listado) {
//    	DocumentoForm header = new DocumentoForm();
		ErrorRespuestaBean error=documentoManager.guardarNuevo(mapperDocumento.getDocumentoForm(listado));
		return error;
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
	@RequestMapping(value = "/anularDocumentoById/{id}", method = RequestMethod.GET)
	public @ResponseBody ErrorRespuestaBean anularDocumentoById(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		ErrorRespuestaBean respuesta =documentoManager.anularDocumentoById(id);

	    return respuesta;
	}
	@RequestMapping(value = "/borrarDocumentoById/{id}", method = RequestMethod.GET)
	public @ResponseBody ErrorRespuestaBean borrarDocumentoById(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		ErrorRespuestaBean respuesta =documentoManager.eliminarById(id);

	    return respuesta;
	}
	@RequestMapping(value = "/getBySearch", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearch(@RequestBody FiltroDocumentoBean busqueda){
		
		//Guardo los Filtros para exportar la lista.
		setFiltrosDeBusqueda(busqueda); 

		//Obtengo los documentos por filtros
		List<DocumentoForm> documentos =documentoManager.buscarPorFiltros(busqueda, "fechaIngreso", false);

		
		//Obtengo el periodo
		PeriodoForm periodo = periodoManager.getPeriodoActual(busqueda.getAdministracionId());

		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        
        	for (DocumentoForm formRow : documentos) {
        		List <String> row =new ArrayList<String>();
        		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
        		row.add(formRow.getTipoDocumentoNombre());
        		row.add("<a href='#' class='contView'>" + formRow.getNumeroFormateado() + "</a> " );
        		row.add(formRow.getDescripcion());
        		row.add(formRow.getFechaIngreso());
        		row.add(formRow.getFechaVencimiento());
        		row.add(formRow.getCuentaNombre());
        		row.add(formRow.getTipoEntidadNombre());
        		row.add(formRow.getEntidadNombre());
        		row.add(formRow.getMonedaCodigo());
        		row.add(FormatUtil.format2DecimalsStr(formRow.getImporteTotal()));
        		row.add(formRow.getDescripcionEstado());
        		    
        	

        		String botonAnular ="";
        		String botonExcel ="<a href='#' class='contExport'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/excel.gif\'></a>";
        		String botonBorrar ="";
        		
        		if ( (! Constants.DOCUMENTO_ESTADO_ANULADO.equals(formRow.getEstado()))){
        			//Si el estado es <> de A
        			//if (formRow.getCantidadAplicaciones() != null && formRow.getCantidadAplicaciones() > 0){	
        			//Valido que este dentro del periodo actual
        			if (DateUtil.convertStringToDate(formRow.getFechaIngreso()).after(DateUtil.convertStringToDate(periodo.getFechaIni())) && 
        					DateUtil.convertStringToDate(formRow.getFechaIngreso()).before(DateUtil.convertStringToDate(periodo.getFechaFin()))) {
        				botonBorrar ="<a href='#' class='contDelete'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/delete.jpeg'></a>";
        			}
    				botonAnular ="<a href='#' class='contAnular'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/anular.png'></a>";
        			//}
        		}
        		row.add(botonAnular + botonBorrar + botonExcel);
        		

				dataTable.getAaData().add(row);
        	}

        	
	    return dataTable;
	}
	@RequestMapping(value = "/exportarExcel/{id}", method = RequestMethod.GET)
	public @ResponseBody String exporEx(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		documentoManager.exportDocumentoDetalleExcel(id);
		return "OK";
		
	}

	public FiltroDocumentoBean getFiltrosDeBusqueda() {
		return filtrosDeBusqueda;
	}
	@RequestMapping(value = "/Excel", method = RequestMethod.GET)
    public void handleFileDownload(HttpServletResponse res) {
        try {
            String fn = "/Test.xls";
            java.net.URL url = getClass().getResource(fn);
            File f = new File(url.toURI());
            System.out.println("Loading file "+fn+"("+f.getAbsolutePath()+")");
            if (f.exists()) {
                res.setContentType("application/xls");
                res.setContentLength(new Long(f.length()).intValue());
                res.setHeader("Content-Disposition", "attachment; filename=Test.xls");
                FileCopyUtils.copy(new FileInputStream(f), res.getOutputStream());
            } else {
                System.out.println("File"+fn+"("+f.getAbsolutePath()+") does not exist");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	public void setFiltrosDeBusqueda(FiltroDocumentoBean filtrosDeBusqueda) {
		this.filtrosDeBusqueda = filtrosDeBusqueda;
	}
	
}
