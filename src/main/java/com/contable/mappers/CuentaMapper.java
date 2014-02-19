package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.Form;
import com.contable.form.CuentaForm;
import com.contable.hibernate.model.Cuenta;

public class CuentaMapper {

	public Cuenta setEntidad(Form form) {

		Cuenta ent = new Cuenta();
		ent.setId(((CuentaForm) form).getId());
		ent.setCodigo(((CuentaForm) form).getCodigo());
//		ent.setDescripcion(((CuentaForm) form).get());
//		ent.setIdAdministracion(((CuentaForm) form).getAdministracion());
		ent.setCodigo(((CuentaForm) form).getCodigo());
		ent.setCodigo(((CuentaForm) form).getCodigo());
		ent.setCodigo(((CuentaForm) form).getCodigo());
		return ent;
	}

	public static  CuentaForm getForm(Cuenta ent) {
		CuentaForm form=new CuentaForm();
	
		form.setId(ent.getId());
		form.setCodigo(ent.getCodigo());
	
		return form;
	}
	
	public static List<CuentaForm> getFormList(List<Cuenta> list) {
		List<CuentaForm> formList = new ArrayList<CuentaForm>();
		
		for (Cuenta ent : list) {
			formList.add((CuentaForm)getForm(ent));
		}
	
		return formList;
	}

}