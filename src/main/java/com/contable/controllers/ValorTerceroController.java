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
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.form.EstructuraForm;
import com.contable.form.ValorTerceForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.BancoManager;
import com.contable.manager.DocumentoTerceManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tercero")
public class ValorTerceroController  {
	
	@Autowired
	private AdministracionManager administracionManager;
	@Autowired
	private BancoManager bancoManager;

	@Autowired
	private DocumentoTerceManager documentoTerceManager;

	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);

		List<ConfigBean> listadoBancos = bancoManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);

		
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("bancos", listadoBancos);
		model.addAttribute("Estructura", new EstructuraForm());
	   return "listado/terceros";
	}
	@RequestMapping(value = "/getBySearch", method = RequestMethod.POST)
	public @ResponseBody String getBySearch(@RequestBody FiltroValTercerosBean busqueda){
		List<ValorTerceForm> listado = documentoTerceManager.buscarPorFiltros(busqueda, "id", true);
		return null;
	}


}
