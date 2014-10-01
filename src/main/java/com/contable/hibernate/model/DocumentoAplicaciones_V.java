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
@Table(name = "documentoaplicaciones_v")
public class DocumentoAplicaciones_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoAplicaciones_V() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "IdDocumento")
	private  int documentoId;

	@Column(name = "DescripcionDodumentoAplicado")
	private  String documentoAplicaDescripcion;

	@Column(name = "IdDocumentoAplica",insertable=false,updatable=false)
	private  Integer documentoAplicaId ;

	@Column(name = "IdTipoDocumentoAplicado",insertable=false,updatable=false)
	private  Integer tipoDocumentoAplicadoId ;

	@Column(name = "nombreTipoDocumentoAplicado",insertable=false,updatable=false)
	private  String tipoDocumentoAplicadoNombre ;

	@Column(name = "NumeroFormateadoAplicacion",insertable=false,updatable=false)
	private  String numeroFormateadoAplicacion ;

	@Column(name = "IdTipoDocumento",insertable=false,updatable=false)
	private  Integer tipoDocumentoId ;

	@Column(name = "nombreTipoDocumento",insertable=false,updatable=false)
	private  String tipoDocumentoNombre ;

	@Column(name = "NumeroFormateado",insertable=false,updatable=false)
	private  String numeroFormateado;

	@Column(name = "NumeroLetra",insertable=false,updatable=false)
	private  String numeroLetra ;
	
	@Column(name = "NumeroEstablecimiento",insertable=false,updatable=false)
	private  Integer numeroEstablecimiento ;
	
	@Column(name = "NumeroAnio",insertable=false,updatable=false)
	private  Integer numeroAnio ;
	
	@Column(name = "NumeroMes",insertable=false,updatable=false)
	private  Integer numeroMes ;
	
	@Column(name = "NumeroDia",insertable=false,updatable=false)
	private  Integer numeroDia ;
	
	@Column(name = "Numero",insertable=false,updatable=false)
	private  Integer numero ;
		
	@Column(name = "IdCuenta",insertable=false,updatable=false)
	private  Integer cuentaId ;
	
    @Column(name="IdMoneda",insertable=false,updatable=false)
  	private  Integer moneda ;

	@Column(name = "monedaNombre",insertable=false,updatable=false)
	private  String monedaNombre ;

	@Column(name = "monedaCodigo",insertable=false,updatable=false)
	private  String monedaCodigo ;
	
	@Column(name = "IdTipoEntidad",insertable=false,updatable=false)
	private  Integer tipoEntidadId ;
	
	@Column(name = "IdEntidad",insertable=false,updatable=false)
	private  Integer entidadId ;
	
  	@Column(name = "TotalAplicado",insertable=false,updatable=false)
  	private  Double importeAplicado;
  	
  	@Column(name = "FechaIngresoDocumentoAplicado")
  	private  Date fechaIngresoDocumentoAplicado;

  	
	public int getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(int documentoId) {
		this.documentoId = documentoId;
	}

	public Integer getDocumentoAplicaId() {
		return documentoAplicaId;
	}

	public void setDocumentoAplicaId(Integer documentoAplicaId) {
		this.documentoAplicaId = documentoAplicaId;
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

	public Integer getMoneda() {
		return moneda;
	}

	public void setMoneda(Integer moneda) {
		this.moneda = moneda;
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

	public Double getImporteAplicado() {
		return importeAplicado;
	}

	public void setImporteAplicado(Double importeAplicado) {
		this.importeAplicado = importeAplicado;
	}

	public String getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}

	public void setTipoDocumentoNombre(String tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}

	public Integer getTipoDocumentoAplicadoId() {
		return tipoDocumentoAplicadoId;
	}

	public void setTipoDocumentoAplicadoId(Integer tipoDocumentoAplicadoId) {
		this.tipoDocumentoAplicadoId = tipoDocumentoAplicadoId;
	}

	public String getTipoDocumentoAplicadoNombre() {
		return tipoDocumentoAplicadoNombre;
	}

	public void setTipoDocumentoAplicadoNombre(String tipoDocumentoAplicadoNombre) {
		this.tipoDocumentoAplicadoNombre = tipoDocumentoAplicadoNombre;
	}

	public String getNumeroFormateadoAplicacion() {
		return numeroFormateadoAplicacion;
	}

	public void setNumeroFormateadoAplicacion(String numeroFormateadoAplicacion) {
		this.numeroFormateadoAplicacion = numeroFormateadoAplicacion;
	}

	public String getNumeroFormateado() {
		return numeroFormateado;
	}

	public void setNumeroFormateado(String numeroFormateado) {
		this.numeroFormateado = numeroFormateado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumentoAplicaDescripcion() {
		return documentoAplicaDescripcion;
	}

	public void setDocumentoAplicaDescripcion(String documentoAplicaDescripcion) {
		this.documentoAplicaDescripcion = documentoAplicaDescripcion;
	}

	public Date getFechaIngresoDocumentoAplicado() {
		return fechaIngresoDocumentoAplicado;
	}

	public void setFechaIngresoDocumentoAplicado(
			Date fechaIngresoDocumentoAplicado) {
		this.fechaIngresoDocumentoAplicado = fechaIngresoDocumentoAplicado;
	}
  	
}
