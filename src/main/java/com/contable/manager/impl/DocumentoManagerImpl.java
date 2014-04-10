package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.beans.RespuestaBean;
import com.contable.common.utils.DocumentoUtil;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.form.MonedaForm;
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.manager.DocumentoManager;
import com.contable.manager.PeriodoManager;
import com.contable.mappers.DocumentoMapper;
import com.contable.mappers.DocumentoMovimientoMapper;
import com.contable.mappers.MonedaMapper;
import com.contable.services.DocumentoAplicacionService;
import com.contable.services.DocumentoMovimientoService;
import com.contable.services.DocumentoService;

@Service("documentoManager")
public class DocumentoManagerImpl extends AbstractManagerImpl<Documento,DocumentoForm> implements DocumentoManager{

	@Autowired
	DocumentoService documentoService;

	@Autowired
	DocumentoMovimientoService documentoMovimientoService;

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
		
		return form;
	}

	@Transactional
	@Override
	public void guardarNuevo(DocumentoForm form){
		RespuestaBean res = new RespuestaBean(); 
		/* seleccion de Periodo*/
		//Valida que la fecha XXX esté dentro de un periodo.
		res = periodoManager.validaPeriodoExistenteByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso());

		//Si es un periodo valido Guardo el documento
		if (res.isValido()){
			/* Seteo en el DOCUMENTO FORM el PERIODO en el form */
			PeriodoForm periodo = periodoManager.getPeriodoByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso(), true); 
			form.setPeriodoId(periodo.getId());
			
			
			/* ----  Guardo el DOCUMENTO ---- */
			int idDocumento = getRelatedService().save(getMapper().getEntidad(form));
			
			/* Seteo en el DOCUMENTO FORM el ID DOCUMENTO */
			form.setId(idDocumento);
			
			/* ----  Guardo el MOVIMIENTO ENCABEZADO ---- */
			DocumentoMovimientoMapper mapperDocMov =  new DocumentoMovimientoMapper(); 
			documentoMovimientoService.save(mapperDocMov.getEntidadDocumentoHeader(form));			
			
			if (form.getAplicaciones() != null && ! form.getAplicaciones().isEmpty()){
				/*  Guardar Aplicaciones  */
				guardarDocumentoAplicaciones(form.getAplicaciones());
			}
			if (form.getImputaciones() != null && ! form.getImputaciones().isEmpty()){
				
			}
			if (form.getValoresEgreTerce() != null && ! form.getValoresEgreTerce().isEmpty()){
				
			}
			if (form.getValoresIngreTerce() != null && ! form.getValoresIngreTerce().isEmpty()){
				
			}
			if (form.getValoresPropio() != null && ! form.getValoresPropio().isEmpty()){
				
			}
			
		}
	}

	/**
	 * Guardo el Documento y el DocumentoMovimiento del Encabezado
	 * 
	 * @param form
	 * @return
	 */
	protected Integer guardarDocumentoCompleto (DocumentoForm form){
		/* ----  Guardo el DOCUMENTO ---- */
		int idDocumento = getRelatedService().save(getMapper().getEntidad(form));
		
		/* Seteo en el DOCUMENTO FORM el ID DOCUMENTO */
		form.setId(idDocumento);
		
		/* ----  Guardo el MOVIMIENTO ENCABEZADO ---- */
		DocumentoMovimientoMapper mapperDocMov =  new DocumentoMovimientoMapper(); 
		documentoMovimientoService.save(mapperDocMov.getEntidadDocumentoHeader(form));
		
		return idDocumento;
		
	}

	/**
	 * Guardo las Aplicaciones
	 * 
	 * @param form
	 * @return
	 */
	protected void guardarDocumentoAplicaciones (List<DocumentoAplicacionForm> listaAplicaciones){
		
		for (DocumentoAplicacionForm documentoAplicacionForm : listaAplicaciones) {
			documentoAplicacionService.save(  ((DocumentoMapper) getMapper()).getEntidad(documentoAplicacionForm)  );
		}
		
	}

	protected void guardarDocumentoImputaciones (List<DocumentoMovimientoForm> listaImputaciones){
		DocumentoMovimientoMapper mapperDocMov = new DocumentoMovimientoMapper(); 
		
		for (DocumentoMovimientoForm form : listaImputaciones) {
			documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
		}
	}

	protected void guardarDocumentoValoresPropios (List<DocumentoMovimientoValorPropioForm> lista){
		DocumentoMovimientoMapper mapperDocMov = new DocumentoMovimientoMapper(); 
		
		for (DocumentoMovimientoValorPropioForm form : lista) {
			documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
			//FALTA MAPEAR DOCUMENTOS PROPIOS
		}
	}

	protected void guardarDocumentoIngreValores (List<DocumentoMovimientoValorTerceForm> lista){
		DocumentoMovimientoMapper mapperDocMov = new DocumentoMovimientoMapper(); 
		
		for (DocumentoMovimientoValorTerceForm form : lista) {
			documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
			//FALTA MAPEAR DOCUMENTOS TERECEROS
		}
	}

	protected void guardarDocumentoEgreValores (List<DocumentoMovimientoValorTerceForm> lista){
		DocumentoMovimientoMapper mapperDocMov = new DocumentoMovimientoMapper(); 
		
		for (DocumentoMovimientoValorTerceForm form : lista) {
			documentoMovimientoService.save(  mapperDocMov.getEntidad(form)  );
			//FALTA MAPEAR DOCUMENTOS TERECEROS
		}
	}


	
}
