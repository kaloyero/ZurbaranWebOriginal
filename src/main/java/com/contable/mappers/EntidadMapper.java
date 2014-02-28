package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.EntidadForm;
import com.contable.hibernate.model.Entidad;

public class EntidadMapper extends MapperImpl<Entidad,EntidadForm>{

	public Entidad getEntidad(EntidadForm form) {
		Entidad ent = new Entidad();
		if (form != null){
			TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
			
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setTipoEntidad(mapperTpEnt.getEntidad(form.getTipo()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		}
		return ent;
	}
	
	public  EntidadForm getForm(Entidad ent) {
		EntidadForm form=new EntidadForm();
		if (ent != null){
			TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setTipo(mapperTpEnt.getForm(ent.getTipoEntidad()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}

}