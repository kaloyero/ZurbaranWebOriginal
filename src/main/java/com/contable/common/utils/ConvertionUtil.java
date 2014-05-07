package com.contable.common.utils;


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
		if (var != null){
			res = Integer.valueOf(var);
		} 
		return res;
	}
	public static Double DouValueOf (String var){
		Double res = null;
		if (var != null){
			res = Double.valueOf(var);
		} 
		return res;
	}
	
}
