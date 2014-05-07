package com.contable.controllers;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.form.EstructuraForm;
import com.contable.form.ValorPropioForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.DocumentoPropioManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/propio")
public class ValorPropioController {
	
	@Autowired
	private AdministracionManager administracionManager;

	@Autowired
	private DocumentoPropioManager documentoPropioManager;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);


		
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("Estructura", new EstructuraForm());
	
	   return "listado/propio";
	}
	@RequestMapping(value = "/getBySearch", method = RequestMethod.POST)
	public @ResponseBody String getBySearch(@RequestBody FiltroValPropiosBean busqueda){
		List<ValorPropioForm> listado = documentoPropioManager.buscarPorFiltros(busqueda, "id", true);
		
		return null;
	}



}
