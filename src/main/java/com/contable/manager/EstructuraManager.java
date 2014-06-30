package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.form.EstructuraForm;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.Estructura;

public interface EstructuraManager extends ConfigurationManager<Estructura,EstructuraForm>{

	public List<EstructuraSaldoForm> getEstructuraSaldos (int idEstructura, int idAdministracion,String fecha);
	
	public List<EstructuraSaldoForm> getEstructuraMovimientosSaldos (int idEstructura, int idAdministracion,String fechaInicial,String fechaFinal, Integer monedaMostrarId);
}
