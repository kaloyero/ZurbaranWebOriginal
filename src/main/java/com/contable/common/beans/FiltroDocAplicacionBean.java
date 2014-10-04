package com.contable.common.beans;



public class FiltroDocAplicacionBean {

	private  Integer 	administracionId ;
	
	private  Integer 	movCuentaId ;
	private  Integer 	movTipoEntidadId ;
	private  String 	movEntidadId ;
	private  String 	docAplicaNumeroFormateado ;
	
	private  String		docAplicadoFechaDesde ;
	private  String		docAplicadoFechaHasta ;
	
	private  String 	movReferencia ;
	private  Integer 	movMonedaId ;
	private  Integer 	monedaMuestraId ;
	
	public FiltroDocAplicacionBean() {
	}

	
	
	public Integer getAdministracionId() {
		return administracionId;
	}

	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}

	public Integer getMovCuentaId() {
		return movCuentaId;
	}

	public void setMovCuentaId(Integer movCuentaId) {
		this.movCuentaId = movCuentaId;
	}

	public Integer getMovTipoEntidadId() {
		return movTipoEntidadId;
	}

	public void setMovTipoEntidadId(Integer movTipoEntidadId) {
		this.movTipoEntidadId = movTipoEntidadId;
	}

	public String getMovEntidadId() {
		return movEntidadId;
	}

	public void setMovEntidadId(String movEntidadId) {
		this.movEntidadId = movEntidadId;
	}

	public String getDocAplicaNumeroFormateado() {
		return docAplicaNumeroFormateado;
	}

	public void setDocAplicaNumeroFormateado(String docAplicaNumeroFormateado) {
		this.docAplicaNumeroFormateado = docAplicaNumeroFormateado;
	}

	public String getDocAplicadoFechaDesde() {
		return docAplicadoFechaDesde;
	}

	public void setDocAplicadoFechaDesde(String docAplicadoFechaDesde) {
		this.docAplicadoFechaDesde = docAplicadoFechaDesde;
	}

	public String getDocAplicadoFechaHasta() {
		return docAplicadoFechaHasta;
	}

	public void setDocAplicadoFechaHasta(String docAplicadoFechaHasta) {
		this.docAplicadoFechaHasta = docAplicadoFechaHasta;
	}

	public String getMovReferencia() {
		return movReferencia;
	}

	public void setMovReferencia(String movReferencia) {
		this.movReferencia = movReferencia;
	}

	public Integer getMovMonedaId() {
		return movMonedaId;
	}

	public void setMovMonedaId(Integer movMonedaId) {
		this.movMonedaId = movMonedaId;
	}

	public Integer getMonedaMuestraId() {
		return monedaMuestraId;
	}

	public void setMonedaMuestraId(Integer monedaMuestraId) {
		this.monedaMuestraId = monedaMuestraId;
	}

	
}
