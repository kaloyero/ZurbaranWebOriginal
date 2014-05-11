package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.hibernate.model.Moneda;

public class MonedaMapper extends MapperImpl<Moneda,MonedaForm>{


	public Moneda getEntidad(MonedaForm form) {
		Moneda ent = new Moneda();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();			 
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setCodigo(form.getCodigo());
			ent.setMonedaLocal(form.getMonedaLocal());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		} else {
			return null;
		}
		return ent;
	}

	public  MonedaForm getForm(Moneda ent) {
		return getForm(ent, null);
	}
	
	public  MonedaForm getForm(Moneda ent, Cotizacion cot) {
		MonedaForm form=new MonedaForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			form.setId(MapperUtil.formValidNull(ent.getId()));
			form.setCodigo(ent.getCodigo());
			form.setNombre(ent.getNombre());
			form.setMonedaLocal(ent.getMonedaLocal());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
			if (cot != null){
				CotizacionMapper mapperCot = new CotizacionMapper();
				form.setCotizacion(mapperCot.getForm(cot));
			}
		}
		return form;
	}

}