package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.TipoDocumento;
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
public class TipoDocumentoController extends ConfigurationControllerImpl<TipoDocumento, TipoDocumentoForm>{

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

	@Override
	protected ConfigurationManager<TipoDocumento, TipoDocumentoForm> getRelatedManager() {
		return tipoDocumentoManager;
	}

	@Override
	protected List<String> getRowDataList(TipoDocumentoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getAdministracion().getNombre()));
		row.add(formRow.getCuentaNombre());
		row.add(formRow.getEntidadNombre());
		row.add(formRow.getTipoMovimiento());
		row.add(formRow.getNombre());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));
		row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");
		return row;
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

	@RequestMapping(value = "/listByAdminId/{id}", method = RequestMethod.GET)
	public @ResponseBody DataTable getByIdAdmin(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		List<ConfigBean> tipDocumentos = tipoDocumentoManager.getConfigNameListByAdm(id);
		DataTable dataTable=new DataTable();
		for (ConfigBean form : tipDocumentos) {
			List <String> row =new ArrayList<String>();
			row.add(ConvertionUtil.StrValueOf(form.getId()));
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
	    List<ConfigBean> listadoentidades=entidadManager.getConfigEntidadesListByTipoEntidad(cuentaManager.findById(tipoDocumento.getCuentaId()).getTipoEntidad().getId(),Constants.CAMPO_EXTRA_BLANCO);

		
		model.addAttribute("TipoDocumento", tipoDocumento);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("cuentas", listadocuentas);
		model.addAttribute("entidades", listadoentidades);


		model.addAttribute("monedas", listadoMonedas);
	   return "configuraciones/editTipoDocumento";
	}
	

}
