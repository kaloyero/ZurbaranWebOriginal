package com.contable.common.beans;



public class FiltroCuentaBean {

	private  Integer 	administracionId ;
	//se usa para resumen de cuenta
	private  String		fechaDesde ;
	//se usa para resumen y saldo de cuenta
	private  String		fechaHasta ;
	private  Integer 	cuentaId ;
	private  Integer 	tipoEntidadId ;
	private  String 	entidadId ;
	private  Integer 	monedaId ;
	private  Integer 	monedaMuestraId ;
	//Es true si filtra por la fecha de cotización del movimiento. Si es false toma la cotización al dia de la fecha.
	private  boolean 	monedaMuestraCotizaFecha = true ;
	private  Integer	anio;
	private  Integer	mes;
  	private  Double 	saldoInicial ;
  	private  Double 	importe ;
  	private  String 	referencia ;
  	
	public FiltroCuentaBean() {
	}
  	
  	
	public FiltroCuentaBean(Integer administracionId, String fechaHasta,
			Integer cuentaId, String entidadId, Integer monedaId) {
		super();
		this.administracionId = administracionId;
		this.fechaHasta = fechaHasta;
		this.cuentaId = cuentaId;
		this.entidadId = entidadId;
		this.monedaId = monedaId;
	}
	
	
	
	public FiltroCuentaBean(Integer administracionId, String fechaDesde,
			String fechaHasta, Integer cuentaId,	String entidadId, Integer monedaId) {
		super();
		this.administracionId = administracionId;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.cuentaId = cuentaId;
		this.entidadId = entidadId;
		this.monedaId = monedaId;
	}


	public Integer getMonedaMuestraId() {
		return monedaMuestraId;
	}
	public void setMonedaMuestraId(Integer monedaMuestraId) {
		this.monedaMuestraId = monedaMuestraId;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
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
	public String getEntidadId() {
		return entidadId;
	}
	public void setEntidadId(String entidadId) {
		this.entidadId = entidadId;
	}
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}
	public Double getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public boolean isMonedaMuestraCotizaFecha() {
		return monedaMuestraCotizaFecha;
	}


	public void setMonedaMuestraCotizaFecha(boolean monedaMuestraCotizaFecha) {
		this.monedaMuestraCotizaFecha = monedaMuestraCotizaFecha;
	}


	

}
