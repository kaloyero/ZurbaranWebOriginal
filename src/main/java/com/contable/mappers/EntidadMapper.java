package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.Form;
import com.contable.form.EntidadForm;
import com.contable.hibernate.model.Entidad;

public class EntidadMapper {

	public Entidad setEntidad(Form form) {

		Entidad ent = new Entidad();
		ent.setId(((EntidadForm) form).getId());
		ent.setCodigoReferencia(((EntidadForm) form).getCodigoReferencia());
		ent.setNombre(((EntidadForm) form).getNombre());
//		ent.setIdTipoEntidad(((EntidadForm) form).getTipo());
		return ent;
	}

	public static  EntidadForm getForm(Entidad ent) {
		EntidadForm form=new EntidadForm();
	
		form.setId(ent.getId());
		form.setCodigoReferencia(ent.getCodigoReferencia());
		form.setNombre(ent.getNombre());
//		form.setTipo(ent.getIdTipoEntidad());
	
		return form;
	}
	
	public static List<EntidadForm> getFormList(List<Entidad> list) {
		List<EntidadForm> formList = new ArrayList<EntidadForm>();
		
		for (Entidad ent : list) {
			formList.add((EntidadForm)getForm(ent));
		}
	
		return formList;
	}

}