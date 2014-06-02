package com.contable.common.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FormatUtil {

	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	/**
	 * Agrega 2 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static Double format2Decimals (Double num){
		
		DecimalFormat decim = new DecimalFormat("#.00");
//	    if (num != null){
//	    	return Double.parseDouble(decim.format(num));
//	    } else {
//	    	return null;
//	    }
	    
	    return num;
		
	}

	
	/**
	 * Agrega 4 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static Double format4Decimals (Double num){
		DecimalFormat decim = new DecimalFormat("#.0000");
//	    if (num != null){
//	    	return Double.parseDouble(decim.format(num));
//	    } else {
//	    	return null;
//	    }
	    
	    return num;
		
	}
	/**
	 * Agrega 2 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static String format2DecimalsStr (Double num){
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(','); 
		DecimalFormat decim = new DecimalFormat("0.00", otherSymbols);
	    if (num != null){
	    	return decim.format(num);
	    } else {
	    	return "0.00";
	    }
		
	}
	public synchronized static String format2DecimalsStr (String num){
		
		return format2DecimalsStr (ConvertionUtil.DouValueOf(num));
		
	}

	
	/**
	 * Agrega 4 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static String format4DecimalsStr (Double num){
		DecimalFormat decim = new DecimalFormat("0.0000");
	    if (num != null){
	    	return decim.format(num);
	    } else {
	    	return "0.00";
	    }
		
	}

}
