package com.contable.form;

import com.contable.common.beans.Form;

public class DocumentoValTerceForm implements Form  {

	private static final long serialVersionUID = -3939874136485777943L;

	private  int id ;
	private  Integer numero;
	private  String  beneficiario;
	private  String  fechaVencimiento;
	private  BancoForm banco;
	private  Integer idMovimiento;
	
	
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
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Integer getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public BancoForm getBanco() {
		return banco;
	}
	public void setBanco(BancoForm banco) {
		this.banco = banco;
	}
	
	
	
}
