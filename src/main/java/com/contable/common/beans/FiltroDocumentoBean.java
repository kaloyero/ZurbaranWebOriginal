package com.contable.common.beans;

import java.util.Date;


public class FiltroDocumentoBean {

	private  String 	numeroLetra ;
	private  Integer 	numeroEstablecimiento ;
	private  Integer 	numeroAnio ;
	private  Integer 	numeroMes ;
	private  Integer 	numeroDia ;
	private  Integer 	numero ;
	private  Date 		fechaIngreso ;
	private  Date 		fechaIngresoDesde ;
	private  Date 		fechaIngresoHasta ;
	private  Date 		fechaVencimiento ;
	private  Integer 	tipoDocumentoId ;
	private  Integer 	cuentaId ;
	private  Integer 	tipoEntidadId ;
	private  Integer 	entidadId ;
	private  Integer 	administracionId ;
  	private  String 	tipoMovimiento ;
  	private  String 	referencia ;  	
  	private  Double 	importeTotalDesde ;
  	private  Double 	importeTotalHasta ;
  	private  Integer 	periodoId ;

  	
  	
  	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getNumeroLetra() {
		return numeroLetra;
	}
	public void setNumeroLetra(String numeroLetra) {
		this.numeroLetra = numeroLetra;
	}
	public Integer getNumeroEstablecimiento() {
		return numeroEstablecimiento;
	}
	public void setNumeroEstablecimiento(Integer numeroEstablecimiento) {
		this.numeroEstablecimiento = numeroEstablecimiento;
	}
	public Integer getNumeroAnio() {
		return numeroAnio;
	}
	public void setNumeroAnio(Integer numeroAnio) {
		this.numeroAnio = numeroAnio;
	}
	public Integer getNumeroMes() {
		return numeroMes;
	}
	public void setNumeroMes(Integer numeroMes) {
		this.numeroMes = numeroMes;
	}
	public Integer getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaIngresoDesde() {
		return fechaIngresoDesde;
	}
	public void setFechaIngresoDesde(Date fechaIngresoDesde) {
		this.fechaIngresoDesde = fechaIngresoDesde;
	}
	public Date getFechaIngresoHasta() {
		return fechaIngresoHasta;
	}
	public void setFechaIngresoHasta(Date fechaIngresoHasta) {
		this.fechaIngresoHasta = fechaIngresoHasta;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Integer getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	public void setTipoDocumentoId(Integer tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	public Integer getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}
	public Integer getTipoEntidadId() {
		return tipoEntidadId;
	}
	public void setTipoEntidadId(Integer tipoEntidadId) {
		this.tipoEntidadId = tipoEntidadId;
	}
	public Integer getEntidadId() {
		return entidadId;
	}
	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public Double getImporteTotalDesde() {
		return importeTotalDesde;
	}
	public void setImporteTotalDesde(Double importeTotalDesde) {
		this.importeTotalDesde = importeTotalDesde;
	}
	public Double getImporteTotalHasta() {
		return importeTotalHasta;
	}
	public void setImporteTotalHasta(Double importeTotalHasta) {
		this.importeTotalHasta = importeTotalHasta;
	}
	public Integer getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Integer periodoId) {
		this.periodoId = periodoId;
	}

}
