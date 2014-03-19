package com.contable.common;

import java.util.List;

import com.contable.common.beans.ConfigBean;

public interface ConfigurationManager<E,F> extends AbstractManager<E,F>{
	
	List<ConfigBean> getConfigNameList();
	
	List<ConfigBean> getConfigNameListByAdm(int idAdministracion);
	
	void deleteConfigRow(int id);

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
	
}
