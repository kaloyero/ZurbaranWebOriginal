package com.contable.form;

import com.contable.common.beans.Form;

public class TipoEntidadForm implements Form  {

	private int id;
	private String nombre;
	private AdministracionForm administracion;
	
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
	
}
