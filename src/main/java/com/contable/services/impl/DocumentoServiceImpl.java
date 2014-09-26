package com.contable.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.common.beans.NumeroBean;
import com.contable.common.constants.ConstantsErrors;
import com.contable.hibernate.dao.DocumentoAplicacionPendiente_VDao;
import com.contable.hibernate.dao.DocumentoDao;
import com.contable.hibernate.dao.DocumentoMovimientoIm_VDao;
import com.contable.hibernate.dao.Documento_VDao;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.Documento_v;
import com.contable.services.DocumentoService;

@Service("documentoService")
public class DocumentoServiceImpl extends AbstractServiceImpl<Documento> implements DocumentoService{

	@Autowired
    private DocumentoDao documentoDao;

	@Autowired
    private Documento_VDao documento_VDao;

	@Autowired
    private DocumentoMovimientoIm_VDao documentoMovimientoIm_VDao;

	
	protected GenericDao<Documento, Integer> getDao() {
		return documentoDao;
	}
	
	public List<Documento_v> getListaView() {
		
		List<Documento_v> list = new ArrayList<Documento_v>();
		list = documento_VDao.findAll(false);
		
		return list;
	}

	@Transactional
	public List<Documento_v> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc) {
		List<Documento_v> lista = new ArrayList<Documento_v>();
		
		//Obtengo de la vista de imputaciones los ids de Documentos que apunten a las referencias
		if (StringUtils.isNotBlank(filtros.getReferencia())){
			Collection<Integer> idDocumentos =  documentoMovimientoIm_VDao.buscarPorReferenciaEnDocumentos(filtros.getReferencia());
			//Si no devuelve documentos  es que no encuentra resultados para ese filtro
			if  (idDocumentos == null || idDocumentos.isEmpty()) {
				return lista;
			}
			//le agrego a los filtros esta lista
			filtros.setIdsDocumentos(idDocumentos);
		}
		
		lista = documento_VDao.buscarEnDocumentosByFiltros(filtros, campoOrden, orderByAsc);
		
		return lista;
	}

	@Transactional
	public Documento_v findViewById(int id) {
		return documento_VDao.findById(id);
	}

	@Transactional
	public ErrorRespuestaBean verificarExisteDocumento(Integer idAdministracion,Integer idTipoDocumento, boolean filtroPorEntidad,Integer idTipoEntidad,Integer idEntidad, NumeroBean num) {
		ErrorRespuestaBean res = new ErrorRespuestaBean();
		
		List<Documento_v> list = documento_VDao.verificarExisteDocumento(idAdministracion, idTipoDocumento, filtroPorEntidad,idTipoEntidad,idEntidad, num);

		if (list.isEmpty() ){
			//Si la lista esta vacia quiere decir que NO EXISTE EL NUMERO. Devuelve TRUE.
			res.setValido(true);
		} else {
			//EXISTE EL NUMERO. Devuelve FALSE.
			res.setValido(false);
			res.setCodError(ConstantsErrors.NUMEROREPETIDO_COD_1_COD_ERROR);
			res.setError(ConstantsErrors.NUMEROREPETIDO_COD_1_ERROR);
			String documentoError = "";
			for (Documento_v documento_v : list) {
				documentoError = documento_v.getNumeroFormato(); 
			}
			res.setDescripcion("La cobinación de númeración que ha seleccionado están presentes en el Documento: " + documentoError);
		}
		
		return res;
	}

	public Documento clone (Documento doc) {
		Documento nuevoDoc = new Documento();
		
		if (doc == null){
			return null;
		}
			//nuevoDoc.setId(doc.getId());
			nuevoDoc.setNumeroLetra(doc.getNumeroLetra());
			nuevoDoc.setNumeroEstablecimiento(doc.getNumeroEstablecimiento());
			nuevoDoc.setNumeroAnio(doc.getNumeroAnio());
			nuevoDoc.setNumeroMes(doc.getNumeroMes());
			nuevoDoc.setNumeroDia(doc.getNumeroDia());
			nuevoDoc.setNumero(doc.getNumero());
			nuevoDoc.setFechaReal(doc.getFechaReal());
			nuevoDoc.setFechaIngreso(doc.getFechaIngreso());
			nuevoDoc.setFechaVencimiento(doc.getFechaVencimiento());
			nuevoDoc.setDescripcion(doc.getDescripcion());
			nuevoDoc.setTipoDocumentoId(doc.getTipoDocumentoId());
			nuevoDoc.setCuentaId(doc.getCuentaId());
			nuevoDoc.setMonedaId(doc.getMonedaId());
			nuevoDoc.setTipoEntidadId(doc.getTipoEntidadId());
			nuevoDoc.setEntidadId(doc.getEntidadId());
			nuevoDoc.setCotizacion(doc.getCotizacion());
			nuevoDoc.setAdministracion(doc.getAdministracion());
			nuevoDoc.setTipoMovimiento(doc.getTipoMovimiento());
			nuevoDoc.setImporteTotal(doc.getImporteTotal());
			nuevoDoc.setImporteAplicado(doc.getImporteAplicado());
			nuevoDoc.setPeriodoId(doc.getPeriodoId());
			nuevoDoc.setEstado(doc.getEstado());
			nuevoDoc.setDocumentoAnulaaId(doc.getDocumentoAnulaaId());
			nuevoDoc.setDocumentoAnuladoPorId(doc.getDocumentoAnuladoPorId());

		return nuevoDoc;
	}

	@Transactional
	public void actualizarEstadoDocumento(int idDocumento, String estado) {
		documentoDao.actualizarEstadoDocumento(idDocumento, estado);
	}

	@Transactional
	public void actualizarDocumentoAnuladoPor(int idDocumento,
			int idDocumentoAnulador) {
		documentoDao.setDocumentoAnuladoPor(idDocumento, idDocumentoAnulador);
	}
}
