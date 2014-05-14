package com.contable.services.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.DocumentoAplicaciones_VDao;
import com.contable.hibernate.dao.DocumentoMovimientoDao;
import com.contable.hibernate.dao.DocumentoMovimientoEv_VDao;
import com.contable.hibernate.dao.DocumentoMovimientoIm_VDao;
import com.contable.hibernate.dao.DocumentoMovimientoIv_VDao;
import com.contable.hibernate.dao.DocumentoMovimientoTotales_VDao;
import com.contable.hibernate.dao.DocumentoMovimientoVp_VDao;
import com.contable.hibernate.model.DocumentoAplicaciones_V;
import com.contable.hibernate.model.DocumentoMovimiento;
import com.contable.hibernate.model.DocumentoMovimientoEv_V;
import com.contable.hibernate.model.DocumentoMovimientoIm_V;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;
import com.contable.services.DocumentoMovimientoService;

@Service("documentoMovimientoService")
public class DocumentoMovimientoServiceImpl extends AbstractServiceImpl<DocumentoMovimiento> implements DocumentoMovimientoService{

	@Autowired
    private DocumentoMovimientoDao documentoMovimientoDao;

	@Autowired
    private DocumentoAplicaciones_VDao documentoAplicaciones_VDao;

	@Autowired
    private DocumentoMovimientoEv_VDao documentoMovimientoEv_VDao;

	@Autowired
    private DocumentoMovimientoIv_VDao documentoMovimientoIv_VDao;

	@Autowired
    private DocumentoMovimientoVp_VDao documentoMovimientoVp_VDao;

	@Autowired
    private DocumentoMovimientoIm_VDao documentoMovimientoIm_VDao;

	@Autowired
    private DocumentoMovimientoTotales_VDao documentoMovimientoTotales_VDao;

	
	protected GenericDao<DocumentoMovimiento, Integer> getDao() {
		return documentoMovimientoDao;
	}

	public List<DocumentoMovimientoIm_V> getMovimientosImputacionByIdDoc(Integer documentoId){
		return documentoMovimientoIm_VDao.findAllByProperty("documentoId", documentoId, false);
	}

	public List<DocumentoMovimientoVp_V> getMovimientosValorPropioByIdDoc(Integer documentoId){
		return documentoMovimientoVp_VDao.findAllByProperty("documentoId", documentoId, false);
	}

	public List<DocumentoMovimientoIv_V> getMovimientosIngreValorByIdDoc(Integer documentoId){
		return documentoMovimientoIv_VDao.findAllByProperty("documentoId", documentoId, false);
	}

	public DocumentoMovimientoIv_V findMovimientoIngreValorByValorTerceId(Integer valorTerceId){
		return documentoMovimientoIv_VDao.findEntityByProperty("valorTerceId", valorTerceId, false);
	}

	public HashMap<Integer,DocumentoMovimientoIv_V> findMovimientoIngreValorByValorTerceIdList(Collection<Integer> valorTerceId){
		HashMap<Integer,DocumentoMovimientoIv_V> map = new HashMap<Integer,DocumentoMovimientoIv_V>();
		List<DocumentoMovimientoIv_V> lista = documentoMovimientoIv_VDao.findMovimientosIngreValorByValorTerceIdList(valorTerceId);

		for (DocumentoMovimientoIv_V mov : lista) {
			map.put(mov.getValorTerceId(), mov);
		}
		
		return map;
	}

	public List<DocumentoMovimientoEv_V> getMovimientosEgreValorByIdDoc(Integer documentoId){
		return documentoMovimientoEv_VDao.findAllByProperty("documentoId", documentoId, false);
	}

	public HashMap<String,ConsultasGeneralesBean> getTotalesMovimientosByDocId(Integer documentoId){
		List<ConsultasGeneralesBean> lista = documentoMovimientoTotales_VDao.getMovimientosTotales(documentoId); 
		HashMap<String,ConsultasGeneralesBean> map = new HashMap<String, ConsultasGeneralesBean>();
		
		//Inicializo Totales
		ConsultasGeneralesBean initBean = new ConsultasGeneralesBean();
		initBean.setCampoDecimal1(0.00);
		initBean.setCampoDecimal2(0.00);
		map.put(Constants.DOCUMENTO_CODMOVIMIENTO_ENCABEZADO, initBean);
		map.put(Constants.DOCUMENTO_CODMOVIMIENTO_IMPUTACIONES, initBean);
		map.put(Constants.DOCUMENTO_CODMOVIMIENTO_INGRESOVALORES, initBean);
		map.put(Constants.DOCUMENTO_CODMOVIMIENTO_EGRESOVALORES, initBean);		
		map.put(Constants.DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS, initBean);
		
		for (ConsultasGeneralesBean bean : lista) {
			map.put(bean.getCampoCadena1(), bean);
		}
		return map;		
 
	}

	public List<DocumentoAplicaciones_V> getCancelacionesByIdDoc(Integer documentoId) {
		return documentoAplicaciones_VDao.findAllByProperty("id", documentoId, false);
	}

}
