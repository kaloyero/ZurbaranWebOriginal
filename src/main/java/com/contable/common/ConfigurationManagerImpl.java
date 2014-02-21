package com.contable.common;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.ConfigBean;

public abstract class ConfigurationManagerImpl<E,F> extends AbstractManagerImpl<E,F> implements ConfigurationManager<E,F> { 

	public List<ConfigBean> getConfigNameList(){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = getRelatedService().getConfigNameList();
		return list;
	}

}
