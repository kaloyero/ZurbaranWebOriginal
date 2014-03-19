package com.contable.common;

import java.util.List;

import com.contable.common.beans.ConfigBean;

public interface ConfigurationManager<E,F> extends AbstractManager<E,F>{
	
	List<ConfigBean> getConfigNameList();
	
	List<ConfigBean> getConfigNameListByAdm(int idAdministracion);
	
	void deleteConfigRow(int id);

	void activeStatus(int id);

	void desactiveStatus(int id);
	
}
