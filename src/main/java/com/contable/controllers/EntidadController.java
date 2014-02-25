package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.IConfigurationController;
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.DataTable;
import com.contable.form.EntidadForm;
import com.contable.hibernate.model.Moneda;
import com.contable.manager.EntidadManager;
import com.contable.manager.TipoEntidadManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/entidad")
public class EntidadController  implements IConfigurationController{
	
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

        dataTable.setsEcho("1");
        dataTable.setiTotalDisplayRecords("5");
        dataTable.setiTotalRecords(String.valueOf(lista.size()));
  
        return dataTable;
	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		
		model.addAttribute("Entidad", new EntidadForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
	   return "configuraciones/entidad";
	}

}
