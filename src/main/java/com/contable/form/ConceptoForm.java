package com.contable.form;

import com.contable.common.beans.FormConfig;

public class ConceptoForm implements FormConfig  {

	private int id;
	private AdministracionForm administracion;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String tipoValor;
	private CuentaForm cuenta;
	private EntidadForm entidad;
	private MonedaForm moneda;
	private String estado;
	
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoValor() {
		return tipoValor;
	}
	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}
	public EntidadForm getEntidad() {
		return entidad;
	}
	public void setEntidad(EntidadForm entidad) {
		this.entidad = entidad;
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
	public MonedaForm getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


}
