package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.DocumentoAplicacionDao;
import com.contable.hibernate.dao.DocumentoAplicacionPendiente_VDao;
import com.contable.hibernate.model.DocumentoAplicacion;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.services.DocumentoAplicacionService;

@Service("documentoAplicacionService")
public class DocumentoAplicacionServiceImpl extends AbstractServiceImpl<DocumentoAplicacion> implements DocumentoAplicacionService{

	@Autowired
    private DocumentoAplicacionDao documentoAplicacionDao;

	@Autowired

    private DocumentoAplicacionPendiente_VDao documentoAplicacionPendiente_VDao;
	
	protected GenericDao<DocumentoAplicacion, Integer> getDao() {
		return documentoAplicacionDao;
	}

	public List<DocumentoAplicacionPendiente_V> getDocsAplicationLista(
			Integer cuenta, Integer tipoEntidad, Integer entidad, Integer moneda) {
		

		List<DocumentoAplicacionPendiente_V> list = documentoAplicacionPendiente_VDao.getListaDocsAplicationPendiente(cuenta, tipoEntidad, entidad, moneda);
		
		return list;
	}

	public DocumentoAplicacionPendiente_V getDocsAplicationByIdDoc(
			int documentoId) {


		return documentoAplicacionPendiente_VDao.findById(documentoId);
	}

}
