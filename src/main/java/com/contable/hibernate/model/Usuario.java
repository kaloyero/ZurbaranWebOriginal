package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	public Usuario() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Descripcion")
	private String  descripcion;
  
	@Column(name = "ClaveAcceso")
	private String claveAcceso;
  
	@Column(name = "Email")
	private String email;
	
	@Column(name = "IdRole")
	private int idRole;
	
	@Column(name = "ValidaPassword")
	private String validaPassword;
	
	@Column(name = "ValidaRole")
	private String validaRol;
	
	@Column(name = "Habilitado")
	private String habilitado;

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

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getValidaPassword() {
		return validaPassword;
	}

	public void setValidaPassword(String validaPassword) {
		this.validaPassword = validaPassword;
	}

	public String getValidaRol() {
		return validaRol;
	}

	public void setValidaRol(String validaRol) {
		this.validaRol = validaRol;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

	
}
