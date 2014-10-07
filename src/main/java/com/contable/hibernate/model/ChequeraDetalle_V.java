package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "chequeradetalle_v")
public class ChequeraDetalle_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public ChequeraDetalle_V() {
	}
	
	
	@Id
	@Column(name = "id", unique = false, nullable = false)
	private  long id ;
	
	@Column(name = "IdChequera")
	private  Integer chequeraId;
	
	@Column(name = "numero")
	private  Integer numero;
	
	@Column(name = "FechaIngreso")
	private Date fechaIng;
	
	@Column(name = "FechaVencimiento")
	private Date fechaVto;
	
	@Column(name = "IdDocumento")
	private  Integer documentoId;
	
	@Column(name = "IdMovimiento")
	private  Integer movimientoId;
	
	@Column(name = "IdValorPropio")
	private  Integer valorPropioId;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdMoneda")		
	private  Moneda moneda;

	@Column(name = "Beneficiario")
	private  String beneficiario;

	@Column(name = "importeValor")
	private  Double importe;
	
	@Column(name = "Estado")
	private  String estado;
	
	@Column(name = "descripcionEstado")
	private  String motivo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getChequeraId() {
		return chequeraId;
	}

	public void setChequeraId(Integer chequeraId) {
		this.chequeraId = chequeraId;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}


	public Date getFechaVto() {
		return fechaVto;
	}

	public void setFechaVto(Date fechaVto) {
		this.fechaVto = fechaVto;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(Date fechaIng) {
		this.fechaIng = fechaIng;
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

	public Integer getValorPropioId() {
		return valorPropioId;
	}

	public void setValorPropioId(Integer valorPropioId) {
		this.valorPropioId = valorPropioId;
	}

	
}
