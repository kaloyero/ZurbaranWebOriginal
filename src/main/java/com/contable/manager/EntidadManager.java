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
	 * Si se desea que no agregue NINGUN campo extra enviar Constants.CAMPO_EXTRA_NINGUNO
	 * 
	 * @param idTipoEntidad
	 * @param extraRow
	 * @return
	 */
	public List<ConfigBean> getConfigEntidadesListByTipoEntidad(Integer idTipoEntidad, String extraRow);
	
	
	/**
	 * Devuelve un listado de entidades según el tipo de entidad (form).
	 * - Si el tipo de entidad es nulo devuelve una lista vacía
	 * - Valida que el Tipo de Entidad sea ACTIVO
	 * 
	 * Si se desea que no agregue NINGUN campo extra enviar Constants.CAMPO_EXTRA_NINGUNO
	 * 
	 * @param form Tipo entidad
	 * @param extraRow
	 * @return
	 */
	public List<ConfigBean> getEntidadesByTipoEntidadForm (TipoEntidadForm form , String extraRow);
	

}
