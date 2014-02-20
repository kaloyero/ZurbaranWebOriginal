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
import com.contable.form.CuentaForm;
import com.contable.manager.CuentaManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cuenta")
public class CuentaController {

	@Autowired
	private CuentaManager cuentaManager;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public @ResponseBody DataTable home(Locale locale, Model model, HttpServletRequest request) {
		
		List<CuentaForm> lista = cuentaManager.getLista();
		
        DataTable dataTable=new DataTable();
        
		for (CuentaForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getAdministracion().getNombre());
			row.add(form.getCodigo());
			row.add(form.getNombre());
			row.add(form.getSaldo());
			dataTable.getAaData().add(row);
		}

        dataTable.setsEcho("1");
        dataTable.setiTotalDisplayRecords("5");
        dataTable.setiTotalRecords(String.valueOf(lista.size()));
  
        return dataTable;

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

}
