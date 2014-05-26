package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.constants.Constants;
import com.contable.common.utils.MapperUtil;
import com.contable.form.AdministracionForm;
import com.contable.form.MonedaForm;
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
			//Si el id de moneda es -1 o null setea NULL
			if (form.getMoneda() == null || form.getMoneda().getId() == null ||  form.getMoneda().getId().equals(-1)){
				ent.setMoneda(null);
			} else {
				MonedaMapper monMap = new MonedaMapper();
				ent.setMoneda(monMap.getEntidad(form.getMoneda()));
			}

			ent.setCuenta(form.getCuentaId());
			//SETEO la Entidad
			if (Constants.UI_ADM_VALUE_TODAS.equals(form.getEntidadId()) ){
				ent.setEntidad(Constants.BD_ADM_VALUE_TODAS);
			} else {
				ent.setEntidad(form.getEntidadId());
			}
			
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
			//Entidad
			//SETEO la Entidad
			if (ent.getEntidad() == Constants.BD_ADM_VALUE_TODAS ){
				form.setEntidadId(Constants.UI_ADM_VALUE_TODAS);
			} else {
				form.setEntidadId(ent.getEntidad());
			}
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
			admForm.setId(ent.getAdministracionId());
			admForm.setNombre(ent.getAdministracionNombre());
			form.setAdministracion(admForm);
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			
			form.setCuentaId(ent.getCuentaId());
			form.setCuentaNombre(ent.getCuentaNombre());
			
			//seteo la moneda
			MonedaForm monedaForm = new MonedaForm();
			monedaForm.setId(ent.getMonedaId());
			monedaForm.setNombre(ent.getMonedaNombre());
			form.setMoneda(monedaForm);

			//SETEO la Entidad
			if (ent.getEntidadId() == Constants.BD_ADM_VALUE_TODAS ){
				form.setEntidadId(Constants.UI_ADM_VALUE_TODAS);
				form.setEntidadNombre(Constants.CAMPO_EXTRA_TODAS);
			} else {
				form.setEntidadId(ent.getEntidadId());
				form.setEntidadNombre(ent.getEntidadNombre());
			}
			form.setTipoEntidadId(ent.getTipoEntidadId());
			form.setTipoEntidadNombre(ent.getTipoEntidadNombre());

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