package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;

public class ConceptoMapper extends MapperImpl<Concepto,ConceptoForm>{


	public Concepto getEntidad(ConceptoForm form) {
		Concepto ent = new Concepto();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			CuentaMapper mapperCue = new CuentaMapper();
			MonedaMapper mapperMon = new MonedaMapper();
			EntidadMapper mapperEnt = new EntidadMapper();
			
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setCodigo(form.getCodigo());
			ent.setDescripcion(form.getDescripcion());
			ent.setTipoValor(form.getTipoValor());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setCuenta(mapperCue.getEntidad(form.getCuenta()));
			ent.setMoneda(mapperMon.getEntidad(form.getMoneda()));
			ent.setEntidad(mapperEnt.getEntidad(form.getEntidad()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		}
		return ent;
	}

	public  ConceptoForm getForm(Concepto ent) {
		ConceptoForm form=new ConceptoForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			CuentaMapper mapperCue = new CuentaMapper();
			MonedaMapper mapperMon = new MonedaMapper();
			EntidadMapper mapperEnt = new EntidadMapper();
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setCodigo(ent.getCodigo());
			form.setDescripcion(ent.getDescripcion());
			form.setTipoValor(ent.getTipoValor());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setCuenta(mapperCue.getForm(ent.getCuenta()));
			form.setMoneda(mapperMon.getForm(ent.getMoneda()));
			form.setEntidad(mapperEnt.getForm(ent.getEntidad()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
			
		}
		return form;
	}


}