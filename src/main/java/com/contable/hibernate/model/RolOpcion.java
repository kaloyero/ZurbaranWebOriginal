package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rolopciones")
public class RolOpcion implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public RolOpcion() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "IdRole")
	private int idRole;
	
	@Column(name = "IdOpcion")
	private int idOpcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public int getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}	

	
	
}
