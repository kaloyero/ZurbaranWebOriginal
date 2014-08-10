package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.ChequeraNoDisponibleForm;
import com.contable.hibernate.model.ChequeraNoDisponible;

public class ChequeraNoDisponibleMapper extends MapperImpl<ChequeraNoDisponible,ChequeraNoDisponibleForm>{

	public ChequeraNoDisponible getEntidad(ChequeraNoDisponibleForm form) {
		ChequeraNoDisponible ent = new ChequeraNoDisponible();
		if (form != null){
			ChequeraMapper mapperChe = new ChequeraMapper();
					
			ent.setId(form.getId());
			ent.setNumero(form.getNumero());
//			ent.setBeneficiario(form.getBeneficiario());
			ent.setImporte(ConvertionUtil.DouValueOf(form.getImporte()));
			ent.setMotivo(form.getMotivo());
//			ent.setFechaEmision(DateUtil.convertStringToDate(form.getFechaEmision()));
//			ent.setFechaVto(DateUtil.convertStringToDate(form.getFechaVto()));
			if (form.getChequera() != null)
				ent.setChequera(mapperChe.getEntidad(form.getChequera()));

		}
		return ent;
	}
	
	public  ChequeraNoDisponibleForm getForm(ChequeraNoDisponible ent) {
		ChequeraNoDisponibleForm form=new ChequeraNoDisponibleForm();
		if (ent != null){
			ChequeraMapper mapperChe = new ChequeraMapper();
			
			form.setId(ent.getId());
			form.setNumero(ent.getNumero());
//			form.setBeneficiario(ent.getBeneficiario());
			form.setImporte(ConvertionUtil.StrValueOf(ent.getImporte()));
			form.setMotivo(ent.getMotivo());
//			form.setFechaEmision(DateUtil.convertDateToString(ent.getFechaEmision()));
//			form.setFechaVto(DateUtil.convertDateToString(ent.getFechaVto()));
			if (ent.getChequera() != null)
				form.setChequera(mapperChe.getForm(ent.getChequera()));
		}
		return form;
	}

}