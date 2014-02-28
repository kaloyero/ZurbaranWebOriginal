package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.TipoDocumento;

public class TipoDocumentoMapper extends MapperImpl<TipoDocumento,TipoDocumentoForm>{


	public TipoDocumento getEntidad(TipoDocumentoForm form) {
		TipoDocumento ent = new TipoDocumento();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			CuentaMapper mapperCue = new CuentaMapper();
			MonedaMapper mapperMon = new MonedaMapper();
			EntidadMapper mapperEnt = new EntidadMapper();
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setCuenta(mapperCue.getEntidad(form.getCuenta()));
			ent.setMoneda(mapperMon.getEntidad(form.getMoneda()));
			ent.setEntidad(mapperEnt.getEntidad(form.getEntidad()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			ent.setNumeracionFormato(form.getNumeracionFormato()); 
			ent.setNumeracionPeriodo(form.getNumeracionPeriodo());
			ent.setNumeracionTipo(form.getNumeracionTipo());
			ent.setPermiteAplicaciones(form.getPermiteAplicaciones());
			ent.setPermiteEgrValTer(form.getPermiteEgrValTer());
			ent.setPermiteValProp(form.getPermiteValProp());
			ent.setTipoMovimiento(form.getTipoMovimiento());
			ent.setPermiteImputaciones(form.getPermiteImputaciones());
			ent.setPermiteIngValTer(form.getPermiteIngValTer());
		}
		return ent;
	}

	public  TipoDocumentoForm getForm(TipoDocumento ent) {
		TipoDocumentoForm form=new TipoDocumentoForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			CuentaMapper mapperCue = new CuentaMapper();
			MonedaMapper mapperMon = new MonedaMapper();
			EntidadMapper mapperEnt = new EntidadMapper();

			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setCuenta(mapperCue.getForm(ent.getCuenta()));
			form.setMoneda(mapperMon.getForm(ent.getMoneda()));
			form.setEntidad(mapperEnt.getForm(ent.getEntidad()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
			form.setNumeracionFormato(ent.getNumeracionFormato()); 
			form.setNumeracionPeriodo(ent.getNumeracionPeriodo());
			form.setNumeracionTipo(ent.getNumeracionTipo());
			form.setPermiteAplicaciones(ent.getPermiteAplicaciones());
			form.setPermiteEgrValTer(ent.getPermiteEgrValTer());
			form.setPermiteValProp(ent.getPermiteValProp());
			form.setTipoMovimiento(ent.getTipoMovimiento());
			form.setPermiteImputaciones(ent.getPermiteImputaciones());
			form.setPermiteIngValTer(ent.getPermiteIngValTer());

		}
		return form;
	}


}