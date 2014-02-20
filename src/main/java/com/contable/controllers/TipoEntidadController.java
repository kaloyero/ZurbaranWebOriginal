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
import com.contable.form.TipoEntidadForm;
import com.contable.manager.TipoEntidadManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tipoEntidad")
public class TipoEntidadController {
	
	@Autowired
	private TipoEntidadManager tipoEntidadManager;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody DataTable home(Locale locale, Model model, HttpServletRequest request) {
		
		List<TipoEntidadForm> lista = tipoEntidadManager.getLista();
		
        DataTable dataTable=new DataTable();
        
			for (TipoEntidadForm form : lista) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(form.getId()));
				row.add(form.getAdministracion().getNombre());
				row.add(form.getNombre());
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
