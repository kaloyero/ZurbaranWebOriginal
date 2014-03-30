package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.MapperUtil;
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Periodo;

public class PeriodoMapper extends MapperImpl<Periodo,PeriodoForm>{


	public Periodo getEntidad(PeriodoForm form) {
		Periodo ent = new Periodo();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
					
			ent.setId(form.getId());
			ent.setFechaIni(DateUtil.convertStringToDate(form.getFechaIni()));
			ent.setFechaFin(DateUtil.convertStringToDate(form.getFechaFin()));
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));

		}
		return ent;
	}
	
	public  PeriodoForm getForm(Periodo ent) {
		PeriodoForm form=new PeriodoForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			
			form.setId(ent.getId());
			form.setFechaIni(DateUtil.convertDateToString(ent.getFechaIni()));
			form.setFechaFin(DateUtil.convertDateToString(ent.getFechaFin()));
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}

}