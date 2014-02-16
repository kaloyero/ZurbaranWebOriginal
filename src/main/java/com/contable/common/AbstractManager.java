package com.contable.common;

import java.util.List;


public interface AbstractManager<E> {

	void save(E dto);
	
	void update(E dto);
	
	void delete(E  dto);
	
//	E findById(PK id);
//	
	List<E> listAll();

	
}
