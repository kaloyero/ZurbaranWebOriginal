package com.contable.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;
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

	@Transactional
	public E findById(int id) {
		E dto = getDao().findById(id);
		return dto;
	}
	
	@Transactional
	public List<E> listAll() {
		List<E> list = new ArrayList<E>();
		list = getDao().findAll(false);
		return list;
	}

	@Transactional
	public List<E> listPaginByFilter(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc){
		List<E> list = new ArrayList<E>();
		
		list = getDao().listByPropertiesPagin(pagIni, qtRows, properties, searchText, orderByProperty, asc);
		return list;
	}
	
	public List<ConfigBean> getConfigNameList(){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = getDao().findComboListByFilter(Constants.FIELD_NAME, Constants.FIELD_ACTIVE,null , Constants.BD_ACTIVO, true);
		
		return list;
	}

	public List<ConfigBean> getConfigNameListByAdm(int idAdministracion){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = getDao().findComboListByFilter(Constants.FIELD_NAME, Constants.FIELD_ACTIVE, idAdministracion,Constants.BD_ACTIVO, true);
		
		return list;
	}

}
