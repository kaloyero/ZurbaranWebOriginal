package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.hibernate.dao.CuentaDao;
import com.contable.hibernate.dao.CuentaMonedaDao;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.services.CuentaService;

@Service("cuentaService")
public class CuentaServiceImpl extends AbstractServiceImpl<Cuenta> implements CuentaService{

	@Autowired
    private CuentaDao cuentaDao;

	@Autowired
    private CuentaMonedaDao cuentaMonedaDao;

	protected GenericDao<Cuenta, Integer> getDao() {
		return cuentaDao;
	}
	
	@Transactional
	public Integer save(Cuenta dto) {
		Integer a = getDao().save(dto);
		
		return a;
	}

	@Transactional
	public void saveCuentaMoneda(List<CuentaMoneda> dto) {
		cuentaMonedaDao.save(dto);
	}

	@Transactional
	public void updateCuentaMoneda(List<Integer> idsMonedas, int idCuenta) {
		cuentaMonedaDao.update(idsMonedas, idCuenta);
	}

	
	@Transactional
	public List<CuentaMoneda> findCuentaMoneda(int idCuenta) {
		return cuentaMonedaDao.getMonedasByIdCuenta(idCuenta);
	}

	@Transactional
	public List<ConfigBean> findCuentaMonedaConfig(int idCuenta) {
		return cuentaMonedaDao.getMonedasConfigByIdCuenta(idCuenta);
	}

}
