package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.Form;
import com.contable.form.AdministracionForm;
import com.contable.hibernate.model.Administracion;

public class AdministracionMapper {

	public static Administracion getEntidad(Form form) {

		Administracion ent = new Administracion();
		ent.setId(((AdministracionForm) form).getId());
		ent.setNombre(((AdministracionForm) form).getNombre());
		return ent;
	}

	public static  AdministracionForm getForm(Administracion ent) {
		AdministracionForm form=new AdministracionForm();
	
		form.setId(ent.getId());
		form.setNombre(ent.getNombre());
	
		return form;
	}
	
	public static List<AdministracionForm> getFormList(List<Administracion> list) {
		List<AdministracionForm> formList = new ArrayList<AdministracionForm>();
		
		for (Administracion ent : list) {
			formList.add((AdministracionForm)getForm(ent));
		}
	
		return formList;
	}

}