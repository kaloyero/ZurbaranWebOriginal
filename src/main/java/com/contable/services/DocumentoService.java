package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.hibernate.model.Documento_v;

public interface DocumentoService extends AbstractService<Documento>{

	List<Documento_v> getListaView();

	/**
	 * Devuelve un listado de Documentos pendientes de Aplicacion
	 * 
	 * @param cuenta
	 * @param tipoEntidad
	 * @param entidad
	 * @param moneda
	 * @return
	 */
	public List<DocumentoAplicacionPendiente_V> getDocsAplicationLista(Integer cuenta,
			Integer tipoEntidad, Integer entidad, Integer moneda);

	/**
	 * Devuelve un documento Pendiente de aplicacion por el id de documento 
	 * 
	 * @param documentoId
	 * @return
	 */
	public DocumentoAplicacionPendiente_V getDocsAplicationByIdDoc(int documentoId);

}
