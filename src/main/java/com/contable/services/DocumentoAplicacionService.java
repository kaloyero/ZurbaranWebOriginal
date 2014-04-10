package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.DocumentoAplicacion;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;

public interface DocumentoAplicacionService extends AbstractService<DocumentoAplicacion>{

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
