package com.contable.common.utils;

import org.apache.commons.lang.StringUtils;

import com.contable.common.constants.Constants;

public class ControllerUtil {
	
	public static final String DESC_ESTADO_ACTIVO = "Activo";
	public static final String DESC_ESTADO_INACTIVO = "Inactivo";
	public static final String DESC_SALDO_ACREEDOR = "Acreedor";
	public static final String DESC_SALDO_DEUDOR = "Deudor";

	/**
	 * Este metodo devuelve la descripcion del ESTADO segun el c�digo de estado 
	 * 
	 * @param codigoEstado
	 * @return
	 */
	public static String getEstadoDescripcion(String codigoEstado) {
		if (StringUtils.isNotBlank(codigoEstado) ){
			if (Constants.UI_ACTIVO.equals(codigoEstado)){
				return	DESC_ESTADO_ACTIVO;	
			} else {
				return  DESC_ESTADO_INACTIVO;
			}
		} else {
			return "";
		}
	}    

	/**
	 * Este metodo devuelve la descripcion del SALDO segun el c�digo de saldo 
	 * 
	 * @param codigoSaldo
	 * @return
	 */
	public static String getSaldoDescripcion(String codigoSaldo) {
		if (StringUtils.isNotBlank(codigoSaldo) ){
			if (Constants.UI_ACREEDOR.equals(codigoSaldo)){
				return	DESC_SALDO_ACREEDOR;	
			} else {
				return  DESC_SALDO_DEUDOR;
			}
		} else {
			return "";
		}
	}    

	
}
