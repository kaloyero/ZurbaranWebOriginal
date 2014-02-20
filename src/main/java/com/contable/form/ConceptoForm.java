package com.contable.form;

import com.contable.common.beans.Form;

public class ConceptoForm implements Form  {

	private int id;
	private AdministracionForm administracion;
	private String codigo; 
	private String nombre;
	private CuentaForm cuenta;
	
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
	public CuentaForm getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaForm cuenta) {
		this.cuenta = cuenta;
	}


}
