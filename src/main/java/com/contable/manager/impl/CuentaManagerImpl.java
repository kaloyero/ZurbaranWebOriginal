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
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.CuentaForm;
import com.contable.form.MonedaForm;
import com.contable.form.ValorPropioForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.manager.CuentaManager;
import com.contable.mappers.CuentaMapper;
import com.contable.mappers.CuentaMonedaMapper;
import com.contable.mappers.DocumentoValorPropioMapper;
import com.contable.mappers.MonedaMapper;
import com.contable.services.CotizacionService;
import com.contable.services.CuentaService;

@Service("cuentaManager")
public class CuentaManagerImpl extends ConfigurationManagerImpl<Cuenta,CuentaForm> implements CuentaManager{

	@Autowired
	CuentaService cuentaService;
	
	@Autowired
	CotizacionService cotizacionService;

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

	public List<CuentaBusquedaForm> buscarResumenCuenta(FiltroCuentaBean filtros,String campoOrden,boolean orderByAsc){
		CuentaMapper mapper = new CuentaMapper();

		List<CuentaBusquedaForm> list = mapper.getFormResumenList(cuentaService.buscarResumenPorFiltros(filtros,campoOrden,orderByAsc));
		
		return list;
	}

	public List<CuentaBusquedaForm> buscarSaldosCuenta(FiltroCuentaBean filtros,String campoOrden,boolean orderByAsc){
		CuentaMapper mapper = new CuentaMapper();

		List<CuentaBusquedaForm> list = mapper.getFormSaldoList(cuentaService.buscarSaldoPorFiltros(filtros,campoOrden,orderByAsc));
		
		return list;
	}

}
