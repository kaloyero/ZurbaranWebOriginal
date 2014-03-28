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
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.TipoDocumentoForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.CuentaManager;
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
	@Autowired
	private CuentaManager cuentaManager;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public @ResponseBody
	DataTable getList(Locale locale, Model model, HttpServletRequest request) {

		List<TipoDocumentoForm> lista = tipoDocumentoManager.getLista();
        DataTable dataTable=new DataTable();
        
		for (TipoDocumentoForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getAdministracion().getNombre());
			row.add(form.getNombre());
			row.add(ControllerUtil.getEstadoDescripcion(form.getEstado()));
			row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");
			dataTable.getAaData().add(row);
		}
		
		dataTable.setTotals(lista.size(), lista.size(), 1);  

        return dataTable;

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,		HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();

		model.addAttribute("TipoDocumento", new TipoDocumentoForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);

		return "configuraciones/tipoDocumento";
		
	}


	public String guardar(@ModelAttribute(value = "Form") TipoDocumentoForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		tipoDocumentoManager.guardarNuevo(form);
		return "success";
	}
	@RequestMapping(value = "/listByAdminId/{id}", method = RequestMethod.GET)
	public @ResponseBody DataTable getByIdAdmin(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		List<ConfigBean> tipDocumentos = tipoDocumentoManager.getConfigNameListByAdm(id);
		DataTable dataTable=new DataTable();
		for (ConfigBean form : tipDocumentos) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getNombre());
			dataTable.getAaData().add(row);
		}
		
		dataTable.setTotals(tipDocumentos.size(), tipDocumentos.size(), 1); 
		return dataTable;
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		TipoDocumentoForm tipoDocumento =tipoDocumentoManager.findById(id);
		
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		List<ConfigBean> listadocuentas =cuentaManager.getConfigNameListByAdm(tipoDocumento.getAdministracion().getId());
	    List<ConfigBean> listadoentidades=entidadManager.getConfigEntidadesListByTipoEntidad(cuentaManager.findById(tipoDocumento.getCuentaId()).getTipoEntidad().getId());

		
		model.addAttribute("TipoDocumento", tipoDocumento);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("cuentas", listadocuentas);
		model.addAttribute("entidades", listadoentidades);


		model.addAttribute("monedas", listadoMonedas);
	   return "configuraciones/editTipoDocumento";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") TipoDocumentoForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		
		if (((TipoDocumentoForm) form).getPermiteAplicaciones()==null) {
			((TipoDocumentoForm) form).setPermiteAplicaciones("N");
		}
		if (((TipoDocumentoForm) form).getPermiteImputaciones()==null) {
			((TipoDocumentoForm) form).setPermiteImputaciones("N");
		}
		if (((TipoDocumentoForm) form).getPermiteEgrValTer()==null) {
			((TipoDocumentoForm) form).setPermiteEgrValTer("N");
		}
		if (((TipoDocumentoForm) form).getPermiteIngValTer()==null) {
			((TipoDocumentoForm) form).setPermiteIngValTer("N");
		}
		if (((TipoDocumentoForm) form).getPermiteValProp()==null) {
			((TipoDocumentoForm) form).setPermiteValProp("N");
		}
		tipoDocumentoManager.update((TipoDocumentoForm) form);
		return "success";
	}


}
