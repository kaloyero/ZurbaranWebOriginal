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
			dataTable.getAaData().add(row);
		}

		dataTable.setTotals(lista.size(), lista.size(), 1);
	
        return dataTable;

	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
	   return "configuraciones/banco";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") BancoForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		bancoManager.guardarNuevo((BancoForm) form);
		return null;
	}

}
