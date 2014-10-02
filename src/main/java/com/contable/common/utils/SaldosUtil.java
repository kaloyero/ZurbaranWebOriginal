package com.contable.common.utils;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.contable.common.constants.Constants;

public class SaldosUtil {

	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	public synchronized static String getImporte(String debito, String credito){
		String importe = "0,00";
		if (StringUtils.isNotBlank(debito) && ( ! Constants.ZERO.equals(debito))){
			//debito
			importe = debito;	
		}
		if (StringUtils.isNotBlank(credito) && ( ! Constants.ZERO.equals(credito))){
			//credito
			importe = FormatUtil.formatNegativeNumber("-"+credito);	
		}
		//devuelve  IMPORTE
		return importe;
	}

	public synchronized static Double getImporteExcel(String debito, String credito){
		Double importe = 0.0;
		if (StringUtils.isNotBlank(debito) && ( ! Constants.ZERO.equals(debito))){
			//debito
			importe = ConvertionUtil.DouValueOf(debito);	
		}
		if (StringUtils.isNotBlank(credito) && ( ! Constants.ZERO.equals(credito))){
			//credito
			importe = ConvertionUtil.DouValueOf(credito) * (-1);	
		}
		//devuelve  IMPORTE
		return importe;
	}
	
	
	public synchronized static Double sumar(Double saldo, String debito, String credito){
		Double deb = ConvertionUtil.DouValueOf(debito);
		Double cre = ConvertionUtil.DouValueOf(credito);
		if (deb == null)
			deb = 0.0;
		if (cre == null)
			cre = 0.0;
		
		// SALDO - Averigua si es menor a ZERO
		saldo = saldo + deb - cre;   
		
		return saldo; 
	}

}
