package com.contable.form;

import com.contable.common.beans.Form;

public class BancoForm implements Form  {

	private int id;
	private String nombre;

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
