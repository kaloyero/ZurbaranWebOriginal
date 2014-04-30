package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.form.EstructuraContenidoForm;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Estructura;

public interface EstructuraManager extends ConfigurationManager<Estructura,EstructuraForm>{

	/**
	 * Guarda contenidos
	 * 
	 * @param form
	 */
	public void guardarNuevoContenido(EstructuraContenidoForm form);

	/**
	 * Listado de Contenidos (configBean)
	 * 
	 * @param idAdministracion
	 * @param extraRow
	 * @return
	 */
	public List<ConfigBean> getContenidosConfig(Integer idAdministracion, String extraRow);
	
	/**
	 * Listado de Contenidos
	 * 
	 * @param extraField
	 * @return
	 */
	public List<EstructuraContenidoForm> getContenidos();
}
