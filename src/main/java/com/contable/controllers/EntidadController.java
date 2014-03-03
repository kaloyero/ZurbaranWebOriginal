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
import com.contable.form.EntidadForm;
import com.contable.manager.EntidadManager;
import com.contable.manager.TipoEntidadManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/entidad")
public class EntidadController  implements IConfigurationController<EntidadForm>{
	
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		List<EntidadForm> lista = entidadManager.getLista();
		
        DataTable dataTable=new DataTable();
        
			for (EntidadForm form : lista) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(form.getId()));
				row.add(form.getTipo().getAdministracion().getNombre());
				row.add(form.getTipo().getNombre());
				row.add(form.getNombre());
				dataTable.getAaData().add(row);
			}

		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;
	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		
		model.addAttribute("Entidad", new EntidadForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		
		entidadManager.getConfigEntidadesListByTipoEntidad(1);
		
	    return "configuraciones/entidad";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") EntidadForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		entidadManager.guardarNuevo((EntidadForm) form);
		return "success";
	}

}
