package com.contable.form;

import java.util.Set;

import com.contable.common.beans.FormConfig;

public class EstructuraForm implements FormConfig  {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;
	private AdministracionForm administracion;
	private String estado;
	private Set<EstructuraContenidoForm> contenidos;
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public AdministracionForm getAdministracion() {
		return administracion;
	}

	public void setAdministracion(AdministracionForm administracion) {
		this.administracion = administracion;
	}

	public Set<EstructuraContenidoForm> getContenidos() {
		return contenidos;
	}

	public void setContenidos(Set<EstructuraContenidoForm> contenidos) {
		this.contenidos = contenidos;
	}

	
}
