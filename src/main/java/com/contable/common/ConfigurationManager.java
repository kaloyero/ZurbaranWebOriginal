package com.contable.common;

import java.util.List;

public interface ConfigurationManager<E,F> extends AbstractManager<E,F>{
	
	List<E> getConfigNameList();
	
}
