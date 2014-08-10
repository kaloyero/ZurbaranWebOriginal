package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "chequeranodisponibles")
public class ChequeraNoDisponible implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public ChequeraNoDisponible() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Numero",nullable=true)
	private  Integer numero;
	
	@Column(name = "Importe",nullable=false)
	private  Double importe;

	@Column(name = "Motivo")
	private String  motivo;

//	@Column(name = "Beneficiario")
//	private String  beneficiario;
//
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdChequera")		
	private  Chequera chequera;

	@Column(name = "Fecha")
	private Date fecha;

//	@Column(name = "FechaEmision")
//	private Date fechaEmision;
//
//	@Column(name = "FechaVencimiento")
//	private Date fechaVto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Chequera getChequera() {
		return chequera;
	}

	public void setChequera(Chequera chequera) {
		this.chequera = chequera;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
