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

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.TipoEntidadForm;
import com.contable.hibernate.model.TipoEntidad;
import com.contable.manager.AdministracionManager;
import com.contable.manager.TipoEntidadManager;
import org.springframework.expression.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tipoEntidad")
public class TipoEntidadController extends ConfigurationControllerImpl<TipoEntidad, TipoEntidadForm>{
	
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	@Autowired
	private AdministracionManager adminManager;

	@Override
	protected ConfigurationManager<TipoEntidad, TipoEntidadForm> getRelatedManager() {
		return tipoEntidadManager;
	}

	@Override
	protected List<String> getRowDataList(TipoEntidadForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getAdministracion().getNombre()));
		row.add(formRow.getNombre());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));
		row.add(BOTON_LISTADO_CAMBIARESTADO +
				BOTON_LISTADO_EDITAR +
				BOTON_LISTADO_ELIMINAR);

		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		
		model.addAttribute("TipoEntidad", new TipoEntidadForm());
		model.addAttribute("administraciones", listadoAdministraciones);
	   return "configuraciones/tipoEntidad";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		TipoEntidadForm tipoEntidad =tipoEntidadManager.findById(id);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		
		model.addAttribute("TipoEntidad", tipoEntidad);
		model.addAttribute("administraciones", listadoAdministraciones);
	   return "configuraciones/editTipoEntidad";
	}

}
