package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.TipoEntidadForm;
import com.contable.hibernate.model.TipoEntidad;

public class TipoEntidadMapper extends MapperImpl<TipoEntidad,TipoEntidadForm>{


	public TipoEntidad getEntidad(TipoEntidadForm form) {
		TipoEntidad ent = new TipoEntidad();
		AdministracionMapper mapperAdm = new AdministracionMapper();
		
		ent.setId(((TipoEntidadForm) form).getId());
		ent.setNombre(((TipoEntidadForm) form).getNombre());
		ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
		
		return ent;
	}

	public  TipoEntidadForm getForm(TipoEntidad ent) {
		TipoEntidadForm form=new TipoEntidadForm();
		AdministracionMapper mapperAdm = new AdministracionMapper();
		
		form.setId(ent.getId());
		form.setNombre(ent.getNombre());
		form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
	
		return form;
	}


}