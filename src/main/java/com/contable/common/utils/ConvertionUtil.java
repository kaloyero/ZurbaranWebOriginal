package com.contable.common.utils;

import org.apache.commons.lang.math.NumberUtils;


public class ConvertionUtil {

	public static String StrValueOf (Double var){
		String res = null;
		if (var != null){
			res = String.valueOf(var);
		} 
		return res;
	}
	public static String StrValueOf (Integer var){
		String res = null;
		if (var != null){
			res = String.valueOf(var);
		} 
		return res;
	}
	public static Integer IntValueOf (String var){
		Integer res = null;
		if (NumberUtils.isDigits(var)){
			res = Integer.valueOf(var);
		} 
		return res;
	}
	public static Double DouValueOf (String var){
		Double res = null;
		if (NumberUtils.isDigits(var)){
			res = Double.valueOf(var);
		} 
		return res;
	}
	
}
