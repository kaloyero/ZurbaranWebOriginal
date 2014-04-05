package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "periodosaldo")
public class PeriodoSaldo implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public PeriodoSaldo() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "SaldoIni")
	private Double saldoIni;
	
	@Column(name = "SaldoIniMonLocal")
	private Double saldoIniMonLocal;
	
	@Column(name = "IdPeriodo")
	private Periodo periodo;
	
	@Column(name = "IdCuenta")
	private Integer cuentaId;
	
	@Column(name = "IdEntidad")
	private Integer entidadId;
	
	@Column(name = "IdTipoEntidad")
	private Integer tipoEntidadId;
	
	@Column(name = "IdMoneda")
	private Moneda moneda;
	
	@Column(name = "SaldoFin")
	private Double saldoFin;
	
	@Column(name = "SaldoFinMonLocal")
	private Double saldoFinMonLocal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getSaldoIni() {
		return saldoIni;
	}

	public void setSaldoIni(Double saldoIni) {
		this.saldoIni = saldoIni;
	}

	public Double getSaldoIniMonLocal() {
		return saldoIniMonLocal;
	}

	public void setSaldoIniMonLocal(Double saldoIniMonLocal) {
		this.saldoIniMonLocal = saldoIniMonLocal;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Integer getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}

	public Integer getEntidadId() {
		return entidadId;
	}

	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}

	public Integer getTipoEntidadId() {
		return tipoEntidadId;
	}

	public void setTipoEntidadId(Integer tipoEntidadId) {
		this.tipoEntidadId = tipoEntidadId;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Double getSaldoFin() {
		return saldoFin;
	}

	public void setSaldoFin(Double saldoFin) {
		this.saldoFin = saldoFin;
	}

	public Double getSaldoFinMonLocal() {
		return saldoFinMonLocal;
	}

	public void setSaldoFinMonLocal(Double saldoFinMonLocal) {
		this.saldoFinMonLocal = saldoFinMonLocal;
	}


}
