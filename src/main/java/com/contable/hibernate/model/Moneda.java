package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "monedas")
public class Moneda implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Moneda() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Codigo")
	private  String codigo;
	@Column(name = "Nombre")
	private  String nombre;
	@Column(name = "IdAdministraciones")
	private  int idAdministraciones;

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
	public int getIdAdministraciones() {
		return idAdministraciones;
	}
	public void setIdAdministraciones(int idAdministraciones) {
		this.idAdministraciones = idAdministraciones;
	}

	
}
