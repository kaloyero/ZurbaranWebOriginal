package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.form.DocumentoValTerceForm;
import com.contable.hibernate.model.DocumentoValorTerce;
import com.contable.hibernate.model.DocumentoValorTerceIngre_V;

public class DocumentoValorTerceMapper extends MapperImpl<DocumentoValorTerce,DocumentoValTerceForm>{


	public DocumentoValorTerce getEntidad(DocumentoValTerceForm form) {
		DocumentoValorTerce ent = new DocumentoValorTerce();
		if (form != null){
			BancoMapper mapperBan = new BancoMapper();
			
			ent.setId(form.getId());
			ent.setBanco(mapperBan.getEntidad(form.getBanco()));
			ent.setFechaVencimiento(DateUtil.convertStringToDate(form.getFechaVencimiento()));
			ent.setNumero(form.getNumero());
			ent.setIdValorTerMov(form.getIdValorTerceMov());
		}
		return ent;
	}

	public  DocumentoValTerceForm getForm(DocumentoValorTerce ent) {
		DocumentoValTerceForm form=new DocumentoValTerceForm();
		if (ent != null){
			BancoMapper mapperBan = new BancoMapper();

			form.setId(ent.getId());
			form.setBanco(mapperBan.getForm(ent.getBanco()));
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setNumero(ent.getNumero());
			form.setIdValorTerceMov(ent.getIdValorTerMov());

		}
		return form;
	}

	public  DocumentoValTerceForm getForm(DocumentoValorTerceIngre_V ent) {
		DocumentoValTerceForm form=new DocumentoValTerceForm();
		if (ent != null){
			BancoMapper mapperBan = new BancoMapper();

			form.setId(ent.getId());
			form.setBanco(mapperBan.getForm(ent.getBanco()));
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setNumero(ent.getNumero());
			form.setIdValorTerceMov(ent.getIdValorTerMov());

		}
		return form;
	}

	
}