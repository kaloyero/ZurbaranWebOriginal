package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.utils.DocumentoUtil;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.manager.DocumentoManager;
import com.contable.manager.DocumentoMovimientoManager;
import com.contable.manager.PeriodoManager;
import com.contable.mappers.DocumentoMapper;
import com.contable.mappers.MonedaMapper;
import com.contable.services.DocumentoAplicacionService;
import com.contable.services.DocumentoService;

@Service("documentoManager")
public class DocumentoManagerImpl extends AbstractManagerImpl<Documento,DocumentoForm> implements DocumentoManager{

	@Autowired
	DocumentoService documentoService;

	@Autowired
	DocumentoMovimientoManager documentoMovimientoManager;

	@Autowired
	DocumentoAplicacionService documentoAplicacionService;
	
	@Autowired
	PeriodoManager periodoManager;

	@Override
	protected AbstractService<Documento> getRelatedService() {
		return documentoService;
	}

	@Override
	protected Mapper<Documento,DocumentoForm> getMapper() {
		return new DocumentoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 

		return list;
	}

	@Override
	public List<DocumentoForm> getLista() {
		DocumentoMapper mapper = new DocumentoMapper();

		List<DocumentoForm> list = mapper.getFormViewList(((DocumentoService) getRelatedService()).getListaView());

		return list;
	}

	public List<ConfigBean> getDocAplicacionesLista(Integer cuenta, Integer tipoEntidad, Integer entidad, Integer moneda ) {
		
		List<DocumentoAplicacionPendiente_V> listDocs = documentoAplicacionService.getDocsAplicationLista(cuenta, tipoEntidad, entidad, moneda);
		
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		for (DocumentoAplicacionPendiente_V doc : listDocs) {
			String numero = DocumentoUtil.getNumeroFormato(doc.getNumeroLetra(),doc.getNumeroEstablecimiento(),doc.getNumeroAnio(),doc.getNumeroMes(),doc.getNumeroDia(),doc.getNumero());
			String nombre = numero 	+ " ( " + doc.getMoneda().getCodigo() + " " + doc.getImporteTotal() + 
									  " / " + doc.getMoneda().getCodigo() + " " + (doc.getImporteTotal() - doc.getImporteAplicacionPendiente()) + 
									  " / " + doc.getMoneda().getCodigo() + " " + doc.getImporteAplicacionPendiente() + " )"; 
			list.add(new ConfigBean(doc.getId(), nombre));
		}

		return list;
	}

	public DocumentoAplicacionForm getDocAplicacioneByIdDoc(int documentoId ) {
		
		DocumentoAplicacionForm form = new DocumentoAplicacionForm();
		
		DocumentoAplicacionPendiente_V doc = documentoAplicacionService.getDocsAplicationByIdDoc(documentoId);
		
		form.setId(doc.getId());
		form.setNumeroText(DocumentoUtil.getNumeroFormato(doc.getNumeroLetra(),doc.getNumeroEstablecimiento(),doc.getNumeroAnio(),doc.getNumeroMes(),doc.getNumeroDia(),doc.getNumero()));
		MonedaForm moneda = (new MonedaMapper()).getForm(doc.getMoneda()); 
		form.setMoneda(moneda);
		form.setImporteTotalText(moneda.getCodigo() + " " + doc.getImporteTotal());
		form.setImporteAplicadoText(moneda.getCodigo() + " " + (doc.getImporteTotal() - doc.getImporteAplicacionPendiente()));
		form.setImportePendienteText(moneda.getCodigo() + " " + doc.getImporteAplicacionPendiente());
		form.setImporteTotal(doc.getImporteTotal());
		form.setImporteAplicado((doc.getImporteTotal() - doc.getImporteAplicacionPendiente()));
		form.setImportePendiente(doc.getImporteAplicacionPendiente());
		
		return form;
	}

	@Transactional
	@Override
	public void guardarNuevo(DocumentoForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(); 
		/* seleccion de Periodo*/
		//Valida que la fecha XXX esté dentro de un periodo.
		//res = periodoManager.validaPeriodoExistenteByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso());

		//Si es un periodo valido Guardo el documento
		//if (res.isValido()){
			/* Seteo en el DOCUMENTO FORM el PERIODO en el form */
			//PeriodoForm periodo = periodoManager.getPeriodoByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso(), true); 
			//form.setPeriodoId(periodo.getId());
			form.setPeriodoId(1);
			
			/* ----  Guardo el DOCUMENTO ---- */
			int idDocumento = getRelatedService().save(getMapper().getEntidad(form));
			
			/* Seteo en el DOCUMENTO FORM el ID DOCUMENTO */
			form.setId(idDocumento);
			/* ----  Guardo el MOVIMIENTO ENCABEZADO ---- */
			documentoMovimientoManager.guardarHeader(form);			
			
			if (form.getAplicaciones() != null && ! form.getAplicaciones().isEmpty()){
				/*  Guardar Aplicaciones  */
				guardarDocumentoAplicaciones(form.getAplicaciones(),idDocumento);
			}
			if (form.getImputaciones() != null && ! form.getImputaciones().isEmpty()){
				/*  Guardar Imputaciones  */
				documentoMovimientoManager.guardarDocumentoImputaciones(form.getImputaciones(),idDocumento,form.getTipoMovimiento());
			}
			if (form.getValoresEgreTerce() != null && ! form.getValoresEgreTerce().isEmpty()){
				/*  Guardar Egreso de valores  */
				documentoMovimientoManager.guardarDocumentoEgreValores(form.getValoresEgreTerce(),idDocumento,form.getTipoMovimiento());
			}
			if (form.getValoresIngreTerce() != null && ! form.getValoresIngreTerce().isEmpty()){
				/*  Guardar Ingreso de valores  */
				documentoMovimientoManager.guardarDocumentoIngreValores(form.getValoresIngreTerce(),idDocumento,form.getTipoMovimiento());
			}
			if (form.getValoresPropio() != null && ! form.getValoresPropio().isEmpty()){
				/*  Guardar Valores Propios  */
				documentoMovimientoManager.guardarDocumentoValoresPropios(form.getValoresPropio(),idDocumento,form.getTipoMovimiento());
			}
			
		//}
	}


	/**
	 * Guardo las Aplicaciones
	 * 
	 * @param form
	 * @return
	 */
	protected void guardarDocumentoAplicaciones (List<DocumentoAplicacionForm> listaAplicaciones,int idDocumento){
		
		for (DocumentoAplicacionForm documentoAplicacionForm : listaAplicaciones) {
			/* SETEO el Id del documento */
			documentoAplicacionForm.setDocumentoId(idDocumento);
			/* GUARDO la Aplicacion */
			documentoAplicacionService.save(  ((DocumentoMapper) getMapper()).getEntidad(documentoAplicacionForm)  );
		}
		
	}

	
	public List<DocumentoAplicacionForm> getDocomentosAplicadosByIdDoc(int documentoId) {
		//@TODO hacer este metodo
		return new ArrayList<DocumentoAplicacionForm>();
	}
	
	@Transactional
	public DocumentoForm findDocumentoById(Integer id){
		// Obtengo la información de Documento
		DocumentoForm documento = new DocumentoForm();
		//Mapper
		DocumentoMapper mapper = new DocumentoMapper();

		//Obtengo Header
		documento = mapper.getForm(documentoService.findViewById(id) );
		//Obtengo Imputaciones
		documento.setImputaciones(documentoMovimientoManager.getListaMovImputacionesByDocId(id));
		//Obtengo Valor Terce
		documento.setValoresIngreTerce(documentoMovimientoManager.getListaMovIngresoValorByDocId(id));
		documento.setValoresEgreTerce(documentoMovimientoManager.getListaMovEgresoValorByDocId(id));
		//Obtengo Valor Propio 
		documento.setValoresPropio(documentoMovimientoManager.getListaMovValorPropioByDocId(id));
		//Obtengo Aplicaciones
		documento.setAplicaciones(getDocomentosAplicadosByIdDoc(id));
		
		return documento;
	}


	@Transactional
	public List<DocumentoForm> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc){
		DocumentoMapper mapper = new DocumentoMapper();

		List<DocumentoForm> list = mapper.getFormViewList(documentoService.buscarPorFiltros(filtros,campoOrden,orderByAsc));
		
		return list;
	}


	
}
