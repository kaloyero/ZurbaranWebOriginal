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
@Table(name = "documentovalorester")
public class DocumentoValorTerce implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoValorTerce() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
<<<<<<< HEAD
	@OneToOne(fetch=FetchType.EAGER )
	@JoinColumn(name = "IdBanco")
=======
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn (name = "IdBanco")
>>>>>>> d824ddb35b116be8c901739b5252e993030990a0
	private  Banco banco;
	
	@Column(name = "Numero")
	private  int numero;
	
	@Column(name = "FechaVencimiento")
	private  Date fechaVencimiento;
<<<<<<< HEAD
=======

>>>>>>> d824ddb35b116be8c901739b5252e993030990a0
	
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
<<<<<<< HEAD
=======
	
>>>>>>> d824ddb35b116be8c901739b5252e993030990a0
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}

}
