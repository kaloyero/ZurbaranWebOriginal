package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.hibernate.model.DocumentoMovimiento;
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
	public void guardarDocumentoImputaciones (List<DocumentoMovimientoForm> lista,int idDocumento){
		for (DocumentoMovimientoForm form : lista) {
			/* SETEO el id del Documento */
			form.setDocumentoId(idDocumento);
			/* SETEO el Codigo de Movimiento */
			form.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_IMPUTACIONES);
			/* GUARDO el Movimiento */
			documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
		}
	}

	@Transactional
	public void guardarDocumentoValoresPropios (List<DocumentoMovimientoValorPropioForm> lista,int idDocumento){
		DocumentoValorPropioMapper mapperValPropio = new DocumentoValorPropioMapper();
		for (DocumentoMovimientoValorPropioForm form : lista) {
			/* SETEO el id del Documento */
			form.setDocumentoId(idDocumento);
			/* SETEO el Codigo de Movimiento */
			form.setCodMovimiento(Constants.DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS);
			/* GUARDO el Movimiento */
			int idMov = documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
			/* SETEO el Id de Movimiento */
			form.getValorPropio().setIdMovimiento(idMov);
			/* GUARDO el Valor Propio */
			documentoValorPropioService.save(mapperValPropio.getEntidad(form.getValorPropio()));
		}
	}

	@Transactional
	public void guardarDocumentoIngreValores (List<DocumentoMovimientoValorTerceForm> lista,int idDocumento){

		guardaDocumentosValoresTerce(lista, Constants.DOCUMENTO_CODMOVIMIENTO_INGRESOVALORES, Constants.TIPODOCUMENTO_VALORTERCE_INGRESO,idDocumento);
		
	}

	@Transactional
	public void guardarDocumentoEgreValores (List<DocumentoMovimientoValorTerceForm> lista,int idDocumento){

		guardaDocumentosValoresTerce(lista,Constants.DOCUMENTO_CODMOVIMIENTO_EGRESOVALOERS, Constants.TIPODOCUMENTO_VALORTERCE_EGRESO,idDocumento);
	}

	private void guardaDocumentosValoresTerce (List<DocumentoMovimientoValorTerceForm> lista,String codigoMov ,String tipoMov, int idDocumento){
		DocumentoValorTerceMovMapper mapperValMov = new DocumentoValorTerceMovMapper();
		
		for (DocumentoMovimientoValorTerceForm form : lista) {
			/* SETEO el id del Documento */
			form.setDocumentoId(idDocumento);
			/* SETEO el Codigo de Movimiento */
			form.setCodMovimiento(codigoMov);
			/* GUARDO el Movimiento */
			int idMov = documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
			/* SETEO el Id de Movimiento */
			form.setIdMovimiento(idMov);
			/* SETEO el Tipo de Movimiento como INGRESO */
			form.setTipoMovimientoValorTerce(tipoMov);
			/* GUARDO el Valor */
			documentoValorTerceMovService.save( mapperValMov.getEntidad(form));
		}

	}
}
