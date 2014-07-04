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
@Table(name = "chequeradetalle_v")
public class ChequeraDetalle_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public ChequeraDetalle_V() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = false, nullable = false)
	private  int ValorPropioId ;
	
	@Column(name = "numero")
	private  Integer numero;
	
	@Column(name = "IdAdministracion")
	private  Integer administracionId;

	@Column(name = "IdDocumento")
	private  Integer documentoId;

	@Column(name = "IdMovimiento")
	private  Integer movimientoId;

	@Column(name = "importeValor")
	private  Double importeValor;
	
	@Column(name = "monedaCodigo")
	private  String monedaCodigo;
	
	@Column(name = "Estado")
	private  String estado;
	
	@Column(name = "descripcionEstado")
	private  String descripcionEstado;

	@Column(name = "beneficiario")
	private  String beneficiario;
	
	@Column(name = "FechaIngreso")
	private  Date fechaIngreso;

	@Column(name = "FechaVencimiento")
	private  Date fechaVencimiento;

	public int getValorPropioId() {
		return ValorPropioId;
	}

	public void setValorPropioId(int valorPropioId) {
		ValorPropioId = valorPropioId;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAdministracionId() {
		return administracionId;
	}

	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
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

	public Double getImporteValor() {
		return importeValor;
	}

	public void setImporteValor(Double importeValor) {
		this.importeValor = importeValor;
	}

	public String getMonedaCodigo() {
		return monedaCodigo;
	}

	public void setMonedaCodigo(String monedaCodigo) {
		this.monedaCodigo = monedaCodigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
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

	
	
}
