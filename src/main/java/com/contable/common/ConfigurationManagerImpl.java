package com.contable.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.ConfigBean;
import com.contable.common.constants.Constants;

public abstract class ConfigurationManagerImpl<E,F> extends AbstractManagerImpl<E,F> implements ConfigurationManager<E,F> { 

	public List<ConfigBean> getConfigNameList(){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = getRelatedService().getConfigNameList();
		return list;
	}

	public List<ConfigBean> getConfigNameListByAdm(int idAdministracion){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = getRelatedService().getConfigNameListByAdm(idAdministracion);
		return list;
	}
	
	@Transactional
	public void deleteConfigRow(int id){
		getRelatedService().deleteConfigRow(id);
	}

	
	@Transactional
	public void toggleStatus(int id){
		getRelatedService().changeToogleStatus(id);
	}
	
	
	@Transactional
	public void activeStatus(int id){
		getRelatedService().changeValueToStatus(Constants.BD_ACTIVO, id);
	}

	@Transactional
	public void desactiveStatus(int id){
		getRelatedService().changeValueToStatus(Constants.BD_INACTIVO, id);
	}

	
}
