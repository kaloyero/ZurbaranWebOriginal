package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.EntidadForm;
import com.contable.hibernate.model.Entidad;

public class EntidadMapper extends MapperImpl<Entidad,EntidadForm>{

	public Entidad getEntidad(EntidadForm form) {
		Entidad ent = new Entidad();
		TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
		
		ent.setId(form.getId());
		ent.setNombre(form.getNombre());
		ent.setTipoEntidad(mapperTpEnt.getEntidad(form.getTipo()));
		return ent;
	}
	
	public  EntidadForm getForm(Entidad ent) {
		EntidadForm form=new EntidadForm();
		TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
		
		form.setId(ent.getId());
		form.setNombre(ent.getNombre());
		form.setTipo(mapperTpEnt.getForm(ent.getTipoEntidad()));
	
		return form;
	}

}