package com.contable.common.beans;



public class NumeroBean {

	private  String 	tipoNumeracion ;
	private  String 	numeroLetra ;
	private  String 	numeroEstablecimiento ;
	private  String 	numeroAnio ;
	private  String 	numeroMes ;
	private  String 	numeroDia ;
	private  String 	numero ;
	private  Integer 	ultimoNumero ;


	public NumeroBean() {
	}

	
	public NumeroBean(String numeroLetra, String numeroEstablecimiento,
			String numero) {
		super();
		this.numeroLetra = numeroLetra;
		this.numeroEstablecimiento = numeroEstablecimiento;
		this.numero = numero;
	}
	
	
	public String getTipoNumeracion() {
		return tipoNumeracion;
	}


	public void setTipoNumeracion(String tipoNumeracion) {
		this.tipoNumeracion = tipoNumeracion;
	}


	public Integer getUltimoNumero() {
		return ultimoNumero;
	}


	public void setUltimoNumero(Integer ultimoNumero) {
		this.ultimoNumero = ultimoNumero;
	}


	public String getNumeroLetra() {
		return numeroLetra;
	}
	public void setNumeroLetra(String numeroLetra) {
		this.numeroLetra = numeroLetra;
	}
	public String getNumeroEstablecimiento() {
		return numeroEstablecimiento;
	}
	public void setNumeroEstablecimiento(String numeroEstablecimiento) {
		this.numeroEstablecimiento = numeroEstablecimiento;
	}
	public String getNumeroAnio() {
		return numeroAnio;
	}
	public void setNumeroAnio(String numeroAnio) {
		this.numeroAnio = numeroAnio;
	}
	public String getNumeroMes() {
		return numeroMes;
	}
	public void setNumeroMes(String numeroMes) {
		this.numeroMes = numeroMes;
	}
	public String getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(String numeroDia) {
		this.numeroDia = numeroDia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
