package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.TipoEntidadForm;
import com.contable.hibernate.model.TipoEntidad;

public class TipoEntidadMapper extends MapperImpl<TipoEntidad,TipoEntidadForm>{


	public TipoEntidad getEntidad(TipoEntidadForm form) {
		TipoEntidad ent = new TipoEntidad();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			
			ent.setId(((TipoEntidadForm) form).getId());
			ent.setNombre(form.getNombre());
			ent.setDescripcion(form.getDescripcion());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		}
		return ent;
	}

	public  TipoEntidadForm getForm(TipoEntidad ent) {
		TipoEntidadForm form=new TipoEntidadForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setDescripcion(ent.getDescripcion());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}


}