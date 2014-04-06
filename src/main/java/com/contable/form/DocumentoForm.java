package com.contable.form;

import com.contable.common.beans.FormConfig;

public class DocumentoForm implements FormConfig  {

	private static final long serialVersionUID = 1L;

	private  int id ;
	private  String  numeroLetra ;
	private  Integer numeroEstablecimiento ;
	private  Integer numeroAnio ;
	private  Integer numeroMes ;
	private  String  numeroDia ;
	private  Integer numero ;
	private  String  fechaReal ;
	private  String  fechaIngreso ;
	private  String  fechaVencimiento ;
	private  String  descripcion ;
	private  Integer tipoDocumentoId ;
	private  Integer cuentaId ;
	private  String  cuentaNombre ;
  	private  MonedaForm moneda ;
	private  Integer tipoEntidadId ;
	private  String  tipoEntidadNombre ;
	private  Integer entidadId ;
	private  String  entidadNombre ;
	private  CotizacionForm cotizacionForm ;
	private  Integer administracionId ;
	private  String  administracionNombre ;
  	private  String  tipoMovimiento ;
  	private  Double  importeTotal ;
  	private  Double  importeAplicado ;
  	private  PeriodoForm periodo ;
  	private  String  estado ;
  	private  Integer documentoAnulaaId ;
  	private  Integer documentoAnuladoPorId ;
  	
  	private  DocumentoMovimientoForm docMovimiento ;
  	private  DocumentoAplicacionForm docAnulacion ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroLetra() {
		return numeroLetra;
	}
	public void setNumeroLetra(String numeroLetra) {
		this.numeroLetra = numeroLetra;
	}
	public Integer getNumeroEstablecimiento() {
		return numeroEstablecimiento;
	}
	public void setNumeroEstablecimiento(Integer numeroEstablecimiento) {
		this.numeroEstablecimiento = numeroEstablecimiento;
	}
	public Integer getNumeroAnio() {
		return numeroAnio;
	}
	public void setNumeroAnio(Integer numeroAnio) {
		this.numeroAnio = numeroAnio;
	}
	public Integer getNumeroMes() {
		return numeroMes;
	}
	public void setNumeroMes(Integer numeroMes) {
		this.numeroMes = numeroMes;
	}
	public String getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(String numeroDia) {
		this.numeroDia = numeroDia;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getFechaReal() {
		return fechaReal;
	}
	public void setFechaReal(String fechaReal) {
		this.fechaReal = fechaReal;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	public void setTipoDocumentoId(Integer tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	public Integer getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public Integer getTipoEntidadId() {
		return tipoEntidadId;
	}
	public void setTipoEntidadId(Integer tipoEntidadId) {
		this.tipoEntidadId = tipoEntidadId;
	}
	public String getTipoEntidadNombre() {
		return tipoEntidadNombre;
	}
	public void setTipoEntidadNombre(String tipoEntidadNombre) {
		this.tipoEntidadNombre = tipoEntidadNombre;
	}
	public Integer getEntidadId() {
		return entidadId;
	}
	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public String getAdministracionNombre() {
		return administracionNombre;
	}
	public void setAdministracionNombre(String administracionNombre) {
		this.administracionNombre = administracionNombre;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public Double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}
	public Double getImporteAplicado() {
		return importeAplicado;
	}
	public void setImporteAplicado(Double importeAplicado) {
		this.importeAplicado = importeAplicado;
	}
	public PeriodoForm getPeriodo() {
		return periodo;
	}
	public void setPeriodo(PeriodoForm periodo) {
		this.periodo = periodo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getDocumentoAnulaaId() {
		return documentoAnulaaId;
	}
	public void setDocumentoAnulaaId(Integer documentoAnulaaId) {
		this.documentoAnulaaId = documentoAnulaaId;
	}
	public Integer getDocumentoAnuladoPorId() {
		return documentoAnuladoPorId;
	}
	public void setDocumentoAnuladoPorId(Integer documentoAnuladoPorId) {
		this.documentoAnuladoPorId = documentoAnuladoPorId;
	}
	public DocumentoMovimientoForm getDocMovimiento() {
		return docMovimiento;
	}
	public void setDocMovimiento(DocumentoMovimientoForm docMovimiento) {
		this.docMovimiento = docMovimiento;
	}
	public DocumentoAplicacionForm getDocAnulacion() {
		return docAnulacion;
	}
	public void setDocAnulacion(DocumentoAplicacionForm docAnulacion) {
		this.docAnulacion = docAnulacion;
	}
	public MonedaForm getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
	}
	public CotizacionForm getCotizacionForm() {
		return cotizacionForm;
	}
	public void setCotizacionForm(CotizacionForm cotizacionForm) {
		this.cotizacionForm = cotizacionForm;
	}

}
