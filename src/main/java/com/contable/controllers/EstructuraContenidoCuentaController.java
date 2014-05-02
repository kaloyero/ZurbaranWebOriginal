package com.contable.controllers;

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

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.form.DocumentoGenericForm;
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.hibernate.model.EstructuraContenidoCuenta;
import com.contable.manager.AdministracionManager;
import com.contable.manager.EstructuraContenidoCuentaManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/estructuraContenidoCuenta")
public class EstructuraContenidoCuentaController extends ConfigurationControllerImpl<EstructuraContenidoCuenta, EstructuraContenidoCuentaForm>{
	
	@Autowired
	private AdministracionManager administracionManager;
	
	@Autowired
	private EstructuraContenidoCuentaManager estructuraContenidoCuentaManager;


	
	@Override
	protected ConfigurationManager<EstructuraContenidoCuenta, EstructuraContenidoCuentaForm> getRelatedManager() {
		//return estructuraManager;
		return estructuraContenidoCuentaManager;
	}

	@Override
	protected List<String> getRowDataList(EstructuraContenidoCuentaForm formRow) {
		

		return null;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,
			HttpServletRequest request) {
	
		   return "configuraciones/estructuraContenido";
	}
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		
	    return "configuraciones/editEstructuraContenido";
	}
	@RequestMapping(value = "/saveCuenta", method = RequestMethod.POST)
	public String guardarCuenta(@RequestBody EstructuraContenidoCuentaForm[] listado){
		estructuraContenidoCuentaManager.guardarNuevo(listado);		
		return "success";
	}


}
