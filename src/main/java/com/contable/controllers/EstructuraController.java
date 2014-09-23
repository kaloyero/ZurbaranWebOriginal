package com.contable.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
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
import com.contable.common.utils.FormatUtil;
import com.contable.form.EstructuraForm;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.DocumentoAplicaciones_V;
import com.contable.hibernate.model.Estructura;
import com.contable.manager.AdministracionManager;
import com.contable.manager.EstructuraManager;
import com.contable.manager.MonedaManager;
import com.contable.services.DocumentoMovimientoService;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/estructura")
public class EstructuraController extends ConfigurationControllerImpl<Estructura, EstructuraForm>{

	
	@Autowired
	private AdministracionManager administracionManager;
	
	@Autowired
	DocumentoMovimientoService documentoMovimientoService;
	
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
		List<ConfigBean> listadoMonedasEn = monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_BLANCO);

		
		model.addAttribute("monedasEN", listadoMonedasEn);
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
		
		List<EstructuraSaldoForm> listado = estructuraManager.getEstructuraSaldos(busqueda.getEstructuraId(), busqueda.getAdministracionId(),busqueda.getFecha(),busqueda.getMonedaMostrarId());
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();
        
        	for (EstructuraSaldoForm formRow : listado) {
        		List <String> row =new ArrayList<String>();
        		row.add(formRow.getContenidoNombre());
        		row.add(formRow.getCuentaNombre());
        		row.add(formRow.getEntidadNombre());
        		row.add(formRow.getMonedaNombre() + " (" + formRow.getMonedaCodigo() + ")");
        		// SALDO - Averigua si es menor a ZERO
        		row.add(FormatUtil.formatNegativeNumber(formRow.getSaldo()));
        		//Muestra En
        		row.add(formRow.getMonedaCodigoMuestra());
        		row.add(FormatUtil.formatNegativeNumber(formRow.getSaldoMuestra()));
				dataTable.getAaData().add(row);
        	}
   
	    return dataTable;
	}
	@RequestMapping(value = "/exporEx", method = RequestMethod.POST)
	public @ResponseBody String exporEx(@RequestBody FiltroSaldoEstructura busqueda) throws ParseException{
		List<EstructuraSaldoForm> listado = estructuraManager.getEstructuraMovimientosSaldos(busqueda.getEstructuraId(), busqueda.getAdministracionId(), busqueda.getFechaDesde(), busqueda.getFecha(), busqueda.getMonedaMostrarId());
		
		estructuraManager.exportPlanillaDiariExcel(listado, busqueda);
		return "OK";
		
	}
	
	@RequestMapping(value = "/getSaldoEstructuraMovimiento", method = RequestMethod.POST)
	public @ResponseBody DataTable getBySearchResumenMovimiento(@RequestBody FiltroSaldoEstructura busqueda){
		
		List<EstructuraSaldoForm> listado = estructuraManager.getEstructuraMovimientosSaldos(busqueda.getEstructuraId(), busqueda.getAdministracionId(), busqueda.getFechaDesde(), busqueda.getFecha(), busqueda.getMonedaMostrarId());

		
		/*Creacion DATATABLE*/ 
        DataTable dataTable=new DataTable();

        	for (EstructuraSaldoForm formRow : listado) {
        		
	        		List <String> row =new ArrayList<String>();
	        		//DOcumento Id
	        		if (formRow.getDocumentoId() != null && formRow.getDocumentoId() > 0){
	        			row.add(ConvertionUtil.StrValueOf(formRow.getDocumentoId()));
	        		} else {
	        			row.add("");
	        		}
	        		//
	        		//Codigo
	        		if ( Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	        			row.add("");
	        			row.add(formRow.getCuentaNombre());
	        			
	        		} else {
	        			//row.add(formRow.getContenidoNombre() + " [" + formRow.getCodigo() + " ]") ;
	        			row.add( "<b>" + formRow.getContenidoNombre() + "</b>") ;
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
	        			String importe = "0,00";
	        			if (Constants.ZERO.equals(formRow.getDebito())){
		        			//debito
//	        				row.add("-");
		        		} else {
		        			//debito
		        			importe = formRow.getDebito();	
		        		}
		        		if (Constants.ZERO.equals(formRow.getCredito())){
		        			//credito
//		        			row.add("-");
		        		} else {
		        			//credito
		        			importe = "(" + formRow.getCredito()+ ")";	
		        		}
		        		//Agrega IMPORTE
		        		row.add(importe);
	        		} else {
//		        		row.add("");
		        		row.add("");
	        		}
	        		// SALDO - Averigua si es menor a ZERO
	        		row.add(FormatUtil.formatNegativeNumber(formRow.getSaldo()));
	        		//EXPRESION EN MONEDA
	    			//moneda
	        		if (StringUtils.isBlank(formRow.getMonedaCodigoMuestra())){
	        			row.add("");
	        			row.add("");
	        			row.add("");
	        		} else {        		
		        		row.add(formRow.getMonedaCodigoMuestra());
		        		//IMPORTE
		        		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
		        			String importe = "0,00";
		        			if (Constants.ZERO.equals(formRow.getDebitoMuestra())){
			        			//debito
		        				//row.add("-");
			        		} else {
			        			//debito
			        			importe = formRow.getDebitoMuestra();	
			        		}
			        		if (Constants.ZERO.equals(formRow.getCreditoMuestra())){
			        			//credito
			        			//row.add("-");
			        		} else {
			        			//credito
			        			importe = "(" + formRow.getCreditoMuestra()+ ")";	
			        		}
			        		//Agrega IMPORTE
			        		row.add(importe);
		        		} else {
			        		row.add("");
		        		}
		        		// SALDO - Averigua si es menor a ZERO
		        		row.add(FormatUtil.formatNegativeNumber(formRow.getSaldoMuestra()));

	        		}
	        		
	        		//Documento y referencia o Saldo
	        		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	        			//DOCUMENTO
	        			row.add(formRow.getTipoDocumentoNombre() +  " " +"<a href='#' class='contView'>" + formRow.getDocumento() + "</a> ");
	        			row.add(formRow.getDocumentoDescripcion() + " " + formRow.getReferencia());
	        			//REFERENCIA
	        		} else if (Constants.ESTRUCTURA_MOV_SALDO_INICIAL.equals(formRow.getCodigo())){
	        			//SALDO
	        			row.add("<b>Saldo Inicial</b>");
	        			row.add("");
	        		} else if (Constants.ESTRUCTURA_MOV_SALDO_FINAL.equals(formRow.getCodigo())){
	        			//SALDO
	        			row.add("<b>Saldo Final</b>");
	        			row.add("");
	        		}

					dataTable.getAaData().add(row);
					
					/* AGREGA REGISTRO PARA DOCUMENTOS APLICADOS */
					if (formRow.isAplicacionesEnDocumento()){
						List<DocumentoAplicaciones_V> documentosAplicados= documentoMovimientoService.getCancelacionesByIdDoc(formRow.getDocumentoId());
						for (DocumentoAplicaciones_V docApl : documentosAplicados) {
							List <String> rowDocApp =new ArrayList<String>();
							rowDocApp.add(ConvertionUtil.StrValueOf(docApl.getDocumentoAplicaId()));
							rowDocApp.add("");rowDocApp.add("");
							rowDocApp.add("");rowDocApp.add("");
							rowDocApp.add("");rowDocApp.add("");
							rowDocApp.add("");rowDocApp.add("");
							rowDocApp.add("");rowDocApp.add("");
							rowDocApp.add(docApl.getTipoDocumentoAplicadoNombre() + " <a href='#' class='contView'>" + docApl.getNumeroFormateado() + "</a> ");
							rowDocApp.add(docApl.getDocumentoAplicaDescripcion());
							dataTable.getAaData().add(rowDocApp);
						}
					}
					
					
        		}
   
	    return dataTable;
	}

}
