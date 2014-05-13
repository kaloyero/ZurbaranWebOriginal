package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.utils.DateUtil;
import com.contable.form.CotizacionForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Moneda;
import com.contable.manager.CotizacionManager;
import com.contable.manager.MonedaManager;
import com.contable.mappers.MonedaMapper;
import com.contable.services.MonedaService;

@Service("monedaManager")
public class MonedaManagerImpl extends ConfigurationManagerImpl<Moneda,MonedaForm> implements MonedaManager{

	@Autowired
	MonedaService monedaService;

	@Autowired
	CotizacionManager cotizacionManager;

	@Override
	protected AbstractService<Moneda> getRelatedService() {
		return monedaService;
	}

	@Override
	protected Mapper<Moneda,MonedaForm> getMapper() {
		return new MonedaMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(Moneda.fieldNombre());
		list.add(Moneda.fieldAdministracion());
		list.add(Moneda.fieldEstado());
		return list;
	}

	@Transactional
	@Override
	public ErrorRespuestaBean guardarNuevo(MonedaForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		if (Constants.UI_ACTIVO.equalsIgnoreCase(form.getMonedaLocal()) ){
			//Seteo todas las monedas locales en FALSO. Porque la unica moneda local será la que ingrese.	
			monedaService.poneMonedaLocalEnFalsoParaTodas();
		}
		int idMoneda = getRelatedService().save(getMapper().getEntidad(form));
		/* SETEO LA COTIZACION INICIAL */
		form.setId(idMoneda);
		CotizacionForm cotForm = new CotizacionForm();
		cotForm.setMoneda(form);
		cotForm.setFecha(DateUtil.getStringToday());
		cotForm.setCotizacion(1);
		cotizacionManager.guardarNuevo(cotForm);
		
		return res;
	}

	@Transactional
	@Override
	public ErrorRespuestaBean update(MonedaForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		if (Constants.UI_ACTIVO.equalsIgnoreCase(form.getMonedaLocal()) ){
			//Seteo todas las monedas locales en FALSO. Porque la unica moneda local será la que ingrese.	
			monedaService.poneMonedaLocalEnFalsoParaTodas();
		}
		getRelatedService().update(getMapper().getEntidad(form));

		return res;
		
	}

}
