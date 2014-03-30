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
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Periodo;
import com.contable.manager.PeriodoManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/periodo")
public class PeriodoController  extends ConfigurationControllerImpl<Periodo, PeriodoForm>{
	
	@Autowired
	private PeriodoManager periodoManager;

	@Override
	protected ConfigurationManager<Periodo, PeriodoForm> getRelatedManager() {
		return periodoManager;
	}

	@Override
	protected List<String> getRowDataList(PeriodoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(String.valueOf(formRow.getId()));
		row.add(formRow.getAdministracion().getNombre());
		row.add("<a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {

		model.addAttribute("periodo", new PeriodoForm());

	   return "configuraciones/periodo";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		PeriodoForm periodo = periodoManager.findById(id);

		model.addAttribute("periodo", periodo);
	
		return "configuraciones/editPeriodo";
	}


}
