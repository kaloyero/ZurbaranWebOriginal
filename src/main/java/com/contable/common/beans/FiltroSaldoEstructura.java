package com.contable.common.beans;



public class FiltroSaldoEstructura {

	private  Integer 	administracionId ;
	private  String		fechaDesde ;
	private  String		fecha ;
	private  Integer 	estructuraId ;
	private  Integer 	monedaMostrarId ;
	private  boolean 	sinSaldos ;

  	
  	
	public boolean isSinSaldos() {
		return sinSaldos;
	}
	public void setSinSaldos(boolean sinSaldos) {
		this.sinSaldos = sinSaldos;
	}
	public Integer getMonedaMostrarId() {
		return monedaMostrarId;
	}
	public void setMonedaMostrarId(Integer monedaMostrarId) {
		this.monedaMostrarId = monedaMostrarId;
	}
	public FiltroSaldoEstructura() {
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Integer getEstructuraId() {
		return estructuraId;
	}
	public void setEstructuraId(Integer estructuraId) {
		this.estructuraId = estructuraId;
	}
}
