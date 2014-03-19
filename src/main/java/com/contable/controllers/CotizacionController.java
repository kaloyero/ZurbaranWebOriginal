package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.IConfigurationController;
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.DataTable;
import com.contable.form.ConceptoForm;
import com.contable.form.CotizacionForm;
import com.contable.manager.CotizacionManager;
import com.contable.manager.MonedaManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cotizacion")
public class CotizacionController  implements IConfigurationController<CotizacionForm>{
	
	@Autowired
	private CotizacionManager cotizacionManager;
	@Autowired
	private MonedaManager monedaManager;

	
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {
		
		List<CotizacionForm> lista = cotizacionManager.getLista();
		
        DataTable dataTable=new DataTable();
        
		for (CotizacionForm form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getMoneda().getNombre());
			row.add(form.getFecha());
			row.add(String.valueOf(form.getCotizacion()));
			row.add("<a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

			dataTable.getAaData().add(row);
		}
		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;


	}
	
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}

	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();

		model.addAttribute("Cotizacion", new CotizacionForm());
		model.addAttribute("monedas", listadoMonedas);
	   return "configuraciones/cotizacion";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") CotizacionForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		cotizacionManager.guardarNuevo((CotizacionForm) form);
		return "success";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") CotizacionForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		cotizacionManager.update((CotizacionForm) form);
		return "success";
	}
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)

	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		CotizacionForm cotizacion =cotizacionManager.findById(id);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();

		model.addAttribute("Cotizacion", cotizacion);
		model.addAttribute("monedas", listadoMonedas);

	
		return "configuraciones/editCotizacion";
	}
}
