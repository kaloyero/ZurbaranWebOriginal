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

import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.utils.DataTable;
import org.springframework.expression.ParseException;

public abstract class AbstractControllerImpl<E,F> implements AbstractController<E,F> { 

	
	public static final String BOTON_LISTADO_EDITAR = "<a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>";
	public static final String BOTON_LISTADO_ELIMINAR = "<a href='#' class='contEliminar'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/delete.jpeg'></a>";
	//public static final String BOTON_LISTADO_CAMBIARESTADO = "<a href='#' class='contChange icono_listado glyphicons no-js edit' src='resources/images/change.jpeg'></a>";
	public static final String BOTON_LISTADO_CAMBIARESTADO = "<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a>";
	

	
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

		DataTable dataTable=constructorDataTable(request);
		
		return dataTable;

	}
	
	/**
	 * Metodo que construye el data Table
	 * 
	 * @param request
	 * @return
	 */
	protected DataTable constructorDataTable(HttpServletRequest request){
		//Obtengo la lista de Administraciones
		//String buscar 	= request.getParameter(DataTable.PARAM_S_SEARCH);
		//Integer paginaIni 	= Integer.parseInt(request.getParameter(DataTable.PARAM_I_DISPLAY_START));
		//Integer cantRegistros 	= Integer.parseInt(request.getParameter(DataTable.PARAM_I_DISPLAY_LENGTH));

		/*Listado */
		//List<F> lista = getDataTableListShow(paginaIni, cantRegistros, buscar, "id", true);
		//List<F> lista = getDataTableListShow(0, 5000, "", "id", true);
		List<F> lista = getDataTableListShow(0, 5000, "", "id", true);

		
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
		for (F formRow : lista) {
			dataTable.getAaData().add(getRowDataList(formRow));
		}

		/* Actualización de Totales */
		Map<String,Integer> totales = getDataTableTotalsShow("");
		dataTable.setTotals(totales.get(GenericDao.VALUE_TOTAL_RECORDS), totales.get(GenericDao.VALUE_TOTAL_RECORDS_DISPLAY), 2);
  
        return dataTable;		
	}
	
	/**
	 * Metodo que devuelve los registros que se van a mostrar
	 * 
	 * @param paginaIni
	 * @param cantRegistros
	 * @param buscar
	 * @param orderBy
	 * @param orderAsc
	 * @return
	 */
	protected List<F> getDataTableListShow(int paginaIni,int cantRegistros, String buscar, String orderBy, boolean orderAsc){
		return getRelatedManager().getLista();
	}
	
	/**
	 * Metodo que devuelve los totales que se van a mostrar
	 * 
	 * @param buscar
	 * @return
	 */
	protected Map<String,Integer> getDataTableTotalsShow(String buscar){
		return getRelatedManager().getListaDateTableTotales(buscar);
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody  ErrorRespuestaBean guardar(@ModelAttribute(value = "Form") F form,BindingResult result, HttpServletRequest request) throws ParseException{
		ErrorRespuestaBean respuesta=getRelatedManager().guardarNuevo(form);		
		return respuesta;
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
