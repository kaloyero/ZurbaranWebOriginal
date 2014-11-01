package com.contable.form;

import com.contable.common.beans.FormConfig;


/**
 * @author kaloye
 *
 */ 
public class UsuarioForm implements FormConfig {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String username;
	private String password;
	private String  descripcion;
	private String email;
	private Integer idRole;
	private String validaPassword;
	private String validaRol;
	private String estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRole) {
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

	
}
