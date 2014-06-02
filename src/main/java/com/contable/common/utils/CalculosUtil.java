package com.contable.common.utils;



public class CalculosUtil {
	

	public synchronized static String calcularImporteByCOtizacion(Double importe,Double cotizacionActual, Double cotizacionConvertir) {
		Double total = 0.0;
		if (cotizacionActual == 0){
			cotizacionActual = 1.0;
		}
		if (cotizacionConvertir == 0){
			cotizacionConvertir = 1.0;
		}
		
		
		if (importe == 0){
			total = 0.0;
		} else {
			total = (importe / cotizacionConvertir) * cotizacionActual;
		}
		
		
		return FormatUtil.format2DecimalsStr(total);
	}    

	
}
