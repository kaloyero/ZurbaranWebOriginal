package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ControllerUtil;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;
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
public class ConceptoController  extends ConfigurationControllerImpl<Concepto, ConceptoForm>{

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

	@Override
	protected ConfigurationManager<Concepto, ConceptoForm> getRelatedManager() {
		return conceptoManager;
	}

	@Override
	protected List<String> getRowDataList(ConceptoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(String.valueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getAdministracion().getNombre()));
		row.add(formRow.getCodigo());
		row.add(formRow.getNombre());
		row.add(formRow.getCuenta().getCodigo());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));

		row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");
		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		List<ConfigBean> listadoEntidades =entidadManager.getConfigNameList();
		List<ConfigBean> listadoCuentas =cuentaManager.getConfigNameListByAdm(-1);
		
		model.addAttribute("Concepto", new ConceptoForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("entidades", listadoEntidades);
		model.addAttribute("cuentas", listadoCuentas);

		

	   return "configuraciones/concepto";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		ConceptoForm concepto =conceptoManager.findById(id);
		
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		List<ConfigBean> listadoCuentas =cuentaManager.getConfigNameListByAdm(concepto.getAdministracion().getId());
		List<ConfigBean> listadoEntidades =entidadManager.getConfigEntidadesListByTipoEntidad(concepto.getCuenta().getTipoEntidad().getId(),Constants.CAMPO_EXTRA_TODAS);

		
		model.addAttribute("Concepto", concepto);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("cuentas", listadoCuentas);
		model.addAttribute("entidades", listadoEntidades);

	
		return "configuraciones/editConcepto";
	}

	
}
