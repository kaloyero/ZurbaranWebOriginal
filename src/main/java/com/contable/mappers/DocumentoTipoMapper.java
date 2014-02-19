package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.Form;
import com.contable.form.DocumentoTipoForm;
import com.contable.hibernate.model.TipoDocumento;

public class DocumentoTipoMapper {

	public TipoDocumento setEntidad(Form form) {

		TipoDocumento ent = new TipoDocumento();
		return ent;
	}

	public static  DocumentoTipoForm getForm(TipoDocumento ent) {
		DocumentoTipoForm form=new DocumentoTipoForm();
	
		return form;
	}
	
	public static List<DocumentoTipoForm> getFormList(List<TipoDocumento> list) {
		List<DocumentoTipoForm> formList = new ArrayList<DocumentoTipoForm>();
		
		for (TipoDocumento ent : list) {
			formList.add((DocumentoTipoForm)getForm(ent));
		}
	
		return formList;
	}

}