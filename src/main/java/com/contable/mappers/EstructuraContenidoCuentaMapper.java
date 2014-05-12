package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.constants.Constants;
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.Entidad;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

public class EstructuraContenidoCuentaMapper extends MapperImpl<EstructuraContenidoCuenta,EstructuraContenidoCuentaForm>{

	public EstructuraContenidoCuenta getEntidad(EstructuraContenidoCuentaForm form) {
		EstructuraContenidoCuenta cuentaContenido = new EstructuraContenidoCuenta();
		if (form != null){
			MonedaMapper mapperMon = new MonedaMapper();
			
			if (form.getEstructuraContenidoId() != null){
				EstructuraContenido est = new EstructuraContenido();
				est.setId(form.getEstructuraContenidoId());
				cuentaContenido.setEstructuraContenido(est);	
			} 
			if (form.getMoneda()!=null){
				cuentaContenido.setMoneda(mapperMon.getEntidad(form.getMoneda()));

			} else {
				MonedaForm moneda =new MonedaForm();
				if (form.getMonedaId() == null || form.getMonedaId().equals(-1)){
					moneda.setId(null);
				} else {
					moneda.setId(form.getMonedaId());
					cuentaContenido.setMoneda(mapperMon.getEntidad(moneda));
				}
			}
			
			Cuenta cta = new Cuenta();
			cta.setId(form.getCuentaId());
			cuentaContenido.setCuenta(cta);
			if (form.getEntidadId() != null && form.getEntidadId() != Constants.UI_ADM_VALUE_TODAS){
				Entidad entidad = new Entidad();
				entidad.setId(form.getEntidadId());
				cuentaContenido.setEntidad(entidad);
			}
			cuentaContenido.setId(form.getId());

		} else {
			return null;
		}
		return cuentaContenido;
	}
		
	public  EstructuraContenidoCuentaForm getForm(EstructuraContenidoCuenta ent) {
		EstructuraContenidoCuentaForm form = new EstructuraContenidoCuentaForm();
		MonedaMapper mapMon = new MonedaMapper();
		
		if (ent != null){
			if (ent.getCuenta() != null){ 
				form.setCuentaId(ent.getCuenta().getId());
				form.setCuentaNombre(ent.getCuenta().getNombre());
			}
			if (ent.getEntidad() != null){
				form.setEntidadId(ent.getEntidad().getId());
				form.setEntidadNombre(ent.getEntidad().getNombre());
			}
			form.setMoneda(mapMon.getForm(ent.getMoneda()) );
			form.setEstructuraContenidoId(ent.getEstructuraContenido().getId());
			form.setId(ent.getId());
		}	else {
			return null;
		}

		return form;
	}

}