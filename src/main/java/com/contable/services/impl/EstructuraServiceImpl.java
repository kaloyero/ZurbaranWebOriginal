package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.dao.EstructuraDao;
import com.contable.hibernate.model.Estructura;
import com.contable.services.EstructuraService;

@Service("estructuraService")
public class EstructuraServiceImpl extends AbstractServiceImpl<Estructura> implements EstructuraService{

	@Autowired
    private EstructuraDao estructuraDao;

	protected GenericDao<Estructura, Integer> getDao() {
		return estructuraDao;
	}

	@Override
	@Transactional
	public List<EstructuraSaldoForm> getEstructuraSaldos(int idEstructura,
			int idAdministracion, String fecha, Integer monedaMostrarId) {

		
		return estructuraDao.getEstructuraSaldos(idEstructura, idAdministracion, fecha, monedaMostrarId);
	}


	
}
