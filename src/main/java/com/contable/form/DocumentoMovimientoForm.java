package com.contable.form;

import com.contable.common.beans.Form;

public class DocumentoMovimientoForm implements Form {
	
	private static final long serialVersionUID = 1L;
	private  int id ;
	private  Integer conceptoId ;
	private  String  conceptoNombre ;
	private  String  conceptoCodigo ;
	private  Integer cuentaId;
	private  String  cuentaNombre ;
	private  String  cuentaCodigo ;
	private  Integer tipoEntidadId ;
	private  String  tipoEntidadNombre ;
	private  Integer entidadId ;
	private  String  entidadNombre ;
	private  String  codMovimiento ;
	private  String  descripcion ;
	private  Integer monedaId;
	private  String  monedaNombre ;
	private  String  monedaCodigo ;
	private  String  tipoMovimiento ;
	private  String  importe;
	private  String  importeMonedaHeader;
	private  Integer documentoId;
	private  Double cotizacion ;
	private  String  referencia ;
	private  Integer movimientoAnulaId;
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getConceptoId() {
		return conceptoId;
	}
	public void setConceptoId(Integer conceptoId) {
		this.conceptoId = conceptoId;
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
	public String getCodMovimiento() {
		return codMovimiento;
	}
	public void setCodMovimiento(String codMovimiento) {
		this.codMovimiento = codMovimiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
//	public Double getImporte() {
//		return importe;
//	}
//	public void setImporte(Double importe) {
//		this.importe = importe;
//	}
	
	public Integer getDocumentoId() {
		return documentoId;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}
	public Double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}
	public String getConceptoNombre() {
		return conceptoNombre;
	}
	public void setConceptoNombre(String conceptoNombre) {
		this.conceptoNombre = conceptoNombre;
	}
	public String getConceptoCodigo() {
		return conceptoCodigo;
	}
	public void setConceptoCodigo(String conceptoCodigo) {
		this.conceptoCodigo = conceptoCodigo;
	}
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public String getCuentaCodigo() {
		return cuentaCodigo;
	}
	public void setCuentaCodigo(String cuentaCodigo) {
		this.cuentaCodigo = cuentaCodigo;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
	}
	public String getMonedaNombre() {
		return monedaNombre;
	}
	public void setMonedaNombre(String monedaNombre) {
		this.monedaNombre = monedaNombre;
	}
	public String getMonedaCodigo() {
		return monedaCodigo;
	}
	public void setMonedaCodigo(String monedaCodigo) {
		this.monedaCodigo = monedaCodigo;
	}
	public String getTipoEntidadNombre() {
		return tipoEntidadNombre;
	}
	public void setTipoEntidadNombre(String tipoEntidadNombre) {
		this.tipoEntidadNombre = tipoEntidadNombre;
	}
	public Integer getMovimientoAnulaId() {
		return movimientoAnulaId;
	}
	public void setMovimientoAnulaId(Integer movimientoAnulaId) {
		this.movimientoAnulaId = movimientoAnulaId;
	}
	public String getImporteMonedaHeader() {
		return importeMonedaHeader;
	}
	public void setImporteMonedaHeader(String importeMonedaHeader) {
		this.importeMonedaHeader = importeMonedaHeader;
	}

}
