package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.dao.DocumentoValorPropioDao;
import com.contable.hibernate.model.DocumentoValorPropio;

@Repository("documentoValorPropioDao")
public class DocumentoValorPropioDaoImpl extends GenericDaoImpl<DocumentoValorPropio, Integer> implements DocumentoValorPropioDao{

	@Override
	protected Class<DocumentoValorPropio> getEntityClass() {
		return DocumentoValorPropio.class;
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoValorPropio> buscarEnValoresPropiosByFiltros(
			FiltroValPropiosBean filtro, String campoOrder, boolean orderByAsc) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
//		if (filtro.getAdministracionId() != null )
//			criteria.add(Restrictions.eq("administracionId", filtro.getAdministracionId()));
		if (filtro.getChequeraId() != null && filtro.getChequeraId() > 0)
			criteria.add(Restrictions.eq("chequera", filtro.getChequeraId()));
		if (StringUtils.isNotBlank(filtro.getBeneficiario()))
			criteria.add(Restrictions.eq("beneficiario", filtro.getChequeraId()));
		
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
		if (filtro.getFechaVtoDesde() != null)
			criteria.add(Restrictions.ge("fechaVencimiento", filtro.getFechaVtoDesde()));
		if (filtro.getFechaVtoHasta() != null)
			criteria.add(Restrictions.le("fechaVencimiento", filtro.getFechaVtoDesde()));

		if (filtro.getNumero() != null && filtro.getNumero() != 0)
			criteria.add(Restrictions.eq("numero", filtro.getNumero()));
		
		
    	/* Agrega el orden */
       	setOrderBy(criteria,campoOrder,orderByAsc);
       	
       	List<DocumentoValorPropio> list = criteria.list();
		
		return list;
	
	}

}
