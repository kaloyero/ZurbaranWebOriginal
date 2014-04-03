package com.contable.form;

import com.contable.common.beans.Form;

public class DocumentoMovimientoForm implements Form {
	
	private static final long serialVersionUID = 1L;
	private  int id ;
	private  String  conceptoId ;
	private  Integer cuentaId;
	private  Integer tipoEntidadId ;
	private  Integer entidadId ;
	private  String  descripcion ;
	private  MonedaForm  moneda;
	private  String  tipoDocumento ;
	private  Double  importe;
	private  Integer documentoId;
	private  CotizacionForm  cotizacion ;

	
	public Integer getTipoEntidadId() {
		return tipoEntidadId;
	}
	public void setTipoEntidadId(Integer tipoEntidadId) {
		this.tipoEntidadId = tipoEntidadId;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConceptoId() {
		return conceptoId;
	}
	public void setConceptoId(String conceptoId) {
		this.conceptoId = conceptoId;
	}
	public Integer getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}
	public Integer getEntidadId() {
		return entidadId;
	}
	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public MonedaForm getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Integer getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}
	public CotizacionForm getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(CotizacionForm cotizacion) {
		this.cotizacion = cotizacion;
	}

}
