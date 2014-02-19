package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.Form;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Moneda;

public class MonedaMapper {

	public Moneda setEntidad(Form form) {

		Moneda ent = new Moneda();
		ent.setId(((MonedaForm) form).getId());
		ent.setNombre(((MonedaForm) form).getNombre());
		ent.setCodigo(((MonedaForm) form).getCodigo());
		ent.setAdministracion(AdministracionMapper.getEntidad(((MonedaForm) form).getAdministracion()));
		return ent;
	}

	public static  MonedaForm getForm(Moneda ent) {
		MonedaForm form=new MonedaForm();
	
		form.setId(ent.getId());
		form.setCodigo(ent.getCodigo());
		form.setNombre(ent.getNombre());
		form.setAdministracion(AdministracionMapper.getForm(ent.getAdministracion()));
	
		return form;
	}
	
	public static List<MonedaForm> getFormList(List<Moneda> list) {
		List<MonedaForm> formList = new ArrayList<MonedaForm>();
		
		for (Moneda ent : list) {
			formList.add((MonedaForm)getForm(ent));
		}
	
		return formList;
	}

}