package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.form.EstructuraForm;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/estructura")
public class EstructuraController extends ConfigurationControllerImpl<EstructuraForm, EstructuraForm>{
	
	@Override
	protected ConfigurationManager<EstructuraForm, EstructuraForm> getRelatedManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String> getRowDataList(EstructuraForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add("1");
		row.add("Codigo");
		row.add("Descripcion");		
		row.add("Agrupa/Detalla");

		return row;
	}

	
	public String showInit(Locale locale, Model model,
			HttpServletRequest request) {
			return null;
	}


}
