package com.contable.form;

import com.contable.common.beans.Form;

/**
 * @author kaloye
 *
 */
public class MonedaForm implements Form  {

	private int id;
	private String nombre;
	private String codigo;
	private AdministracionForm administracion;
	private String estado;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public AdministracionForm getAdministracion() {
		return administracion;
	}

	public void setAdministracion(AdministracionForm administracion) {
		this.administracion = administracion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
