package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.CuentaForm;
import com.contable.hibernate.model.Cuenta;

public class CuentaMapper extends MapperImpl<Cuenta,CuentaForm>{


	public Cuenta getEntidad(CuentaForm form) {
		Cuenta ent = new Cuenta();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
			MonedaMapper mapperMon = new MonedaMapper();
			
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setCodigo(form.getCodigo());
			ent.setDescripcion(form.getDescripcion());
			ent.setTipoSaldo(form.getSaldo());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setTipoEntidad(mapperTpEnt.getEntidad(form.getTipoEntidad()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			/* FIN lista de monedas */
			
		}
		return ent;
	}

	public  CuentaForm getForm(Cuenta ent) {
		CuentaForm form=new CuentaForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
			MonedaMapper mapperMon = new MonedaMapper();
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setCodigo(ent.getCodigo());
			form.setSaldo(ent.getTipoSaldo());
			form.setDescripcion(ent.getDescripcion());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setTipoEntidad(mapperTpEnt.getForm(ent.getTipoEntidad()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}


}