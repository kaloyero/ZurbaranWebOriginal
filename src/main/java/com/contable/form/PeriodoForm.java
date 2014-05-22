package com.contable.form;

import com.contable.common.beans.FormConfig;

public class PeriodoForm implements FormConfig  {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private AdministracionForm administracion;
	private String fechaIni;
	private String fechaFin;
	private double saldoInicial;
	private String estado;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AdministracionForm getAdministracion() {
		return administracion;
	}
	public void setAdministracion(AdministracionForm administracion) {
		this.administracion = administracion;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

}
