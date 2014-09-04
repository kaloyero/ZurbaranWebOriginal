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
	private  int id ;
	
	@Column(name = "IdChequera")
	private  Integer chequeraId;
	
	@Column(name = "numero")
	private  Integer numero;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdMoneda")		
	private  Moneda moneda;

	@Column(name = "Beneficiario")
	private  String beneficiario;

	@Column(name = "FechaVencimiento")
	private  Date fechaVto;

	@Column(name = "Importe")
	private  Double importe;
	
	@Column(name = "Estado")
	private  String estado;
	
	@Column(name = "Motivo")
	private  String motivo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	
}
