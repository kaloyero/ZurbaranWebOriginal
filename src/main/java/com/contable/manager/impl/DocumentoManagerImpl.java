package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
import com.contable.common.constants.ConstantsErrors;
import com.contable.common.excel.WriteDetalleDocumentoExcel;
import com.contable.common.excel.WriteDocumentoExcel;
import com.contable.common.utils.CalculosUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.DocumentoUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;
import com.contable.form.MonedaForm;
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacion;
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
		String filtroTipoMovimiento = DocumentoUtil.invertirTipoDeMovimiento(tipoDoc.getTipoMovimiento());

		//Consulto el listado de Aplicaciones
		List<DocumentoAplicacionPendiente_V> listDocs = documentoAplicacionService.getDocsAplicationLista(filtroTipoMovimiento,cuenta, tipoEntidadId, entidad, moneda);
		
		
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		for (DocumentoAplicacionPendiente_V doc : listDocs) {
			String numero = doc.getTipoDocumentoNombre() + " - " + doc.getDescripcion() + " - " 
							+ DocumentoUtil.getNumeroFormato(doc.getNumeroLetra(),doc.getNumeroEstablecimiento(),doc.getNumeroAnio(),doc.getNumeroMes(),doc.getNumeroDia(),doc.getNumero());
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
		form.setImportePendiente(doc.getImporteTotal() - doc.getImporteAplicado());
		form.setTipoDocumentoNombre(doc.getTipoDocumentoNombre());
		
		return form;
	}

	
	@Transactional
	@Override
	public ErrorRespuestaBean guardarNuevo(DocumentoForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(); 

		/* Válido que tenga movimientos*/
		if ( 	(form.getAplicaciones() == null || form.getAplicaciones().isEmpty())  &&
				(form.getImputaciones() == null || form.getImputaciones().isEmpty())  &&
				(form.getValoresEgreTerce() == null || form.getValoresEgreTerce().isEmpty())  &&
				(form.getValoresIngreTerce() == null || form.getValoresIngreTerce().isEmpty())  &&
				(form.getValoresPropio() == null || form.getValoresPropio().isEmpty())) {
			res.setValido(false);
			res.setCodError(ConstantsErrors.DOCUMENTO_COD_1_COD_ERROR);
			res.setError(ConstantsErrors.DOCUMENTO_COD_1_ERROR);
			res.setDescripcion("El documento no contiene Movimientos.");
			
			return res;
		}
		
		//Valida que la fecha XXX esté dentro de un periodo.
		res = periodoManager.validaPeriodoExistenteByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso());

		
		/* seleccion de Periodo*/
		//Valida que la fecha XXX esté dentro de un periodo.
		res = periodoManager.validaPeriodoExistenteByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso());

		//Si es un periodo NO valido Guardo el documento
		if (! res.isValido()){
			return res;
		}
		/* Seteo en el DOCUMENTO FORM el PERIODO en el form */
		PeriodoForm periodo = periodoManager.getPeriodoByFecha(form.getAdministracion().getId().intValue(), form.getFechaIngreso(), true); 
		form.setPeriodoId(periodo.getId());
		

		/* ----  Obtengo según el tipo de Documento la IdCuenta y el IdTipoEntidad ---- */
		TipoDocumento_v tipoDoc = tipoDocumentoService.findById_v(form.getTipoDocumentoId());
		form.setTipoEntidadId(tipoDoc.getTipoEntidadId());
		form.setCuentaId(tipoDoc.getCuentaId());
		
		/* ----  Válido que el Numero Ingresado no este Repetido si no es una Anulacion----*/ 
		
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

		return findDocumentoById(id);
	}
	
	@Transactional
	public DocumentoForm findDocumentoById(Integer id){
		// Obtengo la información de Documento
		DocumentoForm documento = new DocumentoForm();
		//Mapper
		DocumentoMapper mapper = new DocumentoMapper();

		/* Obtengo Header */
			documento = mapper.getForm(documentoService.findViewById(id) );
		
		/* Obtengo Imputaciones */
			List <DocumentoMovimientoForm> imputaciones = documentoMovimientoManager.getListaMovImputacionesByDocId(id);
			actualizaElImporteMonedaHeader_IM(imputaciones, documento.getMonedaId(), documento.getCotizacion());
			documento.setImputaciones(imputaciones);
		/* Obtengo Valor Terce */
			List<DocumentoMovimientoValorTerceForm> valorIngresoTerce = new ArrayList<DocumentoMovimientoValorTerceForm>();
			List<DocumentoMovimientoValorTerceForm> valorEgresoTerce = new ArrayList<DocumentoMovimientoValorTerceForm>();
			if (documento.getDocumentoAnulaaId() != null) {
				//Si esta anulando un documento recuero los valores del documento que se anula.
				valorIngresoTerce = documentoMovimientoManager.getListaMovIngresoValorByDocId(documento.getDocumentoAnulaaId());
				valorEgresoTerce = documentoMovimientoManager.getListaMovEgresoValorByDocId(documento.getDocumentoAnulaaId());
			} else {
				valorIngresoTerce = documentoMovimientoManager.getListaMovIngresoValorByDocId(id);
				valorEgresoTerce = documentoMovimientoManager.getListaMovEgresoValorByDocId(id);
				
			}
			//Actualiza el campo Moneda Header
			actualizaElImporteMonedaHeader_VT(valorIngresoTerce, documento.getMonedaId(), documento.getCotizacion());
			actualizaElImporteMonedaHeader_VT(valorEgresoTerce, documento.getMonedaId(), documento.getCotizacion());
			//Setea en el form
			documento.setValoresIngreTerce(valorIngresoTerce);
			documento.setValoresEgreTerce(valorEgresoTerce);
		/* Obtengo Valor Propio */ 
			List<DocumentoMovimientoValorPropioForm> valorPropio = new ArrayList<DocumentoMovimientoValorPropioForm>();
			if (documento.getDocumentoAnulaaId() != null) {
				//Si esta anulando un documento recuero los valores del documento que se anula.
				valorPropio = documentoMovimientoManager.getListaMovValorPropioByDocId(documento.getDocumentoAnulaaId());	
			} else {
				valorPropio = documentoMovimientoManager.getListaMovValorPropioByDocId(id);
			}
			//Actualiza el campo Moneda Header
			actualizaElImporteMonedaHeader_VP(valorPropio, documento.getMonedaId(), documento.getCotizacion());
			//Setea en el form
			documento.setValoresPropio(valorPropio);
		
		/* Obtengo Aplicaciones */
			documento.setAplicaciones(documentoMovimientoManager.getCancelacionesByDocId(id));
		
		//Obtengo TOTALES
		setTotalesMovimientosForm(documento, id, documento.getMonedaId(), documento.getCotizacion());
		
		return documento;
	}

	private void actualizaElImporteMonedaHeader_IM(List<DocumentoMovimientoForm> lista, int idMonedaDocumentoHeader, Double cotizacionHeader){
		if (lista != null){
			for (DocumentoMovimientoForm mov : lista) {
				String importeMonedaHeader = CalculosUtil.calcularImporte(mov.getImporte(), mov.getMonedaId(), mov.getCotizacion(), idMonedaDocumentoHeader, cotizacionHeader);
				mov.setImporteMonedaHeader(importeMonedaHeader);
			}
		}

	}

	private void actualizaElImporteMonedaHeader_VT(List<DocumentoMovimientoValorTerceForm> lista, int idMonedaDocumentoHeader, Double cotizacionHeader){
		if (lista != null){
			for (DocumentoMovimientoForm mov : lista) {
				String importeMonedaHeader = CalculosUtil.calcularImporte(mov.getImporte(), mov.getMonedaId(), mov.getCotizacion(), idMonedaDocumentoHeader, cotizacionHeader);
				mov.setImporteMonedaHeader(importeMonedaHeader);
			}
		}
	}

	private void actualizaElImporteMonedaHeader_VP(List<DocumentoMovimientoValorPropioForm> lista, int idMonedaDocumentoHeader, Double cotizacionHeader){
		if (lista != null){
			for (DocumentoMovimientoForm mov : lista) {
				String importeMonedaHeader = CalculosUtil.calcularImporte(mov.getImporte(), mov.getMonedaId(), mov.getCotizacion(), idMonedaDocumentoHeader, cotizacionHeader);
				mov.setImporteMonedaHeader(importeMonedaHeader);
			}
		}
	}

	@Transactional
	public List<DocumentoForm> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc){
		DocumentoMapper mapper = new DocumentoMapper();

		List<DocumentoForm> list = mapper.getFormViewList(documentoService.buscarPorFiltros(filtros,campoOrden,orderByAsc));
		
		return list;
	}

	private void setTotalesMovimientosForm(DocumentoForm documento, int documentoId, int monedaHeaderId, Double cotizacionHeader){
		/* TOTALES Movimientos */
		HashMap<String,ConsultasGeneralesBean> totales = documentoMovimientoManager.getTotalesMovimientosByDocId(documentoId);
		/* SETEO total del HEADER */
		documento.setTotalHeader(FormatUtil.format2DecimalsStr(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_ENCABEZADO).getCampoDecimal1()));
		if (documento.getImputaciones() != null && ! documento.getImputaciones().isEmpty()){
			/* SETEO total del IMPUTACIONES */
			documento.setTotalImputacion(FormatUtil.format2DecimalsStr(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_IMPUTACIONES).getCampoDecimal1()));
		}
		if (documento.getValoresEgreTerce() != null && ! documento.getValoresEgreTerce().isEmpty()){
			/* SETEO total del EGRESO VALOREs */
			documento.setTotalEgresoValor(FormatUtil.format2DecimalsStr(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_EGRESOVALORES).getCampoDecimal1()));
		}
		if (documento.getValoresIngreTerce() != null && ! documento.getValoresIngreTerce().isEmpty()){
			/* SETEO total del HEADER */
			documento.setTotalIngresoValor(FormatUtil.format2DecimalsStr(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_INGRESOVALORES).getCampoDecimal1()));
		}
		if (documento.getValoresPropio() != null && ! documento.getValoresPropio().isEmpty()){
			/* SETEO total del VALORES PROPIOS */
			documento.setTotalValorPropio(FormatUtil.format2DecimalsStr(totales.get(Constants.DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS).getCampoDecimal1()));
		}
		if (documento.getAplicaciones() != null && ! documento.getAplicaciones().isEmpty()){
			Double totalAplicaciones = 0.0;
			for (DocumentoAplicacionForm aplicacion : documento.getAplicaciones()) {
				totalAplicaciones =+ aplicacion.getImporteAplicado();
			}
			/* SETEO total del APLICACIONES */
			documento.setTotalCancelaciones(FormatUtil.format2DecimalsStr(totalAplicaciones));
		}
		
	}

	@Transactional
	public ErrorRespuestaBean anularDocumentoById(Integer documentoId) {
		ErrorRespuestaBean respuesta = new ErrorRespuestaBean(true);
		//Clono el documento que recibo
		Documento documento = documentoService.clone(documentoService.findById(documentoId));

		/* Nuevo numero de Documento*/
		documento.setId(0);
		
		/* Válido que no sea Aplicado por otro documento. */
		if (documentoAplicacionService.tieneAplicaionDeOtroDocumento(documentoId)){
			respuesta.setValido(false);
			respuesta.setCodError(ConstantsErrors.ANULAR_COD_1_COD_ERROR);
			respuesta.setError(ConstantsErrors.ANULAR_COD_1_ERROR);
			respuesta.setDescripcion("El documento que intenta eliminar es aplicado por otro/s documento/s.");
			
			return respuesta;
		}
		
		
		/*	i.	Si el TipoMovimiento (D)ebito cambiar a (C)redito. Si el TipoMovimiento es (C)redito entonces cambiar a (D)ebito.
		 *		Cambio el Tipo de Movimiento del documento	*/
		String tipoMovimientoInvertido = DocumentoUtil.invertirTipoDeMovimiento(documento.getTipoMovimiento());
		documento.setTipoMovimiento(tipoMovimientoInvertido); 		
		 
		/*	iii.IdDocumentoAnulaa – IdDocumento que se anulo */
		documento.setDocumentoAnulaaId(documentoId);
		
		/*	iv.	Fecha Real – Fecha del dia
		 *	v.	Fecha Ingreso – Fecha del dia
		 *	vi.	Fecha Vencimiento – Fecha de Dia */
		documento.setFechaIngreso(DateUtil.getDateToday());
		documento.setFechaReal(DateUtil.getDateToday());
		documento.setFechaVencimiento(DateUtil.getDateToday());
		
		/*	vii.	Estado - A */
		documento.setEstado(Constants.DOCUMENTO_ESTADO_ANULADO);

		
		/* ----  Guardo la ANULACION DEL DOCUMENTO ---- */
		
			/* ----  Guardo el DOCUMENTO ---- */
			int idDocumentoAnulacion = getRelatedService().save(documento);
	
			/* Seteo en el DOCUMENTO FORM el ID DOCUMENTO */
			documento.setId(idDocumentoAnulacion);
		
		/* ----  ANULO los MOVIMIENTOS del DOCUMENTO ---- */
			/* TOma todos los movimientos vinculados al documento y agrega nuevos, reverzando los movimientos*/
				documentoMovimientoManager.anuloMovimientos(documentoId, idDocumentoAnulacion);
			
		/* ANULO Valores de Terceros */
			documentoMovimientoManager.anuloDocumentoValoresTercero(documentoId);
		/* ANULO Valores de Propios */ 
			documentoMovimientoManager.anuloDocumentoValoresPropio(documentoId);
		/* ANULO Cancelaciones */
			anulaDocumentoAplicaciones(documentoId, idDocumentoAnulacion);
		
		/*	ii.	IdDocumentoAnuladoPor – Actualizar en Documento anulado con IdDocumento */
			documentoService.actualizarEstadoDocumento(documentoId, Constants.DOCUMENTO_ESTADO_ANULADO);	
			documentoService.actualizarDocumentoAnuladoPor(documentoId, idDocumentoAnulacion);

		return respuesta;
	}

	
	public ErrorRespuestaBean eliminarById(int documentoId) {
		ErrorRespuestaBean respuesta = new ErrorRespuestaBean(true);

		/*	Valido que se sea un id valido 	*/
		if (documentoId < 1){
			respuesta.setDescripcion("Id no válido.");
			respuesta.setValido(false);
			return respuesta;
		}
		
		/*	VALIDACION PERIODO -> Validar que el documento que se quiere eliminar pertenezca al periodo actual abierto.	*/
		/* Obtengo el documento para saber la administracion */
		Documento documento = documentoService.findById(documentoId);
		//Valida que la fecha Actual esté dentro de un periodo.
		respuesta = periodoManager.validaPeriodoExistenteByFecha(documento.getAdministracion().getId(), DateUtil.getStringToday());

		//Si no es el periodo actual
		if (! respuesta.isValido()){
			return respuesta;
		}

		/* 	VALIDACION TIPO DE NUMERACION AUTOMATICA 
			-  Verificar que no se haya ingresado un documento con numeración siguiente
			en este caso no se borra. */
		//Obtengo el Tipo de Documento
		TipoDocumento tipoDoc = tipoDocumentoService.findById(documento.getTipoDocumentoId());
		boolean actualizaNumeracionAutomatica = false;
		if (Constants.CAMPO_NUMERACION_TIPO_AUTOMATICA.equals(tipoDoc.getNumeracionTipo())){
			NumeroBean numero = numeracionManager.getLastDocNumeration(documento.getAdministracion().getId(), tipoDoc.getId(), DateUtil.convertDateToString(documento.getFechaIngreso()), documento.getNumeroLetra(), documento.getNumeroEstablecimiento());
			//Pregunto si el numero que se quiere eliminar es el ultimo agregado
			//para esto tomo el ultimo numero valido y le resto uno para compararlo con el del documento que quiero borrar.
			if (numero != null && documento.getNumero().equals(ConvertionUtil.IntValueOf(numero.getNumero()) -1) ){
				actualizaNumeracionAutomatica = true;
			} else {
				respuesta.setValido(false);
				respuesta.setCodError(ConstantsErrors.ELIMINAR_COD_2_COD_ERROR);
				respuesta.setError(ConstantsErrors.ELIMINAR_COD_2_ERROR);
				respuesta.setDescripcion("No se puede Eliminar el documento seleccionado. El tipo de documento es automatico. Debe anular este documento.");
				
				return respuesta;
			}
			
		}
		
		try {
			/* Valida que el documento se haya aplicado en otro documento. */
			respuesta = documentoService.delete(documentoId);
			if (actualizaNumeracionAutomatica){
				NumeracionMapper mapNum = new NumeracionMapper();
				documento.setNumero(documento.getNumero()-1);
				numeracionManager.actualizarNumeracion(documento.getAdministracion().getId(), tipoDoc.getId(),mapNum.getEntidad(documento));				
			}
		} catch (Exception e) {
			//Error el documento ha sido cancelado por otro documento
			respuesta.setValido(false);
			respuesta.setCodError(ConstantsErrors.ELIMINAR_COD_1_COD_ERROR);
			respuesta.setError(ConstantsErrors.ELIMINAR_COD_1_ERROR);
			respuesta.setDescripcion("El documento seleccionado no se ha podido eliminar debido a que otros Documentos hacen referencia al mismo.");
		}
		
		return respuesta;
	}

	public void exportExcel(FiltroDocumentoBean filtros) {
		List<DocumentoForm> exportList = buscarPorFiltros(filtros, "", false);
		String nombre = "Listado_documentos_";
		
		//Obtengo el nombre de la administracion
		if ( ! exportList.isEmpty()){
			nombre += exportList.get(0).getAdministracionNombre() + "_";
		}
		
		if (StringUtils.isBlank(filtros.getFechaHasta())) {
			nombre += DateUtil.getStringToday();
		} else {
			nombre += filtros.getFechaHasta();
		}
		
		WriteDocumentoExcel xls = new WriteDocumentoExcel();
		xls.setOutputFile(nombre);
		xls.write(exportList);
	}

	public void exportDocumentoDetalleExcel(int documentoId) {
		DocumentoForm documento = findDocumentoById(documentoId);
		
		String nombre = "Documento_" + documento.getNumeroFormateado();
		
		WriteDetalleDocumentoExcel xls = new WriteDetalleDocumentoExcel();
		xls.setOutputFile(nombre);
		xls.write(documento);
	}

	/**
	 * Actualizo el estado de las Aplicaciones ANULADAS
	 * 
	 * @param form
	 * @return
	 */
	@Transactional
	protected void anulaDocumentoAplicaciones (int idDocumento, int idDocumentoAnula){
		List<DocumentoAplicacionForm> lista = documentoMovimientoManager.getCancelacionesByDocId(idDocumento);
		
		for (DocumentoAplicacionForm form : lista) {
			DocumentoAplicacion aplicacion = ((DocumentoMapper) getMapper()).getEntidad(form) ;
			aplicacion.setId(0);
			aplicacion.setIdDocumento(idDocumentoAnula);
			aplicacion.setImporte(form.getImporteAplicado() * -1);
 			/* GUARDO la Aplicacion */
 			documentoAplicacionService.save( aplicacion );
		}
		
	}

}
