package com.contable.form;

import com.contable.common.beans.Form;

public class DocumentoAplicacionForm implements Form {

	private static final long serialVersionUID = 1L;

	private  int id ;
	private  Integer documentoId ;
	private  Integer documentoAplicaId;
  	private  Double  importe ;

  	private  String  numeroText ;
	private  String  numeroLetra ;
	private  Integer numeroEstablecimiento ;
	private  Integer numeroAnio ;
	private  Integer numeroMes ;
	private  Integer numeroDia ;
	private  Integer numero ;
	private  Integer tipoDocumentoId ;
	private  Integer cuentaId ;
  	private  MonedaForm moneda ;
  	private  Integer monedaId ;
  	private  String  monedaNombre ;
  	private  String  monedaCodigo ;
	private  Integer tipoEntidadId ;
	private  Integer entidadId ;
  	private  String  tipoMovimiento ;
  	private  Double  importeTotal ;
  	private  String  importeTotalText ;
  	private  Double  importePendiente ;
  	private  String  importePendienteText ;
  	private  Double  importeAplicado ;
  	private  String  importeAplicadoText ;
  	private  String  estado ;
  	  	
  	
  	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}
	public Integer getDocumentoAplicaId() {
		return documentoAplicaId;
	}
	public void setDocumentoAplicaId(Integer documentoAplicaId) {
		this.documentoAplicaId = documentoAplicaId;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroText() {
		return numeroText;
	}
	public void setNumeroText(String numeroText) {
		this.numeroText = numeroText;
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
	public MonedaForm getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
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
	public String getImporteTotalText() {
		return importeTotalText;
	}
	public void setImporteTotalText(String importeTotalText) {
		this.importeTotalText = importeTotalText;
	}
	public Double getImportePendiente() {
		return importePendiente;
	}
	public void setImportePendiente(Double importePendiente) {
		this.importePendiente = importePendiente;
	}
	public String getImportePendienteText() {
		return importePendienteText;
	}
	public void setImportePendienteText(String importePendienteText) {
		this.importePendienteText = importePendienteText;
	}
	public Double getImporteAplicado() {
		return importeAplicado;
	}
	public void setImporteAplicado(Double importeAplicado) {
		this.importeAplicado = importeAplicado;
	}
	public String getImporteAplicadoText() {
		return importeAplicadoText;
	}
	public void setImporteAplicadoText(String importeAplicadoText) {
		this.importeAplicadoText = importeAplicadoText;
	}
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
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
  	
  	
  	
}
