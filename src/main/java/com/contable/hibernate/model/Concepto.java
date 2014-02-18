package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "conceptos")
public class Concepto implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Concepto() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "Codigo")
	private String codigo;
	@Column(name = "Nombre")
	private String nombre;
  	@Column(name = "Descripcion")
	private String descripcion;
  	@Column(name = "TipoValor")
	private String tipoValor;
  	@Column(name = "IdEntidad")
	private int idEntidad;
  	@Column(name = "IdCuenta")
	private int idCuenta;
  	@Column(name = "IdMoneda")
	private int idMoneda;
  	@Column(name = "IdAdministracion")
	private int idAdministracion;

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
	public int getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public int getIdMoneda() {
		return idMoneda;
	}
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
	public int getIdAdministracion() {
		return idAdministracion;
	}
	public void setIdAdministracion(int idAdministracion) {
		this.idAdministracion = idAdministracion;
	}

  	
}
