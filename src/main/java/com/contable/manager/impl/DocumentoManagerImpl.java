package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.NumeroBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.utils.DocumentoUtil;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.hibernate.model.TipoDocumento_v;
import com.contable.manager.DocumentoManager;
import com.contable.manager.DocumentoMovimientoManager;
import com.contable.manager.NumeracionManager;
import com.contable.manager.PeriodoManager;
import com.contable.mappers.DocumentoMapper;
import com.contable.mappers.MonedaMapper;
import com.contable.mappers.NumeracionMapper;
import com.contable.services.CuentaService;
import com.contable.services.DocumentoAplicacionService;
import com.contable.services.DocumentoService;
import com.contable.services.TipoDocumentoService;

@Service("documentoManager")
public class DocumentoManagerImpl extends AbstractManagerImpl<Documento,DocumentoForm> implements DocumentoManager{

	@Autowired
	DocumentoService documentoService;

	@Autowired
	DocumentoMovimientoManager documentoMovimientoManager;

	@Autowired
	NumeracionManager numeracionManager;

	@Autowired
	TipoDocumentoService tipoDocumentoService;
	
	@Autowired
	DocumentoAplicacionService documentoAplicacionService;
	
	@Autowired
	PeriodoManager periodoManager;

	@Autowired
	CuentaService cuentaService;
	
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

	public List<ConfigBean> getDocAplicacionesLista(int tipoDocumento,Integer cuenta, Integer entidad, Integer moneda ) {

		//Obtengo de la cuenta el Tipo de Entidad
		Integer tipoEntidadId = null;
		if (cuenta != null){
			Cuenta cta = cuentaService.findById(cuenta);
			//Seteo Tipo de Entidad de la cuenta
			if (cta.getTipoEntidad() != null)
				tipoEntidadId =cta.getTipoEntidad().getId(); 
		}
		//Si no tiene tipo de Entidad, la entidad es nula tambien.
		if (tipoEntidadId == null){
			entidad = null;
		}
		
		//Obtengo el tipo de documento para filtrar por el TIPO de MOVIMIENTO contrario
		TipoDocumento tipoDoc = tipoDocumentoService.findById(tipoDocumento);
		String filtroTipoMovimiento = "";
		if (Constants.TIPODOCUMENTO_TIPOMOV_DEBITO.equals(tipoDoc.getTipoMovimiento())){
			filtroTipoMovimiento = 	Constants.TIPODOCUMENTO_TIPOMOV_CREDITO;	
		} else {
			filtroTipoMovimiento =  Constants.TIPODOCUMENTO_TIPOMOV_DEBITO;
		}

		//Consulto el listado de Aplicaciones
		List<DocumentoAplicacionPendiente_V> listDocs = documentoAplicacionService.getDocsAplicationLista(filtroTipoMovimiento,cuenta, tipoEntidadId, entidad, moneda);
		
		
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		for (DocumentoAplicacionPendiente_V doc : listDocs) {
			String numero = DocumentoUtil.getNumeroFormato(doc.getNumeroLetra(),doc.getNumeroEstablecimiento(),doc.getNumeroAnio(),doc.getNumeroMes(),doc.getNumeroDia(),doc.getNumero());
			String nombre = numero 	+ " ( IT: " + doc.getMoneda().getCodigo() + " " + doc.getImporteTotal() + 
									  " | IA: " + doc.getMoneda().getCodigo() + " " + doc.getImporteAplicado() + 
									  " | IP: " + doc.getMoneda().getCodigo() + " " + (doc.getImporteTotal() - doc.getImporteAplicado()) + " )"; 
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
		form.setImporteAplicadoText(moneda.getCodigo() + " " + doc.getImporteAplicado());
		form.setImportePendienteText(moneda.getCodigo() + " " + (doc.getImporteTotal() - doc.getImporteAplicado()));
		form.setImporteTotal(doc.getImporteTotal());
		form.setImporteAplicado(doc.getImporteAplicado());
		form.setImportePendiente(doc.getImporteTotal() - doc.getImporteAplicado());
		
		return form;
	}

	
	@Transactional
	@Override
	public ErrorRespuestaBean guardarNuevo(DocumentoForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(); 
		/* seleccion de Periodo*/
		//Valida que la fecha XXX esté dentro de un periodo.
		//res = periodoManager.validaPeriodoExistenteByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso());

		//Si es un periodo NO valido Guardo el documento
		//if (! res.isValido()){
		//	return res;
		//}
		/* Seteo en el DOCUMENTO FORM el PERIODO en el form */
		//PeriodoForm periodo = periodoManager.getPeriodoByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso(), true); 
		//form.setPeriodoId(periodo.getId());
		form.setPeriodoId(1);

		/* ----  Obtengo según el tipo de Documento la IdCuenta y el IdTipoEntidad ---- */
		TipoDocumento_v tipoDoc = tipoDocumentoService.findById_v(form.getTipoDocumentoId());
		form.setTipoEntidadId(tipoDoc.getTipoEntidadId());
		form.setCuentaId(tipoDoc.getCuentaId());
		
		/* ----  Válido que el Numero Ingresado no este Repetido ---- */
		NumeracionMapper mapNum = new NumeracionMapper();
		NumeroBean numero = mapNum.getEntidad(form);
		res = numeracionManager.validarNumeroNoRepetido(form.getAdministracion().getId(), tipoDoc.getId(),form.getTipoEntidadId(), form.getEntidadId(),numero) ;

		// Si la numeracion NO es CORRECTA
		if (!res.isValido()) {
			return res;
		}
			
			
		/* ----  Guardo el DOCUMENTO ---- */
		int idDocumento = getRelatedService().save(getMapper().getEntidad(form));

		/* ----  Actualizo la Numeracion en caso de que sea automatica ---- */
		if (Constants.CAMPO_NUMERACION_TIPO_AUTOMATICA.equals(tipoDoc.getNumeracionTipo())){
			numeracionManager.actualizarNumeracion(form.getAdministracion().getId(), tipoDoc.getId(),numero);
		}
		
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
			/*  Guardar Ingreso de INGRESO VALORES  */
			documentoMovimientoManager.guardarDocumentoIngreValores(form.getValoresIngreTerce(),idDocumento,form.getTipoMovimiento());
		}
		if (form.getValoresPropio() != null && ! form.getValoresPropio().isEmpty()){
			/*  Guardar Valores Propios  */
			documentoMovimientoManager.guardarDocumentoValoresPropios(form.getValoresPropio(),idDocumento,form.getTipoMovimiento());
		}
			
		return res;
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
	
	@Deprecated
	@Override
	@Transactional
	public DocumentoForm findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
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
		documento.setAplicaciones(documentoMovimientoManager.getCancelacionesByDocId(id));
		
		//Obtengo TOTALES
		setTotalesMovimientosForm(documento, id);
		
		return documento;
	}


	@Transactional
	public List<DocumentoForm> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc){
		DocumentoMapper mapper = new DocumentoMapper();

		List<DocumentoForm> list = mapper.getFormViewList(documentoService.buscarPorFiltros(filtros,campoOrden,orderByAsc));
		
		return list;
	}

	private void setTotalesMovimientosForm(DocumentoForm documento, int documentoId){
		/* TOTALES Movimientos */
		HashMap<String,ConsultasGeneralesBean> totales = documentoMovimientoManager.getTotalesMovimientosByDocId(documentoId);
		/* SETEO total del HEADER */
		documento.setTotalHeader(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_ENCABEZADO).getCampoDecimal1());
		if (documento.getImputaciones() != null && ! documento.getImputaciones().isEmpty()){
			/* SETEO total del IMPUTACIONES */
			documento.setTotalImputacion(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_IMPUTACIONES).getCampoDecimal1());
		}
		if (documento.getValoresEgreTerce() != null && ! documento.getValoresEgreTerce().isEmpty()){
			/* SETEO total del EGRESO VALOREs */
			documento.setTotalEgresoValor(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_EGRESOVALORES).getCampoDecimal1());
		}
		if (documento.getValoresIngreTerce() != null && ! documento.getValoresIngreTerce().isEmpty()){
			/* SETEO total del HEADER */
			documento.setTotalIngresoValor(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_INGRESOVALORES).getCampoDecimal1());
		}
		if (documento.getValoresPropio() != null && ! documento.getValoresPropio().isEmpty()){
			/* SETEO total del VALORES PROPIOS */
			documento.setTotalValorPropio(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS).getCampoDecimal1());
		}
	}
	
}
