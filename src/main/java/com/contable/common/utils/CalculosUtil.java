package com.contable.common.utils;



public class CalculosUtil {
	

	public static String calcularImporteByCOtizacion(Double importe,Double cotizacionActual, Double cotizacionConvertir) {

		Double total = (importe / cotizacionActual) *cotizacionConvertir;
		
		return FormatUtil.format2DecimalsStr(total);
	}    

	
}
