package com.contable.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.utils.DataTable;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public interface AbstractController<E,F> {

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	@ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request);
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public  @ResponseBody ErrorRespuestaBean guardar(@ModelAttribute(value = "Form") F form,BindingResult result, HttpServletRequest request) throws ParseException;
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") F form,BindingResult result, HttpServletRequest request) throws ParseException;
	
	/**
	 * Entra este metodo antes de cargar la pagina de Alta
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public  String  crear(Locale locale, Model model, HttpServletRequest request);
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request);
	
}
