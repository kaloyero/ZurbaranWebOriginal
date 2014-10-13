package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
			criteria.add(Restrictions.like("", "%"+filtro.getMovReferencia()+"%"));
	
		if (filtro.getMovMonedaId() != null && filtro.getMovMonedaId() > 0)
			criteria.add(Restrictions.eq("movMonedaId", filtro.getMovMonedaId()));
		if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaDesde()))
			criteria.add(Restrictions.ge("fechaIngreso", DateUtil.convertStringToDate(filtro.getDocAplicadoFechaDesde())));
		if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaHasta()))
			criteria.add(Restrictions.le("fechaIngreso", DateUtil.convertStringToDate(filtro.getDocAplicadoFechaHasta())));
		
		/* ORDEN */
    	setOrderBy(criteria,"id",true);
  	
	  	/* Obtengo la lista */
	  	List<DocumentoAplicacionMovimiento_V> lista = (List<DocumentoAplicacionMovimiento_V>)criteria.list();
  	
	  	return lista;
  	  
    }
	
}