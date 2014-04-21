package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.AdministracionForm;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.hibernate.model.TipoDocumento_v;

public class TipoDocumentoMapper extends MapperImpl<TipoDocumento,TipoDocumentoForm>{


	public TipoDocumento getEntidad(TipoDocumentoForm form) {
		TipoDocumento ent = new TipoDocumento();
		if (form != null){
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			//administracion
			AdministracionMapper mapperAdm = new AdministracionMapper();
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			//Moneda
			MonedaMapper monMap = new MonedaMapper();
			ent.setMoneda(monMap.getEntidad(form.getMoneda()));

			ent.setCuenta(form.getCuentaId());
			ent.setEntidad(form.getEntidadId());
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			ent.setNumeracionFormato(form.getNumeracionFormato()); 
			ent.setNumeracionPeriodo(form.getNumeracionPeriodo());
			ent.setNumeracionTipo(form.getNumeracionTipo());
			ent.setPermiteAplicaciones(MapperUtil.getPermisoEntityValue(form.getPermiteAplicaciones()));
			ent.setPermiteEgrValTer(MapperUtil.getPermisoEntityValue(form.getPermiteEgrValTer()));
			ent.setPermiteValProp(MapperUtil.getPermisoEntityValue(form.getPermiteValProp()));
			ent.setPermiteImputaciones(MapperUtil.getPermisoEntityValue(form.getPermiteImputaciones()));
			ent.setPermiteIngValTer(MapperUtil.getPermisoEntityValue(form.getPermiteIngValTer()));
			ent.setTipoMovimiento(form.getTipoMovimiento());
		}
		return ent;
	}

	public  TipoDocumentoForm getForm(TipoDocumento ent) {
		TipoDocumentoForm form=new TipoDocumentoForm();
		if (ent != null){

			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			//administracion
			AdministracionMapper mapperAdm = new AdministracionMapper();
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setCuentaId(ent.getCuenta());
			//moneda
			MonedaMapper monMap = new MonedaMapper();
			form.setMoneda(monMap.getForm(ent.getMoneda()));
			form.setEntidadId(ent.getEntidad());
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
			form.setNumeracionFormato(ent.getNumeracionFormato()); 
			form.setNumeracionPeriodo(ent.getNumeracionPeriodo());
			form.setNumeracionTipo(ent.getNumeracionTipo());
			form.setTipoMovimiento(ent.getTipoMovimiento());
			form.setPermiteAplicaciones(MapperUtil.getPermisoFormValue(ent.getPermiteAplicaciones()));
			form.setPermiteEgrValTer(MapperUtil.getPermisoFormValue(ent.getPermiteEgrValTer()));
			form.setPermiteValProp(MapperUtil.getPermisoFormValue(ent.getPermiteValProp()));
			form.setPermiteImputaciones(MapperUtil.getPermisoFormValue(ent.getPermiteImputaciones()));
			form.setPermiteIngValTer(MapperUtil.getPermisoFormValue(ent.getPermiteIngValTer()));

		}
		return form;
	}

	public  TipoDocumentoForm getForm(TipoDocumento_v ent) {
		TipoDocumentoForm form=new TipoDocumentoForm();
		if (ent != null){

			AdministracionForm admForm = new AdministracionForm();
			admForm.setId(ent.getAdministracion());
			admForm.setNombre(ent.getAdministracionNombre());
			form.setAdministracion(admForm);
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setCuentaId(ent.getCuenta());
			form.setCuentaNombre(ent.getCuentaNombre());
			//form.setMonedaId(ent.getMoneda());
			//form.setMonedaNombre(ent.getMonedaNombre());
			form.setEntidadId(ent.getEntidad());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}

public List<TipoDocumentoForm> getFormViewList(List<TipoDocumento_v> list) {
		List<TipoDocumentoForm> formList = new ArrayList<TipoDocumentoForm>();
		
		for (TipoDocumento_v ent : list) {
			formList.add((TipoDocumentoForm)getForm(ent));
		}
	
		return formList;
	}

}