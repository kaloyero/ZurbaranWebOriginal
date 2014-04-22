package com.contable.manager;

import java.util.HashMap;
import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.hibernate.model.DocumentoMovimiento;

public interface DocumentoMovimientoManager extends AbstractManager<DocumentoMovimiento,DocumentoMovimientoForm>{

	/**
	 * Guarda el movimiento del Header 
	 * 
	 * @param form
	 */
	void guardarHeader(DocumentoForm form);
	
	void guardarDocumentoImputaciones (List<DocumentoMovimientoForm> lista,int idDocumento,String tipoDocumentoHeader);

	void guardarDocumentoValoresPropios (List<DocumentoMovimientoValorPropioForm> lista,int idDocumento,String tipoDocumentoHeader);

	void guardarDocumentoIngreValores (List<DocumentoMovimientoValorTerceForm> lista,int idDocumento,String tipoDocumentoHeader);

	void guardarDocumentoEgreValores (List<DocumentoMovimientoValorTerceForm> lista,int idDocumento,String tipoDocumentoHeader);
	
	public List<DocumentoMovimientoForm> getListaMovImputacionesByDocId (Integer idDocumento);

	public List<DocumentoMovimientoValorPropioForm> getListaMovValorPropioByDocId (Integer idDocumento);
	
	public List<DocumentoMovimientoValorTerceForm> getListaMovEgresoValorByDocId (Integer idDocumento);
	
	public List<DocumentoMovimientoValorTerceForm> getListaMovIngresoValorByDocId (Integer idDocumento);

	public HashMap<String,ConsultasGeneralesBean> getTotalesMovimientosByDocId(Integer idDocumento);
}
