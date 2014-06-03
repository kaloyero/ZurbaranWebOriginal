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
	public List<DocumentoAplicacionPendiente_V> getDocsAplicationLista(String tipoMovimiento, Integer cuenta,
			Integer tipoEntidad, Integer entidad, Integer moneda);

	/**
	 * Devuelve un documento Pendiente de aplicacion por el id de documento 
	 * 
	 * @param documentoId
	 * @return
	 */
	public DocumentoAplicacionPendiente_V getDocsAplicationByIdDoc(int documentoId);


	/**
	 * Devuelve true o false segun el documento actual esta siendo aplicado por otro documento.
	 * Retorna true si tiene Algun o mas documentos que lo Apliquen
	 * Retorna false si ningun documento lo aplica.
	 * 
	 * @param documentoId
	 * @return
	 */
	public boolean tieneAplicaionDeOtroDocumento(int documentoId);
	
}
