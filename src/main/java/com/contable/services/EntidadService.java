package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.hibernate.model.Entidad;

public interface EntidadService extends AbstractService<Entidad>{

	/**
	 * Devuelve las entidades (id + nombre) filtrando por el TIPO de ENTIDAD
	 * 
	 * @param idTipoEntidad
	 * @return
	 */
	public List<ConfigBean> getConfigEntidadesListByTipoEntidad(int idTipoEntidad);
	
}