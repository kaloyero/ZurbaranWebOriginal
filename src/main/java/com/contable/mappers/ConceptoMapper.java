package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;

public class ConceptoMapper extends MapperImpl<Concepto,ConceptoForm>{


	public Concepto getEntidad(ConceptoForm form) {
		Concepto ent = new Concepto();
		AdministracionMapper mapperAdm = new AdministracionMapper();
		CuentaMapper mapperCue = new CuentaMapper();
		
		ent.setId(form.getId());
		ent.setNombre(form.getNombre());
		ent.setCodigo(form.getCodigo());
		ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
		ent.setCuenta(mapperCue.getEntidad(form.getCuenta()));
		ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		return ent;
	}

	public  ConceptoForm getForm(Concepto ent) {
		ConceptoForm form=new ConceptoForm();
		AdministracionMapper mapperAdm = new AdministracionMapper();
		CuentaMapper mapperCue = new CuentaMapper();
		
		form.setId(ent.getId());
		form.setNombre(ent.getNombre());
		form.setCodigo(ent.getCodigo());
		form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
		form.setCuenta(mapperCue.getForm(ent.getCuenta()));
		form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		
		return form;
	}


}