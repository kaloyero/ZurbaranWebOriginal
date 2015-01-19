package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
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
		if (StringUtils.isNotBlank(filtro.getEntidadId())){
			String[] entidades = filtro.getEntidadId().replace("{", "").replace("{", "").split(",");
			criteria.add(Restrictions.in("entidadId", entidades));
		}
			
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
	public List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltros(	FiltroCuentaBean filtro, String anio, String mes, String campoOrder, boolean orderByAsc) {

		boolean muestraMoneda = false;
		//Si filtra por MonedaEn hace un query u otro
		if (filtro.getMonedaMuestraId() != null && filtro.getMonedaMuestraId().intValue() > 0 && filtro.isMonedaMuestraCotizaFecha()){
			muestraMoneda = true;
		}
		
		String queryStr = getQryStrSaldoAnteriorCuenta(filtro, anio, mes, muestraMoneda);
		List<CuentaBusquedaForm> result = getExcecuteSaldoAnteriorCuenta(queryStr, muestraMoneda);
				
		return result;
	
	}

	private String getQryStrSaldoAnteriorCuenta(FiltroCuentaBean filtro, String anio, String mes,boolean mostrarMonedaEn) {

		StringBuilder queryStr = new StringBuilder();
		String tabla = "";
		if (mostrarMonedaEn) {
			tabla = "saldoscuentasmonedasaamm_v";
		} else {
			tabla = "saldoscuentasaamm_v";
		}
		
		queryStr.append("select `IdAdministracion` AS `administracionId`, `IdCuenta` as `cuentaId`, `cuentaNombre`, `IdTipoEntidad` as `tipoEntidadId`, `tipoentidadNombre`, " +
				"`IdEntidad` as `entidadId`, `entidadNombre`, `IdMoneda` as `monedaId`, `monedaNombre`, `monedaCodigo`, sum(saldoaamm) as `saldo` ");
				if (mostrarMonedaEn) {
					queryStr.append(" ,sum(`SaldoMonedaAAMM`) as `totalMostrar`");
				}
		/*FROM*/
		queryStr.append("from "+tabla+"  ");

		/*WHERE*/
		queryStr.append("WHERE ");
		//fecha
		queryStr.append(" `AnioMes` <= '"+ anio + mes +"' ");
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		//cuenta
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (StringUtils.isNotBlank(filtro.getEntidadId())){
			queryStr.append(" AND `IdEntidad` in ("+filtro.getEntidadId().replace("{", "").replace("{", "")+") ");
		}
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND `IdMoneda` = '"+filtro.getMonedaId()+"' ");
		
		if (mostrarMonedaEn) {
			queryStr.append(" AND `IdMonedaEn` = '"+filtro.getMonedaMuestraId()+"' ");
		}
		
		queryStr.append(" group  ");
		queryStr.append(" by	Idadministracion, ");
		queryStr.append(" IdCuenta, ");
		queryStr.append(" IdTipoEntidad, ");
		queryStr.append(" IdEntidad, ");
		queryStr.append(" IdMoneda ");		
		
		

		return queryStr.toString();
	}
		
	@SuppressWarnings("unchecked")
	private List<CuentaBusquedaForm> getExcecuteSaldoAnteriorCuenta(String queryStr, boolean mostrarMonedaEn) {		
		Query query = null;
		if (mostrarMonedaEn) {
			query = getSession().createSQLQuery(queryStr)
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
				.addScalar("totalMostrar",Hibernate.STRING)
				.setResultTransformer( Transformers.aliasToBean(CuentaBusquedaForm.class));
		} else {
			query = getSession().createSQLQuery(queryStr)
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
		}
		List<CuentaBusquedaForm> result = query.list();
		
		return result;
	
	}
	
	@Transactional
	public List<CuentaBusquedaForm> buscarSaldoCuentaActualByFiltros(	FiltroCuentaBean filtro, String fecha,String campoOrder, boolean orderByAsc) {
	
		boolean muestraMoneda = false;
		//Si filtra por MonedaEn y filtra por monedaMuestraCotizaFecha is true
		if (filtro.getMonedaMuestraId() != null && filtro.getMonedaMuestraId().intValue() > 0 && filtro.isMonedaMuestraCotizaFecha()){
			muestraMoneda = true;
		}
		
		String queryStr = getQryStrSaldoCuentaActualCuenta(filtro, muestraMoneda);
		List<CuentaBusquedaForm> result = getExcecuteSaldoCuentaActualCuenta(queryStr,fecha, muestraMoneda);
				
		return result;
		
	}
	
	private String getQryStrSaldoCuentaActualCuenta(FiltroCuentaBean filtro,boolean mostrarMonedaEn) {

		StringBuilder queryStr = new StringBuilder();
		/*SELECT*/
		queryStr.append("select `doc`.`IdAdministracion` AS `administracionId`,`mov`.`IdCuenta` AS `cuentaId`,`cu`.`Nombre` AS `cuentaNombre`,`mov`.`IdTipoEntidad` AS `tipoEntidadId`,`te`.`Nombre` AS `tipoEntidadNombre`,`mov`.`IdEntidad` AS `entidadId`" +
				",`en`.`Nombre` AS `entidadNombre`,`mov`.`IdMoneda` AS `monedaId`,`mo`.`Nombre` AS `monedaNombre`,`mo`.`Codigo` AS `monedaCodigo` " +
				",sum((`mov`.`Importe` * (case when (`mov`.`TipoMovimiento` = 'D') then 1 when (`mov`.`TipoMovimiento` = 'C') then -(1) else 0 end))) AS `saldo`");
		if (mostrarMonedaEn){
			queryStr.append(" , sum((`mov`.`Importe` * (case when (`mov`.`TipoMovimiento` = 'D') then 1 when (`mov`.`TipoMovimiento` = 'C') then -(1) else 0 end) "
					+ " )) AS `saldo`, " + filtro.getMonedaMuestraId() + " IdMonedaEn, (year(doc.FechaIngreso)*100+month(doc.FechaIngreso)) AnioMes,sum(mov.Importe * " 
					+ " (case when (mov.TipoMovimiento = 'D') then 1 when (mov.TipoMovimiento = 'C') then -1 else 0 end) "
					+ " ) SaldoAAMM, sum(round(mov.Importe * (case when (mov.TipoMovimiento = 'D') then 1 when (mov.TipoMovimiento = 'C') then -1 else 0 end ) * " 
					+ " IFNULL(mov.cotizacion,1) / 	"
					+ " (case when mov.IdMoneda = " + filtro.getMonedaMuestraId() + " then IFNULL(mov.cotizacion,1) else "
					+ " (SELECT IFNULL(max(IFNULL(cotizacion,1)),1)	FROM cotizaciones cot where cot.Idmoneda = " + filtro.getMonedaMuestraId() + " "
					+ "	and cot.fecha = (select max(fecha) from cotizaciones cot1 where cot1.Idmoneda = " + filtro.getMonedaMuestraId() + "  and fecha <= doc.FechaIngreso  ) ) "
					+ " end ) "
					+ " ,2) )  totalMostrar ");
		}
				    
		/*FROM*/
		queryStr.append(" from (((((`documentomovimientos` `mov` "); 
		queryStr.append("join `documentos` `doc` on ((`mov`.`IdDocumento` = `doc`.`id`))) "); 
		queryStr.append(" join `cuentas` `cu` on((`mov`.`IdCuenta` = `cu`.`id`))) "); 
		queryStr.append(" join `monedas` `mo` on((`mov`.`IdMoneda` = `mo`.`id`))) "); 
		queryStr.append(" left join `tipoentidades` `te` on((`mov`.`IdTipoEntidad` = `te`.`id`))) "); 
		queryStr.append(" left join `entidades` `en` on((`mov`.`IdEntidad` = `en`.`id`))) "); 
//		queryStr.append("from (((((`documentomovimientos` `mov` join `documentos` `doc` on((`mov`.`IdDocumento` = `doc`.`id`))) join `cuentas` `cu` on((`mov`.`IdCuenta` = `cu`.`id`))) join `monedas` `mo` on((`mov`.`IdMoneda` = `mo`.`id`))) " +
//				"left join `tipoentidades` `te` on((`mov`.`IdTipoEntidad` = `te`.`id`))) left join `entidades` `en` on((`mov`.`IdEntidad` = `en`.`id`)))");
		/*WHERE*/
		queryStr.append(" WHERE ");
		//fecha
		queryStr.append("`doc`.`FechaIngreso` >= :fecha1  and `doc`.`FechaIngreso` <= :fecha2 ");
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `doc`.`IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		//cuenta
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `mov`.`IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `mov`.`IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (StringUtils.isNotBlank(filtro.getEntidadId()))
			queryStr.append(" AND `mov`.`IdEntidad` in ("+filtro.getEntidadId().replace("{", "").replace("{", "")+") ");		
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND `mov`.`IdMoneda` = '"+filtro.getMonedaId()+"' ");

		/*GROUP BY*/
		queryStr.append(" group by `doc`.`IdAdministracion`,`mov`.`IdCuenta`,`mov`.`IdTipoEntidad`,`mov`.`IdEntidad`");

		/*ORDER BY*/
		queryStr.append(" order by `doc`.`FechaIngreso` desc, `mov`.`IdDocumento`, `mov`.`Id` ");	

		return queryStr.toString();
	}
		
	@SuppressWarnings("unchecked")
	@Transactional
	private List<CuentaBusquedaForm> getExcecuteSaldoCuentaActualCuenta(String queryStr, String fecha, boolean mostrarMonedaEn) {			
		
		Query query = null; 
		if (mostrarMonedaEn){
			query = getSession().createSQLQuery(queryStr.toString())
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
				.addScalar("totalMostrar",Hibernate.STRING)
				.addScalar("saldo",Hibernate.STRING)
				.setDate("fecha1", DateUtil.getPrimerDiaMes(fecha))
				.setDate("fecha2", DateUtil.convertStringToDate(fecha))
				.setResultTransformer( Transformers.aliasToBean(CuentaBusquedaForm.class));
		} else {
				query = getSession().createSQLQuery(queryStr.toString())
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
					.setDate("fecha1", DateUtil.getPrimerDiaMes(fecha))
					.setDate("fecha2", DateUtil.convertStringToDate(fecha))
					.setResultTransformer( Transformers.aliasToBean(CuentaBusquedaForm.class));
			
		}
		
		List<CuentaBusquedaForm> result = query.list();
		
		return result;
				
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<CuentaBusquedaForm> buscarSaldoCuentaActualByFiltrosMonedaEn(	FiltroCuentaBean filtro, String fecha,String campoOrder, boolean orderByAsc) {
	
		StringBuilder queryStr = new StringBuilder();
		/*SELECT*/
		queryStr.append("select `doc`.`IdAdministracion` AS `administracionId`,`mov`.`IdCuenta` AS `cuentaId`,`cu`.`Nombre` AS `cuentaNombre`,`mov`.`IdTipoEntidad` AS `tipoEntidadId`,`te`.`Nombre` AS `tipoEntidadNombre`,`mov`.`IdEntidad` AS `entidadId`" +
				",`en`.`Nombre` AS `entidadNombre`,`mov`.`IdMoneda` AS `monedaId`,`mo`.`Nombre` AS `monedaNombre`,`mo`.`Codigo` AS `monedaCodigo` " +
				",sum((`mov`.`Importe` * (case when (`mov`.`TipoMovimiento` = 'D') then 1 when (`mov`.`TipoMovimiento` = 'C') then -(1) else 0 end))) AS `saldo`");
		/*FROM*/
		queryStr.append("from (((((`documentomovimientos` `mov` join `documentos` `doc` on((`mov`.`IdDocumento` = `doc`.`id`))) join `cuentas` `cu` on((`mov`.`IdCuenta` = `cu`.`id`))) join `monedas` `mo` on((`mov`.`IdMoneda` = `mo`.`id`))) " +
				"left join `tipoentidades` `te` on((`mov`.`IdTipoEntidad` = `te`.`id`))) left join `entidades` `en` on((`mov`.`IdEntidad` = `en`.`id`)))");
		/*WHERE*/
		queryStr.append("WHERE ");
		//fecha
		queryStr.append("`doc`.`FechaIngreso` >= :fecha1  and `doc`.`FechaIngreso` <= :fecha2 ");
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `doc`.`IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		//cuenta
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `mov`.`IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `mov`.`IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (StringUtils.isNotBlank(filtro.getEntidadId()))
			queryStr.append(" AND `mov`.`IdEntidad` in ("+filtro.getEntidadId().replace("{", "").replace("{", "")+") ");		
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND `mov`.`IdMoneda` = '"+filtro.getMonedaId()+"' ");
		/*GROUP BY*/
		queryStr.append(" group by `doc`.`IdAdministracion`,`mov`.`IdCuenta`,`mov`.`IdTipoEntidad`,`mov`.`IdEntidad`,`mov`.`IdMoneda`");
		/*ORDER BY*/
		queryStr.append(" order by `doc`.`FechaIngreso` desc, `mov`.`IdDocumento`, `mov`.`Id` ");
		
		
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
				.setDate("fecha1", DateUtil.getPrimerDiaMes(fecha))
				.setDate("fecha2", DateUtil.convertStringToDate(fecha))
				.setResultTransformer( Transformers.aliasToBean(CuentaBusquedaForm.class));

		List<CuentaBusquedaForm> result = query.list();
		
		return result;
		
	}

	@SuppressWarnings("unchecked")
	public List<CuentaBusquedaForm> buscarSaldoCuentaFiltros(	FiltroCuentaBean filtro, String anio, String mes, String campoOrder, boolean orderByAsc) {

		StringBuilder queryStr = new StringBuilder();
		
		queryStr.append(" SELECT Idadministracion as administracionId, ");
		queryStr.append(" IdCuenta as cuentaId, ");
		queryStr.append(" IdTipoEntidad as tipoEntidadId, ");
		queryStr.append(" IdEntidad as entidadId, ");
		queryStr.append(" IdMoneda as monedaId, ");
		queryStr.append(" cuentaNombre, ");
		queryStr.append(" entidadNombre, ");
		queryStr.append(" tipoentidadNombre, ");
		queryStr.append(" monedaNombre,monedaCodigo, ");
		queryStr.append(" sum(Saldo) as saldo");
		queryStr.append(" FROM ");
		queryStr.append(" ( ");
		queryStr.append(" SELECT `Idadministracion`, `IdCuenta`, `cuentaNombre`,`IdTipoEntidad`,`entidadNombre`,`tipoentidadNombre`, `IdEntidad`, `IdMoneda`,`monedaNombre`,`monedaCodigo`, sum(saldoaamm) `Saldo` ");  
		queryStr.append(" FROM saldoscuentasaamm_v ");
		queryStr.append(" 	where  ");
		//fecha
		queryStr.append(" `AnioMes` <= '"+ anio + mes +"' ");
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (StringUtils.isNotBlank(filtro.getEntidadId()))
			queryStr.append(" AND `IdEntidad` in ("+filtro.getEntidadId().replace("{", "").replace("{", "")+") ");
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND `IdMoneda` = '"+filtro.getMonedaId()+"' ");		
		
//		queryStr.append(" group by 	Idadministracion, IdCuenta, IdTipoEntidad, IdEntidad, IdMoneda ");    
	    
		queryStr.append(" UNION ALL ");
		queryStr.append("select `doc`.`IdAdministracion` AS `administracionId`,`mov`.`IdCuenta` AS `cuentaId`,`cu`.`Nombre` AS `cuentaNombre`,`mov`.`IdTipoEntidad` AS `tipoEntidadId`,`te`.`Nombre` AS `tipoEntidadNombre`,`mov`.`IdEntidad` AS `entidadId`" +
				",`en`.`Nombre` AS `entidadNombre`,`mov`.`IdMoneda` AS `monedaId`,`mo`.`Nombre` AS `monedaNombre`,`mo`.`Codigo` AS `monedaCodigo`" +
				",sum((`mov`.`Importe` * (case when (`mov`.`TipoMovimiento` = 'D') then 1 when (`mov`.`TipoMovimiento` = 'C') then -(1) else 0 end))) AS `saldo`");
		/*FROM*/
		queryStr.append("from (((((`documentomovimientos` `mov` join `documentos` `doc` on((`mov`.`IdDocumento` = `doc`.`id`))) join `cuentas` `cu` on((`mov`.`IdCuenta` = `cu`.`id`))) join `monedas` `mo` on((`mov`.`IdMoneda` = `mo`.`id`))) " +
				"left join `tipoentidades` `te` on((`mov`.`IdTipoEntidad` = `te`.`id`))) left join `entidades` `en` on((`mov`.`IdEntidad` = `en`.`id`)))");
		/*WHERE*/
		queryStr.append("WHERE ");
		//fecha
		queryStr.append("`doc`.`FechaIngreso` > :fecha1  and `doc`.`FechaIngreso` < :fecha2 ");
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `doc`.`IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		//cuenta
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `mov`.`IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `mov`.`IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (StringUtils.isNotBlank(filtro.getEntidadId()))
			queryStr.append(" AND `mov`.`IdEntidad` in ("+filtro.getEntidadId().replace("{", "").replace("{", "")+") ");
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND `mov`.`IdMoneda` = '"+filtro.getMonedaId()+"' ");
		/*GROUP BY*/
	//	queryStr.append(" group by `doc`.`IdAdministracion`,`mov`.`IdCuenta`,`mov`.`IdTipoEntidad`,`mov`.`IdEntidad`,`mov`.`IdMoneda`");

		queryStr.append(" ) SALDOCUENTAS ");
		queryStr.append(" group  ");
		queryStr.append(" by	Idadministracion, ");
		queryStr.append(" IdCuenta, ");
		queryStr.append(" IdTipoEntidad, ");
		queryStr.append(" IdEntidad, ");
		queryStr.append(" IdMoneda ");		

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
