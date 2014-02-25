package com.contable.common.beans;

public class Property {

	public static final String TYPE_CADENA =  "CADENA";
	public static final String TYPE_ENTERO =  "ENTERO";
	public static final String TYPE_FECHA  =  "FECHA";
	
	private String name;
	private String type;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
}
