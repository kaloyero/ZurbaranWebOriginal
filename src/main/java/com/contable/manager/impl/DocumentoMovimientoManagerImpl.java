package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.hibernate.model.DocumentoMovimiento;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;
import com.contable.manager.ConceptoManager;
import com.contable.manager.DocumentoMovimientoManager;
import com.contable.mappers.DocumentoMovimientoMapper;
import com.contable.mappers.DocumentoValorPropioMapper;
import com.contable.mappers.DocumentoValorTerceMovMapper;
import com.contable.services.DocumentoMovimientoService;
import com.contable.services.DocumentoValorPropioService;
import com.contable.services.DocumentoValorTerceMovService;

@Service("documentoMovimientoManager")
public class DocumentoMovimientoManagerImpl extends AbstractManagerImpl<DocumentoMovimiento,DocumentoMovimientoForm> implements DocumentoMovimientoManager{

	DocumentoMovimientoMapper mapperDocMov = new DocumentoMovimientoMapper();
	
	@Autowired
	DocumentoMovimientoService documentoMovimientoService;
	
	@Autowired
	DocumentoValorTerceMovService documentoValorTerceMovService; 

	@Autowired
	DocumentoValorPropioService documentoValorPropioService; 

	@Autowired
	ConceptoManager conceptoManager; 

	@Override
	protected AbstractService<DocumentoMovimiento> getRelatedService() {
		return documentoMovimientoService;
	}

	@Override
	protected Mapper<DocumentoMovimiento,DocumentoMovimientoForm> getMapper() {
		return new DocumentoMovimientoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 

		return list;
	}

	@Transactional
	public void guardarHeader(DocumentoForm form){
		documentoMovimientoService.save(mapperDocMov.getEntidadDocumentoHeader(form));
	}

	@Transactional
	public void guardarDocumentoImputaciones (List<DocumentoMovimientoForm> lista,int idDocumento,String tipoDocumentoHeader){
		//Listado de Info de Conceptos (cuenta, tipoEntidad, entidad) 
		HashMap<Integer,ConsultasGeneralesBean> mapConceptoInfo = getConceptoImpu(lista);
		
		for (DocumentoMovimientoForm form : lista) {
			/* SETEO el id del Documento */
			form.setDocumentoId(idDocumento);
			/* SETEO el Tipo de Movimiento */
			form.setTipoMovimiento(getTipoMovimientoRegistros(tipoDocumentoHeader));
			/* SETEO el Codigo de Movimiento */
			form.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_IMPUTACIONES);
			/* SETEO la cuenta por el concepto*/
			form.setCuentaId(mapConceptoInfo.get(form.getConceptoId()).getCampoEntero1());
			/* SETEO el Tipo Entidad por el concepto*/
			form.setTipoEntidadId(mapConceptoInfo.get(form.getConceptoId()).getCampoEntero2());
			/* GUARDO el Movimiento */
			documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
		}
	}

	@Transactional
	public void guardarDocumentoValoresPropios (List<DocumentoMovimientoValorPropioForm> lista,int idDocumento,String tipoDocumentoHeader){
		DocumentoValorPropioMapper mapperValPropio = new DocumentoValorPropioMapper();
		
		//Listado de Info de Conceptos (cuenta, tipoEntidad, entidad) 
		HashMap<Integer,ConsultasGeneralesBean> mapConceptoInfo = getConceptoPropio(lista);

		for (DocumentoMovimientoValorPropioForm form : lista) {
			/* SETEO el id del Documento */
			form.setDocumentoId(idDocumento);
			/* SETEO el Tipo de Movimiento */
			form.setTipoMovimiento(getTipoMovimientoRegistros(tipoDocumentoHeader));
			/* SETEO el Codigo de Movimiento */
			form.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS);
			/* GUARDO el Movimiento */
			int idMov = documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
			/* SETEO la cuenta por el concepto*/
			form.setCuentaId(mapConceptoInfo.get(form.getConceptoId()).getCampoEntero1());
			/* SETEO el Tipo Entidad por el concepto*/
			form.setTipoEntidadId(mapConceptoInfo.get(form.getConceptoId()).getCampoEntero2());
			/* SETEO el Id de Movimiento */
			form.getValorPropio().setIdMovimiento(idMov);
			/* GUARDO el Valor Propio */
			documentoValorPropioService.save(mapperValPropio.getEntidad(form.getValorPropio()));
		}
	}

	@Transactional
	public void guardarDocumentoIngreValores (List<DocumentoMovimientoValorTerceForm> lista,int idDocumento,String tipoDocumentoHeader){
		DocumentoValorTerceMovMapper mapperValMov = new DocumentoValorTerceMovMapper();
		
		//Listado de Info de Conceptos (cuenta, tipoEntidad, entidad) 
		HashMap<Integer,ConsultasGeneralesBean> mapConceptoInfo = getConceptoTerce(lista);
		
		for (DocumentoMovimientoValorTerceForm form : lista) {
			/* SETEO el id del Documento */
			form.setDocumentoId(idDocumento);
			/* SETEO el Tipo de Movimiento */
			form.setTipoMovimiento(getTipoMovimientoRegistros(tipoDocumentoHeader));
			/* SETEO el Codigo de Movimiento */
			form.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_INGRESOVALORES);
			/* SETEO la cuenta por el concepto*/
			form.setCuentaId(mapConceptoInfo.get(form.getConceptoId()).getCampoEntero1());
			/* SETEO el Tipo Entidad por el concepto*/
			form.setTipoEntidadId(mapConceptoInfo.get(form.getConceptoId()).getCampoEntero2());
			/* GUARDO el Movimiento */
			int idMov = documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
			/* SETEO el Id de Movimiento */
			form.setIdMovimiento(idMov);
			/* SETEO el Tipo de Movimiento como INGRESO */
			form.setTipoMovimientoValorTerce(Constants.TIPODOCUMENTO_VALORTERCE_INGRESO);
			/* GUARDO el Valor */
			documentoValorTerceMovService.save( mapperValMov.getEntidad(form));
		}

	}

	@Transactional
	public void guardarDocumentoEgreValores (List<DocumentoMovimientoValorTerceForm> lista,int idDocumento,String tipoDocumentoHeader){
		DocumentoValorTerceMovMapper mapperValMov = new DocumentoValorTerceMovMapper();
		
		//Obtengo una lista de ids
		Collection<Integer> idsValoresTerce = getIdsValoresTerce(lista);
		
		//Obtengo los movimientos de INGRESO para los Valores de Terceros
		HashMap<Integer,DocumentoMovimientoIv_V> movimientosIngresoValor = 
				documentoMovimientoService.findMovimientoIngreValorByValorTerceIdList(idsValoresTerce);		
		
		for (DocumentoMovimientoValorTerceForm form : lista) {
			//Id del Valor de Tercero
			Integer idValorTerce = form.getValorTerce().getId();
			
			//Igualo el movimiento de EGRESO al de INGRESO
			form = mapperDocMov.getForm(movimientosIngresoValor.get(idValorTerce));

			/* RESETEO el id movimiento */
			form.setId(0);
			/* SETEO el id del Documento */
			form.setDocumentoId(idDocumento);
			/* SETEO el Tipo de Movimiento */
			form.setTipoMovimiento(getTipoMovimientoRegistros(tipoDocumentoHeader));
			/* SETEO el Codigo de Movimiento */
			form.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_EGRESOVALORES);
			/* GUARDO el Movimiento */
			int idMov = documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
			/* SETEO el Id de Movimiento */
			form.setIdMovimiento(idMov);
			/* SETEO el Tipo de Movimiento como EGRESO */
			form.setTipoMovimientoValorTerce(Constants.TIPODOCUMENTO_VALORTERCE_EGRESO);
			/* GUARDO el Valor */
			documentoValorTerceMovService.save( mapperValMov.getEntidad(form));
		}
	}
	
	private Collection<Integer> getIdsValoresTerce(List<DocumentoMovimientoValorTerceForm> lista){
		//Obtengo una lista de ids
		Collection<Integer> idsValoresTerce = new ArrayList<Integer>();
		for (DocumentoMovimientoValorTerceForm form : lista) {
			idsValoresTerce.add(form.getValorTerce().getId());
		}
		return idsValoresTerce;
	}

	
	private String getTipoMovimientoRegistros(String tipoDocumentoHeader){
		if (Constants.UI_DEUDOR.equals(tipoDocumentoHeader)){
			return Constants.UI_ACREEDOR;
		} else {
			return Constants.UI_DEUDOR;
		}
	}
	
	/**
	 * Devuelve de un listado de Conceptos Ids lacuenta, tipo de entidad y entidad
	 * 
	 * @return
	 */
	private HashMap<Integer,ConsultasGeneralesBean> getConceptoImpu(List<DocumentoMovimientoForm> lista){
		List<Integer> conceptos = new ArrayList<Integer>();
		
		for (DocumentoMovimientoForm form : lista) {
			conceptos.add(form.getConceptoId());
		}
		
		return conceptoManager.getConceptoInfoParaDocumentoMov(conceptos);
	}
	private HashMap<Integer,ConsultasGeneralesBean> getConceptoTerce(List<DocumentoMovimientoValorTerceForm> lista){
		List<Integer> conceptos = new ArrayList<Integer>();
		
		for (DocumentoMovimientoForm form : lista) {
			conceptos.add(form.getConceptoId());
		}
		
		return conceptoManager.getConceptoInfoParaDocumentoMov(conceptos);
	}
	private HashMap<Integer,ConsultasGeneralesBean> getConceptoPropio(List<DocumentoMovimientoValorPropioForm> lista){
		List<Integer> conceptos = new ArrayList<Integer>();
		
		for (DocumentoMovimientoForm form : lista) {
			conceptos.add(form.getConceptoId());
		}
		
		return conceptoManager.getConceptoInfoParaDocumentoMov(conceptos);
	}

	public List<DocumentoMovimientoForm> getListaMovImputacionesByDocId(Integer idDocumento) {
		return mapperDocMov.getFormMovImList(documentoMovimientoService.getMovimientosImputacionByIdDoc(idDocumento));
	}

	public List<DocumentoMovimientoValorPropioForm> getListaMovValorPropioByDocId(Integer idDocumento) {
		return mapperDocMov.getFormMovVpList(documentoMovimientoService.getMovimientosValorPropioByIdDoc(idDocumento));
	}

	public List<DocumentoMovimientoValorTerceForm> getListaMovEgresoValorByDocId(Integer idDocumento) {
		return mapperDocMov.getFormMovEvList(documentoMovimientoService.getMovimientosEgreValorByIdDoc(idDocumento));
	}

	public List<DocumentoMovimientoValorTerceForm> getListaMovIngresoValorByDocId(Integer idDocumento) {
		return mapperDocMov.getFormMovIvList(documentoMovimientoService.getMovimientosIngreValorByIdDoc(idDocumento));
	}

	public HashMap<String,ConsultasGeneralesBean> getTotalesMovimientosByDocId(Integer idDocumento) {
		return documentoMovimientoService.getTotalesMovimientosByDocId(idDocumento);
	}

}
