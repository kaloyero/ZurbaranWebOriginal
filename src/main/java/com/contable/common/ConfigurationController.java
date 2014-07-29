package com.contable.common;

import java.util.Locale;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.beans.ErrorRespuestaBean;
import org.springframework.expression.ParseException;

/**
 * Interface para controladores de Configuracion
 * 
 * @author kaloye
 *
 */
public interface ConfigurationController<E,F> extends AbstractController<E, F>  {

	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.GET)
	public String changeStatus(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException;
	
	public @ResponseBody ErrorRespuestaBean eliminarById(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException;
	
}
