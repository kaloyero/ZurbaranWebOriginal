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
	public Integer save(E dto) {
		return (Integer) getDao().save(dto);
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
		list = getDao().findComboListByFilter(Constants.FIELD_NAME, Constants.FIELD_ACTIVE,"",null , Constants.BD_ACTIVO, true);
		
		return list;
	}

	public List<ConfigBean> getConfigNameListByAdm(int idAdministracion){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = getDao().findComboListByFilter(Constants.FIELD_NAME, Constants.FIELD_ACTIVE, "administracion.id",idAdministracion,Constants.BD_ACTIVO, true);
		
		return list;
	}

	public void deleteConfigRow(int id){
        try {                   
        	E obj = findById(id);
            delete(obj);                        
        }                                          
        catch (Exception e) {          
            System.out.println("Error al borrar"+ e);
            //Si ocurre algun error al borrar le cambia el estado
            changeValueToStatus(Constants.BD_INACTIVO, id);
        }   		
	}
	

	public void changeToogleStatus(int id){
		
		/*Primero updatea si el campo esta Activo*/
		List<Property> set = new ArrayList<Property>();
		List<Property> where = new ArrayList<Property>();
		set.add(new Property("estado", Property.TYPE_CADENA,Constants.BD_INACTIVO));
		where.add(new Property("id", Property.TYPE_ENTERO,String.valueOf(id)));
		where.add(new Property("estado", Property.TYPE_CADENA,Constants.BD_ACTIVO));
		if (getDao().updateFieldsByWhereClause(set, where) == 0 ){
			/*Si NO esta ACTIVO updetea porque el campo esta INACTIVO*/
			List<Property> set1 = new ArrayList<Property>();
			List<Property> where1 = new ArrayList<Property>();
			set1.add(new Property("estado", Property.TYPE_CADENA,Constants.BD_ACTIVO));
			where1.add(new Property("id", Property.TYPE_ENTERO,String.valueOf(id)));
			where1.add(new Property("estado", Property.TYPE_CADENA,Constants.BD_INACTIVO));

			this.changeValueToStatus(Constants.BD_ACTIVO, id);
		}

	}
	
	public int changeValueToStatus(String estado, int id){
		int affectedRows = 0;
		List<Property> set = new ArrayList<Property>();
		set.add(new Property("estado", Property.TYPE_CADENA,estado));
		List<Property> where = new ArrayList<Property>();
		where.add(new Property("id", Property.TYPE_ENTERO,String.valueOf(id)));
		affectedRows = getDao().updateFieldsByWhereClause(set, where);
		
		return affectedRows;
	}

	
	
}
