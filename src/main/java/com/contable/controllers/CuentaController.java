package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.IConfigurationController;
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.CuentaForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
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
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private MonedaManager monedaManager;
	
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		List<CuentaForm> lista = cuentaManager.getLista();
        DataTable dataTable=new DataTable();
        
		for (CuentaForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(ControllerUtil.getAdministracionDescripcion(form.getAdministracion().getNombre()));
			row.add(form.getCodigo());
			row.add(form.getNombre());
			row.add(ControllerUtil.getSaldoDescripcion(form.getSaldo()));
			row.add(ControllerUtil.getEstadoDescripcion(form.getEstado()));

			row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");
			dataTable.getAaData().add(row);
		}
		
		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;

	}
	@RequestMapping(value = "/listByAdminId/{id}", method = RequestMethod.GET)

public @ResponseBody DataTable getListByAdmin(ModelMap model,@PathVariable int id, HttpServletRequest request) {
	
		
		List<ConfigBean> lista = cuentaManager.getConfigNameListByAdm(id);
        DataTable dataTable=new DataTable();
        
		for (ConfigBean form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getNombre());
			dataTable.getAaData().add(row);
		}
		
		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;

	}
	@RequestMapping(value = "/getDataForConcepto/{id}", method = RequestMethod.GET)

public @ResponseBody DataTable getDataForConcepto(ModelMap model,@PathVariable int id, HttpServletRequest request) {
	
		
		CuentaForm cuenta = cuentaManager.findById(id);
		List<ConfigBean> entidades=entidadManager.getConfigEntidadesListByTipoEntidad(cuenta.getTipoEntidad().getId());
		DataTable dataTable=new DataTable();
		List  row =new ArrayList();
		row.add(cuenta);
		row.add(entidades);
		dataTable.getAaData().add(row);
		return dataTable;
		
	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList(TipoEntidadManager.CAMPO_BLANCO);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();


		
		model.addAttribute("Cuenta", new CuentaForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);


		CuentaForm form1= cuentaManager.findById(9);
		
	   return "configuraciones/cuenta";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") CuentaForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		cuentaManager.guardarNuevo((CuentaForm) form);
		
		return "success";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") CuentaForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		cuentaManager.update((CuentaForm) form);
		return "success";
	}
	
	
	
	
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)

	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		CuentaForm cuenta =cuentaManager.findById(id);
		
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList(TipoEntidadManager.CAMPO_BLANCO);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		
		model.addAttribute("Cuenta",  cuenta);
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		
		return "configuraciones/editCuenta";
	}
	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.GET)
	public String changeStatus(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{		
		cuentaManager.toggleStatus(id);
		return "success";
	}

}
