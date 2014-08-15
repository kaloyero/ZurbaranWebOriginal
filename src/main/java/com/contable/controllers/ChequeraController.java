package com.contable.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.ChequeraForm;
import com.contable.form.ChequeraNoDisponibleForm;
import com.contable.form.DocumentoGenericForm;
import com.contable.form.ValorPropioForm;

import com.contable.hibernate.model.Chequera;
import com.contable.manager.AdministracionManager;
import com.contable.manager.ChequeraManager;
import com.contable.manager.ChequeraNoDisponibleManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.DocumentoPropioManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.TipoEntidadManager;
import org.springframework.expression.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/chequera")
public class ChequeraController  extends ConfigurationControllerImpl<Chequera, ChequeraForm>{
	
	@Autowired
	private ChequeraManager chequeraManager;
	
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	@Autowired
	private AdministracionManager adminManager;
	@Autowired
	private MonedaManager monedaManager;
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private CuentaManager cuentaManager;
	@Autowired
	private ChequeraNoDisponibleManager chequeraNoDisponible;

	@Autowired
	private DocumentoPropioManager documentoPropioManager;

	@Override
	protected ConfigurationManager<Chequera, ChequeraForm> getRelatedManager() {
		return chequeraManager;
	}

	@Override
	protected List<String> getRowDataList(ChequeraForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getAdministracionNombre());
		row.add(ConvertionUtil.StrValueOf(formRow.getNumeroIni()));
		row.add(ConvertionUtil.StrValueOf(formRow.getNumeroFin()));
		row.add("<a href='#' class='contNoDisponible'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a><a href='#' class='contAddNoDisponible'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);
		List<ConfigBean> listadoEntidades =entidadManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoCuentas =cuentaManager.getConfigNameListByAdm(-1);
		
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("entidades", listadoEntidades);
		model.addAttribute("cuentas", listadoCuentas);
		model.addAttribute("Chequera", new ChequeraForm());

	   return "configuraciones/chequera";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		ChequeraForm chequera =chequeraManager.findById(id);
		FiltroValPropiosBean filtro =new FiltroValPropiosBean();
		//List<ValorPropioForm> listado = documentoPropioManager.buscarPorFiltros(filtro, "mostrar anulados", true);
		//model.addAttribute("test", listado);
		model.addAttribute("Chequera", chequera);
	
		return "configuraciones/editChequera";
	}
	@RequestMapping(value = "/saveNodisponible/", method = RequestMethod.POST)
	public ErrorRespuestaBean saveNodisponible(@RequestBody ChequeraNoDisponibleForm cheque) throws ParseException{
		ChequeraForm chequera=new ChequeraForm();
		chequera.setId(cheque.getIdChequera());
		ErrorRespuestaBean error=chequeraNoDisponible.guardarNuevo(cheque);
		return error;
	}


}
