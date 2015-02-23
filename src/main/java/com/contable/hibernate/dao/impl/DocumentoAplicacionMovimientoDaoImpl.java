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
import com.contable.common.beans.FiltroDocAplicacionBean;
import com.contable.common.utils.DateUtil;
import com.contable.hibernate.dao.DocumentoAplicacionMovimientoDao;
import com.contable.hibernate.model.DocumentoAplicacionMovimiento_V;

@Repository("documentoAplicacionMovimientoDao")
public class DocumentoAplicacionMovimientoDaoImpl extends GenericDaoImpl<DocumentoAplicacionMovimiento_V, Integer> implements DocumentoAplicacionMovimientoDao{

	@Override
	protected Class<DocumentoAplicacionMovimiento_V> getEntityClass() {
		return DocumentoAplicacionMovimiento_V.class;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DocumentoAplicacionMovimiento_V> getAplicacionesByFilters(FiltroDocAplicacionBean filtro){

		Criteria criteria = getSession().createCriteria(getEntityClass());

		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			criteria.add(Restrictions.eq("administracionId", filtro.getAdministracionId()));

//		if (filtro.getDocAplicaTipoDocumentoId() != null && filtro.getDocAplicaTipoDocumentoId() > 0)
//			criteria.add(Restrictions.eq("docAplicaTipoDocumentoId", filtro.getDocAplicaTipoDocumentoId()));
		
		if (filtro.getDocAplicaTipoDocumentoId() != null && filtro.getDocAplicaTipoDocumentoId() > 0)
			criteria.add(Restrictions.eq("tipoDocumentoId", filtro.getDocAplicaTipoDocumentoId()));
		
		if (filtro.getDocAplicaCuentaId() != null && filtro.getDocAplicaCuentaId() > 0)
			criteria.add(Restrictions.eq("cuentaId", filtro.getDocAplicaCuentaId()));
		if (filtro.getDocAplicaTipoEntidadId() != null && filtro.getDocAplicaTipoEntidadId() > 0)
			criteria.add(Restrictions.eq("tipoEntidadId", filtro.getDocAplicaTipoEntidadId()));
		if (filtro.getDocAplicaEntidadId() != null && filtro.getDocAplicaEntidadId() > 0){
			criteria.add(Restrictions.eq("entidadId", filtro.getDocAplicaEntidadId()));
		}
		
		if (filtro.getMovCuentaId() != null && filtro.getMovCuentaId() > 0)
			criteria.add(Restrictions.eq("movCuentaId", filtro.getMovCuentaId()));
		if (filtro.getMovTipoEntidadId() != null && filtro.getMovTipoEntidadId() > 0)
			criteria.add(Restrictions.eq("movTipoEntidadId", filtro.getMovTipoEntidadId()));
		if (filtro.getMovEntidadId() != null && filtro.getMovEntidadId() > 0){
			criteria.add(Restrictions.eq("movEntidadId", filtro.getMovEntidadId()));
		}
		if (StringUtils.isNotBlank(filtro.getDocAplicaNumeroFormateado()))
			criteria.add(Restrictions.like("docAplicaNumeroFormateado", "%"+filtro.getDocAplicaNumeroFormateado()+"%"));
		if (StringUtils.isNotBlank(filtro.getMovReferencia()))
			criteria.add(Restrictions.like("movReferencia", "%"+filtro.getMovReferencia()+"%"));
	
		if (filtro.getMovMonedaId() != null && filtro.getMovMonedaId() > 0)
			criteria.add(Restrictions.eq("movMonedaId", filtro.getMovMonedaId()));
		if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaDesde()))
			criteria.add(Restrictions.ge("fechaIngreso", DateUtil.convertStringToDate(filtro.getDocAplicadoFechaDesde())));
		if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaHasta()))
			criteria.add(Restrictions.le("fechaIngreso", DateUtil.convertStringToDate(filtro.getDocAplicadoFechaHasta())));
		
		/* ORDEN */
    	setOrderBy(criteria,"fechaIngreso",true);
  	
	  	/* Obtengo la lista */
	  	List<DocumentoAplicacionMovimiento_V> lista = (List<DocumentoAplicacionMovimiento_V>)criteria.list();
  	
	  	return lista;
  	  
    }

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DocumentoAplicacionMovimiento_V> getAplicacionesByMuestraMonedaEn(FiltroDocAplicacionBean filtro){

		
				StringBuilder queryStr = new StringBuilder();
				/*SELECT*/
				queryStr.append("SELECT da.`Id`, da.`IdDocumento` documentoId , da.`IdAplicacion` aplicacionId , da.`IdAdministracion` administracionId, da.`IdTipoDocumento` tipoDocumentoId, da.`nombreTipoDocumento` tipoDocumentoNombre, da.`NumeroFormateado`, da.`FechaIngreso`, ");
				queryStr.append(" da.`Descripcion`, da.`IdCuenta` cuentaId, da.`cuentaNombre`, da.`IdTipoEntidad` tipoEntidadId, da.`tipoentidadNombre`, da.`IdEntidad` entidadId, da.`entidadNombre`, da.`IdMoneda` monedaId, ");
				queryStr.append(" da.`monedaNombre`, da.`monedaCodigo`, da.`ImporteTotal`, da.`IdDocumentoAplica` docAplicaId, da.`IdAdministracionDocumentoAplicado` docAplicaAdministracionId, da.`IdTipoDocumentoAplicado` docAplicaTipoDocumentoId, ");
				queryStr.append(" da.`nombreTipoDocumentoAplicado` docAplicaTipoDocumentoNombre, da.`NumeroFormateadoAplicacion` docAplicaNumeroFormateado, da.`TotalAplicado` docAplicaTotal, da.`DescripcionAplicacion` docAplicaDescripcion, da.`monedaNombreMov` movMonedaNombre, da.`monedaCodigoMov` movMonedaCodigo, ");
				queryStr.append(" da.`IdMovimiento` movId, da.`IdCuentaMov` movCuentaId, da.`IdTipoEntidadMov` movTipoEntidadId, da.`IdEntidadMov` movEntidadId, da.`IdMonedaMov` movMonedaId, da.`ImporteMov` movImporte, da.`Referencia` movReferencia");
				queryStr.append(", da.cotizacion cotizacion,  dcot.cotizacion movCotizacion ");
				//No estoy usando el campo `CotizacionMov` entonces lo uso para cotizacion Convertir que si lo necesito. En el futuro habrá q crear otra clase q tenga este campo
				//queryStr.append(", da.`CotizacionMov` movCotizacion,  dcot.cotizacion cotizacionConvertir  ");
				/*FROM*/
				queryStr.append("   FROM documentoaplicacionesmovimientos_v da ");
				/*JOIN*/
				queryStr.append(" JOIN documentocotizaciones dcot ON (dcot.fecha = da.fechaingreso AND dcot.IdMoneda = " + filtro.getMonedaMuestraId() + ") ");
				/*WHERE*/
				queryStr.append(" WHERE 1 = 1 ");
				
				if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
					queryStr.append(" AND da.`IdAdministracion` = '"+ filtro.getAdministracionId() + "' ");

//				if (filtro.getDocAplicaTipoDocumentoId() != null && filtro.getDocAplicaTipoDocumentoId() > 0)
//					criteria.add(Restrictions.eq("docAplicaTipoDocumentoId", filtro.getDocAplicaTipoDocumentoId()));
				
				if (filtro.getDocAplicaTipoDocumentoId() != null && filtro.getDocAplicaTipoDocumentoId() > 0)
					queryStr.append(" AND da.`IdTipoDocumentoAplicado` = '"+ filtro.getDocAplicaTipoDocumentoId() + "' ");
				
				if (filtro.getDocAplicaCuentaId() != null && filtro.getDocAplicaCuentaId() > 0)
					queryStr.append(" AND da.`IdCuenta` = '"+ filtro.getDocAplicaCuentaId() + "' ");

				if (filtro.getDocAplicaTipoEntidadId() != null && filtro.getDocAplicaTipoEntidadId() > 0)
					queryStr.append(" AND da.`IdTipoEntidad` = '"+ filtro.getDocAplicaTipoEntidadId() + "' ");
					
				if (filtro.getDocAplicaEntidadId() != null && filtro.getDocAplicaEntidadId() > 0){
					queryStr.append(" AND da.`IdEntidad` = '"+ filtro.getDocAplicaEntidadId() + "' ");
				}
				
				if (filtro.getMovCuentaId() != null && filtro.getMovCuentaId() > 0)
					queryStr.append(" AND da.`IdCuentaMov` = '"+ filtro.getMovCuentaId() + "' ");
					
				if (filtro.getMovTipoEntidadId() != null && filtro.getMovTipoEntidadId() > 0)
					queryStr.append(" AND da.`IdTipoEntidadMov` = '"+ filtro.getMovTipoEntidadId() + "' ");

				if (filtro.getMovEntidadId() != null && filtro.getMovEntidadId() > 0){
					queryStr.append(" AND da.`IdEntidadMov` = '"+ filtro.getMovEntidadId() + "' ");
				
				}
				if (StringUtils.isNotBlank(filtro.getDocAplicaNumeroFormateado()))
					queryStr.append(" AND da.`NumeroFormateadoAplicacion` like '%"+ filtro.getDocAplicaNumeroFormateado() + "%' ");

				if (StringUtils.isNotBlank(filtro.getMovReferencia()))
					queryStr.append(" AND da.`Referencia` like '%"+ filtro.getMovReferencia() + "%' ");
			
				if (filtro.getMovMonedaId() != null && filtro.getMovMonedaId() > 0)
					queryStr.append(" AND da.`IdMonedaMov` = '"+ filtro.getMovMonedaId() + "' ");

				if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaDesde()))
					queryStr.append(" AND da.`FechaIngreso` >=  :fecha1 ");

				if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaHasta()))
					queryStr.append(" AND da.`FechaIngreso` <=  :fecha2 ");
				
				/*WHERE*/
				queryStr.append(" ORDER BY `da`.`FechaIngreso` asc ");
				
				Query query = getSession().createSQLQuery(queryStr.toString())
						.addScalar("aplicacionId")
						.addScalar("documentoId") 
						.addScalar("administracionId") 
						.addScalar("tipoDocumentoId" )
						.addScalar("tipoDocumentoNombre") 
						.addScalar("NumeroFormateado" )
						.addScalar("FechaIngreso" ,Hibernate.DATE)
						.addScalar("Descripcion" )
						.addScalar("cuentaId" )
						.addScalar("cuentaNombre" )
						.addScalar("tipoEntidadId" )
						.addScalar("tipoentidadNombre") 
						.addScalar("entidadId" )
						.addScalar("entidadNombre") 
						.addScalar("monedaId", Hibernate.INTEGER)
						.addScalar("monedaNombre",Hibernate.STRING )
						.addScalar("monedaCodigo" ,Hibernate.STRING )
						.addScalar("Cotizacion",Hibernate.DOUBLE )
						.addScalar("ImporteTotal",Hibernate.DOUBLE) 
						.addScalar("docAplicaId") 
						.addScalar("docAplicaAdministracionId") 
						.addScalar("docAplicaTipoDocumentoId" )
						.addScalar("docAplicaTipoDocumentoNombre") 
						.addScalar("docAplicaNumeroFormateado" )
						.addScalar("docAplicaTotal",Hibernate.DOUBLE )
						.addScalar("docAplicaDescripcion") 
						.addScalar("movMonedaNombre" )
						.addScalar("movMonedaCodigo" )
						.addScalar("movId" )
						.addScalar("movCuentaId" )
						.addScalar("movTipoEntidadId") 
						.addScalar("movEntidadId" )
						.addScalar("movMonedaId" )
						.addScalar("movImporte",Hibernate.DOUBLE )
						.addScalar("movCotizacion",Hibernate.DOUBLE) 
						.addScalar("movReferencia")
						.setResultTransformer( Transformers.aliasToBean(DocumentoAplicacionMovimiento_V.class));

					if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaDesde()))
						query.setDate("fecha1", DateUtil.convertStringToDate(filtro.getDocAplicadoFechaDesde()));

					if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaHasta()))
						query.setDate("fecha2", DateUtil.convertStringToDate(filtro.getDocAplicadoFechaHasta()));
					
						
				List<DocumentoAplicacionMovimiento_V> result = query.list();
				
				return result;
    }
	
}
