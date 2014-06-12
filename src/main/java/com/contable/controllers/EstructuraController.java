package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroSaldoEstructura;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.EstructuraForm;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.Estructura;
import com.contable.manager.AdministracionManager;
import com.contable.manager.EstructuraManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/estructura")
public class EstructuraController extends ConfigurationControllerImpl<Estructura, EstructuraForm>{
	
	@Autowired
	private AdministracionManager administracionManager;
	
	@Autowired
	private EstructuraManager estructuraManager;

	
	@Override
	protected ConfigurationManager<Estructura, EstructuraForm> getRelatedManager() {
		return estructuraManager;
	}

	@Override
	protected List<String> getRowDataList(EstructuraForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getAdministracion().getNombre());
		row.add(formRow.getNombre());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));
		row.add("<a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");


		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showInit(Locale locale, Model model,
			HttpServletRequest request) {
		
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		model.addAttribute("Estructura", new EstructuraForm());

		model.addAttribute("administraciones", listadoAdministraciones);
		   return "configuraciones/estructura";
	}
	@RequestMapping(value = "/saldoEstructura", method = RequestMethod.GET)
	public String showSaldoEstructura(Locale locale, Model model,
			HttpServletRequest request) {
		
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList();
		List<ConfigBean> listadoEstructuras =estructuraManager.getConfigNameList();

		model.addAttribute("Estructura", new EstructuraForm());

		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("estructuras", listadoEstructuras);

		   return "listado/saldoEstructura";
	}
	@RequestMapping(value = "/saldoEstructuraMovimiento", method = RequestMethod.GET)
	public String showSaldoEstructuraMovimiento(Locale locale, Model model,
			HttpServletRequest request) {
		
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList();
		List<ConfigBean> listadoEstructuras =estructuraManager.getConfigNameList();

		model.addAttribute("Estructura", new EstructuraForm());

		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("estructuras", listadoEstructuras);

		   return "listado/saldoEstructuraMovimiento";
	}
	
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		EstructuraForm estructura =estructuraManager.findById(id);
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("Estructura", estructura);
	    return "configuraciones/editEstructura";
	}
	@RequestMapping(value = "/getSaldoEstructuraCuenta", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearchResumen(@RequestBody FiltroSaldoEstructura busqueda){
		
		List<EstructuraSaldoForm> listado = estructuraManager.getEstructuraSaldos(busqueda.getEstructuraId(), busqueda.getAdministracionId(),busqueda.getFecha());
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        
        	for (EstructuraSaldoForm formRow : listado) {
        		List <String> row =new ArrayList<String>();
        		row.add(formRow.getContenidoNombre());
        		row.add(formRow.getCuentaNombre());
        		row.add(formRow.getEntidadNombre());
        		row.add(formRow.getMonedaNombre());
        		row.add(formRow.getSaldo());
				dataTable.getAaData().add(row);
        	}
   
	    return dataTable;
	}

	@RequestMapping(value = "/getSaldoEstructuraMovimiento", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearchResumenMovimiento(@RequestBody FiltroSaldoEstructura busqueda){
		
		List<EstructuraSaldoForm> listado = estructuraManager.getEstructuraMovimientosSaldos(busqueda.getEstructuraId(), busqueda.getAdministracionId(), busqueda.getFechaDesde(), busqueda.getFecha());
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        
        	for (EstructuraSaldoForm formRow : listado) {
        		List <String> row =new ArrayList<String>();
        		if (! "MOV".equals(formRow.getCodigo())){
        			row.add(formRow.getContenidoNombre());
        			row.add(formRow.getCuentaNombre() + " " + formRow.getMonedaNombre() + " ( " + formRow.getMonedaCodigo() + " ) ");
        		} else {
        			row.add("");
        			row.add("");
        		}
        		row.add(formRow.getEntidadNombre());
        		if ("MOV".equals(formRow.getCodigo())){
	        		row.add(formRow.getDebito());
	        		row.add(formRow.getCredito());
        		} else {
	        		row.add("");
	        		row.add("");
        		}
        		row.add(formRow.getSaldo());
				dataTable.getAaData().add(row);
        	}
   
	    return dataTable;
	}

}
