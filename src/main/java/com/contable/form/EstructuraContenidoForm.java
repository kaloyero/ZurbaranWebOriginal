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
	private Integer estructuraId;
	private String estructuraNombre;
	private String administracionNombre;
	
	
	public String getEstructuraNombre() {
		return estructuraNombre;
	}
	public void setEstructuraNombre(String estructuraNombre) {
		this.estructuraNombre = estructuraNombre;
	}
	public String getAdministracionNombre() {
		return administracionNombre;
	}
	public void setAdministracionNombre(String administracionNombre) {
		this.administracionNombre = administracionNombre;
	}
	public Integer getEstructuraId() {
		return estructuraId;
	}
	public void setEstructuraId(Integer estructuraId) {
		this.estructuraId = estructuraId;
	}
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
