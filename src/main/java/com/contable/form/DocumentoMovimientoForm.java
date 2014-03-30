package com.contable.form;

import com.contable.common.beans.Form;

public class DocumentoMovimientoForm implements Form {

	private static final long serialVersionUID = -3939874136485777943L;

	private  int id ;
	private  String  conceptoId ;
	private  Integer cuentaId;
	private  Integer tipoentidadId ;
	private  Integer entidadId ;
	private  String  descripcion ;
	private  MonedaForm  moneda;
	private  Double  importe;
	private  Integer documentoId;
	private  CotizacionForm  cotizacion ;
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
	public Integer getTipoentidadId() {
		return tipoentidadId;
	}
	public void setTipoentidadId(Integer tipoentidadId) {
		this.tipoentidadId = tipoentidadId;
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
