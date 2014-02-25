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
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Moneda;
import com.contable.manager.AdministracionManager;
import com.contable.manager.MonedaManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/moneda")
public class MonedaController implements IConfigurationController<MonedaForm>{
	
	@Autowired
	private MonedaManager monedaManager;
	@Autowired
	private AdministracionManager adminManager;

	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		List<MonedaForm> lista = monedaManager.getLista();
		
        DataTable dataTable=new DataTable();
        
			for (MonedaForm form : lista) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(form.getId()));
				row.add(form.getAdministracion().getNombre());
				row.add(form.getNombre());
				row.add(form.getCodigo());
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
		for (ConfigBean configBean : listadoAdministraciones) {
			System.out.println(configBean.getId());
			System.out.println(configBean.getNombre());
		}
		
		model.addAttribute("Moneda", new Moneda());
		model.addAttribute("administraciones", listadoAdministraciones);
	   return "configuraciones/moneda";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") MonedaForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		monedaManager.guardarNuevo((MonedaForm) form);
		return null;
	}

}
