package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.IConfigurationController;
import com.contable.common.utils.DataTable;
import com.contable.form.BancoForm;
import com.contable.manager.BancoManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/banco")
public class BancoController  implements IConfigurationController<BancoForm>{
	
	@Autowired
	private BancoManager bancoManager;

	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		List<BancoForm> lista = bancoManager.getLista();
		
        DataTable dataTable=new DataTable();
        
		for (BancoForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getNombre());
			row.add(form.getEstado());

			row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");
			dataTable.getAaData().add(row);
		}

		dataTable.setTotals(lista.size(), lista.size(), 1);
	
        return dataTable;

	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") BancoForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		bancoManager.guardarNuevo((BancoForm) form);
		return "success";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") BancoForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		bancoManager.update((BancoForm) form);
		return "success";
	}
	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.GET)
	public String changeStatus(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{		
		bancoManager.toggleStatus(id);
		return "success";
	}

}
