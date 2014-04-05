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
@Table(name = "documentovalorester")
public class DocumentoValorTerceIngre_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoValorTerceIngre_V() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "IdBanco")
	private  Banco banco;
	
	@Column(name = "Numero")
	private  int numero;
	
	@Column(name = "FechaVencimiento")
	private  Date fechaVencimiento;
	
	@Column(name = "IdValorTerMov")
	private  Integer idValorTerMov;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Integer getIdValorTerMov() {
		return idValorTerMov;
	}
	public void setIdValorTerMov(Integer idValorTerMov) {
		this.idValorTerMov = idValorTerMov;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}

}