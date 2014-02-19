package com.contable.common.beans;

import java.util.List;


public interface Mapper<E> {

	public Form getForm(E ent);
	
	public List<Form> getFormList(List<E> list);
	
	public E setEntidad(Form form); 
	
	
	
}
