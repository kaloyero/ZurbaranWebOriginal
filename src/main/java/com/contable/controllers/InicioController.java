package com.contable.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/inicio")
public class InicioController {
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  String  inicio(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

}
