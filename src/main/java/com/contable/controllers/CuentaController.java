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
import com.contable.form.CuentaMonedaForm;
import com.contable.form.MonedaForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.TipoEntidadManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cuenta")
public class CuentaController  implements IConfigurationController<CuentaForm>{

	@Autowired
	private CuentaManager cuentaManager;
	@Autowired
	private AdministracionManager adminManager;
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
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
		
		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;

	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList();

		
		model.addAttribute("Cuenta", new CuentaForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);

		CuentaForm form1= cuentaManager.findById(9);
		
	   return "configuraciones/cuenta";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") CuentaForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		List<CuentaMonedaForm> lista= new ArrayList<CuentaMonedaForm>();
		CuentaMonedaForm ctaMon = new CuentaMonedaForm();
		MonedaForm moneda = new MonedaForm();
		moneda.setId(1);
		ctaMon.setMoneda(moneda);
		lista.add(ctaMon);
		form.setMonedas(lista);
		cuentaManager.guardarNuevo((CuentaForm) form);
		
		return null;
	}

}
