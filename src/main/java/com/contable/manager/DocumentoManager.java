package com.contable.manager;

import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.ConfigBean;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.hibernate.model.Documento;

public interface DocumentoManager extends AbstractManager<Documento,DocumentoForm>{

	/**
	 * Devuelve un listado de Documentos pendientes de Aplicacion
	 * 
	 * @param cuenta
	 * @param tipoEntidad
	 * @param entidad
	 * @param moneda
	 * @return
	 */
	List<ConfigBean> getDocAplicacionesLista(Integer cuenta, Integer tipoEntidad, Integer entidad, Integer moneda );
	
	/**
	 * Devuelve un documento Pendiente de aplicacion por el id de documento 
	 * 
	 * @param documentoId
	 * @return
	 */
	DocumentoAplicacionForm getDocAplicacioneByIdDoc(int documentoId );
	
}
