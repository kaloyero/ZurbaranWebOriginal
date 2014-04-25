package com.contable.hibernate.model;

import java.io.Serializable;

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
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "IdDocumentoAplica")
	private  Integer documentoAplicaId ;

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
		
	@Column(name = "IdTipoDocumento")
	private  Integer tipoDocumentoId ;
	
	@Column(name = "IdCuenta")
	private  Integer cuentaId ;
	
    @Column(name="IdMoneda")
  	private  Integer moneda ;

	@Column(name = "NumeroLetra")
	private  String monedaNombre ;

	@Column(name = "NumeroLetra")
	private  String monedaCodigo ;
	
	@Column(name = "IdTipoEntidad")
	private  Integer tipoEntidadId ;
	
	@Column(name = "IdEntidad")
	private  Integer entidadId ;
	
  	@Column(name = "TotalAplicado")
  	private  Double importeAplicado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


  	
}
