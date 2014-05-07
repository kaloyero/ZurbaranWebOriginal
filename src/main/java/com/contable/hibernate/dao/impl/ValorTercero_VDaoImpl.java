package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroValTercerosBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.DateUtil;
import com.contable.hibernate.dao.ValorTercero_VDao;
import com.contable.hibernate.model.ValorTercero_v;

@Repository("valorTerceros_VDao")
public class ValorTercero_VDaoImpl extends GenericDaoImpl<ValorTercero_v, Integer> implements ValorTercero_VDao{

	@Override
	protected Class<ValorTercero_v> getEntityClass() {
		return ValorTercero_v.class;
	}

	@SuppressWarnings("unchecked")
	public List<ValorTercero_v> buscarEnValoresTerceByFiltros(
			FiltroValTercerosBean filtro, String campoOrder, boolean orderByAsc) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		if (filtro.getAdministracionId() != null )
			criteria.add(Restrictions.eq("administracionId", filtro.getAdministracionId()));
		if (filtro.getBancoId() != null && filtro.getBancoId() > 0)
			criteria.add(Restrictions.eq("bancoId", filtro.getBancoId()));
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			criteria.add(Restrictions.eq("cuentaId", filtro.getCuentaId()));
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			criteria.add(Restrictions.eq("tipoEntidadId", filtro.getTipoEntidadId()));
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			criteria.add(Restrictions.eq("entidadId", filtro.getEntidadId()));
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			criteria.add(Restrictions.eq("monedaId", filtro.getMonedaId()));
		
		if (filtro.isEnCartera() )
			criteria.add(Restrictions.eq("tipomovimiento", Constants.TIPODOCUMENTO_VALORTERCE_INGRESO));
		if (filtro.isDepositados())
			criteria.add(Restrictions.eq("tipomovimiento", Constants.TIPODOCUMENTO_VALORTERCE_EGRESO));
		
		if (filtro.getImporteDesde() != null && filtro.getImporteHasta() != null) {
			criteria.add(Restrictions.between("importeValor", filtro.getImporteDesde(), filtro.getImporteHasta()));
		} else if (filtro.getImporteDesde() != null ){
			criteria.add(Restrictions.ge("importeValor", filtro.getImporteDesde()));
		} else if (filtro.getImporteHasta() != null ){
			criteria.add(Restrictions.le("importeValor", filtro.getImporteHasta()));
		}
		if (StringUtils.isNotBlank(filtro.getFechaVencimientoDesde()) )
			criteria.add(Restrictions.ge("fechaVencimiento", DateUtil.convertStringToDate(filtro.getFechaVencimientoDesde())));
		if (StringUtils.isNotBlank(filtro.getFechaVencimientoHasta()) )
			criteria.add(Restrictions.le("fechaVencimiento", DateUtil.convertStringToDate(filtro.getFechaVencimientoHasta())));
		
    	/* Agrega el orden */
       	setOrderBy(criteria,campoOrder,orderByAsc);
       	
       	List<ValorTercero_v> list = criteria.list();
		
		return list;
	}

	
}
