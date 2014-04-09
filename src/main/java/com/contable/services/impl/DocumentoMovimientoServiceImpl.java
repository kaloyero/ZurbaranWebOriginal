package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.DocumentoMovimientoDao;
import com.contable.hibernate.model.DocumentoMovimiento;
import com.contable.services.DocumentoMovimientoService;

@Service("documentoMovimientoService")
public class DocumentoMovimientoServiceImpl extends AbstractServiceImpl<DocumentoMovimiento> implements DocumentoMovimientoService{

	@Autowired
    private DocumentoMovimientoDao documentoMovimientoDao;

	protected GenericDao<DocumentoMovimiento, Integer> getDao() {
		return documentoMovimientoDao;
	}

}
