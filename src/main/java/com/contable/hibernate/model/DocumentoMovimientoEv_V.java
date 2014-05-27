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
@Table(name = "documentomovimientosev_v")
public class DocumentoMovimientoEv_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoMovimientoEv_V() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdMovimiento", unique = true, nullable = false)
	private Integer movimientoId;
	@Column(name = "IdDocumento",insertable=false, updatable=false)
	private Integer documentoId;
	@Column(name = "Descripcion",insertable=false, updatable=false)
	private String descripcion;
	@Column(name = "conceptoCodigo",insertable=false, updatable=false)
	private String conceptoCodigo;
	@Column(name = "conceptoNombre",insertable=false, updatable=false)
	private String conceptoNombre;
	@Column(name = "monedaNombre",insertable=false, updatable=false)
	private String monedaNombre;
	@Column(name = "monedaCodigo",insertable=false, updatable=false)
	private String monedaCodigo;
	@Column(name = "cuentaNombre",insertable=false, updatable=false)
	private String cuentaNombre;
	@Column(name = "cuentaCodigo",insertable=false, updatable=false)
	private String cuentaCodigo;
	@Column(name = "entidadNombre",insertable=false, updatable=false)
	private String entidadNombre;
	@Column(name = "tipoEntidadNombre",insertable=false, updatable=false)
	private String tipoEntidadNombre;
	@Column(name = "numero",insertable=false, updatable=false)
	private Integer numero;
	@Column(name = "FechaVencimiento",insertable=false, updatable=false)
	private Date fechaVencimiento;
	@Column(name = "importeMovimiento",insertable=false, updatable=false)
	private Double importeMovimiento;
	@Column(name = "Cotizacion",insertable=false, updatable=false)
	private Double cotizacion;
	@Column(name = "nombreBanco",insertable=false, updatable=false)
	private String bancoNombre;
	@Column(name = "IdValorTerce",insertable=false, updatable=false)
	private Integer valorTerceId;
	@Column(name = "IdDocumentoValorterMovs",insertable=false, updatable=false)
	private Integer valorTerceMovId;

	
	@Column(name = "monedaCodigo",insertable=false, updatable=false)
	private String emisor;
	
	public Integer getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}
	public Integer getMovimientoId() {
		return movimientoId;
	}
	public void setMovimientoId(Integer movimientoId) {
		this.movimientoId = movimientoId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getConceptoCodigo() {
		return conceptoCodigo;
	}
	public void setConceptoCodigo(String conceptoCodigo) {
		this.conceptoCodigo = conceptoCodigo;
	}
	public String getConceptoNombre() {
		return conceptoNombre;
	}
	public void setConceptoNombre(String conceptoNombre) {
		this.conceptoNombre = conceptoNombre;
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
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Double getImporteMovimiento() {
		return importeMovimiento;
	}
	public void setImporteMovimiento(Double importeMovimiento) {
		this.importeMovimiento = importeMovimiento;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public Double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}
	public String getBancoNombre() {
		return bancoNombre;
	}
	public void setBancoNombre(String bancoNombre) {
		this.bancoNombre = bancoNombre;
	}
	public String getTipoEntidadNombre() {
		return tipoEntidadNombre;
	}
	public void setTipoEntidadNombre(String tipoEntidadNombre) {
		this.tipoEntidadNombre = tipoEntidadNombre;
	}
	public Integer getValorTerceId() {
		return valorTerceId;
	}
	public void setValorTerceId(Integer valorTerceId) {
		this.valorTerceId = valorTerceId;
	}
	public Integer getValorTerceMovId() {
		return valorTerceMovId;
	}
	public void setValorTerceMovId(Integer valorTerceMovId) {
		this.valorTerceMovId = valorTerceMovId;
	}
	
	
}