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
	@JoinColumn(name = "IdEstructuraContenido", nullable = false)
	private EstructuraContenido estructuraContenido;

	@Column(name = "IdCuenta")
	private Integer cuentaId;

	@Column(name = "IdEntidades")
	private Integer entidadesId;

	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdMoneda")
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

	public Integer getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}

	public Integer getEntidadesId() {
		return entidadesId;
	}

	public void setEntidadesId(Integer entidadesId) {
		this.entidadesId = entidadesId;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

}
