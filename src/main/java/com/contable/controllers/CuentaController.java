package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.DataTable;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.CuentaForm;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.manager.AdministracionManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.TipoEntidadManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cuenta")
public class CuentaController  extends ConfigurationControllerImpl<Cuenta, CuentaForm>{

	@Autowired
	private CuentaManager cuentaManager;
	@Autowired
	private AdministracionManager adminManager;
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private MonedaManager monedaManager;

	
	@Override
	protected ConfigurationManager<Cuenta, CuentaForm> getRelatedManager() {
		return cuentaManager;
	}
	@Override
	protected List<String> getRowDataList(CuentaForm formRow) {

		List <String> row =new ArrayList<String>();
		row.add(String.valueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getAdministracion().getNombre()));
		row.add(formRow.getNombre());
		row.add(formRow.getCodigo());
		if (formRow.getTipoEntidad()!=null){
			row.add(formRow.getTipoEntidad().getNombre());

		}else{
			row.add("");
		}
		
		row.add(ControllerUtil.getSaldoDescripcion(formRow.getSaldo()));
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));

		row.add("<a href='#' class='contChange'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/change.jpeg'></a><a href='#' class='contView'><img style='width:20px;height:20;display:inline;float:right;margin-top:0.1cm;' src='resources/images/view.jpg'></a>");
		return row;
	}

	@RequestMapping(value = "/listByAdminId/{id}", method = RequestMethod.GET)
	public @ResponseBody DataTable getListByAdmin(ModelMap model,@PathVariable int id, HttpServletRequest request) {
	
		
		List<ConfigBean> lista = cuentaManager.getConfigNameListByAdm(id);
        DataTable dataTable=new DataTable();
        
		for (ConfigBean form : lista) {
			List <String> row =new ArrayList<String>();
			row.add(String.valueOf(form.getId()));
			row.add(form.getNombre());
			dataTable.getAaData().add(row);
		}
		
		dataTable.setTotals(lista.size(), lista.size(), 1);  
        return dataTable;

	}
	
	@RequestMapping(value = "/getDataForConcepto/{id}", method = RequestMethod.GET)
	public @ResponseBody DataTable getDataForConcepto(ModelMap model,@PathVariable int id, HttpServletRequest request) {
	
		
		CuentaForm cuenta = cuentaManager.findById(id);
		DataTable dataTable=new DataTable();
		List  row =new ArrayList();
		List<ConfigBean> entidades=null;
		if (cuenta.getTipoEntidad().getId() != null){
			 entidades=entidadManager.getConfigEntidadesListByTipoEntidad(cuenta.getTipoEntidad().getId(),Constants.CAMPO_EXTRA_BLANCO);

			row.add(cuenta);
			row.add(entidades);
			
		}else{
			row.add(cuenta);
			row.add(entidades);
		}
		List<ConfigBean> monedas=cuentaManager.getMonedasConfigByCuenta(cuenta.getId());
		row.add(monedas);


		dataTable.getAaData().add(row);
		return dataTable;
		
	}
	@RequestMapping(value = "/getMonedaByCuenta/{id}", method = RequestMethod.GET)
	public @ResponseBody List<ConfigBean> getMonedaByCuenta(ModelMap model,@PathVariable int id, HttpServletRequest request) {
		
		List<ConfigBean> monedas = cuentaManager.getMonedasConfigByCuenta(id);
		return monedas;
		
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList(TipoEntidadManager.CAMPO_BLANCO);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		//Obtiene el listado de monedas para <TOdas las administraciones>
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameListByAdm(Constants.UI_ADM_VALUE_TODAS);
		
		model.addAttribute("Cuenta", new CuentaForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);

	   return "configuraciones/cuenta";
	}
	@RequestMapping(value = "/resumenCuenta", method = RequestMethod.GET)
	public  String  resumenCuenta(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();

		
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);

		model.addAttribute("Estructura", new EstructuraForm());

	   return "listado/resumenCuenta";
	}
	@RequestMapping(value = "/saldoCuenta", method = RequestMethod.GET)
	public  String  saldoCuenta(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList();
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);
		List<ConfigBean> listadoMonedasEn =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_BLANCO);
		
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("monedasEN", listadoMonedasEn);

		model.addAttribute("Estructura", new EstructuraForm());
		
	   return "listado/saldoCuenta";
	}
	
	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		CuentaForm cuenta =cuentaManager.findById(id);
		
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList(TipoEntidadManager.CAMPO_BLANCO);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		
		model.addAttribute("Cuenta",  cuenta);
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		
		return "configuraciones/editCuenta";
	}
	@RequestMapping(value = "/getBySearchSaldosCuenta", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearch(@RequestBody FiltroCuentaBean busqueda){
		
		List<CuentaBusquedaForm> listado = cuentaManager.buscarSaldosCuenta(busqueda, busqueda.getFechaDesde(), "", true);
		
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        
        	for (CuentaBusquedaForm formRow : listado) {
        		List <String> row =new ArrayList<String>();
        		row.add(formRow.getCuentaNombre());
        		row.add(formRow.getEntidadNombre());
        		row.add(formRow.getMonedaCodigo());
        		row.add(formRow.getSaldo());
        		
        		row.add(formRow.getTotalMostrar());

				dataTable.getAaData().add(row);
        	}
   
	    return dataTable;
	}
	@RequestMapping(value = "/getBySearchSaldosCuentaForResumen", method = RequestMethod.POST)
	public @ResponseBody List getBySearchForResumen(@RequestBody FiltroCuentaBean busqueda){

		String saldoIni = " - ";
		if (StringUtils.isNotBlank(busqueda.getFechaDesde())){
			//Le resto un día a la fecha inicial
			String fechaDesde = DateUtil.sumarDias(busqueda.getFechaDesde(), -1);
			saldoIni = FormatUtil.format2DecimalsStr(cuentaManager.buscarSaldosCuentaParaResumen(busqueda, fechaDesde, "", true));
		}
		String saldoFin = FormatUtil.format2DecimalsStr(cuentaManager.buscarSaldosCuentaParaResumen(busqueda, busqueda.getFechaHasta(), "", true));
		
		List <String> row =new ArrayList<String>();
		/*Creacion DATATABLE*/ 
        row.add(saldoIni);
        row.add(saldoFin);
        
       
   
	    return row;
	}
	@RequestMapping(value = "/getBySearchResumenCuenta", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearchResumen(@RequestBody FiltroCuentaBean busqueda){
		
		List<CuentaBusquedaForm> listado = cuentaManager.buscarResumenCuenta(busqueda);
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        
        	for (CuentaBusquedaForm formRow : listado) {
        		List <String> row =new ArrayList<String>();
        		row.add(String.valueOf(formRow.getDocumentoId()));
        		row.add(formRow.getFechaIngreso());
        		row.add(formRow.getTipodocumentoNombre());
        		row.add("<a href='#' class='contView'>" + formRow.getNumeroFormateado() + "</a>"  );
        		row.add(formRow.getDocDescripcion());
        		row.add(formRow.getCuentaNombre());
        		row.add(formRow.getTipoEntidadNombre());
        		row.add(formRow.getEntidadNombre());
        		row.add(formRow.getMonedaCodigo());
        		row.add(formRow.getDebito());
        		row.add(formRow.getCredito());

				dataTable.getAaData().add(row);
        	}
   
	    return dataTable;
	}
	

}
