package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.Form;
import com.contable.form.BancoForm;
import com.contable.hibernate.model.Banco;

public class BancoMapper {

	public Banco setEntidad(Form form) {

		Banco ent = new Banco();
//		ent.setId(((BancoForm) form).getId());
//		ent.setCodigo(((BancoForm) form).getCodigo());
		return ent;
	}

	public static  BancoForm getForm(Banco ent) {
		BancoForm form=new BancoForm();
	
//		form.setId(ent.getId());
//		form.setCodigo(ent.getCodigo());
	
		return form;
	}
	
	public static List<BancoForm> getFormList(List<Banco> list) {
		List<BancoForm> formList = new ArrayList<BancoForm>();
		
		for (Banco ent : list) {
			formList.add((BancoForm)getForm(ent));
		}
	
		return formList;
	}

}