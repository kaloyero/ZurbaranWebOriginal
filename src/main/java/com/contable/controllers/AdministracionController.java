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
import com.contable.form.AdministracionForm;
import com.contable.manager.AdministracionManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/administracion")
public class AdministracionController implements IConfigurationController{
	
	@Autowired
	private AdministracionManager administracionManager;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		//Obtengo la lista de Administraciones
		List<AdministracionForm> lista = administracionManager.getLista();
		List<AdministracionForm> lista2 = administracionManager.getListaDataTable(0, 100, "", "id", true);

		/*Creacion DATATABLE*/ 
		
        DataTable dataTable=new DataTable();
		for (AdministracionForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getNombre());
			row.add("Activo");
			dataTable.getAaData().add(row);
		}
		dataTable.setTotals(lista.size(), lista.size(), 1);
  
        return dataTable;

	}

	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
	   return "configuraciones/administracion";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Locale locale, Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
