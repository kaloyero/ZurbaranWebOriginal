package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.BancoForm;
import com.contable.hibernate.model.Banco;

public class BancoMapper extends MapperImpl<Banco,BancoForm>{


	public Banco getEntidad(BancoForm form) {
		Banco ent = new Banco();
		
		ent.setId(((BancoForm) form).getId());
		ent.setNombre(((BancoForm) form).getNombre());
		
		return ent;
	}

	public  BancoForm getForm(Banco ent) {
		BancoForm form=new BancoForm();
		
		form.setId(ent.getId());
		form.setNombre(ent.getNombre());
	
		return form;
	}


}