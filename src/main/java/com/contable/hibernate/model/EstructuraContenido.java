package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdEstructura", nullable = false)
	private Estructura estructura;

	@Cascade(value= CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "estructuraContenido")
	private Set<EstructuraContenidoCuenta> cuentas = new HashSet<EstructuraContenidoCuenta>();

	
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

	public Estructura getEstructura() {
		return estructura;
	}

	public void setEstructura(Estructura estructura) {
		this.estructura = estructura;
	}

	public Set<EstructuraContenidoCuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<EstructuraContenidoCuenta> cuentas) {
		this.cuentas = cuentas;
	}


	
}
