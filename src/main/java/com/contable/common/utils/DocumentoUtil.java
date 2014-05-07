package com.contable.common.utils;

import org.apache.commons.lang.StringUtils;


public class DocumentoUtil {
	
	public static final String AGREGAR_ZERO = "0";
	public static final int CANT_ANIOMESDIA = 2;
	public static final int CANT_ESTABLECIMIENTO = 4;
	public static final int CANT_NUMERO = 9;

	/**
	 * Este metodo agrega 'n' 'chars' a la 'cadena'  
	 * 
	 * @param n
	 * @param chars
	 * @param cadena
	 * @return
	 */
	public static String agregarCaracteres(int n, String chars, String cadena) {
		String res = "";
		int agregarN = n - cadena.length();
		
		for (int i = 0; i < agregarN; i++) {
			res += chars; 
		}
		
		res += cadena;

		return res;
	}    

	public static String agregarZeros(int n, String cadena) {
		return agregarCaracteres(n, AGREGAR_ZERO, cadena);
	}    

	public static String completarDocAnioMesDia(Integer cadena) {
		return agregarZeros(CANT_ANIOMESDIA, ConvertionUtil.StrValueOf(cadena));
	}    

	public static String completarDocEstablecimiento(Integer cadena) {
		return agregarZeros(CANT_ESTABLECIMIENTO, ConvertionUtil.StrValueOf(cadena));
	}    

	public static String completarDocNumero(Integer cadena) {
		return agregarZeros(CANT_NUMERO, ConvertionUtil.StrValueOf(cadena));
	}    

	public static String getNumeroFormato (String numeroLetra,Integer numeroEstablecimiento,Integer numeroAnio,Integer numeroMes,Integer numeroDia,Integer numero){
		String resNumero = "";
		
		if (StringUtils.isNotBlank(numeroLetra))
			resNumero+= numeroLetra + " " ;
		if (numeroEstablecimiento != null)
			resNumero+= DocumentoUtil.completarDocEstablecimiento(numeroEstablecimiento) + " ";
		if (numeroAnio != null)
			resNumero+= DocumentoUtil.completarDocAnioMesDia(numeroAnio) + " ";
		if (numeroMes != null)
			resNumero+= DocumentoUtil.completarDocAnioMesDia(numeroMes) + " ";
		if (numeroDia != null)
			resNumero+= DocumentoUtil.completarDocAnioMesDia(numeroDia) + " ";
		if (numero != null)
			resNumero+= DocumentoUtil.completarDocNumero(numero) + " ";

		return resNumero;
	}
	
	
}
