package com.contable.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
	
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;

	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("index");

		return model;

	}
	
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}	
	
	
	@RequestMapping(value = "/credential", method = RequestMethod.GET)
	public  String  inicio(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public  String  defaultPage(Locale locale, Model model, HttpServletRequest request) {
	   return "login";
	}

	
//	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//	public String defaultPage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security + Hibernate Example");
//		model.addObject("message", "This is default page!");
//		model.setViewName("hello");
//		return "login";
//
//	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
//
//		ModelAndView model = new ModelAndView();
//		if (error != null) {
//			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
//		}
//
//		if (logout != null) {
//			model.addObject("msg", "You've been logged out successfully.");
//		}
//		model.setViewName("login");
//
//		return "index";
//
//	}
//
//	// customize the error message
//	private String getErrorMessage(HttpServletRequest request, String key) {
//
//		Exception exception = (Exception) request.getSession().getAttribute(key);
//
//		String error = "";
//		if (exception instanceof BadCredentialsException) {
//			error = "Invalid username and password!";
//		} else if (exception instanceof LockedException) {
//			error = exception.getMessage();
//		} else {
//			error = "Invalid username and password!";
//		}
//
//		return error;
//	}
//
//	// for 403 access denied page
//	@RequestMapping(value = "/403", method = RequestMethod.GET)
//	public String accesssDenied() {
//
//		ModelAndView model = new ModelAndView();
//
//		// check if user is login
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (!(auth instanceof AnonymousAuthenticationToken)) {
//			UserDetails userDetail = (UserDetails) auth.getPrincipal();
//			System.out.println(userDetail);
//
//			model.addObject("username", userDetail.getUsername());
//
//		}
//
//		model.setViewName("403");
//		return "login";
//
//	}
	
	
//	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//	public ModelAndView welcomePage() {
// 
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Custom Login Form");
//		model.addObject("message", "This is welcome page!");
//		model.setViewName("hello");
//		return model;
// 
//	}
 
//	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
//	public ModelAndView adminPage() {
// 
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Custom Login Form");
//		model.addObject("message", "This is protected page!");
//		model.setViewName("admin");
// 
//		return model;
// 
//	}
 
	//Spring Security see this :
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
//
//		ModelAndView model = new ModelAndView();
//		if (error != null) {
//			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
//		}
//
//		if (logout != null) {
//			model.addObject("msg", "You've been logged out successfully.");
//		}
//		model.setViewName("login");
//
//		return "index";
//
//	}
}
