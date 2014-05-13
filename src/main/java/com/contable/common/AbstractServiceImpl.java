package com.contable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.constants.ConstantsErrors;
import com.contable.common.utils.ConvertionUtil;

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
	public ErrorRespuestaBean delete(E persistentObject) {
		ErrorRespuestaBean respuesta =new ErrorRespuestaBean(true);
		boolean eliminado = getDao().delete(persistentObject);
		if (eliminado == false){
			respuesta.setValido(false);
			respuesta.setCodError(ConstantsErrors.ELIMINAR_COD_1_COD_ERROR);
			respuesta.setError(ConstantsErrors.ELIMINAR_COD_1_ERROR);
		}
		return respuesta;
    }

	@Transactional
	public ErrorRespuestaBean delete(int idDocumento) {
		ErrorRespuestaBean respuesta =new ErrorRespuestaBean(true);
		boolean eliminado = getDao().delete(idDocumento);
		
		if (eliminado == false){
			respuesta.setValido(false);
			respuesta.setCodError(ConstantsErrors.ELIMINAR_COD_1_COD_ERROR);
			respuesta.setError(ConstantsErrors.ELIMINAR_COD_1_ERROR);
		}
		return respuesta;
    }

	

	@Transactional
	public E findById(int id) {
		return getDao().findById(id);
	}
	
	@Transactional
	public List<E> listAll() {
		return getDao().findAll(false);
	}

	@Transactional
	public List<E> listPaginByFilter(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc){
		return getDao().listByPropertiesPagin(pagIni, qtRows, properties, searchText, orderByProperty, asc);
	}
	
	@Transactional
	public Map<String,Integer> listPaginTotalesByFilter(List<Property> properties, String searchText){
		return getDao().listByPropertiesTotals(properties, searchText);
	}

	public List<ConfigBean> getConfigNameList(){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		
		return getDao().findComboListByFilterConfig(Constants.FIELD_NAME,null,null,filtroEstado,"id",true);
	}

	public List<ConfigBean> getConfigNameListByAdm(Integer idAdministracion){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		Property filtroAdm = new Property("administracion.id", null, idAdministracion);
		
		return getDao().findComboListByFilterConfig(Constants.FIELD_NAME,null,filtroAdm,filtroEstado,"id",true);
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
		where.add(new Property("id", Property.TYPE_ENTERO,ConvertionUtil.StrValueOf(id)));
		where.add(new Property("estado", Property.TYPE_CADENA,Constants.BD_ACTIVO));
		if (getDao().updateFieldsByWhereClause(set, where) == 0 ){
			/*Si NO esta ACTIVO updetea porque el campo esta INACTIVO*/
			List<Property> set1 = new ArrayList<Property>();
			List<Property> where1 = new ArrayList<Property>();
			set1.add(new Property("estado", Property.TYPE_CADENA,Constants.BD_ACTIVO));
			where1.add(new Property("id", Property.TYPE_ENTERO,ConvertionUtil.StrValueOf(id)));
			where1.add(new Property("estado", Property.TYPE_CADENA,Constants.BD_INACTIVO));

			this.changeValueToStatus(Constants.BD_ACTIVO, id);
		}

	}
	
	public int changeValueToStatus(String estado, int id){
		int affectedRows = 0;
		List<Property> set = new ArrayList<Property>();
		set.add(new Property("estado", Property.TYPE_CADENA,estado));
		List<Property> where = new ArrayList<Property>();
		where.add(new Property("id", Property.TYPE_ENTERO,ConvertionUtil.StrValueOf(id)));
		affectedRows = getDao().updateFieldsByWhereClause(set, where);
		
		return affectedRows;
	}

	
	
}
