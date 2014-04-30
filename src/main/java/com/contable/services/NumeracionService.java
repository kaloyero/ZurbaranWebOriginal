package com.contable.services;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Numeracion;

public interface NumeracionService extends AbstractService<Numeracion>{

	public Integer getUltimoNumero(Integer idTipoDocumento,Integer numAnio,Integer numMes,Integer numDia);

}
