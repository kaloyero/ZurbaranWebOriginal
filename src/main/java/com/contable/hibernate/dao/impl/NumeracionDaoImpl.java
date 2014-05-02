package com.contable.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.NumeracionDao;
import com.contable.hibernate.model.Numeracion;

@Repository("numeracionDao")
public class NumeracionDaoImpl extends GenericDaoImpl<Numeracion, Integer> implements NumeracionDao{

	@Override
	protected Class<Numeracion> getEntityClass() {
		return Numeracion.class;
	}

	public Integer getUltimoNumero(Integer idAdministracion, Integer idTipoDocumento, Integer numAnio, Integer numMes,
			Integer numDia) {

       Numeracion num =  getNumeroByFiltros(idAdministracion, idTipoDocumento, numAnio, numMes, numDia);
       //Si no encuentra es porque para esa Administracion y Tipo de documento no hay numeración
       Integer ultimoNumero = 0;
       if (num != null){
    	   ultimoNumero = num.getUltimoNumero();
       }
    	   
	   return ultimoNumero;
	}

	public Numeracion getNumeroByFiltros(Integer idAdministracion, Integer idTipoDocumento, Integer numAnio, Integer numMes,Integer numDia) {

 	   Criteria criteria = getSession().createCriteria(getEntityClass());
       
 	   criteria.add(Restrictions.eq("tipoDocumentoId", idTipoDocumento));
 	   criteria.add(Restrictions.eq("administracionId", idAdministracion));
 	   criteria.add(Restrictions.eq("numeroAnio", numAnio));
 	   criteria.add(Restrictions.eq("numeroMes", numMes));
 	   criteria.add(Restrictions.eq("numeroDia", numDia));
 	 
       
       return  (Numeracion) criteria.uniqueResult();

	}

}
