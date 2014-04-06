package com.contable.form;

import com.contable.common.beans.Form;

public class PeriodoSaldoForm implements Form {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Double saldoIni;
	private Double saldoIniMonLocal;
	private PeriodoForm periodo;
	private Integer cuentaId;
	private Integer entidadId;
	private Integer tipoEntidadId;
	private MonedaForm moneda;
	private Double saldoFin;
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
	public PeriodoForm getPeriodo() {
		return periodo;
	}
	public void setPeriodo(PeriodoForm periodo) {
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
	public MonedaForm getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaForm moneda) {
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
