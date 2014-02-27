package com.contable.form;

import com.contable.common.beans.Form;

public class EntidadForm implements Form  {

	private int id;
	private String nombre;
	private String codigoReferencia;
	private TipoEntidadForm tipo;
	private String estado;
	
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
	public TipoEntidadForm getTipo() {
		return tipo;
	}
	public void setTipo(TipoEntidadForm tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoReferencia() {
		return codigoReferencia;
	}
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

}
