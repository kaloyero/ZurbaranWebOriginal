package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.DateUtil;
import com.contable.hibernate.dao.CuentaResumen_VDao;
import com.contable.hibernate.model.CuentaResumen_V;

@Repository("cuentaResumen_VDao")
public class CuentaResumen_VDaoImpl extends GenericDaoImpl<CuentaResumen_V, Integer> implements CuentaResumen_VDao{

	@Override
	protected Class<CuentaResumen_V> getEntityClass() {
		return CuentaResumen_V.class;
	}

	@SuppressWarnings("unchecked")
	public List<CuentaResumen_V> buscarResumenByFiltros(FiltroCuentaBean filtro, String campoOrder, boolean orderByAsc){

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
		if (filtro.getFechaDesde() != null)
			criteria.add(Restrictions.ge("fechaIngreso", DateUtil.convertStringToDate(filtro.getFechaDesde())));
		if (filtro.getFechaHasta() != null)
			criteria.add(Restrictions.le("fechaIngreso", DateUtil.convertStringToDate(filtro.getFechaHasta())));

    	/* Agrega el orden */
       	setOrderBy(criteria,campoOrder,orderByAsc);
       	
       	List<CuentaResumen_V> list = criteria.list();
		
		return list;
	
	}
	
}
