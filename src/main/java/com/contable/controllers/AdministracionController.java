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
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.AdministracionForm;
import com.contable.manager.AdministracionManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/administracion")
public class AdministracionController implements IConfigurationController<AdministracionForm>{
	
	@Autowired
	private AdministracionManager administracionManager;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		//Obtengo la lista de Administraciones
		String buscar 	= request.getParameter("sSearch");
		String paginaIni 	= request.getParameter("iDisplayStart");
		String cantRegistros 	= request.getParameter("iDisplayLength");
		List<AdministracionForm> lista = administracionManager.getListaDataTable(Integer.parseInt(paginaIni), Integer.parseInt(cantRegistros), buscar, "id", true);


		/*Creacion DATATABLE*/ 
		
        DataTable dataTable=new DataTable();
		for (AdministracionForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(ControllerUtil.getAdministracionDescripcion(form.getNombre()));
			row.add(ControllerUtil.getEstadoDescripcion(form.getEstado()));
			row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

			dataTable.getAaData().add(row);
		}
		dataTable.setTotals(10, 21, 20);
  
        return dataTable;

	}

	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
	   return "configuraciones/administracion";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") AdministracionForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		administracionManager.guardarNuevo((AdministracionForm) form);		
		return "success";
	}
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)

	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		AdministracionForm administracion =administracionManager.findById(id);

		model.addAttribute("Administracion", administracion);
	   return "configuraciones/editAdministracion";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") AdministracionForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		administracionManager.update((AdministracionForm) form);
		return "success";
	}
	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.GET)
	public String changeStatus(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{		
		administracionManager.toggleStatus(id);
		return "success";
	}

}
