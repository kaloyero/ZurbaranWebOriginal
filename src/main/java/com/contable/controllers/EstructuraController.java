package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
import com.contable.common.constants.Constants;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DataTable;
import com.contable.form.EstructuraForm;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.Estructura;
import com.contable.manager.AdministracionManager;
import com.contable.manager.EstructuraManager;
import com.contable.manager.MonedaManager;
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

	@Autowired
	private MonedaManager monedaManager;

	
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
		List<ConfigBean> listadoMonedasEn = monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_BLANCO);

		
		model.addAttribute("monedasEN", listadoMonedasEn);
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
		
		List<EstructuraSaldoForm> listado = estructuraManager.getEstructuraMovimientosSaldos(busqueda.getEstructuraId(), busqueda.getAdministracionId(), busqueda.getFechaDesde(), busqueda.getFecha(), busqueda.getMonedaMostrarId());
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        int contador = 0;

        
        	for (EstructuraSaldoForm formRow : listado) {
        		
        		/*	FILTRO sin SALDOS */
        		if ( ( busqueda.isSinSaldos() && Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo()) ) || busqueda.isSinSaldos()==false ){
        		
	        		contador++;
	        		List <String> row =new ArrayList<String>();
	        		row.add(ConvertionUtil.StrValueOf(contador));
	        		if ( Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	        			row.add("");
	        			row.add(formRow.getCuentaNombre());
	        			
	        		} else {
	        			row.add(formRow.getContenidoNombre() + " [" + formRow.getCodigo() + " ]") ;
	        			//row.add(formRow.getContenidoNombre() ) ;
	        			if (StringUtils.isBlank(formRow.getCuentaNombre() )){
	        				row.add(" ( " + formRow.getMonedaCodigo() + " ) ");
	        			} else {
	        				row.add(formRow.getCuentaNombre() + " ( " + formRow.getMonedaCodigo() + " ) ");	
	        			}
	        		}
	        		row.add(formRow.getEntidadNombre());
	        		
	        		//fecha / Si es saldo INI o saldo FIN. Muestro las fechas de búsqueda
	        		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	        			row.add(formRow.getFecha());	
	        		} else if (Constants.ESTRUCTURA_MOV_SALDO_INICIAL.equals(formRow.getCodigo())){
	        			row.add(busqueda.getFechaDesde());
	        		} else if (Constants.ESTRUCTURA_MOV_SALDO_FINAL.equals(formRow.getCodigo())){
	        			row.add(busqueda.getFecha());
	        		}
	        		
	        		// MONEDA DEL MOVIMIENTO
	        		//moneda
	    			row.add(formRow.getMonedaCodigo());
	        		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	        			if ("0.00".equals(formRow.getDebito())){
		        			//debito
	        				//row.add("-");
		        		} else {
		        			//debito
		        			row.add(formRow.getDebito());	
		        		}
		        		if ("0.00".equals(formRow.getCredito())){
		        			//credito
		        			//row.add("-");
		        		} else {
		        			//credito
		        			row.add("(" + formRow.getCredito()+ ")");	
		        		}
	        		} else {
		        		row.add("");
	        		}
	        		row.add(formRow.getSaldo());
	        		//EXPRESION EN MONEDA
	    			//moneda
	        		if (StringUtils.isBlank(formRow.getMonedaCodigoMuestra())){
	        			row.add("");
	        			row.add("");
	        			row.add("");
	        		} else {        		
		        		row.add(formRow.getMonedaCodigoMuestra());
		        		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
		        			if ("0.00".equals(formRow.getDebitoMuestra())){
			        			//debito
		        				//row.add("-");
			        		} else {
			        			//debito
			        			row.add(formRow.getDebitoMuestra());	
			        		}
			        		if ("0.00".equals(formRow.getCreditoMuestra())){
			        			//credito
			        			//row.add("-");
			        		} else {
			        			//credito
			        			row.add("(" + formRow.getCreditoMuestra()+ ")");	
			        		}
		        		} else {
			        		row.add("");
		        		}
		        		row.add(formRow.getSaldoMuestra());
	        		}
	        		
	        		//Documento o Saldo
	        		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	        			row.add(formRow.getDocumento());	
	        		} else if (Constants.ESTRUCTURA_MOV_SALDO_INICIAL.equals(formRow.getCodigo())){
	        			row.add("Saldo Inicial");
	        		} else if (Constants.ESTRUCTURA_MOV_SALDO_FINAL.equals(formRow.getCodigo())){
	        			row.add("Saldo Final");
	        		}
	        		
					dataTable.getAaData().add(row);
        		}
        	}
   
	    return dataTable;
	}

}
