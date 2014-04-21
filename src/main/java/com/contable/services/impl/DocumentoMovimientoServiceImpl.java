package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.DocumentoMovimientoDao;
import com.contable.hibernate.dao.DocumentoMovimientoEv_VDao;
import com.contable.hibernate.dao.DocumentoMovimientoIm_VDao;
import com.contable.hibernate.dao.DocumentoMovimientoIv_VDao;
import com.contable.hibernate.dao.DocumentoMovimientoVp_VDao;
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
    private DocumentoMovimientoEv_VDao documentoMovimientoEv_VDao;

	@Autowired
    private DocumentoMovimientoIv_VDao documentoMovimientoIv_VDao;

	@Autowired
    private DocumentoMovimientoVp_VDao documentoMovimientoVp_VDao;

	@Autowired
    private DocumentoMovimientoIm_VDao documentoMovimientoIm_VDao;

	
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

	public List<DocumentoMovimientoEv_V> getMovimientosEgreValorByIdDoc(Integer documentoId){
		return documentoMovimientoEv_VDao.findAllByProperty("documentoId", documentoId, false);
	}

}
