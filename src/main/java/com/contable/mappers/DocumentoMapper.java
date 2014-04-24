package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.DocumentoUtil;
import com.contable.common.utils.MapperUtil;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacion;
import com.contable.hibernate.model.Documento_v;

public class DocumentoMapper extends MapperImpl<Documento,DocumentoForm>{


	public Documento getEntidad(DocumentoForm form) {
		Documento ent = new Documento();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			
			ent.setId(form.getId());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setCotizacion(form.getCotizacion());
			ent.setCuentaId(form.getCuentaId());
			ent.setDescripcion(form.getDescripcion());
			ent.setDocumentoAnulaaId(form.getDocumentoAnulaaId());
			ent.setDocumentoAnuladoPorId(form.getDocumentoAnuladoPorId());
			ent.setEntidadId(form.getEntidadId());
			ent.setEstado(form.getEstado());
			ent.setFechaIngreso(DateUtil.convertStringToDate(form.getFechaIngreso()));
			ent.setFechaReal(DateUtil.convertStringToDate(form.getFechaReal()));
			ent.setFechaVencimiento(DateUtil.convertStringToDate(form.getFechaVencimiento()));
			ent.setImporteAplicado(form.getImporteAplicado());
			ent.setImporteTotal(form.getImporteTotal());
			ent.setMonedaId(form.getMonedaId());
			ent.setNumero(form.getNumero());
			ent.setNumeroAnio(form.getNumeroAnio());
			ent.setNumeroMes(form.getNumeroMes());
			ent.setNumeroDia(form.getNumeroDia());
			ent.setNumeroEstablecimiento(form.getNumeroEstablecimiento());
			ent.setNumeroLetra(form.getNumeroLetra());
			ent.setPeriodoId(form.getPeriodoId());
			ent.setTipoDocumentoId(form.getTipoDocumentoId());
			ent.setTipoEntidadId(form.getTipoEntidadId());
			ent.setTipoMovimiento(form.getTipoMovimiento());
		
		}
		return ent;
	}

	public  DocumentoForm getForm(Documento ent) {
		DocumentoForm form=new DocumentoForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			
			form.setId(ent.getId());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setCotizacion(ent.getCotizacion());
			form.setCuentaId(ent.getCuentaId());
			form.setDescripcion(ent.getDescripcion());
			form.setDocumentoAnulaaId(ent.getDocumentoAnulaaId());
			form.setDocumentoAnuladoPorId(ent.getDocumentoAnuladoPorId());
			form.setEntidadId(ent.getEntidadId());
			form.setEstado(ent.getEstado());
			form.setFechaIngreso(DateUtil.convertDateToString(ent.getFechaIngreso()));
			form.setFechaReal(DateUtil.convertDateToString(ent.getFechaReal()));
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setImporteAplicado(ent.getImporteAplicado());
			form.setImporteTotal(ent.getImporteTotal());
			form.setMonedaId(ent.getMonedaId());
			form.setNumero(ent.getNumero());
			form.setNumeroAnio(ent.getNumeroAnio());
			form.setNumeroMes(ent.getNumeroMes());
			form.setNumeroDia(ent.getNumeroDia());
			form.setNumeroEstablecimiento(ent.getNumeroEstablecimiento());
			form.setNumeroLetra(ent.getNumeroLetra());
			form.setPeriodoId(ent.getPeriodoId());
			form.setTipoDocumentoId(ent.getTipoDocumentoId());
			form.setTipoEntidadId(ent.getTipoEntidadId());
			form.setTipoMovimiento(ent.getTipoMovimiento());

		}
		return form;
	}

	public  DocumentoForm getForm(Documento_v ent) {
		DocumentoForm form=new DocumentoForm();
		if (ent != null){
//			AdministracionMapper mapperAdm = new AdministracionMapper();

			/* SETEO el ID */
			form.setId(ent.getId());
			/* SETEO la Numeracion */
			String numeroFormat = DocumentoUtil.getNumeroFormato(form.getNumeroLetra(), form.getNumeroEstablecimiento(), 
											form.getNumeroAnio(), form.getNumeroMes(), form.getNumeroDia(), form.getNumero());
			form.setNumeroFormateado(numeroFormat);
			/* SETEO la Descripcion */
			form.setDescripcion(ent.getDescripcion());
			/* SETEO las Fechas */
			form.setFechaIngreso(DateUtil.convertDateToString(ent.getFechaIngreso()));
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			/* SETEO el Importe Total */
			form.setImporteTotal(ent.getImporteTotal());
			/* SETEO la Administracion */
//			Administracion adm = new Administracion();
//			adm.setId(ent.getAdministracionId());
//			form.setAdministracion(mapperAdm.getForm(adm));
//			if (ent.getAdministracionId() == null){
//				form.setAdministracionNombre("<Todas>");
//			} else {
				form.setAdministracionNombre(ent.getAdministracionNombre());
//			}
			/* SETEO el Tipo de Documento */
			/* SETEO la Cuenta */
			form.setCuentaId(ent.getCuentaId());
			form.setCuentaNombre(ent.getCuentaNombre());
			form.setCuentaCodigo(ent.getCuentaCodigo());
			/* SETEO la Entidad */
			form.setEntidadId(ent.getEntidad());
			form.setEntidadNombre(ent.getEntidadNombre());
			/* SETEO la Moneda */
			form.setMonedaId(ent.getMoneda());
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setMonedaCodigo(ent.getMonedaCodigo());
			/* SETEO el Estado */
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
			//SETEO la cotizacion
			form.setCotizacion(ent.getCotizacion());
			//SETEO el tipoDocumentoNombre
			form.setTipoDocumentoNombre(ent.getTipodocumentoNombre());
			
		}
		return form;
	}

	public  DocumentoAplicacion getEntidad(DocumentoAplicacionForm form) {
		DocumentoAplicacion ent = new DocumentoAplicacion();
		if (form != null){
			ent.setId(form.getId());
			ent.setIdDocumento(form.getDocumentoId());
			ent.setIdDocumentoAplica(form.getDocumentoAplicaId());
			ent.setImporte(form.getImporte());
		}
		return ent;
	}
	
	public List<DocumentoForm> getFormViewList(List<Documento_v> list) {
		List<DocumentoForm> formList = new ArrayList<DocumentoForm>();
		
		for (Documento_v ent : list) {
			formList.add((DocumentoForm)getForm(ent));
		}
	
		return formList;
	}

}