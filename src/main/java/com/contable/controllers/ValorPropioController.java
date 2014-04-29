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
import com.contable.common.utils.ControllerUtil;
import com.contable.form.AdministracionForm;
import com.contable.hibernate.model.Administracion;
import com.contable.manager.AdministracionManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/propio")
public class ValorPropioController extends ConfigurationControllerImpl<Administracion, AdministracionForm> {
	
	@Autowired
	private AdministracionManager administracionManager;

	@Override
	protected ConfigurationManager<Administracion, AdministracionForm> getRelatedManager() {
		return administracionManager;
	}

	
	public List <String> getRowDataList(AdministracionForm formRow){
		List <String> row =new ArrayList<String>();

		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
	   return "listado/propio";
	}



}