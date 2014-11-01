package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.UsuarioForm;
import com.contable.hibernate.model.Usuario;
import com.contable.manager.UsuarioManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController extends ConfigurationControllerImpl<Usuario, UsuarioForm> {
	
	@Autowired
	private UsuarioManager usuarioManager;

	@Override
	protected ConfigurationManager<Usuario, UsuarioForm> getRelatedManager() {
		return usuarioManager;
	}
	
	@Override
	protected List<String> getRowDataList(UsuarioForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getUsername());
		row.add(formRow.getEmail());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));
		row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("Usuario", new UsuarioForm());
	   return "configuraciones/usuario";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody  ErrorRespuestaBean guardar(@ModelAttribute(value = "Form") UsuarioForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		//TODO cambiar
		form.setIdRole(1);
		form.setValidaPassword("T");
		form.setValidaRol("T");
		form.setEstado("T");
		
		
		ErrorRespuestaBean respuesta=getRelatedManager().guardarNuevo(form);		
		return respuesta;
	}

	
}
