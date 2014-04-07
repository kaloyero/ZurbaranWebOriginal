package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.utils.DocumentoUtil;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.manager.DocumentoManager;
import com.contable.mappers.DocumentoMapper;
import com.contable.mappers.MonedaMapper;
import com.contable.services.DocumentoService;

@Service("documentoManager")
public class DocumentoManagerImpl extends AbstractManagerImpl<Documento,DocumentoForm> implements DocumentoManager{

	@Autowired
	DocumentoService documentoService;

	@Override
	protected AbstractService<Documento> getRelatedService() {
		return documentoService;
	}

	@Override
	protected Mapper<Documento,DocumentoForm> getMapper() {
		return new DocumentoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 

		return list;
	}

	@Override
	public List<DocumentoForm> getLista() {
		DocumentoMapper mapper = new DocumentoMapper();

		List<DocumentoForm> list = mapper.getFormViewList(((DocumentoService) getRelatedService()).getListaView());

		return list;
	}

	public List<ConfigBean> getDocAplicacionesLista(Integer cuenta, Integer tipoEntidad, Integer entidad, Integer moneda ) {
		
		List<DocumentoAplicacionPendiente_V> listDocs = documentoService.getDocsAplicationLista(cuenta, tipoEntidad, entidad, moneda);
		
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		for (DocumentoAplicacionPendiente_V doc : listDocs) {
			String numero = DocumentoUtil.getNumeroFormato(doc.getNumeroLetra(),doc.getNumeroEstablecimiento(),doc.getNumeroAnio(),doc.getNumeroMes(),doc.getNumeroDia(),doc.getNumero());
			String nombre = numero 	+ " ( " + doc.getMoneda().getCodigo() + " " + doc.getImporteTotal() + 
									  " / " + doc.getMoneda().getCodigo() + " " + (doc.getImporteTotal() - doc.getImporteAplicacionPendiente()) + 
									  " / " + doc.getMoneda().getCodigo() + " " + doc.getImporteAplicacionPendiente() + " )"; 
			list.add(new ConfigBean(doc.getId(), nombre));
		}

		return list;
	}


	public DocumentoAplicacionForm getDocAplicacioneByIdDoc(int documentoId ) {
		
		DocumentoAplicacionForm form = new DocumentoAplicacionForm();
		
		DocumentoAplicacionPendiente_V doc = documentoService.getDocsAplicationByIdDoc(documentoId);
		
		form.setId(doc.getId());
		form.setNumeroText(DocumentoUtil.getNumeroFormato(doc.getNumeroLetra(),doc.getNumeroEstablecimiento(),doc.getNumeroAnio(),doc.getNumeroMes(),doc.getNumeroDia(),doc.getNumero()));
		MonedaForm moneda = (new MonedaMapper()).getForm(doc.getMoneda()); 
		form.setMoneda(moneda);
		form.setImporteTotalText(moneda.getCodigo() + " " + doc.getImporteTotal());
		form.setImporteAplicadoText(moneda.getCodigo() + " " + (doc.getImporteTotal() - doc.getImporteAplicacionPendiente()));
		form.setImportePendienteText(moneda.getCodigo() + " " + doc.getImporteAplicacionPendiente());
		
		return form;
	}

	
	public void guardarNuevo(DocumentoForm form){
		
		/* seleccion de Periodo*/
		//Valida que la fecha XXX esté dentro de un periodo.
		
		
		getRelatedService().save(getMapper().getEntidad(form));
		
	}

}
