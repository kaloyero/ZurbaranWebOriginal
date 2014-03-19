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
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.DataTable;
import com.contable.form.TipoEntidadForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.TipoEntidadManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tipoEntidad")
public class TipoEntidadController implements IConfigurationController<TipoEntidadForm>{
	
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	@Autowired
	private AdministracionManager adminManager;

	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		List<TipoEntidadForm> lista = tipoEntidadManager.getLista();
		
        DataTable dataTable=new DataTable();
        
			for (TipoEntidadForm form : lista) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(form.getId()));
				row.add(form.getAdministracion().getNombre());
				row.add(form.getNombre());
				row.add("<a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

				dataTable.getAaData().add(row);
			}
		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;

	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList();
		
		model.addAttribute("TipoEntidad", new TipoEntidadForm());
		model.addAttribute("administraciones", listadoAdministraciones);
	   return "configuraciones/tipoEntidad";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") TipoEntidadForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		tipoEntidadManager.guardarNuevo((TipoEntidadForm) form);
		return "success";
	}
	
	@RequestMapping(value = "/getEntidadById", method = RequestMethod.GET)

	public String get(Locale locale, Model model, HttpServletRequest request) throws ParseException{
		TipoEntidadForm tipoEntidad =tipoEntidadManager.findById(1);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList();
		
		model.addAttribute("TipoEntidad", tipoEntidad);
		model.addAttribute("administraciones", listadoAdministraciones);
	   return "configuraciones/editTipoEntidad";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") TipoEntidadForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		tipoEntidadManager.update((TipoEntidadForm) form);
		return "success";
	}

}
