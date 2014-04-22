package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.form.DocumentoValTerceForm;
import com.contable.hibernate.model.DocumentoValorTerce;
import com.contable.hibernate.model.DocumentoValorTerceDisp_V;

public class DocumentoValorTerceMapper extends MapperImpl<DocumentoValorTerce,DocumentoValTerceForm>{


	public DocumentoValorTerce getEntidad(DocumentoValTerceForm form) {
		DocumentoValorTerce ent = new DocumentoValorTerce();
		if (form != null){
			BancoMapper mapperBan = new BancoMapper();
			
			ent.setId(form.getId());
			ent.setBanco(mapperBan.getEntidad(form.getBanco()));
			ent.setFechaVencimiento(DateUtil.convertStringToDate(form.getFechaVencimiento()));
			ent.setNumero(form.getNumero());
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

		}
		return form;
	}

	public  DocumentoValTerceForm getForm(DocumentoValorTerceDisp_V ent) {
		DocumentoValTerceForm form=new DocumentoValTerceForm();
		if (ent != null){
			BancoMapper mapperBan = new BancoMapper();

			form.setId(ent.getId());
//			form.setBanco(mapperBan.getForm(ent.getBanco()));
//			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
//			form.setNumero(ent.getNumero());

		}
		return form;
	}

	public List<DocumentoValTerceForm> getFormListView(List<DocumentoValorTerceDisp_V> list) {
		List<DocumentoValTerceForm> formList = new ArrayList<DocumentoValTerceForm>();
		
		for (DocumentoValorTerceDisp_V ent : list) {
			DocumentoValTerceForm form=new DocumentoValTerceForm();
			form.setId(ent.getId());
			form.setBancoId(ent.getBanco());
			form.setBancoNombre("bancoNombre");
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setNumero(ent.getNumero());
			
			formList.add(form);
		}
	
		return formList;
	}

	
}