package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Estructura;
import com.contable.manager.AdministracionManager;
import com.contable.manager.EstructuraManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/estructura")
public class EstructuraController extends ConfigurationControllerImpl<Estructura, EstructuraForm>{
	
	@Autowired
	private AdministracionManager administracionManager;
	
	@Autowired
	private EstructuraManager estructuraManager;

	
	@Override
	protected ConfigurationManager<Estructura, EstructuraForm> getRelatedManager() {
		return estructuraManager;
	}

	@Override
	protected List<String> getRowDataList(EstructuraForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add("1");
		row.add("Codigo");
		row.add("Descripcion");		
		row.add("Agrupa/Detalla");

		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,
			HttpServletRequest request) {
		
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		model.addAttribute("Estructura", new EstructuraForm());

		model.addAttribute("administraciones", listadoAdministraciones);
		   return "configuraciones/estructura";
	}


}
