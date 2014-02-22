package com.contable.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.utils.DataTable;

/**
 * Interface para controladores de Configuracion
 * 
 * @author kaloye
 *
 */
public interface IConfigurationController {

	/**
	 * Toma el listado y devuelve un data table
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request);

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
