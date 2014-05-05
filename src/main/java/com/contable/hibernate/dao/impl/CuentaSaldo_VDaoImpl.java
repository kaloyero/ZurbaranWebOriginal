package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

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

	@SuppressWarnings("unchecked")
	public List<CuentaSaldo_V> buscarEnValoresPropiosByFiltros(	FiltroCuentaBean filtro, String campoOrder, boolean orderByAsc) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
//		if (filtro.getAdministracionId() != null )
//			criteria.add(Restrictions.eq("administracionId", filtro.getAdministracionId()));
		
//		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
//			criteria.add(Restrictions.eq("cuentaId", filtro.getCuentaId()));
//		if (filtro.getCuentaEmisionId() != null && filtro.getCuentaEmisionId() > 0)
//		criteria.add(Restrictions.eq("cuentaEmisionId", filtro.getCuentaEmisionId()));
//		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
//			criteria.add(Restrictions.eq("tipoEntidadId", filtro.getTipoEntidadId()));
//		if (filtro.getTipoEntidadEmisionId() != null && filtro.getTipoEntidadEmisionId() > 0)
//		criteria.add(Restrictions.eq("tipoEntidadEmisionId", filtro.getTipoEntidadEmisionId()));
//		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
//			criteria.add(Restrictions.eq("entidadId", filtro.getEntidadId()));
//		if (filtro.getEntidadEmisionId() != null && filtro.getEntidadEmisionId() > 0)
//		criteria.add(Restrictions.eq("entidadEmisionId", filtro.getEntidadEmisionId()));
//		if (filtro.getImporteDesde() != null && filtro.getImporteHasta() != null) {
//			criteria.add(Restrictions.between("importe", filtro.getImporteDesde(), filtro.getImporteHasta()));
//		} else if (filtro.getImporteDesde() != null ){
//			criteria.add(Restrictions.ge("importe", filtro.getImporteDesde()));
//		} else if (filtro.getImporteHasta() != null ){
//			criteria.add(Restrictions.le("importe", filtro.getImporteHasta()));
//		}
//		if (filtro.getFechaEmisionDesde() != null)
//			criteria.add(Restrictions.ge("fechaVencimiento", filtro.getFechaEmisionDesde()));
//		if (filtro.getFechaEmisionHasta() != null)
//			criteria.add(Restrictions.le("fechaVencimiento", filtro.getFechaEmisionDesde()));

    	/* Agrega el orden */
       	setOrderBy(criteria,campoOrder,orderByAsc);
       	
       	List<CuentaSaldo_V> list = criteria.list();
		
		return list;
	
	}

}
