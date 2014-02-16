package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.utils.DataTable;
import com.contable.hibernate.model.Moneda;
import com.contable.services.MonedaManager;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MonedaManager monedaManager;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/moneda", method = RequestMethod.GET)
	public @ResponseBody DataTable home(Locale locale, Model model, HttpServletRequest request) {
		
		String txt = "Hola";
        
		model.addAttribute("serverTime", txt );
		
		List<Moneda> lista = monedaManager.listAll();
		
        DataTable dataTable=new DataTable();

			for (Moneda moneda : lista) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(moneda.getId()));
				row.add(moneda.getCodigo());
				dataTable.getAaData().add(row);
			}

        dataTable.setsEcho("1");
        dataTable.setiTotalDisplayRecords("5");
        dataTable.setiTotalRecords("1");
        return dataTable;

	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public  String  homeTest(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

}
