package com.contable.common.beans;

import java.util.List;


public interface Mapper<E,F> {

	public F getForm(E ent);
	
	public E getEntidad(F form);
	
	public List<F> getFormList(List<E> list); 
	
}
