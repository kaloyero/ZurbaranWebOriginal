package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "documentoaplicacionpendientes_v")
public class DocumentoAplicacionPendiente_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoAplicacionPendiente_V() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

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
		
	@Column(name = "IdTipoDocumento",insertable=false,updatable=false)
	private  Integer tipoDocumentoId ;
	
	@Column(name = "IdCuenta",insertable=false,updatable=false)
	private  Integer cuentaId ;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdMoneda",insertable=false,updatable=false)
  	private  Moneda moneda ;
	
	@Column(name = "IdTipoEntidad",insertable=false,updatable=false)
	private  Integer tipoEntidadId ;
	
	@Column(name = "IdEntidad",insertable=false,updatable=false)
	private  Integer entidadId ;
	
	@Column(name = "ImporteTotal",insertable=false,updatable=false)
  	private  Double importeTotal ;
  	
  	@Column(name = "TotalAplicado",insertable=false,updatable=false)
  	private  Double importeAplicado;

	@Column(name = "TipoMovimiento",insertable=false,updatable=false)
	private  String tipoMovimiento ;
  	
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

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
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

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}


  	
}
