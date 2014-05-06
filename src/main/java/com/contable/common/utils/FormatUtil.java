package com.contable.common.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class FormatUtil {

	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	/**
	 * Agrega 2 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public static Double format2Decimals (Double num){
		
	    DecimalFormat decim = new DecimalFormat("0.00");
	    
	    return Double.parseDouble(decim.format(num));
		
	}

	
	/**
	 * Agrega 4 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public static Double format4Decimals (Double num){
	    DecimalFormat decim = new DecimalFormat("0.0000");
	    
	    return Double.parseDouble(decim.format(num));
		
	}

}
