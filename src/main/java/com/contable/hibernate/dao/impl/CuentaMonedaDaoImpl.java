package com.contable.hibernate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.CuentaMonedaDao;
import com.contable.hibernate.model.CuentaMoneda;

@Repository("cuentaMonedaDao")
public class CuentaMonedaDaoImpl extends GenericDaoImpl<CuentaMoneda, Integer> implements CuentaMonedaDao{

	@Override
	protected Class<CuentaMoneda> getEntityClass() {
		return CuentaMoneda.class;
	}

	@Transactional
	public void save(List<CuentaMoneda> dtoList) {
		for (CuentaMoneda dto : dtoList) {
			this.save(dto);	
		}
	}

	public List<CuentaMoneda> getMonedasByIdCuenta(int idCuenta){
		List<CuentaMoneda> lista = this.findAllByProperty("idCuenta" ,idCuenta);
		return lista;
	}
}
