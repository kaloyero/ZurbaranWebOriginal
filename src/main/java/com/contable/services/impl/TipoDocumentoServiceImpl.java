package com.contable.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.TipoDocumentoConceptoDao;
import com.contable.hibernate.dao.TipoDocumentoDao;
import com.contable.hibernate.dao.TipoDocumento_VDao;
import com.contable.hibernate.model.Concepto;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.hibernate.model.TipoDocumentoConcepto;
import com.contable.hibernate.model.TipoDocumento_v;
import com.contable.services.TipoDocumentoService;

@Service("tipoDocumentoService")
public class TipoDocumentoServiceImpl extends AbstractServiceImpl<TipoDocumento> implements TipoDocumentoService{

	@Autowired
    private TipoDocumentoDao tipoDocumentoDao;

	@Autowired
    private TipoDocumentoConceptoDao tipoDocumentoConceptoDao;

	@Autowired
    private TipoDocumento_VDao tipoDocumento_VDao;

	
	protected GenericDao<TipoDocumento, Integer> getDao() {
		return tipoDocumentoDao;
	}
	
	public List<TipoDocumento_v> getLista_v() {
		
		List<TipoDocumento_v> list = new ArrayList<TipoDocumento_v>();
		list = tipoDocumento_VDao.findAll(false);
		
		return list;
	}

	public TipoDocumento_v findById_v(Integer id) {
		TipoDocumento_v ent = new TipoDocumento_v();
		ent = tipoDocumento_VDao.findById(id);
		return ent;
	}
	
	public List<TipoDocumento_v> getTipoDocumentosByIdAdm(Integer idAdm){
		List<TipoDocumento_v> list = new ArrayList<TipoDocumento_v>();
		
		list = tipoDocumento_VDao.findAllByProperty("IdAdministracion",idAdm,true);
		
		return list;
	}

	public void saveConceptos(int tipoDocumento, Collection<Integer> conceptos) {

		if (conceptos != null)
		for (Integer idConcepto : conceptos) {
			TipoDocumentoConcepto concepto =new TipoDocumentoConcepto();
			concepto.setIdTipoDocumento(tipoDocumento);
			Concepto cto = new Concepto();
			cto.setId(idConcepto);
			concepto.setConcepto(cto);
			tipoDocumentoConceptoDao.save(concepto);
		}
		
	}
	
	@Transactional
	public void updateTipodocumentoconcepto(Collection<Integer> idsConceptos, int idTipoDocumento) {
		tipoDocumentoConceptoDao.update(idsConceptos, idTipoDocumento);
	}

}
