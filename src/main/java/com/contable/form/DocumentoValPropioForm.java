package com.contable.form;

import com.contable.common.beans.Form;

public class DocumentoValPropioForm implements Form  {

	private static final long serialVersionUID = 1L;

	private  int id ;
	private  Integer numero;
	private  String  beneficiario;
	private  String  fechaVencimiento;
	private  Integer idMovimiento;
	private  ChequeraForm chequera;
	
	public ChequeraForm getChequera() {
		return chequera;
	}
	public void setChequera(ChequeraForm chequera) {
		this.chequera = chequera;
	}
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
	
}
