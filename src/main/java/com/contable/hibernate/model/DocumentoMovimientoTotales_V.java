package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "documentototalespormovimiento_v")
public class DocumentoMovimientoTotales_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoMovimientoTotales_V() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdDocumento", nullable = false)
	private Integer documentoId;

	@Column(name = "CodMovimiento",insertable=false, updatable=false)
	private String codigoMovimiento;

	@Column(name = "IdMonedaDoc",insertable=false, updatable=false)
	private Integer monedaDocumentoId;

	@Column(name = "CodMovimiento",insertable=false, updatable=false)
	private String monedaDocumentoNombre;

	@Column(name = "IdMonedaMov",insertable=false, updatable=false)
	private Integer monedaMovimientoId;

	@Column(name = "CodMovimiento",insertable=false, updatable=false)
	private String monedaMovimientoNombre;

	@Column(name = "TotalMovimiento",insertable=false, updatable=false)
	private Double totalMovimiento;

	@Column(name = "TotalMovimientoMonedaDoc",insertable=false, updatable=false)
	private Double totalMovimientoMonedaDoc;

	public Integer getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	public String getCodigoMovimiento() {
		return codigoMovimiento;
	}

	public void setCodigoMovimiento(String codigoMovimiento) {
		this.codigoMovimiento = codigoMovimiento;
	}

	public Integer getMonedaDocumentoId() {
		return monedaDocumentoId;
	}

	public void setMonedaDocumentoId(Integer monedaDocumentoId) {
		this.monedaDocumentoId = monedaDocumentoId;
	}

	public String getMonedaDocumentoNombre() {
		return monedaDocumentoNombre;
	}

	public void setMonedaDocumentoNombre(String monedaDocumentoNombre) {
		this.monedaDocumentoNombre = monedaDocumentoNombre;
	}

	public Integer getMonedaMovimientoId() {
		return monedaMovimientoId;
	}

	public void setMonedaMovimientoId(Integer monedaMovimientoId) {
		this.monedaMovimientoId = monedaMovimientoId;
	}

	public String getMonedaMovimientoNombre() {
		return monedaMovimientoNombre;
	}

	public void setMonedaMovimientoNombre(String monedaMovimientoNombre) {
		this.monedaMovimientoNombre = monedaMovimientoNombre;
	}

	public Double getTotalMovimiento() {
		return totalMovimiento;
	}

	public void setTotalMovimiento(Double totalMovimiento) {
		this.totalMovimiento = totalMovimiento;
	}

	public Double getTotalMovimientoMonedaDoc() {
		return totalMovimientoMonedaDoc;
	}

	public void setTotalMovimientoMonedaDoc(Double totalMovimientoMonedaDoc) {
		this.totalMovimientoMonedaDoc = totalMovimientoMonedaDoc;
	}

	
		
}