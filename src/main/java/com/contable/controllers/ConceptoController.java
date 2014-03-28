package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.IConfigurationController;
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.ConceptoForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.ConceptoManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.TipoEntidadManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/concepto")
public class ConceptoController  implements IConfigurationController<ConceptoForm>{

	@Autowired
	private ConceptoManager conceptoManager;
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	@Autowired
	private AdministracionManager adminManager;
	@Autowired
	private MonedaManager monedaManager;
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private CuentaManager cuentaManager;

	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		List<ConceptoForm> lista = conceptoManager.getLista();
		
        DataTable dataTable=new DataTable();
        
		for (ConceptoForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getAdministracion().getNombre());
			row.add(form.getCodigo());
			row.add(form.getNombre());
			row.add(form.getCuenta().getCodigo());
			row.add(ControllerUtil.getEstadoDescripcion(form.getEstado()));

			row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

			dataTable.getAaData().add(row);
			
		}

		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;


	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		List<ConfigBean> listadoEntidades =entidadManager.getConfigNameList();
		List<ConfigBean> listadoCuentas =cuentaManager.getConfigNameList();
		
		model.addAttribute("Concepto", new ConceptoForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("entidades", listadoEntidades);
		model.addAttribute("cuentas", listadoCuentas);

		

	   return "configuraciones/concepto";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") ConceptoForm form,BindingResult result, HttpServletRequest request) throws ParseException{

/*		CuentaForm ctaMon = new CuentaForm();
		ctaMon.setId(9);
		form.setCuenta(ctaMon);
		AdministracionForm adm = new AdministracionForm();
		adm.setId(1);
		form.setAdministracion(adm);
		EntidadForm ent = new EntidadForm();
		ent.setId(1);
		form.setEntidad(ent);
		MonedaForm mon = new MonedaForm();
		mon.setId(1);
		form.setMoneda(mon);
*/		
		
		conceptoManager.guardarNuevo((ConceptoForm) form);
		return "success";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") ConceptoForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		conceptoManager.update((ConceptoForm) form);
		return "success";
	}
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)

	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		ConceptoForm concepto =conceptoManager.findById(id);
		
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		List<ConfigBean> listadoCuentas =cuentaManager.getConfigNameListByAdm(concepto.getAdministracion().getId());
		List<ConfigBean> listadoEntidades =entidadManager.getConfigEntidadesListByTipoEntidad(concepto.getCuenta().getTipoEntidad().getId());

		
		model.addAttribute("Concepto", concepto);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("cuentas", listadoCuentas);
		model.addAttribute("entidades", listadoEntidades);

	
		return "configuraciones/editConcepto";
	}
	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.GET)
	public String changeStatus(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{		
		conceptoManager.toggleStatus(id);
		return "success";
	}
	
}
