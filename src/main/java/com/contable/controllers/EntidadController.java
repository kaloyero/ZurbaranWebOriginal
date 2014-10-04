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
import com.contable.form.EntidadForm;
import com.contable.hibernate.model.Entidad;
import com.contable.manager.EntidadManager;
import com.contable.manager.TipoEntidadManager;
import org.springframework.expression.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/entidad")
public class EntidadController  extends ConfigurationControllerImpl<Entidad, EntidadForm>{
	
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private TipoEntidadManager tipoEntidadManager;

	@Override
	protected ConfigurationManager<Entidad, EntidadForm> getRelatedManager() {
		return entidadManager;
	}

	@Override
	protected List<String> getRowDataList(EntidadForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getTipo().getAdministracion().getNombre()));
		row.add(formRow.getTipo().getNombre());
		row.add(formRow.getNombre());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));

		row.add(BOTON_LISTADO_CAMBIARESTADO +
				BOTON_LISTADO_EDITAR +
				BOTON_LISTADO_ELIMINAR);

		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		
		model.addAttribute("Entidad", new EntidadForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		
	    return "configuraciones/entidad";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		EntidadForm entidad =entidadManager.findById(id);
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();		
		
		model.addAttribute("Entidad", entidad);
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
	   return "configuraciones/editEntidad";
	}

}
