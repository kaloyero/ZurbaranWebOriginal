package com.contable.manager;

import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.FiltroDocAplicacionBean;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoAplicacionMovimientoForm;
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
	public List<ConfigBean> getDocAplicacionesLista(int tipoDocumento,Integer cuenta, Integer entidad, Integer moneda );
	
	/**
	 * Devuelve un documento Pendiente de aplicacion por el id de documento 
	 * 
	 * @param documentoId
	 * @return
	 */
	public DocumentoAplicacionForm getDocAplicacioneByIdDoc(int documentoId );

	/**
	 * Devuelve una lista de Documentos aplicados por el Id de Documento. 
	 * 
	 * @param documentoId
	 * @return
	 */
	public List<DocumentoAplicacionForm> getDocomentosAplicadosByIdDoc(int documentoId );

	
	/**
	 * Trae documento cOmpleto, con tabs
	 * 
	 * @param id
	 * @return
	 */
	public DocumentoForm findDocumentoById(Integer id);

	
	/**
	 * Metodo para filtrar listado de documentos
	 * 
	 * @param filtros
	 * @param campoOrden
	 * @param orderByAsc
	 * @return
	 */
	public List<DocumentoForm> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc);
	
	/**
	 * Cancela/Anula un documento 
	 * 
	 * @param documentoId
	 * @return
	 */
	public ErrorRespuestaBean anularDocumentoById(Integer documentoId);
	
	/**
	 * Metoddo para exportar excel
	 * 
	 * @param exportList
	 */
	public void exportExcel(FiltroDocumentoBean filtros);
	
	public void exportDocumentoDetalleExcel(int documentoId);
	
	public void exportDocumentoAplicadoExcel(List<DocumentoAplicacionMovimientoForm> documentos,FiltroDocAplicacionBean busqueda);
	
	public ErrorRespuestaBean eliminarById(int documentoId);
	
	/**
	 * Filtra, busca documentos  Aplicados Movimientos
	 * 
	 * @param filtro
	 */
	public List<DocumentoAplicacionMovimientoForm> buscarDocumentosAplicadosPorFiltros (FiltroDocAplicacionBean filtro);
}
