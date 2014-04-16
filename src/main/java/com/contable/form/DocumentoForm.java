package com.contable.form;

import java.util.List;

import com.contable.common.beans.FormConfig;

public class DocumentoForm implements FormConfig  {

	private static final long serialVersionUID = 1L;

	private  int id ;
	private  String  numeroLetra ;
	private  Integer numeroEstablecimiento ;
	private  Integer numeroAnio ;
	private  Integer numeroMes ;
	private  Integer numeroDia ;
	private  Integer numero ;
	private  String  fechaReal ;
	private  String  fechaIngreso ;
	private  String  fechaVencimiento ;
	private  String  descripcion ;
	private  Integer tipoDocumentoId ;
	private  Integer cuentaId ;
	private  String  cuentaNombre ;
  	private  Integer monedaId ;
	private  Integer tipoEntidadId ;
	private  String  tipoEntidadNombre ;
	private  Integer entidadId ;
	private  String  entidadNombre ;
	private  Double cotizacion ;
	private  AdministracionForm administracion ;
	private  String  administracionNombre ;
  	private  String  tipoMovimiento ;
  	private  Double  importeTotal ;
  	private  Double  importeAplicado ;
  	private  Integer periodoId ;
  	private  String  estado ;
  	private  Integer documentoAnulaaId ;
  	private  Integer documentoAnuladoPorId ;
  	
  	private List<DocumentoAplicacionForm> aplicaciones;
  	private List<DocumentoAplicacionForm> aplicacionesAplicadas;  	
  	private List<DocumentoMovimientoForm> imputaciones;
  	private List<DocumentoMovimientoValorTerceForm> valoresIngreTerce;
  	private List<DocumentoMovimientoValorTerceForm> valoresEgreTerce;
  	private List<DocumentoMovimientoValorPropioForm> valoresPropio;
  	
  	
  	public List<DocumentoAplicacionForm> getAplicaciones() {
		return aplicaciones;
	}
	public void setAplicaciones(List<DocumentoAplicacionForm> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}
	public List<DocumentoMovimientoForm> getImputaciones() {
		return imputaciones;
	}
	public void setImputaciones(List<DocumentoMovimientoForm> imputaciones) {
		this.imputaciones = imputaciones;
	}
	public List<DocumentoMovimientoValorTerceForm> getValoresIngreTerce() {
		return valoresIngreTerce;
	}
	public void setValoresIngreTerce(
			List<DocumentoMovimientoValorTerceForm> valoresIngreTerce) {
		this.valoresIngreTerce = valoresIngreTerce;
	}
	public List<DocumentoMovimientoValorTerceForm> getValoresEgreTerce() {
		return valoresEgreTerce;
	}
	public void setValoresEgreTerce(
			List<DocumentoMovimientoValorTerceForm> valoresEgreTerce) {
		this.valoresEgreTerce = valoresEgreTerce;
	}
	public List<DocumentoMovimientoValorPropioForm> getValoresPropio() {
		return valoresPropio;
	}
	public void setValoresPropio(
			List<DocumentoMovimientoValorPropioForm> valoresPropio) {
		this.valoresPropio = valoresPropio;
	}
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
	public Integer getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(Integer numeroDia) {
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
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
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
	public Double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}
	public AdministracionForm getAdministracion() {
		return administracion;
	}
	public void setAdministracion(AdministracionForm administracion) {
		this.administracion = administracion;
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
	public Integer getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Integer periodoId) {
		this.periodoId = periodoId;
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
	public List<DocumentoAplicacionForm> getAplicacionesAplicadas() {
		return aplicacionesAplicadas;
	}
	public void setAplicacionesAplicadas(
			List<DocumentoAplicacionForm> aplicacionesAplicadas) {
		this.aplicacionesAplicadas = aplicacionesAplicadas;
	}

}
