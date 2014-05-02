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
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.hibernate.model.EstructuraContenidoCuenta;
import com.contable.manager.EstructuraContenidoCuentaManager;
import com.contable.mappers.EstructuraContenidoCuentaMapper;
import com.contable.services.EstructuraContenidoCuentaService;

@Service("estructuraContenidoCuentaManager")
public class EstructuraContenidoCuentaManagerImpl extends ConfigurationManagerImpl<EstructuraContenidoCuenta,EstructuraContenidoCuentaForm> implements EstructuraContenidoCuentaManager{

	@Autowired
	EstructuraContenidoCuentaService estructuraContenidoCuentaService;

	@Override
	protected AbstractService<EstructuraContenidoCuenta> getRelatedService() {
		return estructuraContenidoCuentaService;
	}

	@Override
	protected Mapper<EstructuraContenidoCuenta,EstructuraContenidoCuentaForm> getMapper() {
		return new EstructuraContenidoCuentaMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

	@Transactional
	@Override
	public ErrorRespuestaBean guardarNuevo(EstructuraContenidoCuentaForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		estructuraContenidoCuentaService.save(getMapper().getEntidad(form));
		return res;
		
	}

	@Transactional
	public void guardarNuevo(EstructuraContenidoCuentaForm[] formList){
		
		for (EstructuraContenidoCuentaForm form : formList) {
			this.guardarNuevo(form);
		}
		
	}

}
