package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.IConfigurationController;
import com.contable.common.utils.DataTable;
import com.contable.form.EstructuraForm;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/estructura")
public class EstructuraController implements IConfigurationController<EstructuraForm>{
	
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		DataTable dataTable=new DataTable();
		
		List <String> row =new ArrayList<String>();
		row.add("1");
		row.add("Codigo");
		row.add("Descripcion");		
		row.add("Agrupa/Detalla");
		//row.add("");
		dataTable.getAaData().add(row);

		dataTable.setTotals(1, 1, 1);
  
        return dataTable;

	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

	public String showInit(Locale locale, Model model,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") EstructuraForm form,BindingResult result, HttpServletRequest request) throws ParseException{
//		estructuraManager.guardarNuevo((EstructuraForm) form);
		return null;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(EstructuraForm form, BindingResult result,HttpServletRequest request) throws ParseException {
	
		return null;
	}

}
