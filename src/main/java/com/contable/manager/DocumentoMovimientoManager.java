package com.contable.manager;

import java.util.HashMap;
import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.form.DocumentoAplicacionForm;
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

	void guardarDocumentoValoresPropios (List<DocumentoMovimientoValorPropioForm> lista,int idDocumento,String tipoDocumentoHeader,int idAdministracion);

	void guardarDocumentoIngreValores (List<DocumentoMovimientoValorTerceForm> lista,int idDocumento,String tipoDocumentoHeader);

	void guardarDocumentoEgreValores (List<DocumentoMovimientoValorTerceForm> lista,int idDocumento,String tipoDocumentoHeader);
	
	public List<DocumentoAplicacionForm> getCancelacionesByDocId(Integer idDocumento);
	
	public List<DocumentoMovimientoForm> getListaMovImputacionesByDocId (Integer idDocumento);

	public List<DocumentoMovimientoValorPropioForm> getListaMovValorPropioByDocId (Integer idDocumento);
	
	public List<DocumentoMovimientoValorTerceForm> getListaMovEgresoValorByDocId (Integer idDocumento);
	
	public List<DocumentoMovimientoValorTerceForm> getListaMovIngresoValorByDocId (Integer idDocumento);

	public HashMap<String,ConsultasGeneralesBean> getTotalesMovimientosByDocId(Integer idDocumento);
	
	public void anuloDocumentoValoresTercero(int idDocumento);
	
	public void anuloDocumentoValoresPropio(int idDocumento);
	
	
	/**
	 * Anulo TODOS los movimientos para un determinado Documento.
	 * - Copio los registros del documento que va ser anulado, invirtiendo el Tipo de Movimiento
	 *
	 * @param idDocumentoAnular = documento que se va anular. De este id colecto los movimientos que voy a duplicar
	 * @param idDocumentoAnulador = documento nuevo, creado para anular.
	 */
	public void anuloMovimientos (int idDocumentoAnular, int idDocumentoAnulador);
}
