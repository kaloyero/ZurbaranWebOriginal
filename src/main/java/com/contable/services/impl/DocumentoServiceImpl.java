package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.DocumentoAplicacionPendiente_VDao;
import com.contable.hibernate.dao.DocumentoDao;
import com.contable.hibernate.dao.Documento_VDao;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.hibernate.model.Documento_v;
import com.contable.services.DocumentoService;

@Service("documentoService")
public class DocumentoServiceImpl extends AbstractServiceImpl<Documento> implements DocumentoService{

	@Autowired
    private DocumentoDao documentoDao;

	@Autowired
    private Documento_VDao documento_VDao;

	@Autowired
    private DocumentoAplicacionPendiente_VDao documentoAplicacionPendiente_VDao;

	
	protected GenericDao<Documento, Integer> getDao() {
		return documentoDao;
	}
	
	public List<Documento_v> getListaView() {
		
		List<Documento_v> list = new ArrayList<Documento_v>();
		list = documento_VDao.findAll(false);
		
		return list;
	}

	public List<DocumentoAplicacionPendiente_V> getDocsAplicationLista(
			Integer cuenta, Integer tipoEntidad, Integer entidad, Integer moneda) {
		return documentoAplicacionPendiente_VDao.getListaDocsAplicationPendiente(cuenta, tipoEntidad, entidad, moneda);

	}


	public DocumentoAplicacionPendiente_V getDocsAplicationByIdDoc(int documentoId) {
		return documentoAplicacionPendiente_VDao.findById(documentoId);
	}

}
