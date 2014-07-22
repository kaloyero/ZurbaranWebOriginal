package com.contable.common.beans;



public class FiltroValPropiosBean {

	private  Integer 	administracionId ;
	private  Integer 	cuentaId ;
	private  Integer 	tipoEntidadId ;
	private  Integer 	entidadId ;
	private  Integer 	monedaId ;
	private  Integer 	chequeraId ;
	private  String 	fechaEmisionDesde ;
	private  String		fechaEmisionHasta ;
	private  String		fechaVtoDesde ;
	private  String		fechaVtoHasta ;
	
	private  Integer 	numero ;
	private  Double 	importeDesde ;
	private  Double 	importeHasta ;
	
	
	public Integer getChequeraId() {
		return chequeraId;
	}
	public void setChequeraId(Integer chequeraId) {
		this.chequeraId = chequeraId;
	}
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
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
	public String getFechaEmisionDesde() {
		return fechaEmisionDesde;
	}
	public void setFechaEmisionDesde(String fechaEmisionDesde) {
		this.fechaEmisionDesde = fechaEmisionDesde;
	}
	public String getFechaEmisionHasta() {
		return fechaEmisionHasta;
	}
	public void setFechaEmisionHasta(String fechaEmisionHasta) {
		this.fechaEmisionHasta = fechaEmisionHasta;
	}
	public String getFechaVtoDesde() {
		return fechaVtoDesde;
	}
	public void setFechaVtoDesde(String fechaVtoDesde) {
		this.fechaVtoDesde = fechaVtoDesde;
	}
	public String getFechaVtoHasta() {
		return fechaVtoHasta;
	}
	public void setFechaVtoHasta(String fechaVtoHasta) {
		this.fechaVtoHasta = fechaVtoHasta;
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
	
}
