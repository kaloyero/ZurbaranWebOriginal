package com.contable.common.utils;

import com.contable.common.constants.Constants;

public class MapperUtil {

	/**
	 * Este metodo devolvera Activo o No activo, segun reciva Activo o No Activo de la base de datos 
	 * 
	 * @param value
	 * @return
	 */
	public static String getStatusToForm(String valueEntity) {
		if (Constants.BD_ACTIVO.equals(valueEntity)){
			return	Constants.UI_ACTIVO;	
		} else {
			return  Constants.UI_INACTIVO;
		}
	}    

	/**
	 * Este metodo devolvera Activo o No activo, segun reciva Activo o No Activo de la base de datos 
	 * 
	 * @param value
	 * @return
	 */
	public static String getStatusToEntity(String valueForm) {
		if (Constants.UI_ACTIVO.equals(valueForm)){
			return	Constants.BD_ACTIVO;	
		} else {
			return  Constants.BD_INACTIVO;
		}
	}    

}
