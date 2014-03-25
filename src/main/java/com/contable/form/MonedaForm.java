package com.contable.form;

import com.contable.common.beans.FormConfig;

/**
 * @author kaloye
 *
 */
public class MonedaForm implements FormConfig  {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String codigo;
	private String monedaLocal;
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

	public String getMonedaLocal() {
		return monedaLocal;
	}

	public void setMonedaLocal(String monedaLocal) {
		this.monedaLocal = monedaLocal;
	}

	
}
