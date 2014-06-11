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

	public synchronized static String calcularImporte(Double importe, int idMonedaMovimiento, Double cotizacionMovimiento, int idMonedaDocumentoHeader, Double cotizacionHeader){
		String total = "0.00";
		if (cotizacionHeader == null){
			FormatUtil.format2DecimalsStr(importe);
			return total;
		}
		
		//Pregunto si la moneda que muestro es igual a la que quiero mostrar. De ser así dejo el mismo valor.
		if (idMonedaMovimiento == idMonedaDocumentoHeader){
			total = FormatUtil.format2DecimalsStr(importe);
		} else {
			//Double cotizacionMoneda = cotizacionManager.getUltimaCotizacionValidacion(saldo.getMonedaId()).getCotizacion();
			if (cotizacionMovimiento == null || cotizacionMovimiento == 0){
				cotizacionMovimiento = 1.0;
			}
			//calcula
			total = calcularImporteByCOtizacion(cotizacionMovimiento, cotizacionMovimiento, cotizacionHeader);
		}
		//Actualiza el IMPORTE
		return FormatUtil.format2DecimalsStr(total);
	}
	
}
