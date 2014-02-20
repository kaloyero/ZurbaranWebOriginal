package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.AdministracionForm;
import com.contable.hibernate.model.Administracion;

public class AdministracionMapper extends MapperImpl<Administracion,AdministracionForm>{

	public AdministracionForm getForm(Administracion ent) {
		AdministracionForm form=new AdministracionForm();
		
		form.setId(ent.getId());
		form.setNombre(ent.getNombre());
		return form;
	}

	public Administracion getEntidad(AdministracionForm form) {
		Administracion ent = new Administracion();
		ent.setId(((AdministracionForm) form).getId());
		ent.setNombre(((AdministracionForm) form).getNombre());
		return ent;
	}
	
}