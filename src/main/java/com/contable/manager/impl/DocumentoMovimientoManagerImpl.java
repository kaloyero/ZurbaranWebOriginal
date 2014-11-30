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
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.hibernate.model.Chequera;
import com.contable.hibernate.model.DocumentoMovimiento;
import com.contable.hibernate.model.DocumentoMovimientoEv_V;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;
import com.contable.manager.ConceptoManager;
import com.contable.manager.DocumentoMovimientoManager;
import com.contable.mappers.ChequeraMapper;
import com.contable.mappers.DocumentoMapper;
import com.contable.mappers.DocumentoMovimientoMapper;
import com.contable.mappers.DocumentoValorPropioMapper;
import com.contable.mappers.DocumentoValorTerceMovMapper;
import com.contable.services.ChequeraService;
import com.contable.services.DocumentoMovimientoService;
import com.contable.services.DocumentoValorPropioService;
import com.contable.services.DocumentoValorTerceMovService;
import com.contable.services.DocumentoValorTerceService;

@Service("documentoMovimientoManager")
public class DocumentoMovimientoManagerImpl extends AbstractManagerImpl<DocumentoMovimiento,DocumentoMovimientoForm> implements DocumentoMovimientoManager{

	DocumentoMovimientoMapper mapperDocMov = new DocumentoMovimientoMapper();
	
	@Autowired
	DocumentoMovimientoService documentoMovimientoService;
	
	@Autowired
	DocumentoValorTerceMovService documentoValorTerceMovService; 

	@Autowired
	DocumentoValorTerceService documentoValorTerceService; 
	
	@Autowired
	ChequeraService chequeraService;

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
	public void guardarDocumentoValoresPropios (List<DocumentoMovimientoValorPropioForm> lista,int idDocumento,String tipoDocumentoHeader,int idAdministracion){
		DocumentoValorPropioMapper mapperValPropio = new DocumentoValorPropioMapper();
		ChequeraMapper mapCheq = new ChequeraMapper();
		//Listado de Info de Conceptos (cuenta, tipoEntidad, entidad) 
		HashMap<Integer,ConsultasGeneralesBean> mapConceptoInfo = getConceptoPropio(lista);

		for (DocumentoMovimientoValorPropioForm form : lista) {
			/* SETEO el id del Documento */
			form.setDocumentoId(idDocumento);
			/* SETEO el Tipo de Movimiento */
			form.setTipoMovimiento(getTipoMovimientoRegistros(tipoDocumentoHeader));
			/* SETEO el Codigo de Movimiento */
			form.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS);
			/* SETEO la cuenta por el concepto*/
			Integer cuentaId = mapConceptoInfo.get(form.getConceptoId()).getCampoEntero1();
			form.setCuentaId(cuentaId);
			/* SETEO el Tipo Entidad por el concepto*/
			Integer tipoEntidadId =  mapConceptoInfo.get(form.getConceptoId()).getCampoEntero2();
			form.setTipoEntidadId(tipoEntidadId);
			/* SETEO el  id CHEQUERA */
			Chequera chequera = chequeraService.getChequeByCuentaEntidad(idAdministracion,cuentaId,form.getEntidadId(),form.getMonedaId());
			form.getValorPropio().getChequera().setId(chequera.getId());
			/* GUARDO el Movimiento */
			int idMov = documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
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

	@Transactional
	public void anuloDocumentoValoresTercero(int idDocumento){
		//Obtengo una lista de ids
		Collection<Integer> idsValoresTerce = new ArrayList<Integer>() ;
		Collection<Integer> idsValoresTerceEgre =  getIdsValoresTerceEgre(documentoMovimientoService.getMovimientosEgreValorByIdDoc(idDocumento));
		Collection<Integer> idsValoresTerceIngre = getIdsValoresTerceIngre(documentoMovimientoService.getMovimientosIngreValorByIdDoc(idDocumento));
		
		//Agrego a la coleccion de Ids los valores de egreso e ingreso
		idsValoresTerce.addAll(idsValoresTerceEgre);
		idsValoresTerce.addAll(idsValoresTerceIngre);
		
		/* Cambio el estado de los Valores a anulado */
		documentoValorTerceService.anularValoresTerceroByListIds(idsValoresTerce);
		
	}

	@Transactional
	public void anuloDocumentoValoresPropio (int idDocumento){

		//Obtengo una lista de ids
		Collection<Integer> idsValoresPropio = getIdsValoresPropioVista(documentoMovimientoService.getMovimientosValorPropioByIdDoc(idDocumento));
		
		/* Cambio el estado de los Valores a anulado */
		documentoValorPropioService.anularValoresPropioByListIds(idsValoresPropio);

	}
	
	@Transactional
	public void anuloMovimientos (int idDocumentoAnular, int idDocumentoAnulador) {
		List<DocumentoMovimiento> lista =documentoMovimientoService.getMovimientosByIdDocumento(idDocumentoAnular);
		
		for (DocumentoMovimiento movimiento : lista) {
			/* Clono al objeto q recibo */
			DocumentoMovimiento movimientoNuevo = documentoMovimientoService.clone(movimiento);
			/* Guardo el id del movimiento que voy a Anular */
			movimientoNuevo.setMovimientoAnuladoId(movimiento.getId());
			/* RESETEO el id movimiento */
			//movimientoNuevo.setId(0);
			/* SETEO el id del Documento */
			movimientoNuevo.setIdDocumento(idDocumentoAnulador);
			/* SETEO el Tipo de Movimiento. Debe ser el opuesto al que ya ten;ia*/
			movimientoNuevo.setTipoMovimiento(getTipoMovimientoRegistros(movimiento.getTipoMovimiento()));
			/* GUARDO el Movimiento */
			documentoMovimientoService.save(  movimientoNuevo  );			
		}
	}

	private Collection<Integer> getIdsValoresTerce(List<DocumentoMovimientoValorTerceForm> lista){
		//Obtengo una lista de ids
		Collection<Integer> idsValoresTerce = new ArrayList<Integer>();
		if (lista != null && lista.isEmpty() ==false) {
			for (DocumentoMovimientoValorTerceForm form : lista) {
				idsValoresTerce.add(form.getValorTerce().getId());
			}
		}
		return idsValoresTerce;
	}

	private Collection<Integer> getIdsValoresTerceEgre(List<DocumentoMovimientoEv_V> lista){
		//Obtengo una lista de ids
		Collection<Integer> idsValoresTerce = new ArrayList<Integer>();
		
		if (lista != null && lista.isEmpty() ==false) {
			for (DocumentoMovimientoEv_V valor : lista) {
				idsValoresTerce.add(valor.getValorTerceMovId());
			}
		}
		return idsValoresTerce;
	}

	private Collection<Integer> getIdsValoresTerceIngre(List<DocumentoMovimientoIv_V> lista){
		//Obtengo una lista de ids
		Collection<Integer> idsValoresTerce = new ArrayList<Integer>();
		if (lista != null && lista.isEmpty() ==false) {
			for (DocumentoMovimientoIv_V valor : lista) {
				idsValoresTerce.add(valor.getValorTerceMovId());
			}
		}
		return idsValoresTerce;
	}
	
	private Collection<Integer> getIdsValoresPropioVista(List<DocumentoMovimientoVp_V> lista){
		//Obtengo una lista de ids
		Collection<Integer> idsValoresPropio = new ArrayList<Integer>();
		if (lista != null && lista.isEmpty() ==false) {
			for (DocumentoMovimientoVp_V form : lista) {
				idsValoresPropio.add(form.getValorPropioId());
			}
		}
		return idsValoresPropio;
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

	@Transactional
	public List<DocumentoAplicacionForm> getCancelacionesByDocId(Integer idDocumento) {
		DocumentoMapper mapperDoc = new DocumentoMapper();
		return mapperDoc.getFormAplicacionList(documentoMovimientoService.getCancelacionesByIdDoc(idDocumento));
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
