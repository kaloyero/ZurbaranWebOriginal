package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.constants.Constants;
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.form.MonedaForm;
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
			if (form.getMoneda()!=null){
				cuenta.setMoneda(mapperMon.getEntidad(form.getMoneda()));

			} else {
				MonedaForm moneda =new MonedaForm();
				moneda.setId(form.getMonedaId());
				cuenta.setMoneda(mapperMon.getEntidad(moneda));

			}
			cuenta.setCuentaId(form.getCuentaId());
			if (form.getEntidadId() != null && form.getEntidadId() != Constants.UI_ADM_VALUE_TODAS){
				cuenta.setEntidadesId(form.getEntidadId());
			}
			cuenta.setId(form.getId());

		} else {
			return null;
		}
		return cuenta;
	}
		
	public  EstructuraContenidoCuentaForm getForm(EstructuraContenidoCuenta ent) {
		EstructuraContenidoCuentaForm form = new EstructuraContenidoCuentaForm();
		MonedaMapper mapMon = new MonedaMapper();
		
		if (ent != null){
			form.setCuentaId(ent.getCuentaId());
			form.setEntidadId(ent.getEntidadesId());
			form.setMoneda(mapMon.getForm(ent.getMoneda()) );
			form.setEstructuraContenidoId(ent.getEstructuraContenido().getId());
			form.setId(ent.getId());
		}	else {
			return null;
		}

		return form;
	}

}