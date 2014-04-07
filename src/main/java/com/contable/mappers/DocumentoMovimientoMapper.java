package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.constants.Constants;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.hibernate.model.DocumentoMovimiento;

public class DocumentoMovimientoMapper extends MapperImpl<DocumentoMovimiento,DocumentoMovimientoForm>{

	public DocumentoMovimiento getEntidad(DocumentoMovimientoForm form) {
		DocumentoMovimiento ent = new DocumentoMovimiento();
		if (form != null){
			
			ent.setId(form.getId());
			ent.setConceptoId(form.getConceptoId());
			ent.setCodMovimiento(form.getCodMovimiento());
			ent.setCotizacion(form.getCotizacion());
			ent.setCuentaId(form.getCuentaId());
			ent.setDescripcion(form.getDescripcion());
			ent.setEntidadId(form.getEntidadId());
			ent.setIdDocumento(form.getDocumentoId());
			ent.setImporte(form.getImporte());
			ent.setMonedaId(form.getMonedaId());
			ent.setTipoEntidadId(form.getTipoEntidadId());
			ent.setTipoMovimiento(form.getTipoMovimiento());
		}
		return ent;
	}

	public DocumentoMovimiento getEntidadDocumentoHeader(DocumentoForm form,int documentoId) {
		DocumentoMovimiento ent = new DocumentoMovimiento();
		
		if (form != null){
			ent.setIdDocumento(documentoId);
			ent.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_ENCABEZADO);
			
			ent.setId(form.getId());
			ent.setCotizacion(form.getCotizacion());
			ent.setCuentaId(form.getCuentaId());
			ent.setDescripcion(form.getDescripcion());
			ent.setEntidadId(form.getEntidadId());
			ent.setImporte(form.getImporteTotal());
			ent.setMonedaId(form.getMonedaId());
			ent.setTipoEntidadId(form.getTipoEntidadId());
			ent.setTipoMovimiento(form.getTipoMovimiento());
		}
		return ent;
	}

	public DocumentoMovimiento getEntidadDocumentoImputaciones(DocumentoMovimientoForm form,int documentoId) {
		
		DocumentoMovimiento ent = getEntidad(form);
		
		if (form != null){
			ent.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_IMPUTACIONES);
			ent.setIdDocumento(documentoId);
		}
		return ent;
	}

	public DocumentoMovimiento getEntidadDocumentoIngreValor(DocumentoMovimientoValorTerceForm form,int documentoId) {
		
		DocumentoMovimiento ent = getEntidad(form);
		
		if (form != null){
			ent.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_INGRESOVALORES);
			ent.setIdDocumento(documentoId);
		}
		return ent;
	}

	public DocumentoMovimiento getEntidadDocumentoEgreValor(DocumentoMovimientoValorTerceForm form,int documentoId) {
		
		DocumentoMovimiento ent = getEntidad(form);
		
		if (form != null){
			ent.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_EGRESOVALOERS);
			ent.setIdDocumento(documentoId);
		}
		return ent;
	}

	public DocumentoMovimiento getEntidadDocumentoValorPropio(DocumentoMovimientoValorPropioForm form,int documentoId) {
		
		DocumentoMovimiento ent = getEntidad(form);
		
		if (form != null){
			ent.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS);
			ent.setIdDocumento(documentoId);
		}
		return ent;
	}

	
	public  DocumentoMovimientoForm getForm(DocumentoMovimiento ent) {
		DocumentoMovimientoForm form=new DocumentoMovimientoForm();
		if (ent != null){

		}
		return form;
	}


}