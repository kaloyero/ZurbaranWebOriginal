package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuentamonedas")
public class CuentaMoneda implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public CuentaMoneda() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdMoneda")
	private Moneda moneda;
	
	@Column(name = "IdCuenta")
	private  int idCuenta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	
	
}
