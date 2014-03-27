package com.contable.common.beans;

import java.io.Serializable;
import java.util.List;

import com.contable.form.CuentaForm;
import com.contable.form.MonedaForm;
import com.contable.form.TipoDocumentoForm;

public class DocumentoHeaderBean implements Serializable {

	private static final long serialVersionUID = -3939874136485777943L;

	private  CuentaForm  cuenta ;
	private  TipoDocumentoForm tipoDocumento ;
	private  String numeracion;
	private  List<MonedaForm> monedas;
	private  List<ConfigBean> entidades;

	public CuentaForm getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaForm cuenta) {
		this.cuenta = cuenta;
	}
	public TipoDocumentoForm getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumentoForm tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeracion() {
		return numeracion;
	}
	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}
	public List<MonedaForm> getMonedas() {
		return monedas;
	}
	public void setMonedas(List<MonedaForm> monedas) {
		this.monedas = monedas;
	}
	public List<ConfigBean> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<ConfigBean> entidades) {
		this.entidades = entidades;
	}

	
}
