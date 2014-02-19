package com.contable.form;

import com.contable.common.beans.Form;

public class ConceptoForm implements Form  {

	private int id;
	private String administracion;
	private String codigo; 
	private String nombre;
	private String cuenta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdministracion() {
		return administracion;
	}
	public void setAdministracion(String administracion) {
		this.administracion = administracion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

}
