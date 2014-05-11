package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "estructuracontenidocuentas")
public class EstructuraContenidoCuenta implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public EstructuraContenidoCuenta() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdEstructuraContenido", nullable = false,updatable=false)
	private EstructuraContenido estructuraContenido;

	@Column(name = "IdCuenta",updatable=false)
	private Cuenta cuenta;

	@Column(name = "IdEntidad",updatable=false)
	private Entidad entidad;

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IdMoneda" ,updatable=false)
	private Moneda moneda;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public EstructuraContenido getEstructuraContenido() {
		return estructuraContenido;
	}

	public void setEstructuraContenido(EstructuraContenido estructuraContenido) {
		this.estructuraContenido = estructuraContenido;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

}
