package com.contable.common.beans;

import java.util.ArrayList;
import java.util.List;

public abstract class MapperImpl<E,F> implements Mapper<E,F>{

	
	public List<F> getFormList(List<E> list) {
		List<F> formList = new ArrayList<F>();
		
		for (E ent : list) {
			formList.add((F)getForm(ent));
		}
	
		return formList;
	}

	public List<E> getEntidadList(List<F> list) {
		List<E> entityList = new ArrayList<E>();
		
		for (F form : list) {
			entityList.add((E)getEntidad(form));
		}
	
		return entityList;
	}

}