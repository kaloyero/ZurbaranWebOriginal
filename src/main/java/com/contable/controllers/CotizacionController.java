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

import com.contable.common.IConfigurationController;
import com.contable.common.utils.DataTable;
import com.contable.form.CotizacionForm;
import com.contable.manager.CotizacionManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cotizacion")
public class CotizacionController  implements IConfigurationController{
	
	@Autowired
	private CotizacionManager cotizacionManager;

	
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		List<CotizacionForm> lista = cotizacionManager.getLista();
		
        DataTable dataTable=new DataTable();
        
		for (CotizacionForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getMoneda().getNombre());
			row.add(form.getFecha());
			row.add(String.valueOf(form.getCotizacion()));
			dataTable.getAaData().add(row);
		}
		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;


	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
	   return "configuraciones/cotizacion";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Locale locale, Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
