package com.contable.form;

import com.contable.common.beans.Form;

public class DocumentoValTerceForm implements Form  {

	private static final long serialVersionUID = -3939874136485777943L;

	private  int id ;
	private  Integer numero;
	private  String  emisor;
	private  String  fechaVencimiento;
	private  BancoForm banco;
	private  Integer  bancoId;
	private  String  bancoNombre;
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
	public String getBancoNombre() {
		return bancoNombre;
	}
	public void setBancoNombre(String bancoNombre) {
		this.bancoNombre = bancoNombre;
	}
	public Integer getBancoId() {
		return bancoId;
	}
	public void setBancoId(Integer bancoId) {
		this.bancoId = bancoId;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	
	
	
}
