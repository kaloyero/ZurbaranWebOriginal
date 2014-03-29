package com.contable.common;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.utils.DataTable;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public abstract class AbstractControllerImpl<E,F> implements AbstractController<E,F> { 

	/**
	 * Obtener el servicio
	 * @return
	 */
	protected abstract AbstractManager<E,F> getRelatedManager() ;

	/**
	 * Obtener el servicio
	 * @return
	 */
	protected abstract List <String> getRowDataList(F formRow) ;
	
	/**
	 * Toma el listado y devuelve un data table
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public @ResponseBody DataTable getList(Locale locale, Model model, HttpServletRequest request) {

		DataTable dataTable=getDataTableList(request);
		
		return dataTable;

	}
	
	protected DataTable getDataTableList(HttpServletRequest request){
		//Obtengo la lista de Administraciones
		String buscar 	= request.getParameter(DataTable.PARAM_S_SEARCH);
		Integer paginaIni 	= Integer.parseInt(request.getParameter(DataTable.PARAM_I_DISPLAY_START));
		Integer cantRegistros 	= Integer.parseInt(request.getParameter(DataTable.PARAM_I_DISPLAY_LENGTH));

		/*Listado */
		List<F> lista = getRelatedManager().getListaDataTable(paginaIni, cantRegistros, buscar, "id", true);
		
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
		for (F formRow : lista) {
			dataTable.getAaData().add(getRowDataList(formRow));
		}

		/* Actualización de Totales */
		Map<String,Integer> totales = getRelatedManager().getListaDateTableTotales(buscar);
		dataTable.setTotals(totales.get(GenericDao.VALUE_TOTAL_RECORDS), totales.get(GenericDao.VALUE_TOTAL_RECORDS_DISPLAY), 2);
  
        return dataTable;		
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@ModelAttribute(value = "Form") F form,BindingResult result, HttpServletRequest request) throws ParseException{
		getRelatedManager().guardarNuevo(form);		
		return "success";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Form") F form,BindingResult result, HttpServletRequest request) throws ParseException{
		getRelatedManager().update(form);
		return "success";
	}
	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.GET)
	public String changeStatus(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{		
		((ConfigurationManager<E, F>) getRelatedManager()).toggleStatus(id);
		return "success";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public  String  crear(Locale locale, Model model, HttpServletRequest request) {
	   return "index";
	}
	
}
