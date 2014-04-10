package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.DocumentoAplicacionDao;
import com.contable.hibernate.model.DocumentoAplicacion;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.services.DocumentoAplicacionService;

@Service("documentoAplicacionService")
public class DocumentoAplicacionServiceImpl extends AbstractServiceImpl<DocumentoAplicacion> implements DocumentoAplicacionService{

	@Autowired
    private DocumentoAplicacionDao documentoAplicacionDao;

	protected GenericDao<DocumentoAplicacion, Integer> getDao() {
		return documentoAplicacionDao;
	}

	public List<DocumentoAplicacionPendiente_V> getDocsAplicationLista(
			Integer cuenta, Integer tipoEntidad, Integer entidad, Integer moneda) {
		// TODO Auto-generated method stub
		return null;
	}

	public DocumentoAplicacionPendiente_V getDocsAplicationByIdDoc(
			int documentoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
