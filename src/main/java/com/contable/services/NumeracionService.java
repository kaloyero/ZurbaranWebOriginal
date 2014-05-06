package com.contable.services;

import com.contable.common.AbstractService;
import com.contable.common.beans.NumeroBean;
import com.contable.hibernate.model.Numeracion;

public interface NumeracionService extends AbstractService<Numeracion>{

	public Integer getUltimoNumero(Integer idAdministracion, Integer idTipoDocumento,String letra,Integer establecimiento,Integer numAnio,Integer numMes,Integer numDia);

	public void actualizarNumeracion(Integer idAdministracion,Integer idTipoDocumento, NumeroBean num);
	
}
