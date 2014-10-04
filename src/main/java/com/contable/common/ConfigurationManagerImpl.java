package com.contable.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.constants.Constants;
import com.contable.common.constants.ConstantsErrors;

public abstract class ConfigurationManagerImpl<E,F> extends AbstractManagerImpl<E,F> implements ConfigurationManager<E,F> { 

	public List<ConfigBean> getConfigNameList(){
		return getConfigNameList(CAMPO_NINGUNO);
	}
	
	public List<ConfigBean> getConfigNameList(String extraRow){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = getRelatedService().getConfigNameList();
		//Agrega el campo extra
		agergarExtraRow(list, extraRow);		
		
		return list;
	}

	public List<ConfigBean> getConfigNameListByAdm(int idAdministracion){
			return getConfigNameListByAdm(idAdministracion,CAMPO_NINGUNO);
	}

	public List<ConfigBean> getConfigNameListByAdm(int idAdministracion,String extraRow){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		// Si viene -1 quiere decir que son todos
		if (idAdministracion  == -1 ){
			list = getRelatedService().getConfigNameListByAdm(null);	
		} else {
			list = getRelatedService().getConfigNameListByAdm(idAdministracion);
		}
		//Agrega el campo extra
		agergarExtraRow(list, extraRow);
		
		return list;
	}
	
	protected void agergarExtraRow(List<ConfigBean> lista,String extraRow){
		//Si el campo es NINGUNO no agrega la fila
		if (! extraRow.equals(CAMPO_NINGUNO)){
			ConfigBean bean = new ConfigBean();; 
			bean.setId(-1);
			bean.setNombre(extraRow);
			lista.add(0, bean);
		}
	}
	
	@Transactional
	public void toggleStatus(int id){
		getRelatedService().changeToogleStatus(id);
	}
	
	
	@Transactional
	public void activeStatus(int id){
		getRelatedService().changeValueToStatus(Constants.BD_ACTIVO, id);
	}

	@Transactional
	public void desactiveStatus(int id){
		getRelatedService().changeValueToStatus(Constants.BD_INACTIVO, id);
	}

	public ErrorRespuestaBean eliminarConfiguracionById(int id){
		ErrorRespuestaBean respuesta = new ErrorRespuestaBean(true);
		try {
			/* Valida que la entidad no sea referenciada en otro documento. */
			respuesta = getRelatedService().delete(id);
		} catch (Exception e) {
			//Error el documento ha sido cancelado por otro documento
			respuesta.setValido(false);
			respuesta.setCodError(ConstantsErrors.ELIMINAR_COD_1_COD_ERROR);
			respuesta.setError(ConstantsErrors.ELIMINAR_COD_1_ERROR);
			respuesta.setDescripcion("La entidad que intenta borrar está siendo utilizada. Se deshabilitara.");
			//Desactiva el item seleccionado
			desactiveStatus(id);
		}
		return respuesta;	
	}

}
