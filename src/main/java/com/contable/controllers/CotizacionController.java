package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.utils.DataTable;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cotizacion")
public class CotizacionController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody DataTable home(Locale locale, Model model, HttpServletRequest request) {
		
		DataTable dataTable=new DataTable();
		
		List <String> row =new ArrayList<String>();
		row.add("1");
		row.add("Moneda");
		row.add("Fecha");
		row.add("Cotizacion");
		//row.add("");
		dataTable.getAaData().add(row);

        dataTable.setsEcho("1");
        dataTable.setiTotalDisplayRecords("5");
        dataTable.setiTotalRecords("1");
  
        return dataTable;

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

}
