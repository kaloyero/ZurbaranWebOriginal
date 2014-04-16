package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.common.beans.Property;
import com.contable.hibernate.dao.Documento_VDao;
import com.contable.hibernate.model.Documento_v;

@Repository("documento_VDao")
public class Documento_VDaoImpl extends GenericDaoImpl<Documento_v, Integer> implements Documento_VDao{

	@Override
	protected Class<Documento_v> getEntityClass() {
		return Documento_v.class;
	}

	@SuppressWarnings("unchecked")
	public List<Documento_v> buscarEnDocumentosByFiltros(FiltroDocumentoBean filtro, String campoOrder, boolean orderByAsc){
		
		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		if (filtro.getTipoDocumentoId() != null && filtro.getTipoDocumentoId() > 0)
			criteria.add(Restrictions.eq("idTipoDocumento", filtro.getTipoDocumentoId()));
		if (filtro.getNumero() != null && filtro.getNumero() != 0)
			criteria.add(Restrictions.eq("Numero", filtro.getNumero()));
		if (filtro.getNumeroAnio() != null && filtro.getNumeroAnio() != 0)
			criteria.add(Restrictions.eq("NumeroAnio", filtro.getNumeroAnio()));
		if (filtro.getNumeroMes() != null && filtro.getNumeroMes() != 0)
			criteria.add(Restrictions.eq("NumeroMes", filtro.getNumeroMes()));
		if (filtro.getNumeroDia() != null && filtro.getNumeroDia() != 0)	
			criteria.add(Restrictions.eq("NumeroDia", filtro.getNumeroDia()));
		if (filtro.getNumeroEstablecimiento() != null && filtro.getNumeroEstablecimiento() != 0)
			criteria.add(Restrictions.eq("NumeroEstablecimiento", filtro.getNumeroEstablecimiento()));
		if ( filtro.getNumeroLetra() != null && StringUtils.isNotBlank(filtro.getNumeroLetra()) )
			criteria.add(Restrictions.like("NumeroLetra", filtro.getNumeroLetra()).ignoreCase());
		if ( filtro.getTipoMovimiento() != null && StringUtils.isNotBlank(filtro.getTipoMovimiento()) )
			criteria.add(Restrictions.like("TipoMovimiento", filtro.getTipoMovimiento()).ignoreCase());
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			criteria.add(Restrictions.eq("AdministracionId", filtro.getAdministracionId()));
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			criteria.add(Restrictions.eq("EntidadId", filtro.getEntidadId()));
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			criteria.add(Restrictions.eq("CuentaId", filtro.getCuentaId()));
		if (filtro.getPeriodoId() != null && filtro.getPeriodoId() > 0)
			criteria.add(Restrictions.eq("PeriodoId", filtro.getPeriodoId()));
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			criteria.add(Restrictions.eq("TipoEntidadId", filtro.getTipoEntidadId()));
		if (filtro.getFechaIngreso() != null)
			criteria.add(Restrictions.eq("FechaIngreso", filtro.getFechaIngreso()));
		if (filtro.getFechaVencimiento() != null)
			criteria.add(Restrictions.eq("FechaVencimiento", filtro.getFechaVencimiento()));
		if (filtro.getImporteTotalDesde() != null && filtro.getImporteTotalHasta() != null) {
			criteria.add(Restrictions.between("ImporteTotal", filtro.getImporteTotalDesde(), filtro.getImporteTotalHasta()));
		} else if (filtro.getImporteTotalDesde() != null ){
			criteria.add(Restrictions.ge("ImporteTotal", filtro.getImporteTotalDesde()));
		} else if (filtro.getImporteTotalHasta() != null ){
			criteria.add(Restrictions.le("ImporteTotal", filtro.getImporteTotalHasta()));
		}

    	/* Agrega el orden */
       	setOrderBy(criteria,campoOrder,orderByAsc);
       	
       	List<Documento_v> list = criteria.list();
		
		return list;
	}

}
