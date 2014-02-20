package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Moneda;

public class MonedaMapper extends MapperImpl<Moneda,MonedaForm>{


	public Moneda getEntidad(MonedaForm form) {
		Moneda ent = new Moneda();
		AdministracionMapper mapperAdm = new AdministracionMapper();
				
		ent.setId(((MonedaForm) form).getId());
		ent.setNombre(((MonedaForm) form).getNombre());
		ent.setCodigo(((MonedaForm) form).getCodigo());
		ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
		return ent;
	}
	
	public  MonedaForm getForm(Moneda ent) {
		MonedaForm form=new MonedaForm();
		AdministracionMapper mapperAdm = new AdministracionMapper();
		
		form.setId(ent.getId());
		form.setCodigo(ent.getCodigo());
		form.setNombre(ent.getNombre());
		form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
	
		return form;
	}

}