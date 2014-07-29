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
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.BancoForm;
import com.contable.hibernate.model.Banco;
import com.contable.manager.BancoManager;
import org.springframework.expression.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/banco")
public class BancoController extends ConfigurationControllerImpl<Banco, BancoForm> {
	
	@Autowired
	private BancoManager bancoManager;

	@Override
	protected ConfigurationManager<Banco, BancoForm> getRelatedManager() {
		return bancoManager;
	}
	
	@Override
	protected List<String> getRowDataList(BancoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getNombre());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));

		row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("Banco", new BancoForm());
	   return "configuraciones/banco";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		BancoForm banco =bancoManager.findById(id);

		model.addAttribute("Banco", banco);
	   return "configuraciones/editBanco";
	}

}
