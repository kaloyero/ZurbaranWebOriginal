package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.common.beans.NumeroBean;
import com.contable.common.utils.DateUtil;
import com.contable.hibernate.dao.Documento_VDao;
import com.contable.hibernate.model.Documento_v;

@Repository("documento_VDao")
public class Documento_VDaoImpl extends GenericDaoImpl<Documento_v, Integer> implements Documento_VDao{

	@Override
	protected Class<Documento_v> getEntityClass() {
		return Documento_v.class;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Documento_v> buscarEnDocumentosByFiltros(FiltroDocumentoBean filtro, String campoOrder, boolean orderByAsc){
		
		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			criteria.add(Restrictions.eq("administracionId", filtro.getAdministracionId()));
		if (filtro.getTipoDocumentoId() != null && filtro.getTipoDocumentoId() > 0)
			criteria.add(Restrictions.eq("idTipoDocumento", filtro.getTipoDocumentoId()));
		if (filtro.getEntidadId() != null && filtro.getEntidadId() > 0)
			criteria.add(Restrictions.eq("entidad", filtro.getEntidadId()));
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			criteria.add(Restrictions.eq("cuentaId", filtro.getCuentaId()));
		if (filtro.getMonedaId() != null && filtro.getMonedaId() != 0)
			criteria.add(Restrictions.eq("moneda", filtro.getMonedaId()));
		
		//FILTRO FECHA
		if (filtro.getTipoFecha() != null){
			String tipoFecha = "fechaIngreso";
			if (filtro.getTipoFecha())
				tipoFecha = "fechaVencimiento";
			if (StringUtils.isNotBlank(filtro.getFechaDesde()))
				criteria.add(Restrictions.ge(tipoFecha, DateUtil.convertStringToDate(filtro.getFechaDesde())));
			if (StringUtils.isNotBlank(filtro.getFechaHasta()))
				criteria.add(Restrictions.le(tipoFecha, DateUtil.convertStringToDate(filtro.getFechaHasta())));
		}
		
    	/* Agrega el orden */
       	setOrderBy(criteria,campoOrder,orderByAsc);
       	
       	List<Documento_v> list = criteria.list();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Documento_v> verificarExisteDocumento(Integer idAdministracion,Integer idTipoDocumento, boolean entidad,Integer idTipoEntidad,Integer idEntidad, NumeroBean num){
		Criteria criteria = getSession().createCriteria(getEntityClass());

		criteria.add(Restrictions.eq("administracionId", idAdministracion));
		criteria.add(Restrictions.eq("idTipoDocumento", idTipoDocumento));
		//Poene este filtro para que en caso que el documento este duplicado no importe
		criteria.add(Restrictions.isNull("idDocumentoAnuladoPor"));
		
		//Si se quiere validar por entidad
		if (entidad){
			criteria.add(Restrictions.eq("entidad", idEntidad));
			criteria.add(Restrictions.eq("tipoEntidadId", idTipoEntidad));
		}
		
		//NUMERO
		if (StringUtils.isNotBlank(num.getNumero()))
			criteria.add(Restrictions.eq("numero", Integer.valueOf(num.getNumero())));
		else
			criteria.add(Restrictions.isNull("numero"));
		//NUMERO ANIO
		if (StringUtils.isNotBlank(num.getNumeroAnio()))
			criteria.add(Restrictions.eq("numeroAnio", Integer.valueOf(num.getNumeroAnio())));
		else
			criteria.add(Restrictions.isNull("numeroAnio"));
		//NuMERO MES
		if (StringUtils.isNotBlank(num.getNumeroMes()))
			criteria.add(Restrictions.eq("numeroMes", Integer.valueOf(num.getNumeroMes())));
		else
			criteria.add(Restrictions.isNull("numeroMes"));
		//NUMERO DIA
		if (StringUtils.isNotBlank(num.getNumeroDia()))
			criteria.add(Restrictions.eq("numeroDia", Integer.valueOf(num.getNumeroDia())));
		else
			criteria.add(Restrictions.isNull("numeroDia"));
		//NUMERO ESTABLECIMIENTO
		if (StringUtils.isNotBlank(num.getNumeroEstablecimiento()))
			criteria.add(Restrictions.eq("numeroEstablecimiento", Integer.valueOf(num.getNumeroEstablecimiento())));
		else
			criteria.add(Restrictions.isNull("numeroEstablecimiento"));
		//NuMERO LETRA
		if (StringUtils.isNotBlank(num.getNumeroLetra()))
			criteria.add(Restrictions.like("numeroLetra", num.getNumeroLetra()));
		else
			criteria.add(Restrictions.isNull("numeroLetra"));
       	
       	List<Documento_v> list = criteria.list();
		
		return list;		
		
	}
	
}
