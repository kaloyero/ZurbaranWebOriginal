package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.CotizacionForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.manager.CotizacionManager;
import com.contable.manager.MonedaManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cotizacion")
public class CotizacionController  extends ConfigurationControllerImpl<Cotizacion, CotizacionForm>{
	
	@Autowired
	private CotizacionManager cotizacionManager;
	@Autowired
	private MonedaManager monedaManager;

	@Override
	protected ConfigurationManager<Cotizacion, CotizacionForm> getRelatedManager() {
		return cotizacionManager;
	}

	@Override
	protected List<String> getRowDataList(CotizacionForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getMoneda().getNombre());
		row.add(formRow.getFecha());
		row.add(FormatUtil.format2DecimalsStr(formRow.getCotizacion()));

		row.add("<a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();

		model.addAttribute("Cotizacion", new CotizacionForm());
		model.addAttribute("monedas", listadoMonedas);
	   return "configuraciones/cotizacion";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		CotizacionForm cotizacion =cotizacionManager.findById(id);
		//Actualizo la fecha Actual
		cotizacion.setFecha(DateUtil.getStringToday());
		
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();

		model.addAttribute("Cotizacion", cotizacion);
		model.addAttribute("monedas", listadoMonedas);

	
		return "configuraciones/editCotizacion";
	}
	@RequestMapping(value = "/getHistorico/{id}", method = RequestMethod.GET)
	public  @ResponseBody List<CotizacionForm> getHistorico(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		CotizacionForm cotizacion =cotizacionManager.findById(id);
		//Actualizo la fecha Actual
		List<CotizacionForm> form=cotizacionManager.obtenerHistoricoCotizacion(id, DateUtil.getStringToday(), DateUtil.convertDateToString(DateUtil.sumarMeses(DateUtil.getStringToday(), -12)));
		


	
		return form;
	}


}
