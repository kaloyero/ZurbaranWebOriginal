package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.form.DocumentoValPropioForm;
import com.contable.hibernate.model.DocumentoValorPropio;

public class DocumentoValorPropioMapper extends MapperImpl<DocumentoValorPropio,DocumentoValPropioForm>{


	public DocumentoValorPropio getEntidad(DocumentoValPropioForm form) {
		DocumentoValorPropio ent = new DocumentoValorPropio();
		if (form != null){
			ChequeraMapper mapperChe = new ChequeraMapper();
			
			ent.setId(form.getId());
			ent.setBeneficiario(form.getBeneficiario());
			ent.setChequera(mapperChe.getEntidad(form.getChequera()));
			ent.setFechaVencimiento(DateUtil.convertStringToDate(form.getFechaVencimiento()));
			ent.setIdMovimiento(form.getIdMovimiento());
			ent.setNumero(form.getNumero());
			
		}
		return ent;
	}

	public  DocumentoValPropioForm getForm(DocumentoValorPropio ent) {
		DocumentoValPropioForm form=new DocumentoValPropioForm();
		if (ent != null){
			ChequeraMapper mapperChe = new ChequeraMapper();
			
			form.setId(ent.getId());
			form.setBeneficiario(ent.getBeneficiario());
			form.setChequera(mapperChe.getForm(ent.getChequera()));
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setIdMovimiento(ent.getIdMovimiento());
			form.setNumero(ent.getNumero());

		}
		return form;
	}


	
}