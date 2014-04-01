package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.AdministracionForm;
import com.contable.hibernate.model.Administracion;

public class AdministracionMapper extends MapperImpl<Administracion,AdministracionForm>{

	public AdministracionForm getForm(Administracion ent) {
		AdministracionForm form=new AdministracionForm();
		if (ent != null){
			form.setId(MapperUtil.formValidNull(ent.getId()));
			form.setNombre(ent.getNombre());
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}

	public Administracion getEntidad(AdministracionForm form) {
		Administracion ent = new Administracion();
		if (form != null){ 
			//Si el id que resive del form es -1, quiere decir que no tiene administracion
			if (form.getId() != null &&  form.getId().equals(-1)){
				return null;
			}
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		}
		return ent;
	}
	
}