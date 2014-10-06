package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.common.utils.DateUtil;
import com.contable.hibernate.dao.ValorPropio_VDao;
import com.contable.hibernate.model.ValorPropio_v;

@Repository("valorPropios_VDao")
public class ValorPropio_VDaoImpl extends GenericDaoImpl<ValorPropio_v, Integer> implements ValorPropio_VDao{

	@Override
	protected Class<ValorPropio_v> getEntityClass() {
		return ValorPropio_v.class;
	}
	
	@SuppressWarnings("unchecked")
	public ValorPropio_v getCheque(int chequeraId, int numero) {
		ValorPropio_v cheque = null;
		
		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		criteria.add(Restrictions.eq("chequeraId", chequeraId));
		criteria.add(Restrictions.eq("numero", numero));
		
       	List<ValorPropio_v> list = criteria.list();
       	if (list != null && list.size() > 0){
       		cheque = list.get(0);
       	} 
		
		return cheque;
	
	}


	@SuppressWarnings("unchecked")
	public List<ValorPropio_v> buscarEnValoresPropiosByFiltros(FiltroValPropiosBean filtro, String campoOrder, boolean orderByAsc) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			criteria.add(Restrictions.eq("administracionId", filtro.getAdministracionId()));
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			criteria.add(Restrictions.eq("cuentaId", filtro.getCuentaId()));
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			criteria.add(Restrictions.eq("tipoEntidadId", filtro.getTipoEntidadId()));
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			criteria.add(Restrictions.eq("entidadId", filtro.getEntidadId()));
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			criteria.add(Restrictions.eq("monedaId", filtro.getMonedaId()));
		if (StringUtils.isNotBlank(filtro.getFechaEmisionDesde()))
			criteria.add(Restrictions.ge("fechaIngreso", DateUtil.convertStringToDate(filtro.getFechaEmisionDesde())));
		if (StringUtils.isNotBlank(filtro.getFechaEmisionHasta()))
			criteria.add(Restrictions.le("fechaIngreso", DateUtil.convertStringToDate(filtro.getFechaEmisionHasta())));
		if (StringUtils.isNotBlank(filtro.getFechaVtoDesde()))
			criteria.add(Restrictions.ge("fechaVencimiento", DateUtil.convertStringToDate(filtro.getFechaVtoDesde())));
		if (StringUtils.isNotBlank(filtro.getFechaVtoHasta()))
			criteria.add(Restrictions.le("fechaVencimiento", DateUtil.convertStringToDate(filtro.getFechaVtoHasta())));
		if (filtro.getChequeraId() != null && filtro.getChequeraId() > 0)
			criteria.add(Restrictions.eq("chequeraId", filtro.getChequeraId()));
		if (filtro.getNumero() != null && filtro.getNumero() > 0)
			criteria.add(Restrictions.eq("numero", filtro.getNumero()));
		if (filtro.getTipoDocumentoId() != null && filtro.getTipoDocumentoId() > 0)
			criteria.add(Restrictions.eq("tipoDocumentoId", filtro.getTipoDocumentoId()));
		if (StringUtils.isNotBlank(filtro.getDocumentoFormateado()))
			criteria.add(Restrictions.like("documentoFormateado", "%" + filtro.getDocumentoFormateado()+ "%"));

		
    	/* Agrega el orden */
       	setOrderBy(criteria,campoOrder,orderByAsc);
       	
       	List<ValorPropio_v> list = criteria.list();
		
		return list;
	
	}
	
}
