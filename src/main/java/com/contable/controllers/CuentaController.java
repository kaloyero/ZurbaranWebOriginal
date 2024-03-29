package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
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
import com.contable.common.utils.DocumentoUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.common.utils.SaldosUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.CuentaForm;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.manager.AdministracionManager;
import com.contable.manager.CotizacionManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.TipoEntidadManager;


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
	@Autowired
	private CotizacionManager cotizacionManager;

	
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

		row.add(BOTON_LISTADO_CAMBIARESTADO +
				BOTON_LISTADO_EDITAR +
				BOTON_LISTADO_ELIMINAR);

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
			 entidades=entidadManager.getConfigEntidadesListByTipoEntidad(cuenta.getTipoEntidad().getId(),Constants.CAMPO_EXTRA_TODAS);

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
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList(Constants.CAMPO_EXTRA_NINGUNO2);
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
		
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList(Constants.CAMPO_EXTRA_NINGUNO2);
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList();
		
		model.addAttribute("Cuenta",  cuenta);
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		
		return "configuraciones/editCuenta";
	}
	@RequestMapping(value = "/exporSaldoEx", method = RequestMethod.POST)
	public @ResponseBody String exporSaldoEx(@RequestBody FiltroCuentaBean busqueda) throws ParseException{
		
		cuentaManager.exportSaldoExcel(busqueda);
		return "OK";
		
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
        		row.add(FormatUtil.formatNegativeNumber(formRow.getSaldo()));
        		
        		row.add(FormatUtil.formatNegativeNumber(formRow.getTotalMostrar()));

				dataTable.getAaData().add(row);
        	}
   
	    return dataTable;
	}
	@RequestMapping(value = "/getBySearchSaldosCuentaForResumen", method = RequestMethod.POST)
	public @ResponseBody List getBySearchForResumen(@RequestBody FiltroCuentaBean busqueda){

		Double saldoIniNum = 0.0;
		Double saldoFinNum = 0.0;	
		Double saldoIniMostrarNum = 0.0;
		Double saldoFinMostrarNum = 0.0;
		
		String saldoIni = " - ";
		String saldoFin = " - ";
		String saldoIniMostrar = " - ";
		String saldoFinMostrar = " - ";
		if (StringUtils.isNotBlank(busqueda.getFechaDesde())){
			//Le resto un d�a a la fecha inicial
			String fechaDesde = DateUtil.sumarDias(busqueda.getFechaDesde(), -1);
			
			Map<String,Double> saldosInicial = cuentaManager.buscarSaldosCuentaParaResumen(busqueda, fechaDesde, "", true);
			saldoIniNum = saldosInicial.get(Constants.CUENTA_RESUMEN_SALDO);
			saldoIni = FormatUtil.format2DecimalsStr(saldoIniNum);
			
			saldoIniMostrarNum = saldosInicial.get(Constants.CUENTA_RESUMEN_SALDO_MONEDA_EN);
			saldoIniMostrar = FormatUtil.format2DecimalsStr(saldoIniMostrarNum);
		}
		Map<String,Double> saldosFinal = cuentaManager.buscarSaldosCuentaParaResumen(busqueda, busqueda.getFechaHasta(), "", true);
		saldoFinNum = saldosFinal.get(Constants.CUENTA_RESUMEN_SALDO);
		saldoFin = FormatUtil.format2DecimalsStr(saldoFinNum);
		
		saldoFinMostrarNum = saldosFinal.get(Constants.CUENTA_RESUMEN_SALDO_MONEDA_EN);
		saldoFinMostrar = FormatUtil.format2DecimalsStr(saldoFinMostrarNum);

		List <String> row =new ArrayList<String>();
		/*Creacion DATATABLE*/ 
        row.add(saldoIni);
        row.add(saldoFin);
        row.add(saldoIniMostrar);
        row.add(saldoFinMostrar);
   
	    return row;
	}
	@RequestMapping(value = "/exporResumenEx", method = RequestMethod.POST)
	public @ResponseBody String exporResumenEx(@RequestBody FiltroCuentaBean busqueda) throws ParseException{
		
		cuentaManager.exportResumenExcel(busqueda);
		return "OK";
		
	}


	@RequestMapping(value = "/getBySearchResumenCuenta", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearchResumen(@RequestBody FiltroCuentaBean busqueda){
		
		List<CuentaBusquedaForm> listado = cuentaManager.buscarResumenCuenta(busqueda);
		/*  Creacion DATATABLE  */ 
        DataTable dataTable=new DataTable();
        
        /*  Obtengo el Saldo Inicial   */
		Double saldoAcumulado = 0.0;
		Double saldoAcumuladoMonedaEn = 0.0;
		if (StringUtils.isNotBlank(busqueda.getFechaDesde())){
			//Le resto un d�a a la fecha inicial
			String fechaDesde = DateUtil.sumarDias(busqueda.getFechaDesde(), -1);
			Map<String,Double> saldos = cuentaManager.buscarSaldosCuentaParaResumen(busqueda, fechaDesde, "", true);
			
			saldoAcumulado = saldos.get(Constants.CUENTA_RESUMEN_SALDO);
			saldoAcumuladoMonedaEn= saldos.get(Constants.CUENTA_RESUMEN_SALDO_MONEDA_EN);
		}
		
		
        
    	for (CuentaBusquedaForm formRow : listado) {
    		List <String> row =new ArrayList<String>();
    		row.add(String.valueOf(formRow.getDocumentoId()));
    		row.add(formRow.getFechaIngreso());
    		row.add(formRow.getTipodocumentoNombre());
    		row.add("<a href='#' class='contView'>" + formRow.getNumeroFormateado() + "</a>"  );
    		row.add(formRow.getDocDescripcion());
    		row.add(formRow.getReferencia());
    		row.add(formRow.getCuentaNombre());
    		//row.add(formRow.getTipoEntidadNombre());
    		row.add(formRow.getEntidadNombre());
    		//Devuelvo el estado
    		row.add(DocumentoUtil.getResumenCuentaEstado(formRow.getEstado(), formRow.getDocumentoAnuladoPorId(), formRow.getDocumentoAnulaaId()));
    		row.add(formRow.getMonedaCodigo());
    		/*SALDO*/
    		//Debito - credito
    		row.add(SaldosUtil.getImporte(formRow.getDebito(),formRow.getCredito()));
    		//saldo acumulado
    		saldoAcumulado = SaldosUtil.sumar(saldoAcumulado, formRow.getDebito(), formRow.getCredito());
    		row.add(FormatUtil.formatNegativeNumber(FormatUtil.format2DecimalsStr( saldoAcumulado )));
    		/* SALDO Mostrar En Moneda*/
    		if (busqueda.getMonedaMuestraId() == null){
    			row.add("");
    			//Cotizacion
    			row.add("");
    			//Debito - credito
        		row.add("");
        		//saldo acumulado
        		row.add("");
    		} else {
    			row.add(formRow.getMonedaMostrarCodigo());
    			//Cotizacion
    			row.add(FormatUtil.format2DecimalsStr( formRow.getCotizacion()));
    			//Debito - credito
    			row.add(SaldosUtil.getImporte(formRow.getDebitoMostrar(),formRow.getCreditoMostrar()));
        		//saldo acumulado
        		saldoAcumuladoMonedaEn = SaldosUtil.sumar(saldoAcumuladoMonedaEn, formRow.getDebitoMostrar(), formRow.getCreditoMostrar());
        		row.add(FormatUtil.formatNegativeNumber(FormatUtil.format2DecimalsStr( saldoAcumuladoMonedaEn )));
    		}
    		

    		
    		
    		dataTable.getAaData().add(row);
    	}
   
	    return dataTable;
	}
	
	private Double mostrarImporteEnMoneda (int monedaActual, int monedaAConvertir ,Double importe){
		return cotizacionManager.mostrarCotizacionEnmoneda(monedaActual, monedaAConvertir ,importe);
	}
	

	
}
