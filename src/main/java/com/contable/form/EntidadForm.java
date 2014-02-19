package com.contable.form;

import com.contable.common.beans.Form;

public class EntidadForm implements Form  {

	private int id;
	private String administracion;
	private String tipo;
	private String nombre;
	private String codigoReferencia;
	
	
	public String getCodigoReferencia() {
		return codigoReferencia;
	}
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 

	

}
