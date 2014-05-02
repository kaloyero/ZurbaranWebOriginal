package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

public class EstructuraContenidoCuentaMapper extends MapperImpl<EstructuraContenidoCuenta,EstructuraContenidoCuentaForm>{

	public EstructuraContenidoCuenta getEntidad(EstructuraContenidoCuentaForm form) {
		EstructuraContenidoCuenta cuenta = new EstructuraContenidoCuenta();
		if (form != null){
			MonedaMapper mapperMon = new MonedaMapper();
			
			if (form.getEstructuraContenidoId() != null){
				EstructuraContenido est = new EstructuraContenido();
				est.setId(form.getEstructuraContenidoId());
				cuenta.setEstructuraContenido(est);	
			} 
			cuenta.setCuentaId(form.getCuentaId());
			cuenta.setEntidadesId(form.getEntidadId());
			cuenta.setId(form.getId());
			cuenta.setMoneda(mapperMon.getEntidad(form.getMoneda()));

		} else {
			return null;
		}
		return cuenta;
	}
		
	public  EstructuraContenidoCuentaForm getForm(EstructuraContenidoCuenta ent) {
		EstructuraContenidoCuentaForm form = new EstructuraContenidoCuentaForm();
		MonedaMapper mapMon = new MonedaMapper();
		
		if (ent != null){
			EstructuraContenidoCuentaForm contenidoCuentaForm = new EstructuraContenidoCuentaForm();
			contenidoCuentaForm.setCuentaId(ent.getCuentaId());
			contenidoCuentaForm.setEntidadId(ent.getEntidadesId());
			contenidoCuentaForm.setMoneda(mapMon.getForm(ent.getMoneda()) );
			contenidoCuentaForm.setEstructuraContenidoId(ent.getEstructuraContenido().getId());
			contenidoCuentaForm.setId(ent.getId());
		}
		return form;
	}

}