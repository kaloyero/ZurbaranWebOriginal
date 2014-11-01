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

	
	public Usuario(String username, String password, int idRole,
			String habilitado) {
		super();
		this.username = username;
		this.password = password;
		this.idRole = idRole;
		this.estado = habilitado;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "Nombre")
	private String username;
	
	@Column(name = "Descripcion")
	private String  descripcion;
  
	@Column(name = "ClaveAcceso")
	private String password;
  
	@Column(name = "Email")
	private String email;
	
	@Column(name = "IdRole")
	private int idRole;
	
	@Column(name = "ValidaPassword")
	private String validaPassword;
	
	@Column(name = "ValidaRole")
	private String validaRol;
	
	@Column(name = "Habilitado")
	private String estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
