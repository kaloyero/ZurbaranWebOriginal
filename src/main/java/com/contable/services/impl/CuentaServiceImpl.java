package com.contable.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.DocumentoUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.dao.CuentaDao;
import com.contable.hibernate.dao.CuentaMonedaDao;
import com.contable.hibernate.dao.CuentaResumen_VDao;
import com.contable.hibernate.dao.CuentaSaldo_VDao;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
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

	public List<CuentaBusquedaForm> buscarResumenPorFiltros(FiltroCuentaBean filtros, String campoOrden, boolean orderByAsc) {
			List<CuentaBusquedaForm> list = cuentaResumen_VDao.buscarSaldoAnteriorCuentaByFiltros(filtros, campoOrden, orderByAsc);
			
			for (CuentaBusquedaForm form : list) {
				form.setFechaIngreso(DateUtil.convertDateToString(form.getFecha()));
				form.setNumeroFormateado(DocumentoUtil.getNumeroFormato(form.getNumeroLetra(), form.getNumeroEstablecimiento(), form.getNumeroAnio(), form.getNumeroMes(), form.getNumeroDia(), form.getNumero()));
				form.setMonedaNombre(form.getMonedaNombre());
				form.setDebito(FormatUtil.format2DecimalsStr(form.getDebito()));
				form.setCredito(FormatUtil.format2DecimalsStr(form.getCredito()));
			}
			
		return list;

	}
	public List<CuentaBusquedaForm> buscarSaldoPorFiltros(FiltroCuentaBean filtros, String campoOrden, boolean orderByAsc) {

		List<CuentaBusquedaForm> list = new ArrayList<CuentaBusquedaForm>();
		/* SI no se le pasa la fecha retorna una lista vacía*/
		if (StringUtils.isNotBlank(filtros.getFechaHasta())){
			//Tomo el mes y el anio
			Date fecha = DateUtil.convertStringToDate(filtros.getFechaHasta());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha);
			Integer mes = calendar.get(Calendar.MONTH);
			Integer anio = calendar.get(Calendar.YEAR);
			
			list = cuentaSaldo_VDao.buscarSaldoAnteriorCuentaByFiltros(filtros, anio, mes, campoOrden, orderByAsc);
		}
			
		return list;

	}


	public List<CuentaBusquedaForm> buscarSaldoCuentaActualByFiltros(FiltroCuentaBean filtro, String campoOrden, boolean orderByAsc) {
		List<CuentaBusquedaForm> list = new ArrayList<CuentaBusquedaForm>();

		/* SI no se le pasa la fecha retorna una lista vacía*/
		if (StringUtils.isNotBlank(filtro.getFechaHasta())){
			list = cuentaSaldo_VDao.buscarSaldoCuentaActualByFiltros(filtro, campoOrden, orderByAsc);
		}
	
		return list;

}

}
