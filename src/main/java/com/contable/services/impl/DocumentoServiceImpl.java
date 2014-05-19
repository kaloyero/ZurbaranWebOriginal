package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

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
    private DocumentoAplicacionPendiente_VDao documentoAplicacionPendiente_VDao;

	
	protected GenericDao<Documento, Integer> getDao() {
		return documentoDao;
	}
	
	public List<Documento_v> getListaView() {
		
		List<Documento_v> list = new ArrayList<Documento_v>();
		list = documento_VDao.findAll(false);
		
		return list;
	}

	public List<Documento_v> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc) {
		
		List<Documento_v> list = documento_VDao.buscarEnDocumentosByFiltros(filtros, campoOrden, orderByAsc);
		return list;
	}

	@Transactional
	public Documento_v findViewById(int id) {
		return documento_VDao.findById(id);
	}

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

	public void actualizarEstadoDocumento(int idDocumento, String estado) {
		documentoDao.actualizarEstadoDocumento(idDocumento, estado);
	}

}
