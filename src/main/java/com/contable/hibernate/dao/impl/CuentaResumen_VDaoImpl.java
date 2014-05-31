package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.DateUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.dao.CuentaResumen_VDao;
import com.contable.hibernate.model.CuentaResumen_V;

@Repository("cuentaResumen_VDao")
public class CuentaResumen_VDaoImpl extends GenericDaoImpl<CuentaResumen_V, Integer> implements CuentaResumen_VDao{

	@Override
	protected Class<CuentaResumen_V> getEntityClass() {
		return CuentaResumen_V.class;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltros(	FiltroCuentaBean filtro, String campoOrder, boolean orderByAsc) {

		StringBuilder queryStr = new StringBuilder();
		/*SELECT*/
		queryStr.append("select `IdAdministracion` AS `administracionId`, `FechaIngreso` `fecha`, `tipodocumentoNombre` `tipoDocumentoNombre`, `NumeroLetra`, `NumeroEstablecimiento`, " +
				"`NumeroAnio`, `NumeroMes`, `NumeroDia`, `Numero`, `IdDocumento` `documentoId`, `IdMovimiento` `movimientoId`, `Descripcion` , `Referencia` , `IdCuenta` `cuentaId`," +
				" `IdTipoEntidad` `tipoEntidadId`, `IdEntidad` `entidadId`, `IdMoneda` `monedaId`, `monedaNombre`, `monedaCodigo`, `Debito` `debito`, `Credito` `credito` ");
		
		/*FROM*/
		queryStr.append("from resumencuentamovimientos_v ");
		/*WHERE*/
		queryStr.append("WHERE ");
		//fecha
		queryStr.append(" '1' = '1' ");
		//cuenta
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			queryStr.append(" AND `IdEntidad` = '"+filtro.getEntidadId()+"' ");
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND `IdMoneda` = '"+filtro.getMonedaId()+"' ");
		if (StringUtils.isNotBlank(filtro.getFechaDesde()))
			queryStr.append(" AND `fechaIngreso` >= :fechaDesde ");
		if (StringUtils.isNotBlank(filtro.getFechaHasta()))
			queryStr.append(" AND `fechaIngreso` <= :fechaHasta ");
			
		queryStr.append(" ORDER BY FechaIngreso desc ");
		
		Query query = getSession().createSQLQuery(queryStr.toString())
				.addScalar("administracionId")
				.addScalar("cuentaId")
				.addScalar("tipoEntidadId")
				.addScalar("tipodocumentoNombre")
				.addScalar("entidadId")
				.addScalar("documentoId")
				.addScalar("monedaId")
				.addScalar("monedaNombre")
				.addScalar("monedaCodigo")
				.addScalar("fecha")
				.addScalar("numeroLetra")
				.addScalar("numeroEstablecimiento")
				.addScalar("numeroAnio")
				.addScalar("numeroMes")
				.addScalar("numeroDia")
				.addScalar("numero")
				.addScalar("debito",Hibernate.STRING)
				.addScalar("credito",Hibernate.STRING)
				.setResultTransformer( Transformers.aliasToBean(CuentaBusquedaForm.class));
				
		if (StringUtils.isNotBlank(filtro.getFechaDesde()))		
			query.setDate("fechaDesde", DateUtil.convertStringToDate(filtro.getFechaDesde()));
		if (StringUtils.isNotBlank(filtro.getFechaHasta()))
			query.setDate("fechaHasta", DateUtil.convertStringToDate(filtro.getFechaHasta()));


		List<CuentaBusquedaForm> result = query.list();
		
		return result;
	
	}
	
}
