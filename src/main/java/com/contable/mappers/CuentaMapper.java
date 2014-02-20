package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.CuentaForm;
import com.contable.hibernate.model.Cuenta;

public class CuentaMapper extends MapperImpl<Cuenta,CuentaForm>{


	public Cuenta getEntidad(CuentaForm form) {
		Cuenta ent = new Cuenta();
		AdministracionMapper mapperAdm = new AdministracionMapper();
		TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
		
		ent.setId(form.getId());
		ent.setNombre(form.getNombre());
		ent.setCodigo(form.getCodigo());
		ent.setDescripcion(form.getDescripcion());
		ent.setTipoSaldo(form.getSaldo());
		ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
		ent.setTipoEntidad(mapperTpEnt.getEntidad(form.getTipoEntidad()));

		return ent;
	}

	public  CuentaForm getForm(Cuenta ent) {
		CuentaForm form=new CuentaForm();
		AdministracionMapper mapperAdm = new AdministracionMapper();
		TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
		
		form.setId(ent.getId());
		form.setNombre(ent.getNombre());
		form.setCodigo(ent.getCodigo());
		form.setSaldo(ent.getTipoSaldo());
		form.setDescripcion(ent.getDescripcion());
		form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
		form.setTipoEntidad(mapperTpEnt.getForm(ent.getTipoEntidad()));
		
		return form;
	}


}