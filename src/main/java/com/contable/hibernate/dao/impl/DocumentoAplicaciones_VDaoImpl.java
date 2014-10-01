package com.contable.hibernate.dao.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroDocAplicacionBean;
import com.contable.hibernate.dao.DocumentoAplicaciones_VDao;
import com.contable.hibernate.model.DocumentoAplicaciones_V;

@Repository("documentoAplicaciones_VDao")
public class DocumentoAplicaciones_VDaoImpl extends GenericDaoImpl<DocumentoAplicaciones_V, Integer> implements DocumentoAplicaciones_VDao{

	@Override
	protected Class<DocumentoAplicaciones_V> getEntityClass() {
		return DocumentoAplicaciones_V.class;
	}

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public List<DocumentoAplicaciones_V> listAplicacionesByDocIdsList(Set<Integer> ids){

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
    	/* Agrega los filtros */
		criteria.add(Restrictions.in("documentoId", ids));
  	  
		/* ORDEN */
    	setOrderBy(criteria,"documentoId",true);
  	
	  	/* Obtengo la lista */
	  	List<DocumentoAplicaciones_V> lista = (List<DocumentoAplicaciones_V>)criteria.list();
  	
	  	return lista;
  	  
    }

	@SuppressWarnings("unchecked")
	public List<DocumentoAplicaciones_V> getAplicacionesByFilters(FiltroDocAplicacionBean filtro){

		Criteria criteria = getSession().createCriteria(getEntityClass());

		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			criteria.add(Restrictions.eq("administracionId", filtro.getAdministracionId()));
		if (filtro.getDocAplicadoCuentaId() != null && filtro.getDocAplicadoCuentaId() > 0)
			criteria.add(Restrictions.eq("", filtro.getDocAplicadoCuentaId()));
		if (filtro.getDocAplicadoTipoEntidadId() != null && filtro.getDocAplicadoTipoEntidadId() > 0)
			criteria.add(Restrictions.eq("", filtro.getDocAplicadoTipoEntidadId()));
		if (StringUtils.isNotBlank(filtro.getDocAplicadoEntidadId())){
			String[] entidades = filtro.getDocAplicadoEntidadId().replace("{", "").replace("}", "").split(",");
			criteria.add(Restrictions.in("", entidades));
		}
		if (StringUtils.isNotBlank(filtro.getDocAplicadoNumero()))
			criteria.add(Restrictions.like("numeroFormateadoAplicacion", "%"+filtro.getDocAplicadoNumero()+"%"));
		if (StringUtils.isNotBlank(filtro.getDocAplicadoNumero()))
			criteria.add(Restrictions.like("", "%"+filtro.getDocAplicadoReferencia()+"%"));
	
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			criteria.add(Restrictions.eq("moneda", filtro.getMonedaId()));
		if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaDesde()))
			criteria.add(Restrictions.ge("fechaIngresoDocumentoAplicado", filtro.getDocAplicadoFechaDesde()));
		if (StringUtils.isNotBlank(filtro.getDocAplicadoFechaHasta()))
			criteria.add(Restrictions.le("fechaIngresoDocumentoAplicado", filtro.getDocAplicadoFechaHasta()));
		
		/* ORDEN */
    	setOrderBy(criteria,"id",true);
  	
	  	/* Obtengo la lista */
	  	List<DocumentoAplicaciones_V> lista = (List<DocumentoAplicaciones_V>)criteria.list();
  	
	  	return lista;
  	  
    }
	
	
}
