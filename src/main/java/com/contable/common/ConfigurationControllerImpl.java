package com.contable.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public abstract class ConfigurationControllerImpl<E,F> extends AbstractControllerImpl<E,F> implements ConfigurationController<E,F> {
	
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
	
	
}
