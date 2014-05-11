package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.PeriodoSaldoForm;
import com.contable.hibernate.model.PeriodoSaldo;

public class PeriodoSaldoMapper extends MapperImpl<PeriodoSaldo,PeriodoSaldoForm>{


	public PeriodoSaldo getEntidad(PeriodoSaldoForm form) {
		PeriodoSaldo ent = new PeriodoSaldo();
		if (form != null){
			MonedaMapper mapperMon = new MonedaMapper();
			PeriodoMapper mapperPer = new PeriodoMapper();
					
			ent.setId(form.getId());
			ent.setCuentaId(form.getCuentaId());
			ent.setEntidadId(form.getEntidadId());
			if (form.getMoneda() ==  null || form.getMoneda().getId() == null || form.getMoneda().equals(-1)){
				ent.setMoneda(null);
			} else {
				ent.setMoneda(mapperMon.getEntidad(form.getMoneda()));
			}
			ent.setPeriodo(mapperPer.getEntidad(form.getPeriodo()));
			ent.setSaldoFin(form.getSaldoFin());
			ent.setSaldoFinMonLocal(form.getSaldoFinMonLocal());
			ent.setSaldoIni(form.getSaldoIni());
			ent.setSaldoIniMonLocal(form.getSaldoIniMonLocal());
			ent.setTipoEntidadId(form.getTipoEntidadId());
			
		}
		return ent;
	}
	
	public  PeriodoSaldoForm getForm(PeriodoSaldo ent) {
		PeriodoSaldoForm form=new PeriodoSaldoForm();
		if (ent != null){
			MonedaMapper mapperMon = new MonedaMapper();
			PeriodoMapper mapperPer = new PeriodoMapper();
			
			form.setId(ent.getId());
			form.setCuentaId(ent.getCuentaId());
			form.setEntidadId(ent.getEntidadId());
			form.setMoneda(mapperMon.getForm(ent.getMoneda()));
			form.setPeriodo(mapperPer.getForm(ent.getPeriodo()));
			form.setSaldoFin(ent.getSaldoFin());
			form.setSaldoFinMonLocal(ent.getSaldoFinMonLocal());
			form.setSaldoIni(ent.getSaldoIni());
			form.setSaldoIniMonLocal(ent.getSaldoIniMonLocal());
			form.setTipoEntidadId(ent.getTipoEntidadId());
		}
		return form;
	}

}