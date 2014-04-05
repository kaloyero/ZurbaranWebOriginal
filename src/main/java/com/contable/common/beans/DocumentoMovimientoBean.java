package com.contable.common.beans;

import java.io.Serializable;
import java.util.List;

import com.contable.form.ConceptoForm;
import com.contable.form.CuentaForm;

public class DocumentoMovimientoBean implements Serializable {

	private static final long serialVersionUID = -3939874136485777943L;


	private  ConceptoForm  concepto ;
	private  CuentaForm  cuenta ;
	private  List<ConfigBean> monedas;
	private  List<ConfigBean> entidades;

	public CuentaForm getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaForm cuenta) {
		this.cuenta = cuenta;
	}
	public ConceptoForm getConcepto() {
		return concepto;
	}
	public void setConcepto(ConceptoForm concepto) {
		this.concepto = concepto;
	}
	public List<ConfigBean> getMonedas() {
		return monedas;
	}
	public void setMonedas(List<ConfigBean> monedas) {
		this.monedas = monedas;
	}
	public List<ConfigBean> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<ConfigBean> entidades) {
		this.entidades = entidades;
	}
		
}
