package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.ChequeraForm;
import com.contable.hibernate.model.Chequera;

public class ChequeraMapper extends MapperImpl<Chequera,ChequeraForm>{


	public Chequera getEntidad(ChequeraForm form) {
		Chequera ent = new Chequera();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
					
			ent.setId(form.getId());
			ent.setNumeroIni(form.getNumeroIni());
			ent.setNumeroFin(form.getNumeroFin());
			if (form.getConceptoId() != null)
				ent.setConceptosId(form.getConceptoId());
			if (form.getAdministracion() != null)
				ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
   
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));

		}
		return ent;
	}
	
	public  ChequeraForm getForm(Chequera ent) {
		ChequeraForm form=new ChequeraForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			
			form.setId(ent.getId());
			form.setNumeroIni(ent.getNumeroIni());
			form.setNumeroFin(ent.getNumeroFin());
			form.setConceptoId(ent.getConceptosId());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}

}