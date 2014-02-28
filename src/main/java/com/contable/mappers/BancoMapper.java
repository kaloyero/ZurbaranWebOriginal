package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.BancoForm;
import com.contable.hibernate.model.Banco;

public class BancoMapper extends MapperImpl<Banco,BancoForm>{


	public Banco getEntidad(BancoForm form) {
		Banco ent = new Banco();
		if (form != null){		
			ent.setId(((BancoForm) form).getId());
			ent.setNombre(((BancoForm) form).getNombre());
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		}
		return ent;
	}

	public  BancoForm getForm(Banco ent) {
		BancoForm form=new BancoForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}


}