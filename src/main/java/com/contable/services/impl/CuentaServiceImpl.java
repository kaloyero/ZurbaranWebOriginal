package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.hibernate.dao.CuentaDao;
import com.contable.hibernate.dao.CuentaMonedaDao;
import com.contable.hibernate.dao.CuentaResumen_VDao;
import com.contable.hibernate.dao.CuentaSaldo_VDao;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.hibernate.model.CuentaResumen_V;
import com.contable.hibernate.model.CuentaSaldo_V;
import com.contable.services.CuentaService;

@Service("cuentaService")
public class CuentaServiceImpl extends AbstractServiceImpl<Cuenta> implements CuentaService{

	@Autowired
    private CuentaDao cuentaDao;

	@Autowired
    private CuentaMonedaDao cuentaMonedaDao;

	@Autowired
    private CuentaResumen_VDao cuentaResumen_VDao;

	@Autowired
    private CuentaSaldo_VDao cuentaSaldo_VDao;

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

	public List<CuentaResumen_V> buscarResumenPorFiltros(FiltroCuentaBean filtros, String campoOrden, boolean orderByAsc) {
			List<CuentaResumen_V> list = cuentaResumen_VDao.buscarResumenByFiltros(filtros, campoOrden, orderByAsc);
		return list;

	}
	public List<CuentaSaldo_V> buscarSaldoPorFiltros(FiltroCuentaBean filtros, String campoOrden, boolean orderByAsc) {
			List<CuentaSaldo_V> list = cuentaSaldo_VDao.buscarEnValoresPropiosByFiltros(filtros, campoOrden, orderByAsc);
		return list;

	}

	
}
