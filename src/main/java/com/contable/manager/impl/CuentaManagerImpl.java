package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.excel.WriteCuentaResumenExcel;
import com.contable.common.excel.WriteCuentaSaldoExcel;
import com.contable.common.utils.CalculosUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.CotizacionForm;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.CuentaForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.hibernate.model.Entidad;
import com.contable.hibernate.model.Moneda;
import com.contable.manager.CotizacionManager;
import com.contable.manager.CuentaManager;
import com.contable.mappers.CuentaMapper;
import com.contable.mappers.CuentaMonedaMapper;
import com.contable.mappers.MonedaMapper;
import com.contable.services.CotizacionService;
import com.contable.services.CuentaService;
import com.contable.services.EntidadService;
import com.contable.services.MonedaService;

@Service("cuentaManager")
public class CuentaManagerImpl extends ConfigurationManagerImpl<Cuenta,CuentaForm> implements CuentaManager{

	@Autowired
	CuentaService cuentaService;

	@Autowired
	EntidadService entidadService;
	
	@Autowired
	CotizacionService cotizacionService;
	
	@Autowired
	MonedaService monedaService;

	@Autowired
	CotizacionManager cotizacionManager;

	@Override
	protected AbstractService<Cuenta> getRelatedService() {
		return cuentaService;
	}

	@Override
	protected Mapper<Cuenta,CuentaForm> getMapper() {
		return new CuentaMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(Cuenta.fieldNombre());
		list.add(Cuenta.fieldAdministracion());
		list.add(Cuenta.fieldCodigo());
		list.add(Cuenta.fieldDescripcion());
		list.add(Cuenta.fieldTipoEntidad());
		list.add(Cuenta.fieldTipoSaldo());
		list.add(Cuenta.fieldEstado());
		return list;
	}

	//TODO Pasar este metodo a handler
	@Transactional
	@Override
	public CuentaForm findById(Integer id){
		CuentaMonedaMapper mapperCtaMon = new CuentaMonedaMapper();
		CuentaForm form = getMapper().getForm( getRelatedService().findById(id) );
		/*SETEO DE MONEDAS*/
		List<Integer> monedasForm = new ArrayList<Integer>();
		List<CuentaMoneda> monedas = cuentaService.findCuentaMoneda(id);
		form.setMonedas(mapperCtaMon.getForm(monedas));
		for (CuentaMoneda cuentaMoneda : monedas) {
			monedasForm.add(cuentaMoneda.getMoneda().getId());
		}
		form.setIdsMonedas(monedasForm);
		return form;
	}

	public List<MonedaForm> getMonedasByCuenta(Integer cuentaId, boolean cotizacion){
		List<MonedaForm> monedasForm = new ArrayList<MonedaForm>();
		MonedaMapper mapperMon = new MonedaMapper();
		List<CuentaMoneda> monedas = cuentaService.findCuentaMoneda(cuentaId);
		
		for (CuentaMoneda cuentaMoneda : monedas) {
			if (cotizacion){
				Cotizacion cot = cotizacionService.getUltimaCotizacion(cuentaMoneda.getMoneda().getId());
				monedasForm.add(mapperMon.getForm(cuentaMoneda.getMoneda(), cot));
			} else {
				monedasForm.add(mapperMon.getForm(cuentaMoneda.getMoneda()));
			}
			
		}
	
		return monedasForm;
	}

	public List<ConfigBean> getMonedasConfigByCuenta(Integer cuentaId){
		return  this.getMonedasConfigByCuenta(cuentaId,CAMPO_NINGUNO);
	}
	
	public List<ConfigBean> getMonedasConfigByCuenta(Integer cuentaId,String extraRow){
		List<ConfigBean> list = cuentaService.findCuentaMonedaConfig(cuentaId);
		//Agrega el campo extra
		agergarExtraRow(list, extraRow);
		
		return  list;
	}

	
	//TODO Pasar este metodo a handler
	@Transactional
	public ErrorRespuestaBean guardarNuevo(CuentaForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		CuentaMonedaMapper mapperCtaMon = new CuentaMonedaMapper();
		int idCuenta = getRelatedService().save(getMapper().getEntidad(form));
		cuentaService.saveCuentaMoneda(mapperCtaMon.getEntidad(form.getIdsMonedas(),idCuenta));
		
		return res;
	}


	//TODO Pasar este metodo a handler
	@Transactional
	public ErrorRespuestaBean update(CuentaForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		//Actualiza la cuenta
		getRelatedService().update(getMapper().getEntidad(form));
		//actualiza las monedas
		cuentaService.updateCuentaMoneda(form.getIdsMonedas(),form.getId());
		
		return res;
	}

	@Transactional
	public List<CuentaBusquedaForm> buscarResumenCuenta(FiltroCuentaBean filtros){
		List<CuentaBusquedaForm> list = cuentaService.buscarResumenPorFiltros(filtros,"FechaIngreso desc, IdDocumento desc ,movimientoId",false);
		
		/* Mostrar moneda en */
		mostrarEnMoneda(list, filtros);
		
		return list;
	}

	private void mostrarEnMoneda(List<CuentaBusquedaForm> list,FiltroCuentaBean filtros){
		if (filtros.getMonedaMuestraId() != null )
		{
			//Pregunto si la moneda que muestro es igual a la que quiero mostrar.
			CotizacionForm cotForm = null;
			String monedaCodigoMostrar = "";
			if ( ! filtros.getMonedaMuestraId().equals(filtros.getMonedaId())){
				//Obtengo la COtizacion A convertir
				cotForm =cotizacionManager.getUltimaCotizacion(filtros.getMonedaMuestraId()); 
				monedaCodigoMostrar = cotForm.getMoneda().getCodigo();
				//Obtengo la COtizacion de la moneda
				
			}
			
			Map<Integer,List<Cotizacion>> listadoCotizaciones = cotizacionService.obtenerListadoCotizacionAnuales(filtros.getMonedaMuestraId());
			for (CuentaBusquedaForm saldo : list) {
				Double cotizacionMoneda = ConvertionUtil.DouValueOf(saldo.getCotizacion());
				
				//Pregunto si la moneda que muestro es igual a la que quiero mostrar. De ser así dejo el mismo valor.
				if (filtros.getMonedaMuestraId().equals(filtros.getMonedaId())){
					saldo.setMonedaMostrarCodigo(saldo.getMonedaCodigo());
					//Dejo mismo valor
					saldo.setDebitoMostrar(saldo.getDebito());					
					saldo.setCreditoMostrar(saldo.getCredito());
				} else {
					Double cotizacionAConvertir = CalculosUtil.getCotizacionFechaMovDia(listadoCotizaciones, DateUtil.convertStringToDate(saldo.getFechaIngreso()), cotForm);
					
					//seteo la cotización a la moneda q convierto
					saldo.setCotizacion(FormatUtil.format2DecimalsStr( cotizacionAConvertir));
					
					saldo.setMonedaMostrarCodigo(monedaCodigoMostrar);
					//Calculo los valores
					saldo.setDebitoMostrar(CalculosUtil.calcularImporteByCOtizacion(ConvertionUtil.DouValueOf(saldo.getDebito()), cotizacionMoneda, cotizacionAConvertir));					
					saldo.setCreditoMostrar(CalculosUtil.calcularImporteByCOtizacion(ConvertionUtil.DouValueOf(saldo.getCredito()), cotizacionMoneda, cotizacionAConvertir));
					
				}

			}
		}
	}
	
	@Transactional
	public synchronized double buscarSaldosCuentaParaResumen(FiltroCuentaBean filtros,String fecha, String campoOrden,boolean orderByAsc){
		
		List<CuentaBusquedaForm> lista = buscarSaldosCuenta(filtros, fecha, campoOrden, orderByAsc);
		double saldo = 0.0;
		
		if ( ! lista.isEmpty()){
			for (CuentaBusquedaForm saldoCta : lista) {
				saldo = saldo + ConvertionUtil.DouValueOf(saldoCta.getSaldo());
			}
		}
		
		return saldo;
		
	}
	
	
	@Transactional
	public List<CuentaBusquedaForm> buscarSaldosCuenta(FiltroCuentaBean filtros,String fecha, String campoOrden,boolean orderByAsc){
		/* LISTA Q VOY A MOSTRAR */
		List<CuentaBusquedaForm> lista =  new ArrayList<CuentaBusquedaForm>();
		boolean mostrarMonedaEn = false;
		
		// Si esta seleccionado la moneda que se muestra
		if (filtros.getMonedaMuestraId() != null && filtros.getMonedaMuestraId() > 0){
			mostrarMonedaEn = true;
		}
		
		if (StringUtils.isBlank(fecha)){
			//Si no se le pasa la fecha devuelve una lista vacia
			return lista;
		}
		
		//Obtengo los movimientos del mes Actual
		List<CuentaBusquedaForm> movimientosMes = cuentaService.buscarSaldoCuentaActualByFiltros(filtros, fecha,campoOrden, orderByAsc);


		/*Obtengo los saldos del mes anterior*/
		List<CuentaBusquedaForm> movimientosMesAnterior = cuentaService.buscarSaldoPorFiltros(filtros, fecha,campoOrden,orderByAsc);

		
		//Si la lista de movimientos del mes no esta vacía
		if ( ! movimientosMes.isEmpty() ) {
			
			if ( ! movimientosMesAnterior.isEmpty() ) {
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
											if (mostrarMonedaEn){
												//Moneda en que se muestra
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
						lista.add(mesAnt);
					}
				}
			}

			//Agrego los registros de mes actual a la tabla
			lista.addAll(movimientosMes);

		} else {
			//Si esta vacía solo agrego las del mes anterior
			lista = movimientosMesAnterior;
		}
		
		
//		/* Consulta los saldos */
//		lista = cuentaService.buscarSaldoCuenta(filtros, campoOrden, orderByAsc);
		
		//Actualiza los valores de Mostrar en moneda.
		if (filtros.isMonedaMuestraCotizaFecha()){
			muestraEnMonedaNombre(lista, filtros.getMonedaMuestraId());
		} else {
			muestraEnMoneda(lista, filtros.getMonedaMuestraId());	
		}

		
		/* MOSTRAR EN MONEDA*/
		
		
		if ( ! lista.isEmpty()){
			/* verifico si desea mostrar en alguna moneda en esecial */
			if (filtros.getMonedaMuestraId() != null && filtros.getMonedaMuestraId() > 1){
				//Obtengo la COtizacion A convertir
				CotizacionForm cotForm =cotizacionManager.getUltimaCotizacionValidacion(filtros.getMonedaMuestraId()); 
				Double cotizacion = cotForm.getCotizacion();
				
				// Si la moneda no tiene cotización no muestra nada.
				if (cotForm.getMoneda() == null){
					return lista;
				}
				//Si elige moneda obtiene su cotizacion y calcula
				for (CuentaBusquedaForm saldo : lista) {
					//seteo el nombre de la moneda en que muestro
					saldo.setMonedaMostrarCodigo(cotForm.getMoneda().getCodigo());
					saldo.setMonedaMostrarNombre(cotForm.getMoneda().getNombre());
					String total = Constants.ZERO;
					//Pregunto si la moneda que muestro es igual a la que quiero mostrar. De ser así dejo el mismo valor.
					if (filtros.getMonedaMuestraId() == saldo.getMonedaId()){
						total = saldo.getSaldo();
					} else {
						Double cotizacionMoneda = cotizacionManager.getUltimaCotizacionValidacion(saldo.getMonedaId()).getCotizacion();
						if (cotizacionMoneda == 0){
							cotizacionMoneda = 1.0;
						}
						//calcula
						total = CalculosUtil.calcularImporteByCOtizacion(ConvertionUtil.DouValueOf(saldo.getSaldo()), cotizacionMoneda, cotizacion);
					}
					saldo.setTotalMostrar(total);
				}
			} else {
				//Si no muestra en alguna moneda igualo el total al saldo
				for (CuentaBusquedaForm saldo : lista) {
					String total = saldo.getSaldo();
					saldo.setTotalMostrar(total);
				}
			}
		}
		return lista;
	}
		
	public void exportResumenExcel(FiltroCuentaBean filtros) {
		String nombre = "ResumenDeCuenta_";
		String cuentaNombre = getNombreCuenta(filtros.getCuentaId());
		String entidadNombre = getNombreEntidad(filtros.getEntidadId());
		List<CuentaBusquedaForm> exportList = buscarResumenCuenta(filtros);			
		
		/*NOMBRE */
		nombre += "_" +cuentaNombre;
			
        /*  Obtengo el Saldo Inicial   */
		Double saldoAcumulado = 0.0;
		if (StringUtils.isNotBlank(filtros.getFechaDesde())){
			//NOMBRE
			nombre += "_" +filtros.getFechaDesde() ;
			//Le resto un día a la fecha inicial
			String fechaDesde = DateUtil.sumarDias(filtros.getFechaDesde(), -1);
			saldoAcumulado = buscarSaldosCuentaParaResumen(filtros, fechaDesde, "", true);
		}
		Double saldoAcumuladoMonedaMostrar = 0.0;
		if (filtros.getMonedaMuestraId() != null){
			saldoAcumuladoMonedaMostrar = cotizacionManager.mostrarCotizacionEnmoneda(filtros.getMonedaId(), filtros.getMonedaMuestraId(), saldoAcumulado);
		}
		
		//NOMBRE fecha
		nombre += "_" +getFecha(filtros.getFechaHasta());

		
		WriteCuentaResumenExcel xls = new WriteCuentaResumenExcel();
		xls.setOutputFile(nombre);
		xls.write(exportList,filtros,saldoAcumulado,saldoAcumuladoMonedaMostrar,cuentaNombre,entidadNombre);

	}
	
	public void exportSaldoExcel(FiltroCuentaBean filtros) {
		String nombre = "SaldoDeCuenta";
		String cuentaNombre = getNombreCuenta(filtros.getCuentaId());
		String entidadNombre = getNombreEntidad(filtros.getEntidadId());
		
		List<CuentaBusquedaForm> exportList = buscarSaldosCuenta(filtros,filtros.getFechaDesde(), "", false);			
		
		/*NOMBRE */
		nombre += "_" + cuentaNombre;
		nombre += "_" +getFecha(filtros.getFechaDesde());
		
		WriteCuentaSaldoExcel xls = new WriteCuentaSaldoExcel();
		xls.setOutputFile(nombre);
		xls.write(exportList,filtros,cuentaNombre,entidadNombre);

	}
	private void muestraEnMonedaNombre(List<CuentaBusquedaForm> lista, Integer monedaMuestraId){
		
		/* MOSTRAR EN MONEDA*/
		if ( ! lista.isEmpty()){
			/* verifico si desea mostrar en alguna moneda en especial */
			if (monedaMuestraId != null && monedaMuestraId > 1){
				
				Moneda monedaMostrarEn = monedaService.findById(monedaMuestraId);
				
				for (CuentaBusquedaForm saldo : lista) {
					//seteo el nombre de la moneda en que muestro
					saldo.setMonedaMostrarCodigo(monedaMostrarEn.getCodigo());
					saldo.setMonedaMostrarNombre(monedaMostrarEn.getNombre());
				}
			} else {
				//Si no muestra en alguna moneda igualo el total al saldo
				for (CuentaBusquedaForm saldo : lista) {
					String total = saldo.getSaldo();
					saldo.setTotalMostrar(total);
				}				
			}
		}
		
	}

	private void muestraEnMoneda(List<CuentaBusquedaForm> lista, Integer monedaMuestraId){
		
		/* MOSTRAR EN MONEDA*/
		if ( ! lista.isEmpty()){
			/* verifico si desea mostrar en alguna moneda en especial */
			if (monedaMuestraId != null && monedaMuestraId > 1){
				//Obtengo la COtizacion A convertir
				CotizacionForm cotForm =cotizacionManager.getUltimaCotizacion(monedaMuestraId); 
				Double cotizacion = cotForm.getCotizacion();
				
				// Si la moneda no tiene cotización no muestra nada.
				if (cotForm.getMoneda() == null && (new Double(0.00)).equals(cotizacion)){
					return;
				}
				
				Integer ultimaCotizacionMoneda = 0;
				Double cotizacionMoneda = 0.0;
				//Si elige moneda obtiene su cotizacion y calcula
				for (CuentaBusquedaForm saldo : lista) {
					//seteo el nombre de la moneda en que muestro
					saldo.setMonedaMostrarCodigo(cotForm.getMoneda().getCodigo());
					saldo.setMonedaMostrarNombre(cotForm.getMoneda().getNombre());
					String total = Constants.ZERO;
					//Pregunto si la moneda que muestro es igual a la que quiero mostrar. De ser así dejo el mismo valor.
					if (monedaMuestraId == saldo.getMonedaId()){
						total = saldo.getSaldo();
					} else {
						/* para no hacer la consulta siempre por la misma moneda*/
						if ( ! ultimaCotizacionMoneda.equals(saldo.getMonedaId()) ){
							ultimaCotizacionMoneda = saldo.getMonedaId();
							cotizacionMoneda = cotizacionManager.getUltimaCotizacionValidacion(saldo.getMonedaId()).getCotizacion();
							if (cotizacionMoneda == 0){
								cotizacionMoneda = 1.0;
							}
						}
						//calcula
						total = CalculosUtil.calcularImporteByCOtizacion(ConvertionUtil.DouValueOf(saldo.getSaldo()), cotizacionMoneda, cotizacion);
					}
					saldo.setTotalMostrar(total);
				}
			} else {
				//Si no muestra en alguna moneda igualo el total al saldo
				for (CuentaBusquedaForm saldo : lista) {
					String total = saldo.getSaldo();
					saldo.setTotalMostrar(total);
				}				
			}
		}
		
	}
	
	private String getNombreCuenta(Integer idCuenta){
		String nombre = "";
		
		/*NOMBRE */
		if (idCuenta != null ){
			Cuenta cuenta = cuentaService.findById(idCuenta); 
			if (cuenta != null){
				nombre = cuenta.getNombre(); 
			}
		}
		
		return nombre;
	}

	private String getFecha(String fecha){
		String nombre = "";
		
		if (StringUtils.isBlank(fecha)) {
			nombre = DateUtil.getStringToday();
		} else {
			nombre = fecha;
		}
		return nombre;
	}
	
	private String getNombreEntidad(String entidades){
		String nombre = "";
		
		/*NOMBRE */
		if (StringUtils.isNotBlank(entidades)){
			String[] ents = entidades.split(",");
			if (ents.length > 1){
				nombre = "SELECCION MULTIPLE";
			} else {
				Entidad ent = entidadService.findById(ConvertionUtil.IntValueOf(ents[0]).intValue()); 
				if (ent != null){
					nombre = ent.getNombre(); 
				}
			}
		} 
		
		return nombre;
	}
}
