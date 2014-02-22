package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.IConfigurationController;
import com.contable.common.utils.DataTable;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/estructura")
public class EstructuraController implements IConfigurationController{
	
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		DataTable dataTable=new DataTable();
		
		List <String> row =new ArrayList<String>();
		row.add("1");
		row.add("Codigo");
		row.add("Descripcion");		
		row.add("Agrupa/Detalla");
		//row.add("");
		dataTable.getAaData().add(row);

        dataTable.setsEcho("1");
        dataTable.setiTotalDisplayRecords("5");
        dataTable.setiTotalRecords("1");
  
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

}
