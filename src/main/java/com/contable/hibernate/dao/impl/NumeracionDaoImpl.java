package com.contable.hibernate.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.NumeracionDao;
import com.contable.hibernate.model.Numeracion;

@Repository("numeracionDao")
public class NumeracionDaoImpl extends GenericDaoImpl<Numeracion, Integer> implements NumeracionDao{

	@Override
	protected Class<Numeracion> getEntityClass() {
		return Numeracion.class;
	}
	
	@Transactional
	public Integer getUltimoNumero(Integer idAdministracion, Integer idTipoDocumento, String letra, Integer establecimiento, Integer numAnio, Integer numMes,
			Integer numDia) {
	
       Numeracion num =  getNumeroByFiltros(idAdministracion, idTipoDocumento,letra, establecimiento, numAnio, numMes, numDia);
       //Si no encuentra es porque para esa Administracion y Tipo de documento no hay numeración
       Integer ultimoNumero = 0;
       if (num != null){
    	   ultimoNumero = num.getUltimoNumero();
       }
    	   
	   return ultimoNumero;
	}

	public Numeracion getNumeroByFiltros(Integer idAdministracion, Integer idTipoDocumento,  String letra, Integer establecimiento, Integer numAnio, Integer numMes,Integer numDia) {

 	   Criteria criteria = getSession().createCriteria(getEntityClass());
       
 	   criteria.add(Restrictions.eq("tipoDocumentoId", idTipoDocumento));
 	   criteria.add(Restrictions.eq("administracionId", idAdministracion));
 	   	if (StringUtils.isNotBlank(letra)){
 		  criteria.add(Restrictions.like("numeroLetra", letra));   
 	   	} else {
 		  criteria.add(Restrictions.isNull("numeroLetra"));
 	   	}
 	   	if (establecimiento != null && establecimiento > 0){
 	   		criteria.add(Restrictions.eq("numeroEstablecimiento", establecimiento));   
 	   	} else {
 	   		criteria.add(Restrictions.isNull("numeroEstablecimiento"));
 	   	}
		if (numAnio != null && numAnio > 0){
			criteria.add(Restrictions.eq("numeroAnio", numAnio));
 	   	} else {
 	   		criteria.add(Restrictions.isNull("numeroAnio"));
 	   	}
		if (numMes != null && numMes > 0){
			criteria.add(Restrictions.eq("numeroMes", numMes));
 	   	} else {
 	   		criteria.add(Restrictions.isNull("numeroMes"));
 	   	}
		if (numDia != null && numDia > 0){
			criteria.add(Restrictions.eq("numeroDia", numDia));
 	   	} else {
 	   		criteria.add(Restrictions.isNull("numeroDia"));
 	   	}
       
       return  (Numeracion) criteria.uniqueResult();

	}

}
