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
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.EstructuraForm;
import com.contable.form.ValorTerceForm;
import com.contable.manager.AdministracionManager;
import com.contable.manager.BancoManager;
import com.contable.manager.DocumentoTerceManager;
import com.contable.manager.MonedaManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tercero")
public class ValorTerceroController  {
	
	@Autowired
	private AdministracionManager administracionManager;
	@Autowired
	private BancoManager bancoManager;

	@Autowired
	private DocumentoTerceManager documentoTerceManager;
	@Autowired
	private MonedaManager monedaManager;

	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =administracionManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);

		List<ConfigBean> listadoBancos = bancoManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);

		
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("bancos", listadoBancos);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("Estructura", new EstructuraForm());
	   return "listado/terceros";
	}
	@RequestMapping(value = "/getBySearch", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearch(@RequestBody FiltroValTercerosBean busqueda){
		List<ValorTerceForm> listado = documentoTerceManager.buscarPorFiltros(busqueda, "id", true);
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();

        	for (ValorTerceForm formRow : listado) {
        		List <String> row =new ArrayList<String>();
        		row.add(ConvertionUtil.StrValueOf(formRow.getDocumentoId()));
        		row.add(formRow.getTipoDocumentoNombre());
        		row.add(formRow.getNumeroFormateado());
	    		row.add(formRow.getFechaVencimiento());
        		row.add(formRow.getCuentaNombre());
        		row.add(formRow.getTipoEntidadNombre());
        		if (formRow.getEntidadNombre()==null){
            		row.add("");
        		}else{
            		row.add(formRow.getEntidadNombre());
        		}
        		if (Constants.DOCUMENTO_ESTADO_ANULADO.equals(formRow.getEstado())){
            		row.add("Anulado");
        		}else{
        			row.add("");
        		}
        		row.add(formRow.getMonedaCodigo());
        		row.add(String.valueOf(formRow.getImporteValor()));
        		row.add("</a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");

				dataTable.getAaData().add(row);
        	}
   
	    return dataTable;
	}


}
