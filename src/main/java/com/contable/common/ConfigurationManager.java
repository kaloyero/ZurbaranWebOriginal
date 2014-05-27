package com.contable.common;

import java.util.List;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.constants.Constants;

public interface ConfigurationManager<E,F> extends AbstractManager<E,F>{
	
	public static final String CAMPO_NINGUNO = Constants.CAMPO_EXTRA_NINGUNO;
	
	public static final String CAMPO_TODAS = Constants.CAMPO_EXTRA_TODAS;
	
	public static final String CAMPO_BLANCO = Constants.CAMPO_EXTRA_BLANCO;
	
	/**
	 * Devuelve los listados de con el Id y el nombre. 
	 * 
	 * @return
	 */
	List<ConfigBean> getConfigNameList();

	/**
	 * Devuelve los listados de con el Id y el nombre.
	 * El campo extraRow sirve para agregarle un item al proncipio del listado 
	 * 
	 * @param extraRow / Si es CAMPO_NINGUNO no agrega nada 
	 * @return
	 */
	List<ConfigBean> getConfigNameList(String extraRow);

	/**
	 * Devuelve los listados de con el Id y el nombre filtrando por la Administracion.
	 * 
	 * @param idAdministracion
	 * @return
	 */
	List<ConfigBean> getConfigNameListByAdm(int idAdministracion);
	
	/**
	 * Devuelve los listados de con el Id y el nombre filtrando por la Administracion.
	 * El campo extraRow sirve para agregarle un item al proncipio del listado
	 * 
	 * @param idAdministracion
	 * @param extraRow / Si es CAMPO_NINGUNO no agrega nada
	 * @return
	 */
	List<ConfigBean> getConfigNameListByAdm(int idAdministracion,String extraRow);
	
	/**
	 * Activa o Desactiva el estado de la Entidad
	 * 
	 *  Si el estado es Activo lo desactiva, y si esta Desactivo lo activa
	 * 
	 * @param id
	 */
	void toggleStatus(int id);
	
	void activeStatus(int id);

	void desactiveStatus(int id);

	public ErrorRespuestaBean eliminarConfiguracionById(int id);
}
