package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "entidades")
public class Entidad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Entidad() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Nombre")
	private  String nombre;
	@Column(name = "CodigoReferencia")
	private  String codigoReferencia;
	@Column(name = "IdTipoEntidad")
	private  int idTipoEntidad;

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
	public String getCodigoReferencia() {
		return codigoReferencia;
	}
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	public int getIdTipoEntidad() {
		return idTipoEntidad;
	}
	public void setIdTipoEntidad(int idTipoEntidad) {
		this.idTipoEntidad = idTipoEntidad;
	}	
	

}
