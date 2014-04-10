package com.contable.common.beans;


public class DocumentoAplicacionesSearch {


	
	private Integer cuentaId;
	private Integer tipoDocumentoId;
	private Integer entidadId;
	private Integer monedaId;
	
	

	public DocumentoAplicacionesSearch(){
	}



	public Integer getCuentaId() {
		return cuentaId;
	}



	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}



	public Integer getTipoDocumentoId() {
		return tipoDocumentoId;
	}



	public void setTipoDocumentoId(Integer tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}



	public Integer getEntidadId() {
		return entidadId;
	}



	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}



	public Integer getMonedaId() {
		return monedaId;
	}



	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}

}
