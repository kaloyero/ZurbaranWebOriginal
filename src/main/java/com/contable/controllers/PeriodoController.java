package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.AbstractControllerImpl;
import com.contable.common.AbstractManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Periodo;
import com.contable.manager.AdministracionManager;
import com.contable.manager.PeriodoManager;
import org.springframework.expression.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/periodo")
public class PeriodoController  extends AbstractControllerImpl<Periodo, PeriodoForm>{
	
	@Autowired
	private PeriodoManager periodoManager;
	
	@Autowired
	private AdministracionManager adminManager;

	@Override
	protected AbstractManager<Periodo, PeriodoForm> getRelatedManager() {
		return periodoManager;
	}

	@Override
	protected List<String> getRowDataList(PeriodoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getAdministracion().getNombre());
		row.add(formRow.getFechaIni());
		row.add(formRow.getFechaFin());
		row.add("<a href='#' class='contDelete'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/delete.jpeg'></a>");

		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList();

		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("periodo", new PeriodoForm());

	   return "configuraciones/periodo";
	}
	
	@RequestMapping(value = "/getFechaInicialbyAdmin/{id}", method = RequestMethod.GET)
	public @ResponseBody String getFechaInicialbyAdmin(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		String fecha =periodoManager.getFechaPeriodoInicial(id);
		return fecha;
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		PeriodoForm periodo = periodoManager.findById(id);

		model.addAttribute("periodo", periodo);
	
		return "configuraciones/editPeriodo";
	}


}
