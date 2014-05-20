package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "chequeras_v")
public class Chequera_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Chequera_V() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "NumeroIni")
	private  Integer numeroIni;
	
	@Column(name = "NumeroFin")
	private  Integer numeroFin;

	@Column(name = "Inactivo")
	private String  estado;

	@Column(name = "Descripcion")
	private  String descripcion;

	@Column(name = "administracionNombre")
	private  String administracionNombre;
	@Column(name = "cuentaNombre")
	private  String cuentaNombre;
	@Column(name = "tipoentidadNombre")
	private  String tipoEntidadNombre;
	@Column(name = "entidadNombre")
	private  String entidadNombre;
	@Column(name = "monedaCodigo")
	private  String monedaCodigo;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getNumeroIni() {
		return numeroIni;
	}
	public void setNumeroIni(Integer numeroIni) {
		this.numeroIni = numeroIni;
	}
	public Integer getNumeroFin() {
		return numeroFin;
	}
	public void setNumeroFin(Integer numeroFin) {
		this.numeroFin = numeroFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAdministracionNombre() {
		return administracionNombre;
	}
	public void setAdministracionNombre(String administracionNombre) {
		this.administracionNombre = administracionNombre;
	}
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public String getTipoEntidadNombre() {
		return tipoEntidadNombre;
	}
	public void setTipoEntidadNombre(String tipoEntidadNombre) {
		this.tipoEntidadNombre = tipoEntidadNombre;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
	}
	public String getMonedaCodigo() {
		return monedaCodigo;
	}
	public void setMonedaCodigo(String monedaCodigo) {
		this.monedaCodigo = monedaCodigo;
	}
	
}
