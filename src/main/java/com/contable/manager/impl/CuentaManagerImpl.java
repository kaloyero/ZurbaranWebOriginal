package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.contable.common.utils.DateUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.CuentaForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.hibernate.model.CuentaSaldo_V;
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
	CotizacionService cotizacionManager;

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
	public CuentaForm findById(Integer id){
		//CuentaMonedaMapper mapperCtaMon = new CuentaMonedaMapper();
		CuentaForm form = getMapper().getForm( getRelatedService().findById(id) );
		/*SETEO DE MONEDAS*/
		List<Integer> monedasForm = new ArrayList<Integer>();
		List<CuentaMoneda> monedas = cuentaService.findCuentaMoneda(id);
		//form.setMonedas(mapperCtaMon.getForm(monedas));
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
				Cotizacion cot = cotizacionManager.getUltimaCotizacion(cuentaMoneda.getMoneda().getId());
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

	public List<CuentaBusquedaForm> buscarResumenCuenta(FiltroCuentaBean filtros,String campoOrden,boolean orderByAsc){
		CuentaMapper mapper = new CuentaMapper();

		List<CuentaBusquedaForm> list = mapper.getFormResumenList(cuentaService.buscarResumenPorFiltros(filtros,campoOrden,orderByAsc));
		
		//Obtener los saldos Inicial - final
		
		
		return list;
	}

	public List<CuentaBusquedaForm> buscarSaldosCuenta(FiltroCuentaBean filtros,String fecha, String campoOrden,boolean orderByAsc){
		CuentaMapper mapper = new CuentaMapper();

		//Resto un mes a la fecha por la cual se busca
        filtros.setFechaHasta(DateUtil.convertDateToString(DateUtil.sumarMeses(fecha, 1)));
		//Obtengo los saldos del mes anterior
		List<CuentaSaldo_V> movimientosMesAnterior = cuentaService.buscarSaldoPorFiltros(filtros,campoOrden,orderByAsc);
		//Obtengo los movimientos del mes
		List<CuentaSaldo_V> movimientosMes = new ArrayList<CuentaSaldo_V>();
		
		//
		List<CuentaBusquedaForm> lista =  new ArrayList<CuentaBusquedaForm>();
		if (! movimientosMesAnterior.isEmpty()){
			lista = mapper.getFormSaldoList(movimientosMesAnterior);
			if ( ! movimientosMes.isEmpty() ) {
				for (CuentaSaldo_V saldoMes : movimientosMes) {
					boolean agregar = true;
					for (CuentaBusquedaForm saldoMesAnt : lista) {
						//Pregunto si todos los campos por los que agrupo son iguales
						if ( (saldoMesAnt.getAdministracionId() == null && saldoMes.getAdministracionId() == null) || (saldoMesAnt.getAdministracionId().equals(saldoMes.getAdministracionId()))){
							if ( (saldoMesAnt.getCuentaId() == null && saldoMes.getCuentaId() == null) || ( saldoMesAnt.getCuentaId().equals(saldoMes.getCuentaId()))){
								if ( (saldoMesAnt.getTipoEntidadId() == null && saldoMes.getTipoEntidadId() == null) || (saldoMesAnt.getTipoEntidadId().equals(saldoMes.getTipoEntidadId()))){
									if ( (saldoMesAnt.getEntidadId() == null && saldoMes.getEntidadId() == null) || (saldoMesAnt.getEntidadId().equals(saldoMes.getEntidadId()))){
										if ( (saldoMesAnt.getMonedaId() == null && saldoMes.getMonedaId() == null) || (saldoMesAnt.getMonedaId().equals(saldoMes.getMonedaId()))){	
											//Si esta el saldo, lo actualizo y no lo agrego
											saldoMesAnt.setTotal(String.valueOf(Double.valueOf(saldoMesAnt.getTotal()) + saldoMes.getSaldoAAMM()));
											agregar = false;				
										}
									}
								}
							}
						}		
					}
					if (agregar){
						lista.add(mapper.getForm(saldoMes));
					}
				}
			}
		} else {
			if ( ! movimientosMes.isEmpty() ) {
				lista = mapper.getFormSaldoList(movimientosMes);
			}
		}
		
		/* MOSTRAR EN MONEDA*/
		//Obtengo la COtizacion A convertir
		Double cotizacion = new Double(1.0);
		if (filtros.getMonedaMuestraId() != null && filtros.getMonedaMuestraId() > 1){
			cotizacion = cotizacionManager.getUltimaCotizacion(filtros.getMonedaMuestraId()).getCotizacion();
		}
		for (CuentaBusquedaForm saldo : lista) {
			Double cotizacionMoneda = cotizacionManager.getUltimaCotizacion(filtros.getMonedaMuestraId()).getCotizacion();
			String total = CalculosUtil.calcularImporteByCOtizacion(Double.valueOf(saldo.getTotal()), cotizacionMoneda, cotizacion);
			saldo.setTotalMostrar(total);
		}
		
		return lista;
	}
		
	
}
