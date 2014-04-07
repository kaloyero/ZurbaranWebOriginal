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
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.ControllerUtil;
import com.contable.form.CotizacionForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Moneda;
import com.contable.manager.AdministracionManager;
import com.contable.manager.CotizacionManager;
import com.contable.manager.MonedaManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/moneda")
public class MonedaController extends ConfigurationControllerImpl<Moneda, MonedaForm>{
	
	@Autowired
	private MonedaManager monedaManager;
	@Autowired
	private CotizacionManager cotizacionManager;
	@Autowired
	private AdministracionManager adminManager;

	@Override
	protected ConfigurationManager<Moneda, MonedaForm> getRelatedManager() {
		return monedaManager;
	}

	@Override
	protected List<String> getRowDataList(MonedaForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(String.valueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getAdministracion().getNombre()));
		row.add(formRow.getNombre());
		row.add(formRow.getCodigo());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));
		row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");
		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		
		model.addAttribute("Moneda", new MonedaForm());
		model.addAttribute("administraciones", listadoAdministraciones);
	   return "configuraciones/moneda";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		MonedaForm moneda =monedaManager.findById(id);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("Moneda", moneda);
	   return "configuraciones/editMoneda";
	}
	@RequestMapping(value = "/getCotizacionyByMonedaId/{id}", method = RequestMethod.GET)
	public @ResponseBody double getCotizacion(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		CotizacionForm form=cotizacionManager.getUltimaCotizacionValidacion(id);
		return form.getCotizacion();
	}

}
