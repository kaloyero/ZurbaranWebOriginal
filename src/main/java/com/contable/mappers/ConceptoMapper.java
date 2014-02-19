package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.Form;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;

public class ConceptoMapper {

	public Concepto setEntidad(Form form) {

		Concepto ent = new Concepto();
		ent.setId(((ConceptoForm) form).getId());
		ent.setCodigo(((ConceptoForm) form).getCodigo());
		return ent;
	}

	public static  ConceptoForm getForm(Concepto ent) {
		ConceptoForm form=new ConceptoForm();
	
		form.setId(ent.getId());
		form.setCodigo(ent.getCodigo());
	
		return form;
	}
	
	public static List<ConceptoForm> getFormList(List<Concepto> list) {
		List<ConceptoForm> formList = new ArrayList<ConceptoForm>();
		
		for (Concepto ent : list) {
			formList.add((ConceptoForm)getForm(ent));
		}
	
		return formList;
	}

}