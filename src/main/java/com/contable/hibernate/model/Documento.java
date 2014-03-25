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
@Table(name = "documento")
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
	private  int numeroEstablecimiento ;
	
	@Column(name = "NumeroAnio")
	private  int numeroAnio ;
	
	@Column(name = "NumeroMes")
	private  int numeroMes ;
	
	@Column(name = "NumeroDia")
	private  String numeroDia ;
	
	@Column(name = "Numero")
	private  int numero ;
	
	@Column(name = "FechaReal")
	private  Date fechaReal ;
	
	@Column(name = "FechaIngreso")
	private  Date fechaIngreso ;
	
	@Column(name = "FechaVencimiento")
	private  Date fechaVencimiento ;
	
	@Column(name = "Descripcion")
	private  String descripcion ;
	
	@Column(name = "IdTipoDocumento")
	private  int idTipoDocumento ;
	
	@Column(name = "IdCuenta")
	private  int idCuenta ;
	
	@Column(name = "IdMoneda")
  	private  int idMoneda ;
	
	@Column(name = "IdTipoEntidad")
	private  int idTipoEntidad ;
	
	@Column(name = "IdEntidad")
	private  int idEntidad ;
	
	@Column(name = "Cotizacion")
	private  float cotizacion ;
	
	@Column(name = "IdAdministracion")
	private  int idAdministracion ;
	
  	@Column(name = "TipoMovimiento")
  	private  String tipoMovimiento ;
  	
  	@Column(name = "ImporteTotal")
  	private  float importeTotal ;
  	
  	@Column(name = "ImporteAplicado")
  	private  float importeAplicado ;
  	
  	@Column(name = "IdPeriodo")
  	private  int idPeriodo ;
  	
  	@Column(name = "Estado")
  	private  String estado ;
  	
  	@Column(name = "IdDocumentoAnulaa")
  	private  int idDocumentoAnulaa ;
  	
  	@Column(name = "IdDocumentoAnuladoPor")	
  	private  int idDocumentoAnuladoPor ;

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

	public int getNumeroEstablecimiento() {
		return numeroEstablecimiento;
	}

	public void setNumeroEstablecimiento(int numeroEstablecimiento) {
		this.numeroEstablecimiento = numeroEstablecimiento;
	}

	public int getNumeroAnio() {
		return numeroAnio;
	}

	public void setNumeroAnio(int numeroAnio) {
		this.numeroAnio = numeroAnio;
	}

	public int getNumeroMes() {
		return numeroMes;
	}

	public void setNumeroMes(int numeroMes) {
		this.numeroMes = numeroMes;
	}

	public String getNumeroDia() {
		return numeroDia;
	}

	public void setNumeroDia(String numeroDia) {
		this.numeroDia = numeroDia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}

	public int getIdTipoEntidad() {
		return idTipoEntidad;
	}

	public void setIdTipoEntidad(int idTipoEntidad) {
		this.idTipoEntidad = idTipoEntidad;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	public float getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(float cotizacion) {
		this.cotizacion = cotizacion;
	}

	public int getIdAdministracion() {
		return idAdministracion;
	}

	public void setIdAdministracion(int idAdministracion) {
		this.idAdministracion = idAdministracion;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public float getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(float importeTotal) {
		this.importeTotal = importeTotal;
	}

	public float getImporteAplicado() {
		return importeAplicado;
	}

	public void setImporteAplicado(float importeAplicado) {
		this.importeAplicado = importeAplicado;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdDocumentoAnulaa() {
		return idDocumentoAnulaa;
	}

	public void setIdDocumentoAnulaa(int idDocumentoAnulaa) {
		this.idDocumentoAnulaa = idDocumentoAnulaa;
	}

	public int getIdDocumentoAnuladoPor() {
		return idDocumentoAnuladoPor;
	}

	public void setIdDocumentoAnuladoPor(int idDocumentoAnuladoPor) {
		this.idDocumentoAnuladoPor = idDocumentoAnuladoPor;
	}


}
