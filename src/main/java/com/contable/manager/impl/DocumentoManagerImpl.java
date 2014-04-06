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
import com.contable.form.DocumentoForm;
import com.contable.hibernate.model.Documento;
import com.contable.manager.DocumentoManager;
import com.contable.mappers.DocumentoMapper;
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

	public List<ConfigBean> getListaDocAplicaciones(Integer cuenta, Integer tipoEntidad, Integer entidad, Integer moneda ) {
		
		List<Documento> listDocs = documentoService.getListaDocsAplication(cuenta, tipoEntidad, entidad, moneda, true);
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		for (Documento doc : listDocs) {
			String nombre = DocumentoUtil.getNumeroFormato(doc.getNumeroLetra(),doc.getNumeroEstablecimiento(),doc.getNumeroAnio(),doc.getNumeroMes(),doc.getNumeroDia(),doc.getNumero());
			list.add(new ConfigBean(doc.getId(), nombre));
		}

		return list;
	}

	public void guardarNuevo(DocumentoForm form){
		
		/* seleccion de Periodo*/
		//Valida que la fecha XXX esté dentro de un periodo.
		
		
		getRelatedService().save(getMapper().getEntidad(form));
		
	}

}
