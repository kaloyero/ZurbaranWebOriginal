package com.contable.common.beans;


public class ConfigBean {

	private int id=0;
	
	private String nombre="";

	public ConfigBean(){
	}

	
	public ConfigBean(int id, String nombre){
		this.id=id;
		this.nombre=nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
