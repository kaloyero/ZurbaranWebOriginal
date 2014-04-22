package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.constants.Constants;
import com.contable.common.utils.DateUtil;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.form.DocumentoValPropioForm;
import com.contable.form.DocumentoValTerceForm;
import com.contable.hibernate.model.DocumentoMovimiento;
import com.contable.hibernate.model.DocumentoMovimientoEv_V;
import com.contable.hibernate.model.DocumentoMovimientoIm_V;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;

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

	public DocumentoMovimiento getEntidadDocumentoHeader(DocumentoForm form) {
		DocumentoMovimiento ent = new DocumentoMovimiento();
		
		if (form != null){
			ent.setIdDocumento(form.getId());
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

	public  DocumentoMovimientoForm getForm(DocumentoMovimiento ent) {
		DocumentoMovimientoForm form=new DocumentoMovimientoForm();
		if (ent != null){

		}
		return form;
	}


	public  DocumentoMovimientoValorPropioForm getForm(DocumentoMovimientoVp_V ent) {
		DocumentoMovimientoValorPropioForm form=new DocumentoMovimientoValorPropioForm();
		if (ent != null){
			DocumentoValPropioForm formValorPropio = new DocumentoValPropioForm();
			
//			form.setCodMovimiento(ent.getcodMovimiento);
			form.setId(ent.getMovimientoId());
			form.setDocumentoId(ent.getDocumentoId());
			form.setDescripcion(ent.getDescripcion());
			form.setCotizacion(ent.getCotizacion());
			form.setConceptoNombre(ent.getConceptoNombre());
			form.setConceptoCodigo(ent.getConceptoCodigo());
			form.setCuentaNombre(ent.getCuentaNombre());
			form.setCuentaCodigo(ent.getCuentaCodigo());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setMonedaCodigo(ent.getMonedaCodigo());
			form.setImporte(ent.getImporteMovimiento());
			form.setTipoEntidadNombre(ent.getTipoEntidadNombre());
			
			/* VALOR PROPIO */
			formValorPropio.setBeneficiario(ent.getBeneficiario());
			formValorPropio.setChequeraNombre(ent.getChequeraNombre());
			formValorPropio.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()) );
			formValorPropio.setNumero(ent.getNumero());
			formValorPropio.setIdMovimiento(ent.getMovimientoId());
			form.setValorPropio(formValorPropio);
			
		}
		return form;
	}

	public  DocumentoMovimientoValorTerceForm getForm(DocumentoMovimientoIv_V ent) {
		DocumentoMovimientoValorTerceForm form=new DocumentoMovimientoValorTerceForm();
		if (ent != null){
			DocumentoValTerceForm formValorTerce = new DocumentoValTerceForm();

//			form.setCodMovimiento(ent.getcodMovimiento);
			form.setId(ent.getMovimientoId());
			form.setDocumentoId(ent.getDocumentoId());
			form.setDescripcion(ent.getDescripcion());
			form.setCotizacion(ent.getCotizacion());
			form.setConceptoNombre(ent.getConceptoNombre());
			form.setConceptoCodigo(ent.getConceptoCodigo());
			form.setCuentaNombre(ent.getCuentaNombre());
			form.setCuentaCodigo(ent.getCuentaCodigo());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setMonedaCodigo(ent.getMonedaCodigo());
			form.setImporte(ent.getImporteMovimiento());
			
			/* VALOR TERCERO */
			formValorTerce.setBancoNombre(ent.getBancoNombre());
			formValorTerce.setBeneficiario(ent.getEmisor());
			formValorTerce.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()) );
			formValorTerce.setIdMovimiento(ent.getMovimientoId());
			formValorTerce.setNumero(ent.getNumero());
			form.setValorTerce(formValorTerce);
			
		}
		return form;
	}

	public  DocumentoMovimientoValorTerceForm getForm(DocumentoMovimientoEv_V ent) {
		DocumentoMovimientoValorTerceForm form=new DocumentoMovimientoValorTerceForm();
		if (ent != null){
			DocumentoValTerceForm formValorTerce = new DocumentoValTerceForm();

//			form.setCodMovimiento(ent.getcodMovimiento);
			form.setId(ent.getMovimientoId());
			form.setDocumentoId(ent.getDocumentoId());
			form.setDescripcion(ent.getDescripcion());
			form.setCotizacion(ent.getCotizacion());
			form.setConceptoNombre(ent.getConceptoNombre());
			form.setConceptoCodigo(ent.getConceptoCodigo());
			form.setCuentaNombre(ent.getCuentaNombre());
			form.setCuentaCodigo(ent.getCuentaCodigo());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setMonedaCodigo(ent.getMonedaCodigo());
			form.setImporte(ent.getImporteMovimiento());
			
			/* VALOR TERCERO */
			formValorTerce.setBancoNombre(ent.getBancoNombre());
			formValorTerce.setBeneficiario(ent.getEmisor());
			formValorTerce.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()) );
			formValorTerce.setIdMovimiento(ent.getMovimientoId());
			formValorTerce.setNumero(ent.getNumero());
			form.setValorTerce(formValorTerce);
			
		}
		return form;
	}

	public  DocumentoMovimientoForm getForm(DocumentoMovimientoIm_V ent) {
		DocumentoMovimientoForm form=new DocumentoMovimientoForm();
		if (ent != null){

//			form.setCodMovimiento(ent.getcodMovimiento);
			form.setId(ent.getMovimientoId());
			form.setDocumentoId(ent.getDocumentoId());
			form.setDescripcion(ent.getDescripcion());
			form.setCotizacion(ent.getCotizacion());
			form.setConceptoNombre(ent.getConceptoNombre());
			form.setConceptoCodigo(ent.getConceptoCodigo());
			form.setCuentaNombre(ent.getCuentaNombre());
			form.setCuentaCodigo(ent.getCuentaCodigo());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setMonedaCodigo(ent.getMonedaCodigo());
			form.setImporte(ent.getImporteMovimiento());
			
		}
		return form;
	}
	
	public List<DocumentoMovimientoForm> getFormMovImList(List<DocumentoMovimientoIm_V> list) {
		List<DocumentoMovimientoForm> formList = new ArrayList<DocumentoMovimientoForm>();
		for (DocumentoMovimientoIm_V ent : list) {
			formList.add(getForm(ent));
		}
		return formList;
	}

	public List<DocumentoMovimientoValorTerceForm> getFormMovEvList(List<DocumentoMovimientoEv_V> list) {
		List<DocumentoMovimientoValorTerceForm> formList = new ArrayList<DocumentoMovimientoValorTerceForm>();
		for (DocumentoMovimientoEv_V ent : list) {
			formList.add(getForm(ent));
		}
		return formList;
	}

	public List<DocumentoMovimientoValorTerceForm> getFormMovIvList(List<DocumentoMovimientoIv_V> list) {
		List<DocumentoMovimientoValorTerceForm> formList = new ArrayList<DocumentoMovimientoValorTerceForm>();
		for (DocumentoMovimientoIv_V ent : list) {
			formList.add(getForm(ent));
		}
		return formList;
	}

	public List<DocumentoMovimientoValorPropioForm> getFormMovVpList(List<DocumentoMovimientoVp_V> list) {
		List<DocumentoMovimientoValorPropioForm> formList = new ArrayList<DocumentoMovimientoValorPropioForm>();
		for (DocumentoMovimientoVp_V ent : list) {
			formList.add(getForm(ent));
		}
		return formList;
	}

	
}

