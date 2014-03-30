package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Moneda;

public class MonedaMapper extends MapperImpl<Moneda,MonedaForm>{


	public Moneda getEntidad(MonedaForm form) {
		Moneda ent = new Moneda();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
					
			form.setId(MapperUtil.formValidNull(ent.getId()));
			ent.setNombre(((MonedaForm) form).getNombre());
			ent.setCodigo(((MonedaForm) form).getCodigo());
			ent.setMonedaLocal(((MonedaForm) form).getMonedaLocal());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		}
		return ent;
	}
	
	public  MonedaForm getForm(Moneda ent) {
		MonedaForm form=new MonedaForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			
			//Si el id que resive del form es -1, quiere decir que no tiene administracion
			if (form.getId().equals(-1)){
				return null;
			}
			form.setCodigo(ent.getCodigo());
			form.setNombre(ent.getNombre());
			form.setMonedaLocal(ent.getMonedaLocal());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}

}