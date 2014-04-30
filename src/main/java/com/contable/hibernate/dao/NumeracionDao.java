package com.contable.hibernate.dao;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Numeracion;

public interface NumeracionDao extends GenericDao<Numeracion, Integer> {

	public Integer getUltimoNumero(Integer idTipoDocumento,Integer numAnio,Integer numMes,Integer numDia);

}
