package com.contable.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.beans.ErrorRespuestaBean;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public abstract class ConfigurationControllerImpl<E,F> extends AbstractControllerImpl<E,F> implements ConfigurationController<E,F> {

	public static final String BOTON_LISTADO_ELIMINAR = "<a href='#' class='contEliminar'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/delete.jpeg'></a>";
	public static final String BOTON_LISTADO_EDITAR = "<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a>";
	public static final String BOTON_LISTADO_VER = "<a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>";

	/**
	 * Obtener el servicio
	 * @return
	 */
	protected abstract ConfigurationManager<E,F> getRelatedManager() ;


	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.GET)
	public String changeStatus(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{		
		(getRelatedManager()).toggleStatus(id);
		return "success";
	}

	@RequestMapping(value = "/eliminarById/{id}", method = RequestMethod.GET)
	public @ResponseBody ErrorRespuestaBean eliminarById(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		ErrorRespuestaBean respuesta = (getRelatedManager()).eliminarConfiguracionById(id);
	    return respuesta;
	}
	
}
