package com.contable.common.utils;

import org.apache.commons.lang.StringUtils;

import com.contable.common.constants.Constants;

public class MapperUtil {

	/**
	 * Este metodo devolvera UI_ACTIVO o UI_INACTIVO, segun reciba BD_ACTIVO o BD_INACTIVO de la base de datos 
	 * 
	 * @param value
	 * @return
	 */
	public static String getStatusToForm(String valueEntity) {
		if (StringUtils.isNotBlank(valueEntity) ){
			if (Constants.BD_ACTIVO.equals(valueEntity)){
				return	Constants.UI_ACTIVO;	
			} else {
				return  Constants.UI_INACTIVO;
			}
		} else { 
			return "";
		}			
	}    

	/**
	 * Este metodo devolvera BD_ACTIVO o BD_INACTIVO, segun reciba UI_INACTIVO o UI_INACTIVO de la vista
	 * 
	 * @param value
	 * @return
	 */
	public static String getStatusToEntity(String valueForm) {
		if (StringUtils.isNotBlank(valueForm) ){
			if (Constants.UI_ACTIVO.equals(valueForm)){
				return	Constants.BD_ACTIVO;	
			} else {
				return  Constants.BD_INACTIVO;
			}
		} else {
			return "";
		}
	}    

	/**
	 * Este metodo devolverá UI_DEUDOR o UI_ACREEDOR, segun reciba BD_DEUDOR o BD_ACREEDOR de la base de datos 
	 * 
	 * @param value
	 * @return
	 */
	public static String getSaldoToForm(String valueEntity) {
		if (StringUtils.isNotBlank(valueEntity) ){
			if (Constants.BD_ACREEDOR.equals(valueEntity)){
				return	Constants.UI_ACREEDOR;	
			} else {
				return  Constants.UI_DEUDOR;
			}
		} else { 
			return "";
		}			
	}    

	/**
	 * Este metodo devolvera BD_DEUDOR o BD_ACREEDOR, segun reciba UI_DEUDOR o UI_ACREEDOR de la vista 
	 * 
	 * @param value
	 * @return
	 */
	public static String getSaldoToEntity(String valueForm) {
		if (StringUtils.isNotBlank(valueForm) ){
			if (Constants.UI_ACREEDOR.equals(valueForm)){
				return	Constants.BD_ACREEDOR;	
			} else {
				return  Constants.BD_DEUDOR;
			}
		} else {
			return "";
		}
	}    

	public static Integer formValidNull(Integer valueEntity) {
		if (valueEntity == null ){
			return -1;	
		} else {
			return valueEntity;
		}
	}    
	
	
}
