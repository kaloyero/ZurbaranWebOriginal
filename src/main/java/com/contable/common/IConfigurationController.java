package com.contable.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.utils.DataTable;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Interface para controladores de Configuracion
 * 
 * @author kaloye
 *
 */
public interface IConfigurationController<F> {

	/**
	 * Toma el listado y devuelve un data table
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
//	@RequestMapping(value = "/lista", method = RequestMethod.GET)
//	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request);

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
	
	
	/**
	 * Metodo que guarda
	 * 
	 * @param form
	 * @param result
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public  String  guardar(@ModelAttribute(value = "Form") F form,BindingResult result, HttpServletRequest request) throws ParseException;	

	/**
	 * @param form
	 * @param result
	 * @param request
	 * @return
	 * @throws ParseExceptionñ
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") F form,BindingResult result, HttpServletRequest request) throws ParseException;	

	
	/**
	 * 
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request);
	
}
