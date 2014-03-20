package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.TipoDocumentoDao;
import com.contable.hibernate.dao.TipoDocumento_VDao;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.hibernate.model.TipoDocumento_v;
import com.contable.services.TipoDocumentoService;

@Service("tipoDocumentoService")
public class TipoDocumentoServiceImpl extends AbstractServiceImpl<TipoDocumento> implements TipoDocumentoService{

	@Autowired
    private TipoDocumentoDao tipoDocumentoDao;

	@Autowired
    private TipoDocumento_VDao tipoDocumento_VDao;

	
	protected GenericDao<TipoDocumento, Integer> getDao() {
		return tipoDocumentoDao;
	}
	
	public List<TipoDocumento_v> getListaView() {
		
		List<TipoDocumento_v> list = new ArrayList<TipoDocumento_v>();
		list = tipoDocumento_VDao.findAll(false);
		
		return list;
	}

}
