package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "estructuras")
public class EstructuraContenidoCuenta implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public EstructuraContenidoCuenta() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "IdEstructuraContenido")
	private int estructuraContenidoId;

	@Column(name = "IdCuenta")
	private int cuentaId;

	@Column(name = "IdEntidades")
	private int entidadesId;

	@Column(name = "IdMoneda")
	private int monedaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstructuraContenidoId() {
		return estructuraContenidoId;
	}

	public void setEstructuraContenidoId(int estructuraContenidoId) {
		this.estructuraContenidoId = estructuraContenidoId;
	}

	public int getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}

	public int getEntidadesId() {
		return entidadesId;
	}

	public void setEntidadesId(int entidadesId) {
		this.entidadesId = entidadesId;
	}

	public int getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(int monedaId) {
		this.monedaId = monedaId;
	}

}
