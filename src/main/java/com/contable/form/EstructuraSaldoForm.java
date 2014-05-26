package com.contable.form;

import java.io.Serializable;


public class EstructuraSaldoForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private String contenidoNombre;
	private String cuentaNombre;
	private String entidadNombre;
	private String monedaNombre;
	private String monedaCodigo;
	private String saldo;

	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
	}

	public String getContenidoNombre() {
		return contenidoNombre;
	}
	public void setContenidoNombre(String contenidoNombre) {
		this.contenidoNombre = contenidoNombre;
	}
	public String getMonedaNombre() {
		return monedaNombre;
	}
	public void setMonedaNombre(String monedaNombre) {
		this.monedaNombre = monedaNombre;
	}
	public String getMonedaCodigo() {
		return monedaCodigo;
	}
	public void setMonedaCodigo(String monedaCodigo) {
		this.monedaCodigo = monedaCodigo;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	
}