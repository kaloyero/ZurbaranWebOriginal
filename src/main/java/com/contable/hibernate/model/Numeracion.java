package com.contable.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.contable.common.beans.Form;


@Entity
@Table(name = "numeracion")
public class Numeracion implements Form {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Numeracion() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "NumeroLetra")
	private  String numeroLetra ;
	
	@Column(name = "NumeroEstablecimiento")
	private  Integer numeroEstablecimiento ;
	
	@Column(name = "NumeroAnio")
	private  Integer numeroAnio ;
	
	@Column(name = "NumeroMes")
	private  Integer numeroMes ;
	
	@Column(name = "NumeroDia")
	private  Integer numeroDia ;
	
	@Column(name = "UltimoNumero")
	private  Integer ultimoNumero ;
	
	@Column(name = "IdTipoDocumento")
	private int tipoDocumentoId;
	
	@Column(name = "IdAdministracion")
	private Integer administracionId;

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

	public Integer getUltimoNumero() {
		return ultimoNumero;
	}

	public void setUltimoNumero(Integer ultimoNumero) {
		this.ultimoNumero = ultimoNumero;
	}

	public int getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(int tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public Integer getAdministracionId() {
		return administracionId;
	}

	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}

	
}
