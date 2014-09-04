package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.form.DocumentoValPropioForm;
import com.contable.form.ValorPropioForm;
import com.contable.hibernate.model.ChequeraDetalle_V;
import com.contable.hibernate.model.DocumentoValorPropio;
import com.contable.hibernate.model.ValorPropio_v;

public class DocumentoValorPropioMapper extends MapperImpl<DocumentoValorPropio,DocumentoValPropioForm>{


	public DocumentoValorPropio getEntidad(DocumentoValPropioForm form) {
		DocumentoValorPropio ent = new DocumentoValorPropio();
		if (form != null){
			ChequeraMapper mapperChe = new ChequeraMapper();
			
			ent.setId(form.getId());
			ent.setBeneficiario(form.getBeneficiario());
			ent.setChequera(mapperChe.getEntidad(form.getChequera()));
			ent.setFechaVencimiento(DateUtil.convertStringToDate(form.getFechaVencimiento()));
			ent.setIdMovimiento(form.getIdMovimiento());
			ent.setNumero(form.getNumero());
			
		}
		return ent;
	}

	public  DocumentoValPropioForm getForm(DocumentoValorPropio ent) {
		DocumentoValPropioForm form=new DocumentoValPropioForm();
		if (ent != null){
			ChequeraMapper mapperChe = new ChequeraMapper();
			
			form.setId(ent.getId());
			form.setBeneficiario(ent.getBeneficiario());
			form.setChequera(mapperChe.getForm(ent.getChequera()));
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setIdMovimiento(ent.getIdMovimiento());
			form.setNumero(ent.getNumero());

		}
		return form;
	}

	public  ValorPropioForm getForm(ValorPropio_v ent) {
		ValorPropioForm  form=new ValorPropioForm ();
		if (ent != null){
			form.setId(ent.getId());
			form.setNumero(ent.getNumero());
			form.setBeneficiario(ent.getBeneficiario());
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setAdministracionId(ent.getAdministracionId());
			form.setAdministracionNombre(ent.getAdministracionNombre());
			form.setFechaIngreso(DateUtil.convertDateToString(ent.getFechaIngreso()));
			form.setTipoDocumentoNombre(ent.getTipoDocumentoNombre());
			form.setDocumentoId(ent.getDocumentoId());
			form.setDocumentoFormateado(ent.getDocumentoFormateado());
			form.setMovimientoId(ent.getMovimientoId());
			form.setCotizacion(ent.getCotizacion());
			form.setImporteValor(ent.getImporteValor());
			form.setCuentaId(ent.getCuentaId());
			form.setTipoEntidadId(ent.getTipoEntidadId());
			form.setEntidadId(ent.getEntidadId());
			form.setMonedaId(ent.getMonedaId());
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setMonedaCodigo(ent.getMonedaCodigo());
			form.setCuentaNombre(ent.getCuentaNombre());
			form.setCuentaCodigo(ent.getCuentaCodigo());
			form.setTipoEntidadNombre(ent.getTipoEntidadNombre());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setEstado(ent.getEstado());
		}
		return form;
	}

	public  ValorPropioForm getForm(ChequeraDetalle_V ent) {
		ValorPropioForm form=new ValorPropioForm();
		if (ent != null){
			MonedaMapper mapperMon = new MonedaMapper();
			
			//form.setId(ent.getValorPropioId());
			form.setBeneficiario(ent.getBeneficiario());
			form.setEstado(ent.getEstado());
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVto()));
			form.setFechaIngreso(DateUtil.convertDateToString(ent.getFechaIng()));
			form.setMonedaId(ent.getMoneda().getId());
			form.setMonedaCodigo(ent.getMoneda().getCodigo());
			form.setMonedaNombre(ent.getMoneda().getNombre());
			form.setImporteValor(ent.getImporte());
			form.setDocumentoId(ent.getDocumentoId());
			form.setMotivo(ent.getMotivo());
			form.setNumero(ent.getNumero());
			
			
		}
		return form;
	}

	
	public  List<ValorPropioForm> getFormBuscaList(List<ValorPropio_v> listEnt) {
		List<ValorPropioForm> list = new ArrayList<ValorPropioForm>(); 
		for (ValorPropio_v valor : listEnt) {
			list.add(getForm(valor));
		}
		return list;
	}
	
	public List<ValorPropioForm> getFormViewListDetail(List<ChequeraDetalle_V> list) {
		List<ValorPropioForm> formList = new ArrayList<ValorPropioForm>();
		
		for (ChequeraDetalle_V ent : list) {
			formList.add((ValorPropioForm)getForm(ent));
		}
	
		return formList;
	}


	
}