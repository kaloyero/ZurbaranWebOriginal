package com.contable.common;

import java.util.List;


public interface AbstractService<E> {

	void save(E dto);
	
	void update(E dto);
	
	void delete(E  dto);
	
//	E findById(PK id);
//	
	List<E> listAll();

	
}
