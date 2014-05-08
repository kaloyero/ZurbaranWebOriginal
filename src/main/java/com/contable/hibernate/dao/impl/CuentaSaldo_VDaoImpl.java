package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.DateUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.dao.CuentaSaldo_VDao;
import com.contable.hibernate.model.CuentaSaldo_V;

@Repository("cuentaSaldo_VDao")
public class CuentaSaldo_VDaoImpl extends GenericDaoImpl<CuentaSaldo_V, Integer> implements CuentaSaldo_VDao{

	@Override
	protected Class<CuentaSaldo_V> getEntityClass() {
		return CuentaSaldo_V.class;
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<CuentaSaldo_V> buscarSaldoCuentaByFiltros(	FiltroCuentaBean filtro, Integer anio, Integer mes, String campoOrder, boolean orderByAsc) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			criteria.add(Restrictions.eq("administracionId", filtro.getAdministracionId()));
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			criteria.add(Restrictions.eq("cuentaId", filtro.getCuentaId()));
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			criteria.add(Restrictions.eq("tipoEntidadId", filtro.getTipoEntidadId()));
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			criteria.add(Restrictions.eq("entidadId", filtro.getEntidadId()));
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			criteria.add(Restrictions.eq("monedaId", filtro.getMonedaId()));
		
		criteria.add(Restrictions.eq("anio", anio));
		criteria.add(Restrictions.eq("mes",  mes));

    	/* Agrega el orden */
       	setOrderBy(criteria,campoOrder,orderByAsc);
       	
       	List<CuentaSaldo_V> list = criteria.list();
		
		return list;
	
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltros(	FiltroCuentaBean filtro, Integer anio, Integer mes, String campoOrder, boolean orderByAsc) {

		StringBuilder queryStr = new StringBuilder();
		/*SELECT*/
		queryStr.append("select `IdAdministracion` AS `administracionId`, `IdCuenta` as `cuentaId`, `cuentaNombre`, `IdTipoEntidad` as `tipoEntidadId`, `tipoentidadNombre`, " +
				"`IdEntidad` as `entidadId`, `entidadNombre`, `IdMoneda` as `monedaId`, `monedaNombre`, `monedaCodigo`, `Anio`, `Mes`, `SaldoAAMM` as `saldo` ");
		/*FROM*/
		queryStr.append("from saldoscuentasaamm_v ");
		/*WHERE*/
		queryStr.append("WHERE ");
		//fecha
		queryStr.append("`anio` = '"+anio + "' and `mes` = '"+mes+"' ");
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		//cuenta
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			queryStr.append(" AND `IdEntidad` = '"+filtro.getEntidadId()+"' ");
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND `IdMoneda` = '"+filtro.getMonedaId()+"' ");
		
		Query query = getSession().createSQLQuery(queryStr.toString())
				.addScalar("administracionId")
				.addScalar("cuentaId")
				.addScalar("cuentaNombre")
				.addScalar("tipoEntidadId")
				.addScalar("tipoEntidadNombre")
				.addScalar("entidadId")
				.addScalar("entidadNombre")
				.addScalar("monedaId")
				.addScalar("monedaNombre")
				.addScalar("monedaCodigo")
				.addScalar("saldo",Hibernate.STRING)
 				
				.setResultTransformer( Transformers.aliasToBean(CuentaBusquedaForm.class));

		List<CuentaBusquedaForm> result = query.list();
		
		return result;
	
	}

	
	@SuppressWarnings("unchecked")
	public List<CuentaBusquedaForm> buscarSaldoCuentaActualByFiltros(	FiltroCuentaBean filtro, String campoOrder, boolean orderByAsc) {
	
		StringBuilder queryStr = new StringBuilder();
		/*SELECT*/
		queryStr.append("select `doc`.`IdAdministracion` AS `administracionId`,`mov`.`IdCuenta` AS `cuentaId`,`cu`.`Nombre` AS `cuentaNombre`,`mov`.`IdTipoEntidad` AS `tipoEntidadId`,`te`.`Nombre` AS `tipoEntidadNombre`,`mov`.`IdEntidad` AS `entidadId`" +
				",`en`.`Nombre` AS `entidadNombre`,`mov`.`IdMoneda` AS `monedaId`,`mo`.`Nombre` AS `monedaNombre`,`mo`.`Codigo` AS `monedaCodigo`" +
				",sum((`mov`.`Importe` * (case when (`mov`.`TipoMovimiento` = 'D') then 1 when (`mov`.`TipoMovimiento` = 'C') then -(1) else 0 end))) AS `saldo`");
		/*FROM*/
		queryStr.append("from (((((`documentomovimientos` `mov` join `documentos` `doc` on((`mov`.`IdDocumento` = `doc`.`id`))) join `cuentas` `cu` on((`mov`.`IdCuenta` = `cu`.`id`))) join `monedas` `mo` on((`mov`.`IdMoneda` = `mo`.`id`))) " +
				"left join `tipoentidades` `te` on((`mov`.`IdTipoEntidad` = `te`.`id`))) left join `entidades` `en` on((`mov`.`IdEntidad` = `en`.`id`)))");
		/*WHERE*/
		queryStr.append("WHERE ");
		//fecha
//		queryStr.append("`doc`.`FechaIngreso` > '"+DateUtil.getPrimerDiaMes(filtro.getFechaHasta())+"' and `doc`.`FechaIngreso` < '"+filtro.getFechaHasta()+"' ");
		queryStr.append("`doc`.`FechaIngreso` > :fecha1  and `doc`.`FechaIngreso` < :fecha2 ");
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `doc`.`IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		//cuenta
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `mov`.`IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `mov`.`IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			queryStr.append(" AND `doc`.`IdEntidad` = '"+filtro.getEntidadId()+"' ");
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND `doc`.`IdMoneda` = '"+filtro.getMonedaId()+"' ");
		/*GROUP BY*/
		queryStr.append(" group by `doc`.`IdAdministracion`,`mov`.`IdCuenta`,`mov`.`IdTipoEntidad`,`mov`.`IdEntidad`,`mov`.`IdMoneda`");
		
		Query query = getSession().createSQLQuery(queryStr.toString())
				.addScalar("administracionId")
				.addScalar("cuentaId")
				.addScalar("cuentaNombre")
				.addScalar("tipoEntidadId")
				.addScalar("tipoEntidadNombre")
				.addScalar("entidadId")
				.addScalar("entidadNombre")
				.addScalar("monedaId")
				.addScalar("monedaNombre")
				.addScalar("monedaCodigo")
				.addScalar("saldo",Hibernate.STRING)
				.setDate("fecha1", DateUtil.getPrimerDiaMes(filtro.getFechaHasta()))
				.setDate("fecha2", DateUtil.convertStringToDate(filtro.getFechaHasta()))
				.setResultTransformer( Transformers.aliasToBean(CuentaBusquedaForm.class));

		List<CuentaBusquedaForm> result = query.list();
		
		return result;
		
	}
}
