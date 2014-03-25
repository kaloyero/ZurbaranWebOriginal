package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.DocumentoForm;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.Documento_v;

public class DocumentoMapper extends MapperImpl<Documento,DocumentoForm>{


	public Documento getEntidad(DocumentoForm form) {
		Documento ent = new Documento();
		if (form != null){
			ent.setId(form.getId());
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			ent.setTipoMovimiento(form.getTipoMovimiento());
		}
		return ent;
	}

	public  DocumentoForm getForm(Documento ent) {
		DocumentoForm form=new DocumentoForm();
		if (ent != null){

			form.setId(ent.getId());
			form.setCuentaId(ent.getIdCuenta());
			form.setMonedaId(ent.getIdMoneda());
			form.setEntidadId(ent.getIdEntidad());
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
			form.setTipoMovimiento(ent.getTipoMovimiento());

		}
		return form;
	}

	public  DocumentoForm getForm(Documento_v ent) {
		DocumentoForm form=new DocumentoForm();
		if (ent != null){

			form.setId(ent.getId());
			form.setAdministracionId(ent.getAdministracion());
			if (ent.getAdministracion() == null){
				form.setAdministracionNombre("<Todas>");
			} else {
				form.setAdministracionNombre(ent.getAdministracionNombre());
			}
			form.setCuentaId(ent.getCuenta());
			form.setCuentaNombre(ent.getCuentaNombre());
			form.setMonedaId(ent.getMoneda());
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setEntidadId(ent.getEntidad());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}
	
	public List<DocumentoForm> getFormViewList(List<Documento_v> list) {
		List<DocumentoForm> formList = new ArrayList<DocumentoForm>();
		
		for (Documento_v ent : list) {
			formList.add((DocumentoForm)getForm(ent));
		}
	
		return formList;
	}

}