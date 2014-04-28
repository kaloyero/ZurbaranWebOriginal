package com.contable.form;

import java.util.Set;

import com.contable.common.beans.Form;

public class EstructuraContenidoForm implements Form {

	private static final long serialVersionUID = 1L;

	private int id;
	private String codigo;
	private String descripcion;
	private String modo;
	private Set<EstructuraContenidoCuentaForm> contenidoCuentas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	public Set<EstructuraContenidoCuentaForm> getContenidoCuentas() {
		return contenidoCuentas;
	}
	public void setContenidoCuentas(
			Set<EstructuraContenidoCuentaForm> contenidoCuentas) {
		this.contenidoCuentas = contenidoCuentas;
	}
	
}
