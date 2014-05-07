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
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.ChequeraForm;
import com.contable.hibernate.model.Chequera;
import com.contable.manager.ChequeraManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/chequera")
public class ChequeraController  extends ConfigurationControllerImpl<Chequera, ChequeraForm>{
	
	@Autowired
	private ChequeraManager chequeraManager;

	@Override
	protected ConfigurationManager<Chequera, ChequeraForm> getRelatedManager() {
		return chequeraManager;
	}

	@Override
	protected List<String> getRowDataList(ChequeraForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getAdministracion().getNombre());
		row.add(ConvertionUtil.StrValueOf(formRow.getNumeroIni()));
		row.add(ConvertionUtil.StrValueOf(formRow.getNumeroFin()));
		row.add("<a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {

		model.addAttribute("chequera", new ChequeraForm());

	   return "configuraciones/chequera";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		ChequeraForm chequera =chequeraManager.findById(id);

		model.addAttribute("Chequera", chequera);
	
		return "configuraciones/editChequera";
	}


}
