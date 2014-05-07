package com.contable.common.beans;



public class FiltroValTercerosBean {

	private  String 	fechaVencimientoDesde ;
	private  String		fechaVencimientoHasta ;
	private  Integer 	administracionId ;
	private  Integer 	bancoId ;
	private  Integer 	monedaId ;
	private  Integer 	cuentaId ;
	private  Integer 	tipoEntidadId ;
	private  Integer 	entidadId ;
	private  Integer 	numero ;
  	private  boolean 	enCartera = false ;
  	private  boolean 	depositados = false ;
  	private  Double 	importeDesde ;
  	private  Double 	importeHasta ;

  	
  	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}
	public String getFechaVencimientoDesde() {
		return fechaVencimientoDesde;
	}
	public void setFechaVencimientoDesde(String fechaVencimientoDesde) {
		this.fechaVencimientoDesde = fechaVencimientoDesde;
	}
	public String getFechaVencimientoHasta() {
		return fechaVencimientoHasta;
	}
	public void setFechaVencimientoHasta(String fechaVencimientoHasta) {
		this.fechaVencimientoHasta = fechaVencimientoHasta;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public Integer getBancoId() {
		return bancoId;
	}
	public void setBancoId(Integer bancoId) {
		this.bancoId = bancoId;
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
	public boolean isEnCartera() {
		return enCartera;
	}
	public void setEnCartera(boolean enCartera) {
		this.enCartera = enCartera;
	}
	public boolean isDepositados() {
		return depositados;
	}
	public void setDepositados(boolean depositados) {
		this.depositados = depositados;
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
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}


}
