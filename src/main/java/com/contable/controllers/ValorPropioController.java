package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DataTable;
import com.contable.common.utils.FormatUtil;
import com.contable.form.EstructuraForm;
import com.contable.form.ValorPropioForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.DocumentoPropioManager;
import com.contable.manager.MonedaManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/propio")
public class ValorPropioController {
	
	@Autowired
	private AdministracionManager administracionManager;

	@Autowired
	private DocumentoPropioManager documentoPropioManager;
	
	@Autowired
	private MonedaManager monedaManager;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);

		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("Estructura", new EstructuraForm());
	
	   return "listado/propio";
	}
	@RequestMapping(value = "/getBySearch", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearch(@RequestBody FiltroValPropiosBean busqueda){
		List<ValorPropioForm> listado = documentoPropioManager.buscarPorFiltros(busqueda, "id", true);
		
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
 
        	for (ValorPropioForm formRow : listado) {
        		List <String> row =new ArrayList<String>();
        		row.add(ConvertionUtil.StrValueOf(formRow.getDocumentoId()));
        		row.add(ConvertionUtil.StrValueOf(formRow.getNumero()));
        		row.add(formRow.getFechaIngreso());
        		row.add(formRow.getFechaVencimiento());
        		row.add(formRow.getTipoDocumentoNombre());
        		row.add("<a href='#' class='contView'>" + formRow.getDocumentoFormateado() + "</a> ");
        		if (formRow.getEntidadNombre()==null){
            		row.add(formRow.getCuentaNombre());
        		}else{
            		row.add(formRow.getCuentaNombre() + " / "+formRow.getEntidadNombre());
        		}
        		row.add(formRow.getMonedaCodigo());
        		row.add(FormatUtil.format2DecimalsStr(formRow.getImporteValor()));
        		if (Constants.DOCUMENTO_ESTADO_ANULADO.equals(formRow.getEstado())){
            		row.add("Anulado");
        		}else{
        			row.add("");
        		}
//        		row.add("</a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

				dataTable.getAaData().add(row);
        	}
   
	    return dataTable;
	}



}
