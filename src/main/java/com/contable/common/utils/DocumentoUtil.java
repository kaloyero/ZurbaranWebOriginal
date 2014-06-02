package com.contable.common.utils;

import org.apache.commons.lang.StringUtils;

import com.contable.common.constants.Constants;


public class DocumentoUtil {
	
	public static final String AGREGAR_ZERO = "0";
	public static final int CANT_ANIOMESDIA = 2;
	public static final int CANT_ESTABLECIMIENTO = 4;
	public static final int CANT_NUMERO = 8;
	public static final String SEPARADOR = "-";

	/**
	 * Este metodo agrega 'n' 'chars' a la 'cadena'  
	 * 
	 * @param n
	 * @param chars
	 * @param cadena
	 * @return
	 */
	public synchronized static String agregarCaracteres(int n, String chars, String cadena) {
		String res = "";
		int agregarN = n - cadena.length();
		
		for (int i = 0; i < agregarN; i++) {
			res += chars; 
		}
		
		res += cadena;

		return res;
	}    

	public synchronized static String agregarZeros(int n, String cadena) {
		return agregarCaracteres(n, AGREGAR_ZERO, cadena);
	}    

	public synchronized static String completarDocAnioMesDia(Integer cadena) {
		return agregarZeros(CANT_ANIOMESDIA, ConvertionUtil.StrValueOf(cadena));
	}    

	public synchronized static String completarDocEstablecimiento(Integer cadena) {
		return agregarZeros(CANT_ESTABLECIMIENTO, ConvertionUtil.StrValueOf(cadena));
	}    

	public synchronized static String completarDocNumero(Integer cadena) {
		return agregarZeros(CANT_NUMERO, ConvertionUtil.StrValueOf(cadena));
	}    

	public synchronized static String getNumeroFormato (String numeroLetra,Integer numeroEstablecimiento,Integer numeroAnio,Integer numeroMes,Integer numeroDia,Integer numero){
		StringBuffer resNumero = new StringBuffer("");

		if (StringUtils.isNotBlank(numeroLetra))
			resNumero.append(numeroLetra + SEPARADOR) ;
		if (numeroEstablecimiento != null)
			resNumero.append(DocumentoUtil.completarDocEstablecimiento(numeroEstablecimiento) + SEPARADOR);
		if (numeroAnio != null)
			resNumero.append(DocumentoUtil.completarDocAnioMesDia(numeroAnio) + SEPARADOR);
		if (numeroMes != null)
			resNumero.append(DocumentoUtil.completarDocAnioMesDia(numeroMes) + SEPARADOR);
		if (numeroDia != null)
			resNumero.append(DocumentoUtil.completarDocAnioMesDia(numeroDia) + SEPARADOR);
		if (numero != null)
			resNumero.append(DocumentoUtil.completarDocNumero(numero));

		return resNumero.toString();
	}
	
	public synchronized static String invertirTipoDeMovimiento (String tipoMovimientoActual){
		String tipoMovimientoInvertido = "";

		if (Constants.TIPODOCUMENTO_TIPOMOV_DEBITO.equals(tipoMovimientoActual)){
			tipoMovimientoInvertido = 	Constants.TIPODOCUMENTO_TIPOMOV_CREDITO;	
		} else {
			tipoMovimientoInvertido =  Constants.TIPODOCUMENTO_TIPOMOV_DEBITO;
		}

		return tipoMovimientoInvertido;
	}
		
	
	
}
