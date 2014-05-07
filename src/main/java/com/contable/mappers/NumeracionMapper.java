package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.beans.NumeroBean;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.DocumentoForm;
import com.contable.form.NumeracionForm;
import com.contable.hibernate.model.Numeracion;

public class NumeracionMapper extends MapperImpl<Numeracion,NumeracionForm>{


	public Numeracion getEntidad(NumeracionForm form) {
		Numeracion ent = new Numeracion();
		if (form != null){
			ent.setId(form.getId());
			//administracion
//			AdministracionMapper mapperAdm = new AdministracionMapper();
//			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setNumeroEstablecimiento(form.getNumeroEstablecimiento());
			ent.setNumeroAnio(form.getNumeroAnio());
			ent.setNumeroDia(form.getNumeroDia());
			ent.setNumeroMes(form.getNumeroMes());
			ent.setNumeroLetra(form.getNumeroLetra());
			ent.setUltimoNumero(form.getUltimoNumero());
			ent.setTipoDocumentoId(form.getTipoDocumentoId());
			ent.setAdministracionId(form.getAdministracionId());

		}
		return ent;
	}

	public NumeroBean getEntidad(DocumentoForm form) {
		NumeroBean ent = new NumeroBean();
		if (form != null){
			ent.setNumeroEstablecimiento(ConvertionUtil.StrValueOf(form.getNumeroEstablecimiento()));
			ent.setNumeroAnio(ConvertionUtil.StrValueOf(form.getNumeroAnio()));
			ent.setNumeroDia(ConvertionUtil.StrValueOf(form.getNumeroDia()));
			ent.setNumeroMes(ConvertionUtil.StrValueOf(form.getNumeroMes()));
			ent.setNumeroLetra(form.getNumeroLetra());
			ent.setNumero(ConvertionUtil.StrValueOf(form.getNumero()));
		}
		return ent;
	}

	public  NumeracionForm getForm(Numeracion ent) {
		NumeracionForm form=new NumeracionForm();
		if (ent != null){

			form.setId(ent.getId());
			form.setNumeroEstablecimiento(ent.getNumeroEstablecimiento());
			form.setNumeroAnio(ent.getNumeroAnio());
			form.setNumeroDia(ent.getNumeroDia());
			form.setNumeroMes(ent.getNumeroMes());
			form.setNumeroLetra(ent.getNumeroLetra());
			form.setUltimoNumero(ent.getUltimoNumero());
			form.setTipoDocumentoId(ent.getTipoDocumentoId());
			form.setAdministracionId(ent.getAdministracionId());

		}
		return form;
	}

	
}