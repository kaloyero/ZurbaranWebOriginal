package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.contable.common.utils.CalculosUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.CuentaForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.manager.CotizacionManager;
import com.contable.manager.CuentaManager;
import com.contable.mappers.CuentaMapper;
import com.contable.mappers.CuentaMonedaMapper;
import com.contable.mappers.MonedaMapper;
import com.contable.services.CotizacionService;
import com.contable.services.CuentaService;

@Service("cuentaManager")
public class CuentaManagerImpl extends ConfigurationManagerImpl<Cuenta,CuentaForm> implements CuentaManager{

	@Autowired
	CuentaService cuentaService;

	@Autowired
	CotizacionService cotizacionService;
	
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
		return  cuentaService.findCuentaMonedaConfig(cuentaId);
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
	public List<CuentaBusquedaForm> buscarResumenCuenta(FiltroCuentaBean filtros,String campoOrden,boolean orderByAsc){
		List<CuentaBusquedaForm> list = cuentaService.buscarResumenPorFiltros(filtros,campoOrden,orderByAsc);
		
		return list;
	}

	@Transactional
	public List<CuentaBusquedaForm> buscarSaldosCuenta(FiltroCuentaBean filtros,String fecha, String campoOrden,boolean orderByAsc){
		/* LISTA Q VOY A MOSTRAR */
		List<CuentaBusquedaForm> lista =  new ArrayList<CuentaBusquedaForm>();

		if (StringUtils.isBlank(fecha)){
			//Si no se le pasa la fecha devuelve una lista vacia
			return lista;
		}
		
		/*Seteo la fecha Actual*/
		filtros.setFechaHasta(fecha);
		//Obtengo los movimientos del mes Actual
		List<CuentaBusquedaForm> movimientosMes = cuentaService.buscarSaldoCuentaActualByFiltros(filtros, campoOrden, orderByAsc);
		//List<CuentaSaldo_V> movimientosMes = new ArrayList<CuentaSaldo_V>();

		/*Obtengo los saldos del mes anterior*/
		List<CuentaBusquedaForm> movimientosMesAnterior = cuentaService.buscarSaldoPorFiltros(filtros,campoOrden,orderByAsc);

		
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
		
		/* MOSTRAR EN MONEDA*/
		/* verifico si desea mostrar en alguna moneda en esecial */
		if (filtros.getMonedaMuestraId() != null && filtros.getMonedaMuestraId() > 1){
			//Obtengo la COtizacion A convertir
			Double cotizacion = cotizacionManager.getUltimaCotizacionValidacion(filtros.getMonedaMuestraId()).getCotizacion();
			//Si elige moneda obtiene su cotizacion y calcula
			for (CuentaBusquedaForm saldo : lista) {
				Double cotizacionMoneda = cotizacionManager.getUltimaCotizacionValidacion(saldo.getMonedaId()).getCotizacion();
				//calcula
				String total = CalculosUtil.calcularImporteByCOtizacion(ConvertionUtil.DouValueOf(saldo.getSaldo()), cotizacionMoneda, cotizacion);
				saldo.setTotalMostrar(total);
			}
		} else {
			//Si no muestra en alguna moneda igualo el total al saldo
			for (CuentaBusquedaForm saldo : lista) {
				String total = saldo.getSaldo();
				saldo.setTotalMostrar(total);
			}
		}
		
		return lista;
	}
		
	
}
