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
import com.contable.common.utils.ControllerUtil;
import com.contable.form.EstructuraContenidoForm;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Estructura;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.manager.AdministracionManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.EstructuraContenidoManager;
import com.contable.manager.EstructuraManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/estructuraContenido")
public class EstructuraContenidoController extends ConfigurationControllerImpl<EstructuraContenido, EstructuraContenidoForm>{
	
	@Autowired
	private AdministracionManager administracionManager;
	
	@Autowired
	private EstructuraContenidoManager estructuraContenidoManager;
	
	@Autowired
	private EstructuraManager estructuraManager;
	
	@Autowired
	private CuentaManager cuentaManager;

	
	@Override
	protected ConfigurationManager<EstructuraContenido, EstructuraContenidoForm> getRelatedManager() {
		//return estructuraManager;
		return estructuraContenidoManager;
	}

	@Override
	protected List<String> getRowDataList(EstructuraContenidoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(String.valueOf(formRow.getId()));
		row.add(formRow.getCodigo());
		row.add(formRow.getModo());
		row.add(formRow.getEstructuraNombre());
		row.add("<a href='#' class='contCuenta'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,
			HttpServletRequest request) {
		
		List<ConfigBean> listadoEstructuras =estructuraManager.getConfigNameList();
		model.addAttribute("EstructuraContenido", new EstructuraContenidoForm());

		model.addAttribute("estructuras", listadoEstructuras);
		   return "configuraciones/estructuraContenido";
	}
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		EstructuraContenidoForm estructuraContenido =estructuraContenidoManager.findById(id);

		List<ConfigBean> listadoEstructuras =estructuraManager.getConfigNameList();
		
		model.addAttribute("estructuras", listadoEstructuras);
		model.addAttribute("EstructuraContenido", estructuraContenido);
	    return "configuraciones/editEstructuraContenido";
	}
	@RequestMapping(value = "/getCuentaByContenidoId/{id}", method = RequestMethod.GET)
	public String getCuentaByContenidoId(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
	
		EstructuraContenidoForm estructuraContenido =estructuraContenidoManager.findById(id);
		List<ConfigBean> listadoCuentas =cuentaManager.getConfigNameList();
		model.addAttribute("cuentas", listadoCuentas);

		model.addAttribute("EstructuraContenido", estructuraContenido);
	    return "configuraciones/estructuraCuentaContenido";
	}


}
