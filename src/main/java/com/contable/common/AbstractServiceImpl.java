package com.contable.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.constants.Constants;

public abstract class AbstractServiceImpl<E> implements AbstractService<E> { 
	
	protected abstract GenericDao<E, ?> getDao();
	
	@Transactional
	public void save(E dto) {
		getDao().save(dto);
	}

	@Transactional
	public void update(E dto) {
		getDao().update(dto);
	}	

	
	@Transactional
	public void delete(E persistentObject) {
		getDao().delete(persistentObject);
    }

//	@Transactional
//	public E findById(PK id) {
//		E dto = getDao().findById(id);
//		return dto;
//	}
	
	@Transactional
	public List<E> listAll() {
		List<E> list = new ArrayList<E>();
		list = getDao().findAll(false);
		return list;
	}


	public List<E> getConfigNameList(){
		List<E> list = new ArrayList<E>();
		list = getDao().findComboListByFilter(Constants.FIELD_NAME, Constants.FIELD_ACTIVE, Constants.TRUE, true);
		return list;
	}

}
