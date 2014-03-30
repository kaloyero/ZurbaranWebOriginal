package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "estructurascontenido")
public class EstructuraContenido implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public EstructuraContenido() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Codigo")
	private  String codigo;
	
	@Column(name = "Descripcion")
	private  String descripcion;

	@Column(name = "Modo")
	private  String modo;
	
	@Column(name = "IdEstructura")
	private int estructuraId;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public int getEstructuraId() {
		return estructuraId;
	}

	public void setEstructuraId(int estructuraId) {
		this.estructuraId = estructuraId;
	}

}
