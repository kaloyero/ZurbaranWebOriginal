package com.contable.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.hibernate.model.DocumentoAplicaciones_V;
import com.contable.hibernate.model.DocumentoMovimiento;
import com.contable.hibernate.model.DocumentoMovimientoEv_V;
import com.contable.hibernate.model.DocumentoMovimientoIm_V;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;

public interface DocumentoMovimientoService extends AbstractService<DocumentoMovimiento>{

	/**
	 * Devuelve un objeto igual al que recibe.
	 * 
	 * @param mov
	 * @return
	 */
	public DocumentoMovimiento clone (DocumentoMovimiento mov);
	
	/**
	 * Obtengo los documentos cancelados de un documento especifico.
	 * 
	 * @param documentoId
	 * @return
	 */
	public List<DocumentoAplicaciones_V> getCancelacionesByIdDoc(Integer documentoId);

	/**
	 * Retorna un listado de documentos aplicados en base a una lista de id documentos 
	 * 
	 * @param Ids
	 * @return
	 */
	public List<DocumentoAplicaciones_V> getCancelacionesByListIdDoc(Set<Integer> ids);
	
	public List<DocumentoMovimientoIm_V> getMovimientosImputacionByIdDoc(Integer documentoId);

	public List<DocumentoMovimientoVp_V> getMovimientosValorPropioByIdDoc(Integer documentoId);

	public List<DocumentoMovimientoIv_V> getMovimientosIngreValorByIdDoc(Integer documentoId);
	
	public DocumentoMovimientoIv_V findMovimientoIngreValorByValorTerceId(Integer valorTerceId);
	
	public HashMap<Integer,DocumentoMovimientoIv_V> findMovimientoIngreValorByValorTerceIdList(Collection<Integer> valorTerceId);

	public List<DocumentoMovimientoEv_V> getMovimientosEgreValorByIdDoc(Integer documentoId);

	public HashMap<String,ConsultasGeneralesBean> getTotalesMovimientosByDocId(Integer documentoId);
	
	/**
	 * Devuelve todos los Movimientos para un documento
	 * 
	 * @param documentoId
	 * @return
	 */
	public List<DocumentoMovimiento> getMovimientosByIdDocumento(Integer documentoId);
}
