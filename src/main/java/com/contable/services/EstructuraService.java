package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.Estructura;

public interface EstructuraService extends AbstractService<Estructura>{

	
	public List<EstructuraSaldoForm> getEstructuraSaldos (int idEstructura, int idAdministracion,String fecha, Integer monedaMostrarId);
	
	
}
