package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tipoentidades")
public class TipoEntidad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public TipoEntidad() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Descripcion")
	private String  descripcion;

	@Column(name = "IdAdministracion")
	private int idAdministracion;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdAdministracion() {
		return idAdministracion;
	}

	public void setIdAdministracion(int idAdministracion) {
		this.idAdministracion = idAdministracion;
	}

	
}
