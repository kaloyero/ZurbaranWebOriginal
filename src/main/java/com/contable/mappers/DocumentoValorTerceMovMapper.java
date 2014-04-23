package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.hibernate.model.DocumentoValorTerceMov;

public class DocumentoValorTerceMovMapper extends MapperImpl<DocumentoValorTerceMov,DocumentoMovimientoValorTerceForm>{


	public DocumentoValorTerceMov getEntidad(DocumentoMovimientoValorTerceForm form) {
		DocumentoValorTerceMov ent = new DocumentoValorTerceMov();
		if (form != null){
			DocumentoValorTerceMapper mapperTer = new DocumentoValorTerceMapper();
			
				ent.setId(form.getId());	
				ent.setTipoMovimiento(form.getTipoMovimientoValorTerce());
				ent.setIdMovimiento(form.getIdMovimiento());
				ent.setValorTerce(mapperTer.getEntidad(form.getValorTerce()));
			
		}
		return ent;
	}

	public  DocumentoMovimientoValorTerceForm getForm(DocumentoValorTerceMov ent) {
		DocumentoMovimientoValorTerceForm form=new DocumentoMovimientoValorTerceForm();
		if (ent != null){
			DocumentoValorTerceMapper mapperTer = new DocumentoValorTerceMapper();
			
			form.setId(ent.getId());
			form.setTipoMovimientoValorTerce(ent.getTipoMovimiento());
			form.setIdMovimiento(ent.getIdMovimiento());
			form.setValorTerce(mapperTer.getForm(ent.getValorTerce()));
		}
		return form;
	}

	
}