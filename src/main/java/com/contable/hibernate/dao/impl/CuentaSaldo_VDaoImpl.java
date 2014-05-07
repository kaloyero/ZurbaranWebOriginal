package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroCuentaBean;
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
		
		if (filtro.getAdministracionId() != null )
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
	
	@SuppressWarnings("unchecked")
	public List buscarSaldoCuentaActualByFiltros(	FiltroCuentaBean filtro, Integer anio, Integer mes, String campoOrder, boolean orderByAsc) {
	
		StringBuilder queryStr = new StringBuilder();
		/*SELECT*/
		queryStr.append("select `doc`.`IdAdministracion` AS `IdAdministracion`,`mov`.`IdCuenta` AS `IdCuenta`,`cu`.`Nombre` AS `cuentaNombre`,`mov`.`IdTipoEntidad` AS `IdTipoEntidad`,`te`.`Nombre` AS `tipoentidadNombre`,`mov`.`IdEntidad` AS `IdEntidad`," +
				"`en`.`Nombre` AS `entidadNombre`,`mov`.`IdMoneda` AS `IdMoneda`,`mo`.`Nombre` AS `monedaNombre`,`mo`.`Codigo` AS `monedaCodigo`,sum((`mov`.`Importe` * (case when (`mov`.`TipoMovimiento` = 'D') then 1 when (`mov`.`TipoMovimiento` = 'C') " +
				"then -(1) else 0 end))) AS `SaldoAAMM`");
		/*FROM*/
		queryStr.append("from (((((`documentomovimientos` `mov` join `documentos` `doc` on((`mov`.`IdDocumento` = `doc`.`id`))) join `cuentas` `cu` on((`mov`.`IdCuenta` = `cu`.`id`))) join `monedas` `mo` on((`mov`.`IdMoneda` = `mo`.`id`))) " +
				"left join `tipoentidades` `te` on((`mov`.`IdTipoEntidad` = `te`.`id`))) left join `entidades` `en` on((`mov`.`IdEntidad` = `en`.`id`)))");
		/*WHERE*/
		queryStr.append("WHERE ");
		//fecha
		queryStr.append("`doc`.`FechaIngreso` > '"+anio+"-"+mes+"-01' and `doc`.`FechaIngreso` < '"+filtro.getFechaHasta()+"' ");
		if (filtro.getAdministracionId() != null )
			queryStr.append("AND `doc`.`IdAdministracion` is '"+filtro.getAdministracionId()+"'");
		//cuenta
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append("AND `mov`.`IdCuenta` is '"+filtro.getCuentaId()+"'");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append("AND `mov`.`IdTipoEntidad` is '"+filtro.getTipoEntidadId()+"'");
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			queryStr.append("AND `doc`.`IdEntidad` is '"+filtro.getEntidadId()+"'");
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append("AND `doc`.`IdMoneda` is '"+filtro.getMonedaId()+"'");
		/*GROUP BY*/
		queryStr.append(" group by `doc`.`IdAdministracion`,`mov`.`IdCuenta`,`mov`.`IdTipoEntidad`,`mov`.`IdEntidad`,`mov`.`IdMoneda`");
		
		Query query = getSession().createSQLQuery(queryStr.toString());

		List result = query.list();
		
		return result;
		
	}
}
