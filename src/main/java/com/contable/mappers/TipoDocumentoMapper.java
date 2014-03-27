package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.Administracion;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.hibernate.model.TipoDocumento_v;

public class TipoDocumentoMapper extends MapperImpl<TipoDocumento,TipoDocumentoForm>{


	public TipoDocumento getEntidad(TipoDocumentoForm form) {
		TipoDocumento ent = new TipoDocumento();
		if (form != null){
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			//administracion
			Administracion adm = new Administracion();
			adm.setId(form.getAdministracionId());
			ent.setAdministracion(adm);
			//Moneda
			MonedaMapper monMap = new MonedaMapper();
			ent.setMoneda(monMap.getEntidad(form.getMoneda()));

			ent.setCuenta(form.getCuentaId());
			ent.setEntidad(form.getEntidadId());
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

			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setAdministracionId(ent.getAdministracion().getId());
			form.setAdministracionNombre(ent.getAdministracion().getNombre());
			form.setCuentaId(ent.getCuenta());
			//moneda
			MonedaMapper monMap = new MonedaMapper();
			form.setMoneda(monMap.getForm(ent.getMoneda()));
			form.setEntidadId(ent.getEntidad());
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

	public  TipoDocumentoForm getForm(TipoDocumento_v ent) {
		TipoDocumentoForm form=new TipoDocumentoForm();
		if (ent != null){

			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setAdministracionId(ent.getAdministracion());
			if (ent.getAdministracion() == null){
				form.setAdministracionNombre("<Todas>");
			} else {
				form.setAdministracionNombre(ent.getAdministracionNombre());
			}
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