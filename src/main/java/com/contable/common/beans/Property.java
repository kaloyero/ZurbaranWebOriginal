package com.contable.common.beans;

import org.hibernate.criterion.SimpleExpression;

public class Property {

	public static final String TYPE_CADENA =  "CADENA";
	public static final String TYPE_ENTERO =  "ENTERO";
	public static final String TYPE_FECHA  =  "FECHA";
	
	public static final String OPERATOR_AND  =  "AND";
	public static final String OPERATOR_OR  =   "OR";
	
	//Nombre del atributo
	private String name;
	//Tipo del atributo
	private String type;
	//valor con el que se compara
	private String value;
	//Operador lógico que se desea aplicar
	private String operator;
	//Restriccion SQL
	private SimpleExpression restriction;
	
	
	public Property(String propertyName,String type) {
		this.name = propertyName;
		this.type = type;
	}

	public Property(String propertyName,String type,String value) {
		this.name = propertyName;
		this.type = type;
		this.value = value;
	}

	public Property(String propertyName,String type,String value,String operator) {
		this.name = propertyName;
		this.type = type;
		this.value = value;
		this.operator = operator;
	}

	public Property(SimpleExpression rest,String operator) {
		this.operator = operator;
		this.restriction = rest;
	}

	
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public SimpleExpression getRestriction() {
		return restriction;
	}

	public void setRestriction(SimpleExpression restriction) {
		this.restriction = restriction;
	}


}
