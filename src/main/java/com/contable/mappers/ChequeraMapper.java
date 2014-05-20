package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.ChequeraForm;
import com.contable.hibernate.model.Chequera;
import com.contable.hibernate.model.Chequera_V;

public class ChequeraMapper extends MapperImpl<Chequera,ChequeraForm>{


	public Chequera getEntidad(ChequeraForm form) {
		Chequera ent = new Chequera();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			MonedaMapper mapperMon = new MonedaMapper();
					
			ent.setId(form.getId());
			ent.setNumeroIni(form.getNumeroIni());
			ent.setNumeroFin(form.getNumeroFin());
			ent.setCuentaId(form.getCuentaId());
			ent.setEntidadId(form.getEntidadId());
			ent.setTipoEntidadId(form.getTipoEntidadId());
			ent.setDescripcion(form.getDescripcion());
			if (form.getAdministracion() != null)
				ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			if (form.getMoneda() != null)
				ent.setMoneda(mapperMon.getEntidad(form.getMoneda()));

			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));

		}
		return ent;
	}
	
	public  ChequeraForm getForm(Chequera ent) {
		ChequeraForm form=new ChequeraForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			MonedaMapper mapperMon = new MonedaMapper();
					
			form.setId(ent.getId());
			form.setNumeroIni(ent.getNumeroIni());
			form.setNumeroFin(ent.getNumeroFin());
			form.setCuentaId(ent.getCuentaId());
			form.setEntidadId(ent.getEntidadId());
			form.setTipoEntidadId(ent.getTipoEntidadId());
			form.setDescripcion(ent.getDescripcion());
			if (ent.getAdministracion() != null)
				form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			if (ent.getMoneda() != null)
				form.setMoneda(mapperMon.getForm(ent.getMoneda()));

			form.setEstado(MapperUtil.getStatusToEntity(ent.getEstado()));
		}
		return form;
	}

	public  ChequeraForm getForm(Chequera_V ent) {
		ChequeraForm form=new ChequeraForm();
		if (ent != null){
					
			form.setId(ent.getId());
			form.setNumeroIni(ent.getNumeroIni());
			form.setNumeroFin(ent.getNumeroFin());
			form.setCuentaNombre(ent.getCuentaNombre());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setTipoEntidadNombre(ent.getTipoEntidadNombre());
			form.setAdministracionNombre(ent.getAdministracionNombre());
			form.setMonedaCodigo(ent.getMonedaCodigo());
			form.setDescripcion(ent.getDescripcion());
			form.setEstado(MapperUtil.getStatusToEntity(ent.getEstado()));
		}
		return form;
	}

	public List<ChequeraForm> getFormViewList(List<Chequera_V> list) {
		List<ChequeraForm> formList = new ArrayList<ChequeraForm>();
		
		for (Chequera_V ent : list) {
			formList.add((ChequeraForm)getForm(ent));
		}
	
		return formList;
	}

}