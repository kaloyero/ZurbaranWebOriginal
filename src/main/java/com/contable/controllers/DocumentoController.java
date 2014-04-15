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
import com.contable.form.AdministracionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoGenericForm;
import com.contable.form.DocumentoGenericMapper;
import com.contable.form.EntidadForm;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.Entidad;
import com.contable.manager.AdministracionManager;
import com.contable.manager.BancoManager;
import com.contable.manager.ConceptoManager;
import com.contable.manager.DocumentoManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
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
	private EntidadManager entidadManager;
	
	private DocumentoGenericMapper mapperDocumento=new DocumentoGenericMapper();

	
	@Override
	protected AbstractManager<Documento, DocumentoForm> getRelatedManager() {
		return documentoManager;
	}

	@Override
	protected List<String> getRowDataList(DocumentoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add("1");
		row.add("Administracion");
		row.add("Codigo");
		row.add("Nombre");

		return row;
	}
	

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,		HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
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

		
		
		DocumentoForm formPrueba = new DocumentoForm();

		AdministracionForm formAdm = new AdministracionForm();
		formAdm.setId(1);
		
		formPrueba.setAdministracion(formAdm);
		formPrueba.setCuentaId(1);
		formPrueba.setDescripcion("descripcion");
		formPrueba.setEntidadId(1);
		formPrueba.setEstado("T");
		formPrueba.setFechaIngreso("04-01-2014");
		formPrueba.setFechaReal("04-01-2014");
		formPrueba.setFechaVencimiento("04-01-2014");
		formPrueba.setImporteTotal(1200.00);
		formPrueba.setMonedaId(1);
		formPrueba.setNumeroLetra("A");
		formPrueba.setNumeroEstablecimiento(01);
		formPrueba.setNumeroAnio(14);
		formPrueba.setNumeroMes(1);
		formPrueba.setNumeroDia(6);
		formPrueba.setNumero(1);
		formPrueba.setTipoDocumentoId(1);
		formPrueba.setTipoEntidadId(1);
		formPrueba.setTipoMovimiento("A");
		
//		documentoManager.guardarNuevo(formPrueba);
//		conceptoManager.getDocumentMovByConcept(1);		
//		tipoDocumentoManager.getDocumentHeaderByTipodocumento(1);
		
		
		
		return "documento";
	}

	@RequestMapping(value = "/getDocumentoHeader/{id}", method = RequestMethod.GET)
	public @ResponseBody DocumentoHeaderBean getByIdAdmin(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{

		DocumentoHeaderBean documentoForm =tipoDocumentoManager.getDocumentHeaderByTipodocumento(id);
		
		return documentoForm;
	}

	@RequestMapping(value = "/getDocumentoTabInfo/{id}", method = RequestMethod.GET)
	public @ResponseBody DocumentoMovimientoBean impGetConceptoInfo(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		
		DocumentoMovimientoBean bean =conceptoManager.getDocumentMovByConcept(id);

		return bean;
	}
	@RequestMapping(value = "/testSave", method = RequestMethod.POST)
    public @ResponseBody String saveUser(@RequestBody DocumentoGenericForm[] listado) {
    	DocumentoForm header = new DocumentoForm();
		documentoManager.guardarNuevo(mapperDocumento.getDocumentoForm(listado));
		return "a";
    } 
	@RequestMapping(value = "/getAplicaciones", method = RequestMethod.POST)
    public @ResponseBody List<ConfigBean> getAplicaciones(@RequestBody DocumentoAplicacionesSearch searchAplicacion) {
		                                                                    
		List<ConfigBean> beanList = documentoManager.getDocAplicacionesLista(searchAplicacion.getCuentaId(), searchAplicacion.getTipoDocumentoId(), searchAplicacion.getEntidadId(),searchAplicacion.getMonedaId());
		return beanList;
	}
	
	
}
