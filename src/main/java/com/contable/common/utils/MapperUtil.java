package com.contable.common.utils;

import org.apache.commons.lang.StringUtils;

import com.contable.common.constants.Constants;

public class MapperUtil {

	/**
	 * Este metodo devolvera Activo o No activo, segun reciva Activo o No Activo de la base de datos 
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
	 * Este metodo devolvera Activo o No activo, segun reciva Activo o No Activo de la base de datos 
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

}
