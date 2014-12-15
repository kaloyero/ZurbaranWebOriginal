package com.contable.common.utils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.contable.common.constants.Constants;
import com.contable.form.CotizacionForm;
import com.contable.hibernate.model.Cotizacion;



public class CalculosUtil {
	

	public synchronized static String calcularImporteByCOtizacion(Double importe,Double cotizacionActual, Double cotizacionConvertir) {
		Double total = 0.0;
		if (cotizacionActual == 0){
			cotizacionActual = 1.0;
		}
		if (cotizacionConvertir == 0){
			cotizacionConvertir = 1.0;
		}
		
		
		if (importe == null || importe == 0){
			total = 0.0;
		} else {
			total = (importe / cotizacionConvertir) * cotizacionActual;
		}
		
		
		return FormatUtil.format2DecimalsStr(total);
	}    

	public synchronized static String calcularImporte(String importe, int idMonedaMovimiento, Double cotizacionMovimiento, int idMonedaDocumentoHeader, Double cotizacionHeader){
		String total = Constants.ZERO;
		if (cotizacionHeader == null){
			FormatUtil.format2DecimalsStr(importe);
			return total;
		}
		
		//Pregunto si la moneda que muestro es igual a la que quiero mostrar. De ser así dejo el mismo valor.
		if (idMonedaMovimiento == idMonedaDocumentoHeader){
			total = importe;
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

	
	public synchronized static Double getCotizacionFechaMovDia(Map<Integer,List<Cotizacion>> listadoCotizaciones, Date fecha, CotizacionForm cotForm){
		Double cotizacionMoneda = 1.0;
		
		if (fecha != null){ 
			int ano = DateUtil.getYear(fecha);
	
			List<Cotizacion> cotizaciones = listadoCotizaciones.get(ano);
			
			//IMPORTANTE Q ESTEN ACOMODADOS POR FECHA DE MENOR A MAYOR, sino no anda bien
			if (cotizaciones != null){
				Double ultimaCotizacion = 1.0;
				for (Cotizacion cotizacion : cotizaciones) {
					
					if ( cotizacion.getFecha().after(fecha) ) {
						//Si la fecha es posterior a la fecha de cotizacion toma actualiza la fecha de cotizacion
						ultimaCotizacion = cotizacion.getCotizacion();	
					} else {
						ultimaCotizacion = cotizacion.getCotizacion();	
						//Si la fecha es anterior sale
						break;
					}
				}			
				cotizacionMoneda = ultimaCotizacion ;
			}
			
		} else {
			//Si la fecha es nula devuelve la ultima cotización 
			cotizacionMoneda = cotForm.getCotizacion();
		}
		
		return cotizacionMoneda;

	}
}
