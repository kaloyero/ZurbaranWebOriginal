package com.contable.common.beans;

import java.util.Date;


public class FiltroValPropiosBean {

	private  String 	beneficiario ;
	private  Date 		fechaEmisionDesde ;
	private  Date 		fechaEmisionHasta ;
	private  Date 		fechaVtoDesde ;
	private  Date 		fechaVtoHasta ;
	private  Integer 	cuentaId ;
	private  Integer 	cuentaEmisionId ;
	private  Integer 	tipoEntidadId ;
	private  Integer 	tipoEntidadEmisionId ;
	private  Integer 	entidadId ;
	private  Integer 	entidadEmisionId ;
	private  Integer 	administracionId ;
	private  Integer 	chequeraId ;
	private  Integer 	numero ;
	private  Double 	importeDesde ;
	private  Double 	importeHasta ;
	
	
	public Integer getChequeraId() {
		return chequeraId;
	}
	public void setChequeraId(Integer chequeraId) {
		this.chequeraId = chequeraId;
	}
	public Date getFechaEmisionDesde() {
		return fechaEmisionDesde;
	}
	public void setFechaEmisionDesde(Date fechaEmisionDesde) {
		this.fechaEmisionDesde = fechaEmisionDesde;
	}
	public Date getFechaEmisionHasta() {
		return fechaEmisionHasta;
	}
	public void setFechaEmisionHasta(Date fechaEmisionHasta) {
		this.fechaEmisionHasta = fechaEmisionHasta;
	}
	public Date getFechaVtoDesde() {
		return fechaVtoDesde;
	}
	public void setFechaVtoDesde(Date fechaVtoDesde) {
		this.fechaVtoDesde = fechaVtoDesde;
	}
	public Date getFechaVtoHasta() {
		return fechaVtoHasta;
	}
	public void setFechaVtoHasta(Date fechaVtoHasta) {
		this.fechaVtoHasta = fechaVtoHasta;
	}
	public Integer getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}
	public Integer getCuentaEmisionId() {
		return cuentaEmisionId;
	}
	public void setCuentaEmisionId(Integer cuentaEmisionId) {
		this.cuentaEmisionId = cuentaEmisionId;
	}
	public Integer getTipoEntidadId() {
		return tipoEntidadId;
	}
	public void setTipoEntidadId(Integer tipoEntidadId) {
		this.tipoEntidadId = tipoEntidadId;
	}
	public Integer getTipoEntidadEmisionId() {
		return tipoEntidadEmisionId;
	}
	public void setTipoEntidadEmisionId(Integer tipoEntidadEmisionId) {
		this.tipoEntidadEmisionId = tipoEntidadEmisionId;
	}
	public Integer getEntidadId() {
		return entidadId;
	}
	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}
	public Integer getEntidadEmisionId() {
		return entidadEmisionId;
	}
	public void setEntidadEmisionId(Integer entidadEmisionId) {
		this.entidadEmisionId = entidadEmisionId;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Double getImporteDesde() {
		return importeDesde;
	}
	public void setImporteDesde(Double importeDesde) {
		this.importeDesde = importeDesde;
	}
	public Double getImporteHasta() {
		return importeHasta;
	}
	public void setImporteHasta(Double importeHasta) {
		this.importeHasta = importeHasta;
	}
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
  	

}
