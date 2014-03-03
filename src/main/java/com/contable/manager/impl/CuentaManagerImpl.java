package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.CuentaForm;
import com.contable.form.CuentaMonedaForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.manager.CuentaManager;
import com.contable.manager.MonedaManager;
import com.contable.mappers.CuentaMapper;
import com.contable.services.CuentaService;

@Service("cuentaManager")
public class CuentaManagerImpl extends ConfigurationManagerImpl<Cuenta,CuentaForm> implements CuentaManager{

	@Autowired
	CuentaService cuentaService;
	
	@Autowired
	MonedaManager monedaManager;
	
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

	//TODO borrar este metodo
	@Transactional
	public CuentaForm findById(Integer id){
		CuentaForm form = getMapper().getForm( getRelatedService().findById(id) );
		List<MonedaForm> monedas = monedaManager.getLista();
		List<CuentaMonedaForm> listaMonedas = new ArrayList<CuentaMonedaForm>();
		
		int i = 1;
		for (MonedaForm monedaForm : monedas) {
			CuentaMonedaForm ctaMon= new CuentaMonedaForm();
			ctaMon.setId(i);
			ctaMon.setIdCuenta(String.valueOf(form.getId()));
			ctaMon.setMoneda(monedaForm);
			i++;
			listaMonedas.add(ctaMon);
		}
		form.setMonedas(listaMonedas);
		return form;
	}

}
