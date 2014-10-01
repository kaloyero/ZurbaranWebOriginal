package com.contable.common.beans;



public class FiltroDocAplicacionBean {

	private  Integer 	administracionId ;
	
	private  Integer 	docAplicadoCuentaId ;
	private  Integer 	docAplicadoTipoEntidadId ;
	private  String 	docAplicadoEntidadId ;
	private  String 	docAplicadoNumero ;
	
	private  String		docAplicadoFechaDesde ;
	private  String		docAplicadoFechaHasta ;
	
	private  String 	docAplicadoReferencia ;
	private  Integer 	monedaId ;
	private  Integer 	monedaMuestraId ;
	
	public FiltroDocAplicacionBean() {
	}

	public Integer getAdministracionId() {
		return administracionId;
	}

	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}

	public Integer getDocAplicadoCuentaId() {
		return docAplicadoCuentaId;
	}

	public void setDocAplicadoCuentaId(Integer docAplicadoCuentaId) {
		this.docAplicadoCuentaId = docAplicadoCuentaId;
	}

	public Integer getDocAplicadoTipoEntidadId() {
		return docAplicadoTipoEntidadId;
	}

	public void setDocAplicadoTipoEntidadId(Integer docAplicadoTipoEntidadId) {
		this.docAplicadoTipoEntidadId = docAplicadoTipoEntidadId;
	}

	public String getDocAplicadoEntidadId() {
		return docAplicadoEntidadId;
	}

	public void setDocAplicadoEntidadId(String docAplicadoEntidadId) {
		this.docAplicadoEntidadId = docAplicadoEntidadId;
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

	public String getDocAplicadoReferencia() {
		return docAplicadoReferencia;
	}

	public void setDocAplicadoReferencia(String docAplicadoReferencia) {
		this.docAplicadoReferencia = docAplicadoReferencia;
	}


	public Integer getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}

	public Integer getMonedaMuestraId() {
		return monedaMuestraId;
	}

	public void setMonedaMuestraId(Integer monedaMuestraId) {
		this.monedaMuestraId = monedaMuestraId;
	}

	public String getDocAplicadoNumero() {
		return docAplicadoNumero;
	}

	public void setDocAplicadoNumero(String docAplicadoNumero) {
		this.docAplicadoNumero = docAplicadoNumero;
	}
  	
  	


}
