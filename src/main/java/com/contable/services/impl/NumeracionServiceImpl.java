package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.NumeracionDao;
import com.contable.hibernate.model.Numeracion;
import com.contable.services.NumeracionService;

@Service("numeracionService")
public class NumeracionServiceImpl extends AbstractServiceImpl<Numeracion> implements NumeracionService{

	@Autowired
    private NumeracionDao numeracionDao;

	protected GenericDao<Numeracion, Integer> getDao() {
		return numeracionDao;
	}
	
	public Integer getUltimoNumero(Integer idTipoDocumento,Integer numAnio,Integer numMes,Integer numDia) {
		
		Integer numero = numeracionDao.getUltimoNumero(idTipoDocumento, numAnio, numMes, numDia);
		
		return numero;
	}

}
