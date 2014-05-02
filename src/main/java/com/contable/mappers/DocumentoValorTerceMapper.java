package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.form.DocumentoValTerceForm;
import com.contable.form.ValorTerceForm;
import com.contable.hibernate.model.DocumentoValorTerce;
import com.contable.hibernate.model.DocumentoValorTerceDisp_V;
import com.contable.hibernate.model.ValorTercero_v;

public class DocumentoValorTerceMapper extends MapperImpl<DocumentoValorTerce,DocumentoValTerceForm>{


	public DocumentoValorTerce getEntidad(DocumentoValTerceForm form) {
		DocumentoValorTerce ent = new DocumentoValorTerce();
		if (form != null){
			BancoMapper mapperBan = new BancoMapper();
			
			ent.setId(form.getId());
			ent.setBanco(mapperBan.getEntidad(form.getBanco()));
			ent.setFechaVencimiento(DateUtil.convertStringToDate(form.getFechaVencimiento()));
			ent.setNumero(form.getNumero());
		}
		return ent;
	}

	public  DocumentoValTerceForm getForm(DocumentoValorTerce ent) {
		DocumentoValTerceForm form=new DocumentoValTerceForm();
		if (ent != null){
			BancoMapper mapperBan = new BancoMapper();

			form.setId(ent.getId());
			form.setBanco(mapperBan.getForm(ent.getBanco()));
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setNumero(ent.getNumero());

		}
		return form;
	}

	public  DocumentoValTerceForm getForm(DocumentoValorTerceDisp_V ent) {
		DocumentoValTerceForm form=new DocumentoValTerceForm();
		if (ent != null){
			BancoMapper mapperBan = new BancoMapper();

			form.setId(ent.getId());
//			form.setBanco(mapperBan.getForm(ent.getBanco()));
//			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
//			form.setNumero(ent.getNumero());

		}
		return form;
	}

	public List<DocumentoValTerceForm> getFormListView(List<DocumentoValorTerceDisp_V> list) {
		List<DocumentoValTerceForm> formList = new ArrayList<DocumentoValTerceForm>();
		
		for (DocumentoValorTerceDisp_V ent : list) {
			DocumentoValTerceForm form=new DocumentoValTerceForm();
			form.setId(ent.getId());
			form.setBancoId(ent.getBanco());
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setNumero(ent.getNumero());
			form.setBancoNombre(ent.getBancoNombre());
			form.setMonedaCodigo(ent.getMonedaCodigo());
			form.setMonedaNombre("monedaNombre");
			form.setImporte(ent.getImporte());
			
			formList.add(form);
		}
	
		return formList;
	}

	public  ValorTerceForm getForm(ValorTercero_v ent) {
		ValorTerceForm  form=new ValorTerceForm ();
		if (ent != null){
			form.setId(ent.getId());
			form.setNumero(ent.getNumero());

			form.setTipomovimiento(ent.getTipomovimiento());
			form.setValorTerceId(ent.getValorTerceId());
			form.setBancoId(ent.getBancoId());
			form.setNombreBanco(ent.getNombreBanco());
			form.setFechaVencimiento(DateUtil.convertDateToString(ent.getFechaVencimiento()));
			form.setAdministracionId(ent.getAdministracionId());
			form.setAdministracionNombre(ent.getAdministracionNombre());
			form.setDocumentoId(ent.getDocumentoId());
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
			
		}
		return form;
	}

	public  List<ValorTerceForm> getFormBuscaList(List<ValorTercero_v> listEnt) {
		List<ValorTerceForm> list = new ArrayList<ValorTerceForm>(); 
		for (ValorTercero_v valor : listEnt) {
			list.add(getForm(valor));
		}
		return list;
	}

}