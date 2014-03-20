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
import com.contable.form.CuentaForm;
import com.contable.form.TipoDocumentoForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.TipoDocumentoManager;
import com.contable.manager.TipoEntidadManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tipoDocumento")
public class TipoDocumentoController implements IConfigurationController<TipoDocumentoForm>{

	@Autowired
	private TipoDocumentoManager tipoDocumentoManager;
	@Autowired
	private AdministracionManager adminManager;
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private MonedaManager monedaManager;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public @ResponseBody
	DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		DataTable dataTable=new DataTable();
		
		List <String> row =new ArrayList<String>();
		row.add("1");
		row.add("Administracion");
		row.add("Codigo");
		row.add("Nombre");
		//row.add("");
		dataTable.getAaData().add(row);

		dataTable.setTotals(1, 1, 1);  
        return dataTable;

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,		HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();

		model.addAttribute("TipoDocumento", new TipoDocumentoForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);

		
		return "configuraciones/tipoDocumento";
		
		
	}


	public String guardar(@ModelAttribute(value = "Form") TipoDocumentoForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		tipoDocumentoManager.guardarNuevo((TipoDocumentoForm) form);
		return "configuraciones/tipoDocumento";
	}


}
