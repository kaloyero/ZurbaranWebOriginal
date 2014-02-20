package com.contable.common;

import java.util.ArrayList;
import java.util.List;

public abstract class ConfigurationManagerImpl<E,F> extends AbstractManagerImpl<E,F> implements ConfigurationManager<E,F> { 

	public List<E> getConfigNameList(){
		List<E> list = new ArrayList<E>();
		list = getRelatedService().getConfigNameList();
		return list;
	}

}
