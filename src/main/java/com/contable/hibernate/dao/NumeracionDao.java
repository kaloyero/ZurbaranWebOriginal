package com.contable.hibernate.dao;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Numeracion;

public interface NumeracionDao extends GenericDao<Numeracion, Integer> {

	public Integer getUltimoNumero(Integer idAdministracion, Integer idTipoDocumento, String letra, Integer establecimiento, Integer numAnio, Integer numMes,Integer numDia);
	
	public Numeracion getNumeroByFiltros(Integer idAdministracion, Integer idTipoDocumento,  String letra, Integer establecimiento, Integer numAnio, Integer numMes,Integer numDia);

}
