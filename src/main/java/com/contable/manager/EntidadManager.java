package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.form.EntidadForm;
import com.contable.form.TipoEntidadForm;
import com.contable.hibernate.model.Entidad;

public interface EntidadManager extends ConfigurationManager<Entidad,EntidadForm>{

	
	/**
	 * Devuelve las entidades (id + nombre) filtrando por el TIPO de ENTIDAD
	 * 
	 * @param idTipoEntidad
	 * @return
	 */
	public List<ConfigBean> getConfigEntidadesListByTipoEntidad(int idTipoEntidad);
	
	
	/**
	 * Devuelve un listado de entidades según el tipo de entidad (form).
	 * - Si el tipo de entidad es nulo devuelve una lista vacía
	 * - Valida que el Tipo de Entidad sea ACTIVO
	 * 
	 * @param form Tipo entidad
	 * @return
	 */
	public List<ConfigBean> getEntidadesByTipoEntidadForm (TipoEntidadForm form );
	

}
