package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.beans.FiltroSaldoEstructura;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.excel.WritePlantillaDiariaExcel;
import com.contable.common.excel.WriteSaldoEstructuraExcel;
import com.contable.common.utils.CalculosUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.CotizacionForm;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.EstructuraForm;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.hibernate.model.DocumentoAplicaciones_V;
import com.contable.hibernate.model.Estructura;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.hibernate.model.EstructuraContenidoCuenta;
import com.contable.hibernate.model.Moneda;
import com.contable.manager.CotizacionManager;
import com.contable.manager.EstructuraManager;
import com.contable.mappers.EstructuraMapper;
import com.contable.services.AdministracionService;
import com.contable.services.CotizacionService;
import com.contable.services.CuentaService;
import com.contable.services.DocumentoMovimientoService;
import com.contable.services.EstructuraContenidoService;
import com.contable.services.EstructuraService;
import com.contable.services.MonedaService;

@Service("estructuraManager")
public class EstructuraManagerImpl extends ConfigurationManagerImpl<Estructura,EstructuraForm> implements EstructuraManager{

	@Autowired
	AdministracionService administracionService;
	
	@Autowired
	MonedaService monedaService;
	
	@Autowired
	EstructuraService estructuraService;

	@Autowired
	DocumentoMovimientoService documentoMovimientoService;

	@Autowired
	CuentaService cuentaService;

	@Autowired
	EstructuraContenidoService estructuraContenidoService;

	@Autowired
	CotizacionManager cotizacionManager;

	@Autowired
	CotizacionService cotizacionService;

	@Override
	protected AbstractService<Estructura> getRelatedService() {
		return estructuraService;
	}

	@Override
	protected Mapper<Estructura,EstructuraForm> getMapper() {
		return new EstructuraMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

	
	
// CODIGO VIEEEJOOOO	
//	public List<EstructuraSaldoForm> getEstructuraSaldos (int idEstructura, int idAdministracion,String fecha, Integer monedaMostrarId){
//		//Si la fecha viene vac�a devuelve un listado vacio
//		if (StringUtils.isBlank(fecha)){
//			return new ArrayList<EstructuraSaldoForm>(); 
//		}
//		
//		List<EstructuraSaldoForm> saldosEstructura = new ArrayList<EstructuraSaldoForm>();
//		
//		Estructura estructura = estructuraService.findById(idEstructura);
//		
//		if (idEstructura <1 || idAdministracion < 1 ){
//			return saldosEstructura;
//		}
//		
//		//Contenidos - Ordeno los contenidos seg�n el orden de alta
//		List<EstructuraContenido> contenidos = ordenarContenidos(estructura.getContenidos());
//		for (EstructuraContenido contenido : contenidos) {
//			List<CuentaBusquedaForm> listaSaldos = new ArrayList<CuentaBusquedaForm>();
//			
//			//Contenido Cuentas - Ordeno las cuentas seg�n el orden de alta
//			List<EstructuraContenidoCuenta> contenidoCuentas = ordenarContenidoCuentas(contenido.getCuentas());
//			
//			for (EstructuraContenidoCuenta conteCuenta : contenidoCuentas) {
//				String entidad = null;
//				if (conteCuenta.getEntidad() != null)
//					entidad = ConvertionUtil.StrValueOf(conteCuenta.getEntidad().getId());
//				
//				//Por cada cuenta consulto y agrego a lista de saldos
//				listaSaldos.addAll(getListadoPorContenidoCuenta(fecha, contenido.getModo(), idAdministracion, conteCuenta.getCuenta().getId(), entidad, conteCuenta.getMoneda().getId(),monedaMostrarId));
//			}
//			if (Constants.ESTRUCTURA_AGRUPA.equals(contenido.getModo())){
//				/* Obtengo saldos */
//				HashMap<Integer, EstructuraSaldoForm> saldos = getSaldosAgrupadosPorMonedas(listaSaldos, Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO,contenido.getCodigo());
//				/*Agrego los Saldos Iniciales al listado que voy a mostrar */ 
//				for (Integer key : saldos.keySet()) {
//					saldosEstructura.add(saldos.get(key));
//				}
//
//				
//				
//			} else if (Constants.ESTRUCTURA_DETALLA.equals(contenido.getModo())){
//				for (CuentaBusquedaForm cuentaBusquedaForm : listaSaldos) {
//					saldosEstructura.add( getEstructuraSaldoForm(cuentaBusquedaForm, Constants.ESTRUCTURA_MOV_SALDO_INICIAL ,contenido.getCodigo(),true));
//					
//				}
//			}
//		}
//
//		//Actualiza los valores de Mostrar en moneda.
////		muestraEnMoneda(saldosEstructura, monedaMostrarId,false);
//		
//		//Actualiza el codigo de la moneda q muestra
//		if (monedaMostrarId != null && monedaMostrarId > 1){
//
//			//Obtengo Moneda Local
//			Moneda monedaMostrar = monedaService.findById(monedaMostrarId); 
//			String codigoMonedaMostrarEn =monedaMostrar.getCodigo(); 
//			for (EstructuraSaldoForm saldo : saldosEstructura) {
//				saldo.setCodigo(codigoMonedaMostrarEn);
//			}
//			
//		}
//			
//		
//		return saldosEstructura;
//		
//	}

	@Transactional
	public List<EstructuraSaldoForm> getEstructuraSaldos (int idEstructura, int idAdministracion,String fecha, Integer monedaMostrarId){
		//Si la fecha viene vac�a devuelve un listado vacio
		if (StringUtils.isBlank(fecha)){
			return new ArrayList<EstructuraSaldoForm>(); 
		}
		
		List<EstructuraSaldoForm> saldosEstructura = estructuraService.getEstructuraSaldos(idEstructura, idAdministracion, fecha, monedaMostrarId);
		
		//Actualiza el codigo de la moneda q muestra
		if (monedaMostrarId != null && monedaMostrarId > 1){

			//Obtengo Moneda Local
			Moneda monedaMostrar = monedaService.findById(monedaMostrarId); 
			String codigoMonedaMostrarEn =monedaMostrar.getCodigo(); 
			for (EstructuraSaldoForm saldo : saldosEstructura) {
				saldo.setCodigo(codigoMonedaMostrarEn);
			}
			
		}
			
		
		return saldosEstructura;
		
	}
	
	private List<EstructuraContenido> ordenarContenidos(Collection<EstructuraContenido> contenidos){
		
		List<EstructuraContenido> list = new ArrayList<EstructuraContenido>(contenidos);
		
		Collections.sort(list, new Comparator<EstructuraContenido>(){
			 
			public int compare(EstructuraContenido o1, EstructuraContenido o2) {
				return new Integer(o1.getId()).compareTo(new Integer(o2.getId()));
			}
		});
		
		return list;
	}

	private List<EstructuraContenidoCuenta> ordenarContenidoCuentas(Collection<EstructuraContenidoCuenta> contenidoCuentas){
		
		List<EstructuraContenidoCuenta> list = new ArrayList<EstructuraContenidoCuenta>(contenidoCuentas);
		
		Collections.sort(list, new Comparator<EstructuraContenidoCuenta>(){
			 
			public int compare(EstructuraContenidoCuenta o1, EstructuraContenidoCuenta o2) {
				return new Integer(o1.getId()).compareTo(new Integer(o2.getId()));
			}
		});
		
		return list;
	}

	/**
	 * @param muestrafechaMovimiento Si es true, quiere decir que va a buscar la cotizaci�n por la fecha del movimiento. 
	 * 								 Si es false, utilizar� la cotizaci�n de la fecha actual 
	 */
	public List<EstructuraSaldoForm> getEstructuraMovimientosSaldos (int idEstructura, int idAdministracion,String fechaInicial,String fechaFinal, Integer monedaMostrarId, boolean muestrafechaMovimiento){
		/* Inicialiso lista que voy a retornar */
		List<EstructuraSaldoForm> saldosEstructura = new ArrayList<EstructuraSaldoForm>();
		
		/* Obtengo la estructura que voy a mostrar */
		Estructura estructura = estructuraService.findById(idEstructura);
		
		/* VALIDACIONES
		 * Si el numero de estructura o la administraci�n es < a 1
		 * Si ALGUNA fecha viene vac�a 
		 * devuelve un listado vacio
		 */
		if (idEstructura <1 || idAdministracion < 1 
				|| StringUtils.isBlank(fechaInicial) || StringUtils.isBlank(fechaFinal)){
			return saldosEstructura;
		}
		
		/* le resto un d�a a la fecha inicial */
		String fechaSaldoInicial = DateUtil.sumarDias(fechaInicial, -1);
		
		
		
		/* Comienza a iterar la estructura */
		//Contenidos - Ordeno los contenidos seg�n el orden de alta
		List<EstructuraContenido> contenidos = ordenarContenidos(estructura.getContenidos());
		for (EstructuraContenido contenido : contenidos) {
			List<CuentaBusquedaForm> listaSaldoInicial = new ArrayList<CuentaBusquedaForm>();
			List<CuentaBusquedaForm> listaSaldoFinal = new ArrayList<CuentaBusquedaForm>();
			List<CuentaBusquedaForm> listaResumen = new ArrayList<CuentaBusquedaForm>();

			
			//Contenido Cuentas - Ordeno las cuentas seg�n el orden de alta
			List<EstructuraContenidoCuenta> contenidoCuentas = ordenarContenidoCuentas(contenido.getCuentas());
			
			for (EstructuraContenidoCuenta conteCuenta : contenidoCuentas) {
				String entidad = null;
				if (conteCuenta.getEntidad() != null)
					entidad = ConvertionUtil.StrValueOf(conteCuenta.getEntidad().getId());
				
				/* Saldos Ini */
				listaSaldoInicial.addAll(getListadoPorContenidoCuenta(fechaSaldoInicial, contenido.getModo(), idAdministracion, conteCuenta.getCuenta().getId(), entidad, conteCuenta.getMoneda().getId(),null));
				/* Saldos Fin */
				listaSaldoFinal.addAll(getListadoPorContenidoCuenta(fechaFinal, contenido.getModo(), idAdministracion, conteCuenta.getCuenta().getId(), entidad, conteCuenta.getMoneda().getId(),null));
				
				/* Obtengo Lista de resumen Movimientos*/
				FiltroCuentaBean filtros = new FiltroCuentaBean(idAdministracion, fechaInicial, fechaFinal, conteCuenta.getCuenta().getId(), entidad, conteCuenta.getMoneda().getId());
				listaResumen.addAll(cuentaService.buscarResumenPorFiltros(filtros,"FechaIngreso",true));
			}
			/* AGRUPA */
			if (Constants.ESTRUCTURA_AGRUPA.equals(contenido.getModo())){
				/* Obtengo saldos Iniciales */
				HashMap<Integer, EstructuraSaldoForm> saldosIni = getSaldosAgrupadosPorMonedas(listaSaldoInicial, Constants.ESTRUCTURA_MOV_SALDO_INICIAL ,contenido.getCodigo());
				/* Obtengo saldos Finales */
				HashMap<Integer, EstructuraSaldoForm> saldosFin = getSaldosAgrupadosPorMonedas(listaSaldoFinal, Constants.ESTRUCTURA_MOV_SALDO_FINAL ,contenido.getCodigo());

				//Agrego los saldos iniciales que faltan
				mergeSaldoInicialConFinal(saldosIni, saldosFin);
				
				/*Agrego los Saldos Iniciales al listado que voy a mostrar con los movimientos */ 
				for (Integer key : saldosIni.keySet()) {
					//Inicializo el saldo acumulado
					Double saldoAcum = ConvertionUtil.DouValueOf(saldosIni.get(key).getSaldo());
					/* Agrego saldo Inicial */
					saldosEstructura.add(saldosIni.get(key));
					/* obtengo los movimientos por saldos*/
					for (CuentaBusquedaForm mov : listaResumen) {
						if (key.equals(mov.getMonedaId())) {
							EstructuraSaldoForm form = getEstructuraSaldoForm(mov, Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO,"",false);
							//calculo el saldo acumulado
							saldoAcum = calculaSaldoAcumulado(saldoAcum, form.getDebito(), form.getCredito());
							//seteo el saldo Acumulado
							form.setSaldo(FormatUtil.format2DecimalsStr(saldoAcum));
							saldosEstructura.add(form);
						}
					}
					/* Agrego saldo Final */
					saldosEstructura.add(saldosFin.get(key));
				}
				
			/* DETALLA */
			} else if (Constants.ESTRUCTURA_DETALLA.equals(contenido.getModo())){
				HashMap<String, EstructuraSaldoForm> saldosFin = new HashMap<String, EstructuraSaldoForm>();
				/* Saldo Final */
				for (CuentaBusquedaForm saldo : listaSaldoFinal) {
					String clave = generaClave(saldo.getCuentaId(), saldo.getEntidadId(), saldo.getMonedaId());
					saldosFin.put(clave, getEstructuraSaldoForm(saldo,Constants.ESTRUCTURA_MOV_SALDO_FINAL, contenido.getCodigo(),true));
				}

				//Agrego los saldos iniciales que faltan
				mergeSaldoInicialConFinal(listaSaldoInicial, listaSaldoFinal);
				
				/* Saldo Inicial */
				for (CuentaBusquedaForm saldo : listaSaldoInicial) {
					//Inicializo el saldo acumulado
					Double saldoAcum = ConvertionUtil.DouValueOf(saldo.getSaldo());
					//agrego el saldo inicial
					saldosEstructura.add( getEstructuraSaldoForm(saldo, Constants.ESTRUCTURA_MOV_SALDO_INICIAL,contenido.getCodigo(),true));
					for (CuentaBusquedaForm mov : listaResumen) {
						//selecciona el resumen por cuenta, entidad y moneda
						if (mov.getCuentaId().equals(saldo.getCuentaId())){
							if ( ( (mov.getEntidadId() == null ||  mov.getEntidadId() < 1) && (saldo.getEntidadId() == null ||  saldo.getEntidadId() < 1) )
									|| mov.getEntidadId().equals(saldo.getEntidadId())){
								if (mov.getMonedaId().equals(saldo.getMonedaId())){
									EstructuraSaldoForm form = getEstructuraSaldoForm(mov, Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO,"",true);
									//calculo el saldo acumulado
									saldoAcum = calculaSaldoAcumulado(saldoAcum, form.getDebito(), form.getCredito());
									//seteo el saldo Acumulado
									form.setSaldo(FormatUtil.format2DecimalsStr(saldoAcum));
									saldosEstructura.add(form);
								}
							}
						}
					}
					String clave = generaClave(saldo.getCuentaId(), saldo.getEntidadId(), saldo.getMonedaId());
					saldosEstructura.add(saldosFin.get(clave));
					
				}

			}
		}
		
		//Actualiza los valores de Mostrar en moneda.
		muestraEnMoneda(saldosEstructura, monedaMostrarId, muestrafechaMovimiento);
		
		/* AGREGA REGISTRO PARA DOCUMENTOS APLICADOS */
//		for (EstructuraSaldoForm saldo : saldosEstructura) {
//			if (saldo.isAplicacionesEnDocumento()){
//				List<DocumentoAplicaciones_V> documentosAplicados= documentoMovimientoService.getCancelacionesByIdDoc(saldo.getDocumentoId());
//				for (DocumentoAplicaciones_V docApl : documentosAplicados) {
//					List <String> rowDocApp =new ArrayList<String>();
//					rowDocApp.add(ConvertionUtil.StrValueOf(docApl.getDocumentoAplicaId()));
//					rowDocApp.add("");rowDocApp.add("");
//					rowDocApp.add("");rowDocApp.add("");
//					rowDocApp.add("");rowDocApp.add("");
//					rowDocApp.add("");rowDocApp.add("");
//					rowDocApp.add("");rowDocApp.add("");
//					rowDocApp.add("Documento Aplicado: ");
//					rowDocApp.add("<a href='#' class='contView'>" + docApl.getNumeroFormateado() + "</a> ");
//					dataTable.getAaData().add(rowDocApp);
//				}
//			}
//		}
		

		
		
		
		return saldosEstructura;
		
	}
	
	/**
	 * @param saldosEstructura
	 * @param monedaMuestraId
	 * @param muestrafechaMovimiento Si es true, quiere decir que va a buscar la cotizaci�n por la fecha del movimiento. 
	 * 								 Si es false, utilizar� la cotizaci�n de la fecha actual 
	 */
	private void muestraEnMoneda(List<EstructuraSaldoForm> saldosEstructura, Integer monedaMuestraId, boolean muestrafechaMovimiento){
		/* MOSTRAR EN MONEDA*/
		if ( ! saldosEstructura.isEmpty()){
			/* verifico si desea mostrar en alguna moneda en especial */
			if (monedaMuestraId != null && monedaMuestraId > 1){

				//Obtengo Moneda Local
				CotizacionForm cotForm =cotizacionManager.getUltimaCotizacion(monedaMuestraId); 
				Double cotizacion = cotForm.getCotizacion();

				//Obtengo la COtizacion A convertir
				Integer monedaLocalId =monedaService.obtenerMonedaLocal().getId(); 
				
				// Si la moneda no tiene cotizaci�n no muestra nada.
				if (cotForm.getMoneda() == null && (new Double(0.00)).equals(cotizacion)){
					return;
				}

				//MUESTRA POR COTIZACION DEL DIA O COTIZACION DE LA FECHA
				if (muestrafechaMovimiento){
					muestraEnMonedaFechaMovCotizacion(saldosEstructura, monedaMuestraId,cotForm,monedaLocalId);
				} else {
					muestraEnMonedaUltimaCotizacion(saldosEstructura, monedaMuestraId,cotForm,monedaLocalId);
				}
			} else {
				//Si no muestra en alguna moneda igualo el total al saldo
				for (EstructuraSaldoForm saldo : saldosEstructura) {
					saldo.setCreditoMuestra(Constants.ZERO);
					saldo.setDebitoMuestra(Constants.ZERO);
					saldo.setSaldoMuestra("");
				}
			}
		}
		
	}

	private void muestraEnMonedaFechaMovCotizacion(List<EstructuraSaldoForm> saldosEstructura, Integer monedaMuestraId, CotizacionForm cotForm,Integer monedaLocalId){
		
		Map<Integer,List<Cotizacion>> listadoCotizaciones = cotizacionService.obtenerListadoCotizacionAnuales(monedaMuestraId);
		
		Integer ultimaCotizacionMonedaId = 0;
		Double cotizacionMoneda = 0.0;
		//Si elige moneda obtiene su cotizacion y calcula
		for (EstructuraSaldoForm saldo : saldosEstructura) {
			if (saldo.getFecha() != null){
				//Cotizacion
				Double cotizacion = CalculosUtil.getCotizacionFechaMovDia(listadoCotizaciones, DateUtil.convertStringToDate(saldo.getFecha()), cotForm);
				
				cotizacionMoneda = getMuestraenUltimaCotMoneda(saldo, monedaMuestraId, ultimaCotizacionMonedaId, cotizacionMoneda, monedaLocalId, true);
				//setea la ultima cotizacion. Para este caso> solo sirve si la fecha es null
				ultimaCotizacionMonedaId = saldo.getMonedaId();
				
				setFormMonedaMuestraen(saldo, monedaMuestraId, cotForm, cotizacion, cotizacionMoneda);	
			}
		}
		
	}
	
	private void muestraEnMonedaUltimaCotizacion(List<EstructuraSaldoForm> saldosEstructura, Integer monedaMuestraId, CotizacionForm cotForm,Integer monedaLocalId){
		Double cotizacion = cotForm.getCotizacion();
		Integer ultimaCotizacionMoneda = 0;
		Double cotizacionMoneda = 0.0;
		//Si elige moneda obtiene su cotizacion y calcula
		for (EstructuraSaldoForm saldo : saldosEstructura) {
			cotizacionMoneda = getMuestraenUltimaCotMoneda(saldo, monedaMuestraId, ultimaCotizacionMoneda, cotizacionMoneda, monedaLocalId, false);
			//setea la ultima cotizacion
			ultimaCotizacionMoneda = saldo.getMonedaId();
			setFormMonedaMuestraen(saldo, monedaMuestraId, cotForm, cotizacion, cotizacionMoneda);
		}

	}

	private Double getMuestraenUltimaCotMoneda(EstructuraSaldoForm saldo, Integer monedaMuestraId, Integer ultimaCotizacionMoneda,Double cotizacionMoneda,Integer monedaLocalId, boolean muestrafechaMovimiento){
		Double res = 0.0;
		
		if ( ! monedaMuestraId.equals(saldo.getMonedaId())){
			/* Si es igual a la moneda local la cotizaci�n es 1 */
			if (saldo.getMonedaId().equals(monedaLocalId)){
				cotizacionMoneda = 1.0;
			} else {
				if (muestrafechaMovimiento) {
					if ( (saldo.getFecha() != null) ){
						cotizacionMoneda = cotizacionService.obtenerCotizacionPorFechaProxima(saldo.getMonedaId().intValue(), saldo.getFecha());
					} else {
						cotizacionMoneda = -1.0;
					}
				} else {
					/* para no hacer la consulta siempre por la misma moneda*/
					if ( ! ultimaCotizacionMoneda.equals(saldo.getMonedaId()) ){
						cotizacionMoneda = cotizacionManager.getUltimaCotizacionValidacion(saldo.getMonedaId()).getCotizacion();
						if (cotizacionMoneda == 0){
							cotizacionMoneda = 1.0;
						}
					}
				}
				
			}
			res = cotizacionMoneda;
		}
		return res;
		
	}

	
	private void setFormMonedaMuestraen(EstructuraSaldoForm saldo, Integer monedaMuestraId, CotizacionForm cotForm, Double cotizacion,Double cotizacionMoneda){
			
			//seteo el nombre de la moneda en que muestro
			saldo.setMonedaCodigoMuestra(cotForm.getMoneda().getCodigo());
			saldo.setMonedaNombreMuestra(cotForm.getMoneda().getNombre());
			saldo.setMonedaCotizacionMuestra(FormatUtil.format2DecimalsStr(cotizacion));
			//Pregunto si la moneda que muestro es igual a la que quiero mostrar. De ser as� dejo el mismo valor.
			if (monedaMuestraId.equals(saldo.getMonedaId())){
				saldo.setCreditoMuestra(saldo.getCredito());
				saldo.setDebitoMuestra(saldo.getDebito());
				saldo.setSaldoMuestra(saldo.getSaldo());
			} else {
				//calcula
				saldo.setCreditoMuestra(CalculosUtil.calcularImporteByCOtizacion(ConvertionUtil.DouValueOf(saldo.getCredito()), cotizacionMoneda, cotizacion));
				saldo.setDebitoMuestra(CalculosUtil.calcularImporteByCOtizacion(ConvertionUtil.DouValueOf(saldo.getDebito()), cotizacionMoneda, cotizacion));
				saldo.setSaldoMuestra(CalculosUtil.calcularImporteByCOtizacion(ConvertionUtil.DouValueOf(saldo.getSaldo()), cotizacionMoneda, cotizacion));
			}
	}



	
	private Double calculaSaldoAcumulado (Double saldoAcum , String debito, String credito) {
		Double result = saldoAcum.doubleValue();
		if (StringUtils.isNotBlank(debito) && ConvertionUtil.DouValueOf(debito) != 0 ){
			result = result + ConvertionUtil.DouValueOf(debito);
		} 
		if (StringUtils.isNotBlank(credito) && ConvertionUtil.DouValueOf(credito) != 0 ){
			result = result - ConvertionUtil.DouValueOf(credito);
		} 
		return result;
	}
	
	private void mergeSaldoInicialConFinal(HashMap<Integer, EstructuraSaldoForm> listaSaldoInicial, HashMap<Integer, EstructuraSaldoForm> listaSaldoFinal) {
		
		
			for (Integer key : listaSaldoFinal.keySet()) {
			
				if (listaSaldoInicial.containsKey(key) == false){
					EstructuraSaldoForm saldoNuevo = listaSaldoFinal.get(key);
					saldoNuevo.setCodigo(Constants.ESTRUCTURA_MOV_SALDO_INICIAL );
					saldoNuevo.setSaldo(Constants.ZERO);
					listaSaldoInicial.put(key,saldoNuevo);
				}
			}
				
	}

	private void mergeSaldoInicialConFinal(List<CuentaBusquedaForm> listaSaldoInicial, List<CuentaBusquedaForm> listaSaldoFinal) {
		
		for (CuentaBusquedaForm saldoFin : listaSaldoFinal) {
				boolean agregasaldo = true;
				String claveFin = generaClave(saldoFin.getCuentaId(), saldoFin.getEntidadId(), saldoFin.getMonedaId());
				
				for (CuentaBusquedaForm saldoIni : listaSaldoInicial) {
					if (claveFin.equals(generaClave(saldoIni.getCuentaId(), saldoIni.getEntidadId(), saldoIni.getMonedaId())) ){
						agregasaldo = false;
					}
				}
				if (agregasaldo){
					CuentaBusquedaForm saldoNuevo = saldoFin;
					saldoNuevo.setSaldo(Constants.ZERO);
					listaSaldoInicial.add(saldoNuevo);
				}
			}
				
	}

	
	private HashMap<Integer, EstructuraSaldoForm> getSaldosAgrupadosPorMonedas(List<CuentaBusquedaForm> listaSaldo, String codigo,String nombreContenido) {
		HashMap<Integer, EstructuraSaldoForm> saldos = new HashMap<Integer, EstructuraSaldoForm>();
		for (CuentaBusquedaForm saldoCuenta : listaSaldo) {
			if (saldos.containsKey(saldoCuenta.getMonedaId())){
				//Summo el nuevo saldo al que tengo guardado el saldosIni
				Double nuevoSaldo = ConvertionUtil.DouValueOf(saldos.get(saldoCuenta.getMonedaId()).getSaldo())  + ConvertionUtil.DouValueOf(saldoCuenta.getSaldo());
				//Actualizo el nuevo saldo
				saldos.get(saldoCuenta.getMonedaId()).setSaldo(FormatUtil.format2DecimalsStr(nuevoSaldo));

				//Para mostrar en moneda
				if (StringUtils.isNotBlank(saldoCuenta.getTotalMostrar())){
					Double nuevoSaldoMostrar = ConvertionUtil.DouValueOf(saldos.get(saldoCuenta.getMonedaId()).getSaldoMuestra())  + ConvertionUtil.DouValueOf(saldoCuenta.getTotalMostrar());
					//Actualizo el nuevo saldo Mostrar
					saldos.get(saldoCuenta.getMonedaId()).setSaldoMuestra(FormatUtil.format2DecimalsStr(nuevoSaldoMostrar));

				}
			} else {
				//Creo un nuevo Saldo para esa moneda
				EstructuraSaldoForm form = getEstructuraSaldoForm(saldoCuenta, codigo, nombreContenido,false);
				form.setSaldo(FormatUtil.format2DecimalsStr(saldoCuenta.getSaldo()));
				form.setSaldoMuestra(FormatUtil.format2DecimalsStr(saldoCuenta.getTotalMostrar()));
				saldos.put(saldoCuenta.getMonedaId(), form);
			}
		}
		
		return saldos;
	}
	
	
	private EstructuraSaldoForm getEstructuraSaldoForm (CuentaBusquedaForm movimiento, String codigo, String contenidoNombre,boolean detalla) {
		EstructuraSaldoForm form = new EstructuraSaldoForm();
		
		form.setContenidoNombre(contenidoNombre);
		form.setCodigo(codigo);
	
		form.setTipoDocumentoNombre(movimiento.getTipodocumentoNombre());
		form.setDocumentoId(movimiento.getDocumentoId());
		form.setDocumentoDescripcion(movimiento.getDocDescripcion());
		if (movimiento.getReferencia() != null){
			form.setReferencia(movimiento.getReferencia());	
		} else {
			form.setReferencia("");
		}
		
		form.setMonedaId(movimiento.getMonedaId());
		form.setMonedaCodigo(movimiento.getMonedaCodigo());
		form.setMonedaNombre(movimiento.getMonedaNombre());
		form.setFecha(movimiento.getFechaIngreso());
		form.setDocumento(movimiento.getNumeroFormateado());
		form.setDebito(movimiento.getDebito());
		form.setCredito(movimiento.getCredito());
		form.setSaldo(FormatUtil.format2DecimalsStr(movimiento.getSaldo()));
		form.setSaldoMuestra(FormatUtil.format2DecimalsStr(movimiento.getTotalMostrar()));
		form.setDocumentoDescripcion(movimiento.getDocDescripcion());
		if (movimiento.getAplicacionesEnDocumento() != null && movimiento.getAplicacionesEnDocumento().byteValue() >= 1){
			form.setAplicacionesEnDocumento(true);
		} else {
			form.setAplicacionesEnDocumento(false);	
		}
		
		if (detalla){
			form.setEntidadNombre(movimiento.getEntidadNombre());	
			form.setCuentaId(movimiento.getCuentaId());
			form.setCuentaNombre(movimiento.getCuentaNombre());
		}

		return form;
		
	}

	private List<CuentaBusquedaForm> getListadoPorContenidoCuenta(String fecha, String modo, int idAdm,int cuenta,String entidad, Integer moneda, Integer monedaMuestra){
		/* LISTA Q VOY A MOSTRAR */
		List<CuentaBusquedaForm> lista =  new ArrayList<CuentaBusquedaForm>();
		
		if (StringUtils.isBlank(fecha)){
			//Si no se le pasa la fecha devuelve una lista vacia
			return lista;
		}
		
		FiltroCuentaBean filtros = new FiltroCuentaBean(idAdm, fecha,cuenta, entidad, moneda,monedaMuestra) ;
		
		//Obtengo los movimientos del mes Actual
		List<CuentaBusquedaForm> movimientosMes = cuentaService.buscarSaldoCuentaActualByFiltros(filtros,fecha, "", true);
		//List<CuentaSaldo_V> movimientosMes = new ArrayList<CuentaSaldo_V>();

		/*Obtengo los saldos del mes anterior*/
		List<CuentaBusquedaForm> movimientosMesAnterior = cuentaService.buscarSaldoPorFiltros(filtros,fecha,"",true);

		//Si la lista de movimientos del mes no esta vac�a
		if ( ! movimientosMes.isEmpty() ) {
			if ( ! movimientosMesAnterior.isEmpty() ) {
				if (Constants.ESTRUCTURA_DETALLA.equals(modo)){
					//si tengo que Detallar filtro los listados. Modifico movimientosMes 
					filtroDetalla(movimientosMes, movimientosMesAnterior);
				} else {
					//Si no solamente uno las busquedas
					lista.addAll(movimientosMesAnterior);
				}
			}
			//Agrego los registros de mes actual a la tabla
			lista.addAll(movimientosMes);
		} else {
			//Si esta vac�a solo agrego las del mes anterior
			lista = movimientosMesAnterior;
		}

		return lista;
	}
	
	
	private void filtroDetalla(List<CuentaBusquedaForm> movimientosMes,List<CuentaBusquedaForm> movimientosMesAnterior){
		
			//itereo la lista de movimientos de mes actual
			for (CuentaBusquedaForm mesAnt : movimientosMesAnterior) {			
				boolean agregar = true;
				//itereo la lista de movimientos de mes actual buscando si alguno pertenece al periodo
				for (CuentaBusquedaForm mesAct : movimientosMes) {
					//Pregunto si todos los campos por los que agrupo son iguales
					if ( (mesAct.getAdministracionId() == null && mesAnt.getAdministracionId() == null) || (mesAct.getAdministracionId().equals(mesAnt.getAdministracionId()))){
						if ( (mesAct.getCuentaId() == null && mesAnt.getCuentaId() == null) || ( mesAct.getCuentaId().equals(mesAnt.getCuentaId()))){
							if ( (mesAct.getTipoEntidadId() == null && mesAnt.getTipoEntidadId() == null) || (mesAct.getTipoEntidadId().equals(mesAnt.getTipoEntidadId()))){
								if ( (mesAct.getEntidadId() == null && mesAnt.getEntidadId() == null) || (mesAct.getEntidadId().equals(mesAnt.getEntidadId()))){
									if ( (mesAct.getMonedaId() == null && mesAnt.getMonedaId() == null) || (mesAct.getMonedaId().equals(mesAnt.getMonedaId()))){	
										//Si esta el saldo, lo actualizo 
										mesAct.setSaldo(FormatUtil.format2DecimalsStr(ConvertionUtil.DouValueOf(mesAct.getSaldo()) + ConvertionUtil.DouValueOf(mesAnt.getSaldo())));
										//Para mostrar en moneda
										if (StringUtils.isNotBlank(mesAnt.getTotalMostrar())){
											mesAct.setTotalMostrar(FormatUtil.format2DecimalsStr(ConvertionUtil.DouValueOf(mesAct.getTotalMostrar()) + ConvertionUtil.DouValueOf(mesAnt.getTotalMostrar())));
										}
										//existe, NO lo agrego
										agregar = false;				
									}
								}
							}
						}
					}		
				}
				//Si luego de iterar los movimientos del mes actual, el saldo no esta en la lista lo agrego
				if (agregar){
					//Agrego saldo nuevo
					movimientosMes.add(mesAnt);
				}
			}
		
	}

	public void exportPlanillaDiariExcel(List<EstructuraSaldoForm> listado,FiltroSaldoEstructura busqueda) {
		
		Map<Integer,List<DocumentoAplicaciones_V>> listadoCancelaciones = getDocumentosAplicadosByEstructuras(listado);
		
		String nombre = "PlanillaDiaria_" + busqueda.getFechaDesde() +" - " + busqueda.getFecha();
		
		WritePlantillaDiariaExcel xls = new WritePlantillaDiariaExcel();
		xls.setOutputFile(nombre);
		xls.write(listado,busqueda,listadoCancelaciones);
	}

	public void exportSaldoEstructuraExcel(List<EstructuraSaldoForm> listado,FiltroSaldoEstructura busqueda) {
		
		String nombre = "SaldoEstructura_" + busqueda.getFecha();
		
		WriteSaldoEstructuraExcel xls = new WriteSaldoEstructuraExcel();
		String administracion = "";
		String estructura = "";
		String monedaEn = "";
		
		if (busqueda.getAdministracionId() != null){
			administracion = administracionService.findById(busqueda.getAdministracionId()).getNombre();
		}
		if (busqueda.getEstructuraId() != null){
			estructura = estructuraService.findById(busqueda.getEstructuraId()).getNombre();
		}
		if (busqueda.getMonedaMostrarId() != null){
			monedaEn = monedaService.findById(busqueda.getMonedaMostrarId()).getNombre();
		}
		
		
		xls.setOutputFile(nombre);
		xls.write(listado,busqueda,administracion,estructura,monedaEn);
				
				
	}

	private String generaClave (Integer cuentaId, Integer entidadId,Integer monedaId){
		return cuentaId + "-" + entidadId + "-" + monedaId;
	}

	public Map<Integer, List<DocumentoAplicaciones_V>> getDocumentosAplicadosByEstructuras(List<EstructuraSaldoForm> lista){ 
		Map<Integer, List<DocumentoAplicaciones_V>> resutList = new HashMap<Integer, List<DocumentoAplicaciones_V>>();
		
		Set<Integer> idsDocumentos = new HashSet<Integer>();
		
		for (EstructuraSaldoForm form : lista) {
			idsDocumentos.add(form.getDocumentoId());
		}
		//Elimino si hay un elemento null
		idsDocumentos.remove(null);
		
		List<DocumentoAplicaciones_V> docsAplicados = documentoMovimientoService.getCancelacionesByListIdDoc(idsDocumentos);
		
		for (Integer docId : idsDocumentos) {
			 List<DocumentoAplicaciones_V> listAplDoc = new ArrayList<DocumentoAplicaciones_V>();
			 for (DocumentoAplicaciones_V aplicacion : docsAplicados) {
				 if (docId.equals(aplicacion.getDocumentoId())){
					 //Agrego la aplicacion a la lista de aplicaciones
					 listAplDoc.add(aplicacion);

				 }
			 }
			 resutList.put(docId, listAplDoc);
			 
		}
		
		return resutList;
		
	}
	
}
