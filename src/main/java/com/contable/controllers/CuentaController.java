package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.CuentaForm;
import com.contable.hibernate.model.Cuenta;
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
public class CuentaController  extends ConfigurationControllerImpl<Cuenta, CuentaForm>{

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

	
	@Override
	protected ConfigurationManager<Cuenta, CuentaForm> getRelatedManager() {
		return cuentaManager;
	}
	@Override
	protected List<String> getRowDataList(CuentaForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(String.valueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getAdministracion().getNombre()));
		row.add(formRow.getCodigo());
		row.add(formRow.getNombre());
		row.add(ControllerUtil.getSaldoDescripcion(formRow.getSaldo()));
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));

		row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");
		return row;
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

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList(TipoEntidadManager.CAMPO_BLANCO);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		//Obtiene el listado de monedas para <TOdas las administraciones>
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameListByAdm(Constants.UI_ADM_VALUE_TODAS);


		
		model.addAttribute("Cuenta", new CuentaForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);


		CuentaForm form1= cuentaManager.findById(9);
		
	   return "configuraciones/cuenta";
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

}
