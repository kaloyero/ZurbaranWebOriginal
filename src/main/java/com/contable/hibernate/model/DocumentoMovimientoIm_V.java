package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "documentomovimientosim_v")
public class DocumentoMovimientoIm_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoMovimientoIm_V() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdMovimiento", unique = true, nullable = false)
	private Integer movimientoId;
	@Column(name = "IdDocumento",insertable=false, updatable=false)
	private Integer documentoId;
	@Column(name = "Descripcion",insertable=false, updatable=false)
	private String  descripcion;
	@Column(name = "conceptoCodigo",insertable=false, updatable=false)
	private String  conceptoCodigo;
	@Column(name = "conceptoNombre",insertable=false, updatable=false)
	private String  conceptoNombre;
	@Column(name = "IdMoneda",insertable=false, updatable=false)
	private Integer  monedaId;
	@Column(name = "monedaNombre",insertable=false, updatable=false)
	private String  monedaNombre;
	@Column(name = "monedaCodigo",insertable=false, updatable=false)
	private String  monedaCodigo;
	@Column(name = "cuentaNombre",insertable=false, updatable=false)
	private String  cuentaNombre;
	@Column(name = "cuentaCodigo",insertable=false, updatable=false)
	private String  cuentaCodigo;
	@Column(name = "entidadNombre",insertable=false, updatable=false)
	private String  entidadNombre;
	@Column(name = "importeMovimiento",insertable=false, updatable=false)
	private Double  importeMovimiento;
	@Column(name = "Cotizacion",insertable=false, updatable=false)
	private Double cotizacion;
	@Column(name = "Referencia",insertable=false,updatable=false)
	private  String referencia;

	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
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
	public Double getImporteMovimiento() {
		return importeMovimiento;
	}
	public void setImporteMovimiento(Double importeMovimiento) {
		this.importeMovimiento = importeMovimiento;
	}
	public Double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}

	
}
