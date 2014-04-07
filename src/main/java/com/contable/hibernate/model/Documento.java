
package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "documentos")
public class Documento implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Documento() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "NumeroLetra")
	private  String numeroLetra ;
	
	@Column(name = "NumeroEstablecimiento")
	private  Integer numeroEstablecimiento ;
	
	@Column(name = "NumeroAnio")
	private  Integer numeroAnio ;
	
	@Column(name = "NumeroMes")
	private  Integer numeroMes ;
	
	@Column(name = "NumeroDia")
	private  Integer numeroDia ;
	
	@Column(name = "Numero")
	private  Integer numero ;
	
	@Column(name = "FechaReal")
	private  Date fechaReal ;
	
	@Column(name = "FechaIngreso")
	private  Date fechaIngreso ;
	
	@Column(name = "FechaVencimiento")
	private  Date fechaVencimiento ;
	
	@Column(name = "Descripcion")
	private  String descripcion ;
	
	@Column(name = "IdTipoDocumento")
	private  Integer tipoDocumentoId ;
	
	@Column(name = "IdCuenta")
	private  Integer cuentaId ;
	
	@Column(name = "IdMoneda")
  	private  Integer monedaId ;
	
	@Column(name = "IdTipoEntidad")
	private  Integer tipoEntidadId ;
	
	@Column(name = "IdEntidad")
	private  Integer entidadId ;
	
	@Column(name = "Cotizacion")
	private  Double cotizacion ;
	
	@Column(name = "IdAdministracion")
	private  Administracion administracion ;
	
  	@Column(name = "TipoMovimiento")
  	private  String tipoMovimiento ;
  	
  	@Column(name = "ImporteTotal")
  	private  Double importeTotal ;
  	
  	@Column(name = "ImporteAplicado")
  	private  Double importeAplicado ;
  	
  	@Column(name = "IdPeriodo")
  	private  Integer periodoId ;
  	
  	@Column(name = "Estado")
  	private  String estado ;
  	
  	@Column(name = "IdDocumentoAnulaa")
  	private  Integer documentoAnulaaId ;
  	
  	@Column(name = "IdDocumentoAnuladoPor")	
  	private  Integer documentoAnuladoPorId ;

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

	public Date getFechaReal() {
		return fechaReal;
	}

	public void setFechaReal(Date fechaReal) {
		this.fechaReal = fechaReal;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
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

	public Integer getEntidadId() {
		return entidadId;
	}

	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}

	public Double getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Administracion getAdministracion() {
		return administracion;
	}

	public void setAdministracion(Administracion administracion) {
		this.administracion = administracion;
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

}
